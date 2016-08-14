package com.inno.tax;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.inno.tax.service.Client_DataService;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

@Controller
@Scope("session")
public class HelloController {
	
	Client_Data cd;
	
	@Autowired
	Client_DataService client_DataServiceImpl;
	
	
	/**
	 * Fields first name = f1_01_0_ last name = f1_02_0_ identifying number =
	 * f1_03_0_ SSN号或者ITIN号 home address = f1_04_0_ city state ZIP code =
	 * f1_05_0_ foreign country name = TextField1 foreign province = f1_73_0_
	 * foreign post code = f1_301_0_ [1] single is "1" = c1_2_0_ [2] married is
	 * "2" = c1_2_0_ Occupation = f1_61_0_ protection PIN = f1_130
	 * =========================================================================
	 * ============= [3] Wage = f1_10_0_ **所有W-2表中 单元[1]项标示的收入之和 [4] Taxable
	 * Refund = f1_12_0_ **州税与地方税的退税总和，查看1099-G，没无该表则跳过此项 [5] Scholarship =
	 * f1_14_0_ **所有1042-S 表中Line 2项标示的收入之和 [6-1] treaty = f1_16_0_ 填入5000 [6-2]
	 * treaty type = f1_17_0_ Treaty C [7] sum 3,4,5 = f1_18_0_ 单元[3]+[4]+[5]之和
	 * [8] Scholarship exc= f1_20_0_ 此项不适用，填入0 [9] Student loan intr deduction
	 * 此项不适用，填入0 [10] adjst gross income= f1_24_0_ 单元[7]-[8]-[9]之差,为[7] [11]
	 * itemized deduct = f1_26_0_ **W-2上单元[17]与[19]数字之和 [12] 10-11 = f1_28_0_
	 * 单元[10]-[11]之差1 [13] exemption = f1_30_0_ **2014年为3950 [14] taxable income
	 * = f1_32_0_ 单元[12]-[13]的差，如为负数，填入0 [15] tax = f1_34_0_ 套用taxing table得出税款
	 * [16] SS and MT 此项不适用，不做填入 [17] is 15 = f1_38_0_ 单元[15]+[16]之和，等于[15]
	 * [18a] Federal wh w2 = f1_40_0_ **W-2表中单元[2]中数字之和 [18b] Federal wh 1042S =
	 * f1_100_0_ **1042-S表中单元[7]中数字之和 [19] last year return = f1_42_0_
	 * **2013年未退的税款 [20] 1040c = f1_44_0_ **如收到1040-C表，则填入此项 [21] total payments
	 * = f1_46_0_ 单元[18a]+[18b]+[19]+[20]之和
	 * ================================================================== [22]
	 * over paid = f1_48_0_ [21]-[17] if >0 , else 0; [23a] refund = f1_50_0_
	 * **希望拿回多少钱的退税。 [23b] routing number = f1_52_0_ **Routing number [23c]
	 * checking/saving "1/2"= c1_4_0_ **account type [23d] account number =
	 * f1_53_0_ ** account number [23e] mail outside US = f1_74_0_ **是否寄到美国以外地址
	 * [24] 2015 tax estimate = f1_54_0_ **未全拿回的退税留到15年 [25] amount you own =
	 * f1_56_0_ 若[22]<0, 则为[17]-[21] [26] tax penalty = f1_58_0_ 0
	 */

	

	@RequestMapping(value = "/person_info", method = RequestMethod.GET)
	public ModelAndView personInfo() {
		Path objPath = new Path();
		String path = objPath.getPath();
		System.out.println("now1 : "+ path);
		boolean pathFlag = objPath.getFlag();
		String pathshow = this.getClass().getResource("").getPath();
		ModelAndView model2 = new ModelAndView("PersonInfo");
		model2.addObject("step1", "Personal Information");
		model2.addObject("path", pathshow);
		return model2;
	}

	@RequestMapping(value = "/confirm_person_info", method = RequestMethod.POST)
	public ModelAndView submitName(@RequestParam Map<String, String> person_info)  {
		
		ModelAndView model3 = new ModelAndView("confirmPersonInfo");
		cd = new Client_Data();
		//写person_info类
		
		cd.setFirstname(person_info.get("firstname"));
		cd.setLastname(person_info.get("lastname"));
		cd.setId_num(person_info.get("id_num"));
		cd.setHome_addr(person_info.get("home_addr"));
		cd.setCity_state_zip(person_info.get("city_state_zip"));
		cd.setCountry(person_info.get("country"));
		cd.setProvince(person_info.get("province"));
		cd.setZipcode(person_info.get("zipcode"));
		cd.setIsSingle(person_info.get("isSingle"));

//		String path = this.getClass().getResource("").getPath();
//		path = path.substring(0, path.length() - 99);
		Path objPath = new Path();
		String path = objPath.getPath();
		System.out.println("now2 : "+ path);
		boolean pathFlag = objPath.getFlag();
		
		String jsonPath;
		if (pathFlag){
			jsonPath = path + "temp.json";
		}else{
			jsonPath = path + "temp.json";
			System.out.println(jsonPath);
		}
		
		
	// 写person_info类
	
//		try{
//		BufferedWriter bw = new BufferedWriter(new FileWriter(jsonPath));
//		bw.write("[{ ");
//		bw.write("\"firstname" + "\": \"" + firstname + "\", ");
//		bw.write("\"lastname" + "\": \"" + lastname + "\", ");
//		bw.write("\"id_num" + "\": \"" + id_num + "\", ");
//		bw.write("\"home_addr" + "\": \"" + home_addr + "\", ");
//		bw.write("\"city_state_zip" + "\": \"" + city_state_zip + "\", ");
//		bw.write("\"country" + "\": \"" + country + "\", ");
//		bw.write("\"province" + "\": \"" + province + "\", ");
//		bw.write("\"zipcode" + "\": \"" + zipcode + "\", ");
//		bw.write("\"isSingle" + "\": \"" + isSingle + "\"}]\n");
//		bw.close();
//		}catch(IOException e){
//			
//		}

	// 
		model3.addObject("firstname", cd.getFirstname());
		model3.addObject("lastname", cd.getLastname());
		model3.addObject("id_num", cd.getId_num());
		model3.addObject("home_addr", cd.getHome_addr());
		model3.addObject("city_state_zip", cd.getCity_state_zip());
		model3.addObject("country", cd.getCountry());
		model3.addObject("province", cd.getProvince());
		model3.addObject("zipcode", cd.getZipcode());
		model3.addObject("isSingle", cd.getIsSingle());
		return model3;

	}

	@RequestMapping(value = "/IncomeAndTax")
	public ModelAndView incomeAndTax() {

		ModelAndView model4 = new ModelAndView("IncomeAndTax");
		return model4;

	}

	@RequestMapping(value = "/calculateTax")
	public ModelAndView submitIncome(@RequestParam Map<String, String> IncomeAndTax)  {
		ModelAndView model5 = new ModelAndView("calculateTax");
//
		cd.setWage(IncomeAndTax.get("wage"));
		cd.setTaxable_refunds(IncomeAndTax.get("taxable_refunds"));
		cd.setScholarship(IncomeAndTax.get("scholarship"));
		cd.setTreaty(IncomeAndTax.get("treaty"));
		cd.setTreaty_type(IncomeAndTax.get("treaty_type"));

//		double num7 = Double.parseDouble(wage) + Double.parseDouble(taxable_refunds) + Double.parseDouble(scholarship);
//		double num8 = 0.0;
//		double num9 = 0.0;
//		double num10 = num7;
		
		
		cd.calculateNum7_8_9_10();

		cd.setItemized_deduction(IncomeAndTax.get("itemized_deduction"));

//		double num12 = num10 - Double.parseDouble(itemized_deduction);
//		String exemption = IncomeAndTax.get("exemption");
//		double num14 = num12 - Double.parseDouble(exemption);
//		double tax;
		cd.setExemption(IncomeAndTax.get("exemption"));
		cd.calculateNum12_14();
		cd.calcualteTax();

		cd.setFederal_withheld_W2(IncomeAndTax.get("federal_withheld_W2"));
		cd.setFederal_withheld_1042S(IncomeAndTax.get("federal_withheld_1042S"));
		cd.setReturn_of_2013(IncomeAndTax.get("return_of_2013"));
		cd.setCredit_1040C(IncomeAndTax.get("credit_1040C"));
			

		cd.calculateTotalPayments();
		
//		try {
//			tax = (double) GetTax.getTax(num14);
//			double num17 = tax;
//		String federal_withheld_W2 = IncomeAndTax.get("federal_withheld_W2");
//		String federal_withheld_1042S = IncomeAndTax.get("federal_withheld_1042S");
//		String return_of_2013 = IncomeAndTax.get("return_of_2013");
//		String credit_1040C = IncomeAndTax.get("credit_1040C");
			

//		Double totalPayments = Double.parseDouble(federal_withheld_W2) + Double.parseDouble(federal_withheld_1042S)
//				+ Double.parseDouble(return_of_2013) + Double.parseDouble(credit_1040C);
		
		

		// write tax data to Temp
//		String path = this.getClass().getResource("").getPath();
//		;
//		path = path.substring(0, path.length() - 99);
		//File file;
//		String jsonPath = "";
//		Path objPath = new Path();
//		String path = objPath.getPath();
//		boolean pathFlag = objPath.getFlag();
//		if (pathFlag == true){
//			jsonPath = path + "temp.json";
//		}else{
//			jsonPath = path + "temp.json";
//		}
//		
		
//		BufferedWriter bw = new BufferedWriter(
//				new OutputStreamWriter(new FileOutputStream(jsonPath, true)));
//		bw.write("[{");
//		bw.write("\"wage" + "\": \"" + wage + "\", ");
//		bw.write("\"taxable_refunds" + "\": \"" + taxable_refunds + "\", ");
//		bw.write("\"scholarship" + "\": \"" + scholarship + "\", ");
//		bw.write("\"treaty" + "\": \"" + treaty + "\", ");
//		bw.write("\"treaty_type" + "\": \"" + treaty_type + "\", ");
//		bw.write("\"num7" + "\": \"" + num7 + "\", ");
//		bw.write("\"num8" + "\": \"" + num8 + "\", ");
//		bw.write("\"num9" + "\": \"" + num9 + "\", ");
//		bw.write("\"num10" + "\": \"" + num10 + "\", ");
//		bw.write("\"itemized_deduction" + "\": \"" + itemized_deduction + "\", ");
//		bw.write("\"num12" + "\": \"" + num12 + "\", ");
//		bw.write("\"exemption" + "\": \"" + exemption + "\", ");
//		bw.write("\"num14" + "\": \"" + num14 + "\", ");
//		bw.write("\"tax" + "\": \"" + tax + "\", ");
//		bw.write("\"num17" + "\": \"" + num17 + "\", ");
//		bw.write("\"federal_withheld_W2" + "\": \"" + federal_withheld_W2 + "\", ");
//		bw.write("\"federal_withheld_1042S" + "\": \"" + federal_withheld_1042S + "\", ");
//		bw.write("\"return_of_2013" + "\": \"" + return_of_2013 + "\", ");
//		bw.write("\"credit_1040C" + "\": \"" + credit_1040C + "\", ");
//		bw.write("\"totalPayments" + "\": \"" + totalPayments + "\"}]\n");
//		bw.close();

		model5.addObject("wage", cd.getWage());
		model5.addObject("taxable_refunds", cd.getTaxable_refunds());
		model5.addObject("scholarship", cd.getScholarship());
		model5.addObject("treaty", cd.getTreaty());
		model5.addObject("treaty_type", cd.getTreaty_type());
		model5.addObject("num7", cd.getNum7());
		model5.addObject("num8", cd.getNum8());

		model5.addObject("num9", cd.getNum9());
		model5.addObject("num10", cd.getNum10());
		model5.addObject("itemized_deduction", cd.getItemized_deduction());
		model5.addObject("num12", cd.getNum12());

		model5.addObject("exemption", cd.getExemption());
		model5.addObject("num14", cd.getNum14());
		model5.addObject("tax", cd.getTax());
		model5.addObject("num17", cd.getNum17());
		model5.addObject("federal_withheld_W2", cd.getFederal_withheld_W2());
		model5.addObject("federal_withheld_1042S", cd.getFederal_withheld_1042S());
		model5.addObject("return_of_2013", cd.getReturn_of_2013());
		model5.addObject("credit_1040C", cd.getCredit_1040C());
		model5.addObject("totalPayments",cd.getTotalPayments());

		
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return model5;

	}

	@RequestMapping(value = "/refund")
	public ModelAndView refund(@RequestParam Map<String, String> refund)  {
		ModelAndView model6 = new ModelAndView("refund");
//		int i = 0;
//		BufferedReader reader = null;
//		String[] jsonContext = new String[2];
//
//		File file;
//		String jsonPath = "";
//		Path objPath = new Path();
//		String path = objPath.getPath();
//		boolean pathFlag = objPath.getFlag();
//		if (pathFlag == true){
//			jsonPath = path + "temp.json";
//		}else{
//			jsonPath = path + "temp.json";
//		}
//		
////		String path = this.getClass().getResource("").getPath();
////		path = path.substring(0, path.length() - 99);
//		try{
//		FileInputStream fileinputStream = new FileInputStream(jsonPath);
//		InputStreamReader inputStreamReader = new InputStreamReader(fileinputStream, "UTF-8");
//		reader = new BufferedReader(inputStreamReader);
//		String tempString = null;
//
//		while ((tempString = reader.readLine()) != null) {
//			jsonContext[i] = tempString;
//			i++;
//		}
//		// String JsonContext = new Util().ReadFile(path + "taxing/temp.json");
//
//		JSONArray jsonArray = JSONArray.fromObject(jsonContext[1]);
//		JSONObject jsonObject = jsonArray.getJSONObject(0);
//
//		String totalPayments = jsonObject.get("totalPayments").toString();
//		String tax = jsonObject.get("num17").toString();

//		double overpaid = 0;
//		double owe = 0;
//		String refundorowe = null;
//		if (Double.parseDouble(totalPayments) > Double.parseDouble(tax)) {
//			overpaid = Double.parseDouble(totalPayments) - Double.parseDouble(tax);
//			refundorowe = "Congratulations, you have refund available!";
//		} else {
//			owe = Double.parseDouble(tax) - Double.parseDouble(totalPayments);
//			refundorowe = "Sorry, you need to pay more tax!";
//		}
		cd.calculateOverpaidOrOwe();
		model6.addObject("overpaid", cd.getOverpaid());
		model6.addObject("owe", cd.getOwe());
		
		String overpaid_or_owe;
		
		if (cd.isOverpaid_or_owe()){
			overpaid_or_owe = "Congratulations! You have refund.";
			
		}else{
			overpaid_or_owe = "Sorry! You do not have refund.";
		
		}
		model6.addObject("refundorowe", overpaid_or_owe);
//		reader.close();
//		}catch(IOException e){
//			
//		}
		return model6;
	}

	@RequestMapping(value = "/refundConfirm")
	public ModelAndView refundConfirm(@RequestParam Map<String, String> refundConfirm)  {
		ModelAndView model7 = new ModelAndView("refundConfirm");
//		String overpaid = refundConfirm.get("overpaid");
//		String refund = refundConfirm.get("refund");
//		String routing_num = refundConfirm.get("routing_num");
//		String checkingOrSaving = refundConfirm.get("checkingOrSaving");
//		String account_num = refundConfirm.get("account_num");
//		String mail_outUS_add = refundConfirm.get("mail_outUS_add");
//		String tax_2015 = refundConfirm.get("tax_2015");
//		String zipcode = refundConfirm.get("zipcode");
//		String owe = refundConfirm.get("owe");
		
		cd.setRefund(refundConfirm.get("refund"));
		cd.setRouting_num(refundConfirm.get("routing_num"));
		cd.setCheckingOrSaving(refundConfirm.get("checkingOrSaving"));
		cd.setAccount_num(refundConfirm.get("account_num"));
		cd.setMail_outUS_add(refundConfirm.get("mail_outUS_add"));
		cd.setTax_2015(refundConfirm.get("tax_2015"));
		

//		String path = this.getClass().getResource("").getPath();
//		;
//		path = path.substring(0, path.length() - 99);
		
//		File file;
//		String jsonPath = "";
//		Path objPath = new Path();
//		String path = objPath.getPath();
//		boolean pathFlag = objPath.getFlag();
//		if (pathFlag == true){
//			jsonPath = path + "temp.json";
//		}else{
//			jsonPath = path + "temp.json";
//		}
//		
//		try{
//
//		BufferedWriter bw = new BufferedWriter(
//				new OutputStreamWriter(new FileOutputStream(jsonPath, true)));
//		bw.write("[{");
//		bw.write("\"overpaid" + "\": \"" + overpaid + "\", ");
//		bw.write("\"refund" + "\": \"" + refund + "\", ");
//		bw.write("\"routing_num" + "\": \"" + routing_num + "\", ");
//		bw.write("\"checkingOrSaving" + "\": \"" + checkingOrSaving + "\", ");
//		bw.write("\"account_num" + "\": \"" + account_num + "\", ");
//		bw.write("\"mail_outUS_add" + "\": \"" + mail_outUS_add + "\", ");
//		bw.write("\"tax_2015" + "\": \"" + tax_2015 + "\", ");
//		bw.write("\"zipcode" + "\": \"" + zipcode + "\", ");
//		bw.write("\"owe" + "\": \"" + owe + "\"}]");
//		bw.close();

		model7.addObject("overpaid", cd.getOverpaid());
		model7.addObject("refund", cd.getRefund());
		model7.addObject("routing_num", cd.getRouting_num());
		model7.addObject("checkingOrSaving", cd.getCheckingOrSaving());
		model7.addObject("account_num", cd.getAccount_num());
		model7.addObject("mail_outUS_add", cd.getMail_outUS_add());
		model7.addObject("tax_2015", cd.getTax_2015());
		model7.addObject("mail_outUS_add", cd.getMail_outUS_add());
//		}catch(IOException e){
//			
//		}
		return model7;
	}

	@RequestMapping(value = "/page2")
	public ModelAndView page2() {

		ModelAndView model9 = new ModelAndView("page2");
		return model9;

	}

	@RequestMapping(value = "/generatePdf")
	ModelAndView getPdf(@RequestParam Map<String, String> page2)  {
		ModelAndView model8 = new ModelAndView("generatePdf");

//		String citizenship = page2.get("citizenship");
//		System.out.println(citizenship);
//		String residence = page2.get("residence");
//		String greencard = page2.get("greencard");
//		String US_citizen = page2.get("US_citizen");
//		String greencard_holder = page2.get("greencard_holder");
//		String e = page2.get("e");
//		String f = page2.get("f");
//		String f_yes = page2.get("f_yes");
//		String enterUSA = page2.get("enterUSA");
//		String departedUSA = page2.get("departedUSA");
//		String h1 = page2.get("h1");
//		String h2 = page2.get("h2");
//		String h3 = page2.get("h3");
		cd.setCitizenship(page2.get("citizenship"));
		cd.setResidence(page2.get("residence"));
		cd.setGreencard(page2.get("greencard"));
		cd.setUS_citizen(page2.get("US_citizen"));
		cd.setGreencard_holder(page2.get("greencard_holder"));
		cd.setE(page2.get("e"));
		cd.setF(page2.get("f"));
		cd.setF_yes(page2.get("f_yes"));
		cd.setEnterUSA(page2.get("enterUSA"));
		cd.setDepartedUSA(page2.get("departedUSA"));
		cd.setH1(page2.get("h1"));
		cd.setH2(page2.get("h2"));
		cd.setH3(page2.get("h3"));
		
//		String I = page2.get("I");
//		String I2 = page2.get("I2");
//		String country2 = page2.get("country2");
//		String article_20 = page2.get("article_20");
//		String prior_tax_year_month = page2.get("prior_tax_year_month");
//		String amount_of_exemption_5000 = page2.get("amount_of_exemption_5000");
//		String treaty_total = page2.get("treaty_total");
//		String J = page2.get("J");
		cd.setI(page2.get("I"));
		cd.setI2(page2.get("I2"));
		cd.setCountry2(page2.get("country2"));
		cd.setArticle_20(page2.get("article_20"));
		cd.setPrior_tax_year_month(page2.get("prior_tax_year_month"));
		cd.setAmount_of_exemption_5000(page2.get("amount_of_exemption_5000"));
		cd.setTreaty_total(page2.get("treaty_total"));
		cd.setJ(page2.get("J"));

		int i = 0;

		BufferedReader reader = null;
		String[] jsonContext = new String[3];

//		String path = this.getClass().getResource("").getPath();
//		path = path.substring(0, path.length() - 99);
		
		File file;
		String jsonPath = "";
		Path objPath = new Path();
		String path = objPath.getPath();
//		boolean pathFlag = objPath.getFlag();
//		if (pathFlag == true){
//			jsonPath = path + "temp.json";
//		}else{
//			jsonPath = path + "temp.json";
//		}
//		
		
		

		try {
			
			//FileInputStream fileinputStream = new FileInputStream(jsonPath);
			//InputStreamReader inputStreamReader = new InputStreamReader(fileinputStream, "UTF-8");
			//reader = new BufferedReader(inputStreamReader);
			//String tempString = null;
//			model8.addObject("path", path + "/taxing/FormFillPDF.pdf");
			// modify the path of temp.json to FormFillPDF.pdf
			model8.addObject("path", path + "FormFillPDF.pdf");
			//System.out.println("jsonPath is : " + jsonPath.substring(0, jsonPath.length()-9));
//			while ((tempString = reader.readLine()) != null) {
//				jsonContext[i] = tempString;
//				i++;
//			}
			// String JsonContext = new Util().ReadFile(path + "taxing/temp.json");

//			JSONArray jsonArray0 = JSONArray.fromObject(jsonContext[0]);
//			JSONObject jsonObject0 = jsonArray0.getJSONObject(0);
//
//			JSONArray jsonArray1 = JSONArray.fromObject(jsonContext[1]);
//			JSONObject jsonObject1 = jsonArray1.getJSONObject(0);
//
//			JSONArray jsonArray2 = JSONArray.fromObject(jsonContext[2]);
//			JSONObject jsonObject2 = jsonArray2.getJSONObject(0);

//			String firstname = jsonObject0.get("firstname").toString();
//			String lastname = jsonObject0.get("lastname").toString();
//			String id_num = jsonObject0.get("id_num").toString();
//			String home_addr = jsonObject0.get("home_addr").toString();
//			String city_state_zip = jsonObject0.get("city_state_zip").toString();
//			String country = jsonObject0.get("country").toString();
//			String province = jsonObject0.get("province").toString();
//			String zipcode = jsonObject0.get("zipcode").toString();
//
//			String isSingle = jsonObject0.get("isSingle").toString();
			// /Users/chizhang/Documents/workspaceEE/taxing/test.pdf
			// /Users/chizhang/Documents/workspaceEE/taxing/FormFillPDF.pdf
			// /home/ubuntu/test/test.pdf

			PdfReader readerPdf = new PdfReader(path + "test.pdf");

			// PdfReader reader = new
			// PdfReader("/Users/chizhang/Documents/workspaceEE/taxing/test.pdf");
			/** filling in the personal information */
			PdfStamper stamp1 = new PdfStamper(readerPdf, new FileOutputStream(path + "FormFillPDF.pdf"));
			// model3.addObject("showstatus", "outputed");
			AcroFields form1 = stamp1.getAcroFields();
			// Personal info=============================================
			form1.setField("f1_01_0_", cd.getFirstname());
			form1.setField("f1_02_0_", cd.getLastname());
			form1.setField("f1_03_0_", cd.getId_num());
			form1.setField("f1_04_0_", cd.getHome_addr());
			form1.setField("f1_05_0_", cd.getCity_state_zip());
			form1.setField("TextField1", cd.getCountry());
			form1.setField("f1_73_0_", cd.getProvince());
			form1.setField("f1_301_0_", cd.getZipcode());
			form1.setField("c1_2_0_[0]", cd.getIsSingle());
			form1.setField("c1_2_0_[1]", cd.getIsSingle());

//			String wage = jsonObject1.get("wage").toString();
//			String taxable_refunds = jsonObject1.get("taxable_refunds").toString();
//			String scholarship = jsonObject1.get("scholarship").toString();
//			String treaty = jsonObject1.get("treaty").toString();
//			String treaty_type = jsonObject1.get("treaty_type").toString();
//			String num7 = jsonObject1.get("num7").toString();
//			String num8 = jsonObject1.get("num8").toString();
//			String num9 = jsonObject1.get("num9").toString();
//			String num10 = jsonObject1.get("num10").toString();
//			String itemized_deduction = jsonObject1.get("itemized_deduction").toString();
//			String num12 = jsonObject1.get("num12").toString();
//			String exemption = jsonObject1.get("exemption").toString();
//			String num14 = jsonObject1.get("num14").toString();
//			String tax = jsonObject1.get("tax").toString();
//			String num17 = jsonObject1.get("num17").toString();
//			String federal_withheld_W2 = jsonObject1.get("federal_withheld_W2").toString();
//			String federal_withheld_1042S = jsonObject1.get("federal_withheld_1042S").toString();
//			String return_of_2013 = jsonObject1.get("return_of_2013").toString();
//			String credit_1040C = jsonObject1.get("credit_1040C").toString();
//			String totalPayments = jsonObject1.get("totalPayments").toString();

			form1.setField("f1_10_0_", cd.getWage());
			form1.setField("f1_12_0_", cd.getTaxable_refunds());
			form1.setField("f1_14_0_", cd.getScholarship());
			form1.setField("f1_16_0_", cd.getTreaty());
			form1.setField("f1_17_0_", cd.getTreaty_type());

			form1.setField("f1_18_0_", cd.getNum7()+"");

			form1.setField("f1_24_0_", cd.getNum10() + "");
			form1.setField("f1_26_0_", cd.getItemized_deduction());

			form1.setField("f1_28_0_", cd.getNum12() + "");
			form1.setField("f1_30_0_", cd.getExemption());

			form1.setField("f1_32_0_", cd.getNum14() + "");

			form1.setField("f1_34_0_", cd.getTax() + "");
			form1.setField("f1_38_0_", cd.getTax() + "");
			form1.setField("f1_40_0_", cd.getFederal_withheld_W2());
			form1.setField("f1_100_0_", cd.getFederal_withheld_1042S());
			form1.setField("f1_42_0_", cd.getReturn_of_2013());
			form1.setField("f1_44_0_", cd.getCredit_1040C());

			form1.setField("f1_46_0_", cd.getTotalPayments() + "");

//			String overpaid = jsonObject2.get("overpaid").toString();
//			String refund = jsonObject2.get("refund").toString();
//			String routing_num = jsonObject2.get("routing_num").toString();
//			String checkingOrSaving = jsonObject2.get("checkingOrSaving").toString();
//			String account_num = jsonObject2.get("account_num").toString();
//			String mail_outUS_add = jsonObject2.get("mail_outUS_add").toString();
//			String tax_2015 = jsonObject2.get("tax_2015").toString();
//			String owe = jsonObject2.get("owe").toString();
			int tax_penalty = 0;
			form1.setField("f1_48_0_", cd.getOverpaid() + "");

			form1.setField("f1_50_0_", cd.getRefund());
			form1.setField("f1_52_0_", cd.getRouting_num());
			form1.setField("c1_4_0_[0]", cd.getCheckingOrSaving());
			form1.setField("c1_4_0_[1]", cd.getCheckingOrSaving());
			form1.setField("f1_53_0_", cd.getAccount_num());
			form1.setField("f1_74_0_", cd.getMail_outUS_add());
			form1.setField("f1_52_0_", cd.getRouting_num());
			form1.setField("f1_54_0_", cd.getTax_2015());

			form1.setField("f1_56_0_", cd.getOwe()+"");
			form1.setField("f1_58_0_", tax_penalty + "");
			// ======page2======================================
			form1.setField("f2_01_0_", cd.getCitizenship());
			form1.setField("f2_02_0_", cd.getResidence());
			form1.setField("c2_01_0_[0]", cd.getGreencard());
			form1.setField("c2_01_0_[1]", cd.getGreencard());
			form1.setField("c2_35_0_[0]", cd.getUS_citizen());
			form1.setField("c2_35_0_[1]", cd.getUS_citizen());
			form1.setField("c2_37_0_[0]", cd.getGreencard_holder());
			form1.setField("c2_37_0_[1]", cd.getGreencard_holder());
			form1.setField("f2_19_0_", cd.getE());
			form1.setField("c2_36_0_[0]", cd.getF());
			form1.setField("c2_36_0_[1]", cd.getF());
			form1.setField("f2_18_0_", cd.getF_yes());

			form1.setField("f2_019_0_", cd.getEnterUSA());
			form1.setField("f2_22_0_", cd.getDepartedUSA());
			form1.setField("f2_15_0_", cd.getH1());
			form1.setField("f2_16_0_", cd.getH2());
			form1.setField("f2_17_0_", cd.getH3());

			form1.setField("c2_22_0_[0]", cd.getI());
			form1.setField("c2_22_0_[1]", cd.getI());
			form1.setField("f2_129_0_", cd.getI2());

			form1.setField("f2_127_0_", cd.getCountry2());
			form1.setField("f2_128_0_", cd.getArticle_20());
			form1.setField("f2_129_0_", cd.getPrior_tax_year_month());
			form1.setField("f2_130_0_", cd.getAmount_of_exemption_5000());
			form1.setField("f2_143_0_", cd.getTreaty_total());
			form1.setField("c2_34_0_[0]", cd.getJ());
			form1.setField("c2_34_0_[1]", cd.getJ());

			stamp1.close();
			reader.close();
		} catch (Exception de) {
			de.printStackTrace();
		}
		
//		Session session = HibernatePersistence.getSessionFactory().openSession();
//        session.beginTransaction();
        
//        Product product = new Product();

        //Make some product for storing in database
        //product.setId(1);
//        product.setName("COKE");
//        product.setCode("C001");
//        product.setPrice(new BigDecimal("18.00"));

        
        //Save product to database
//        Integer productId =(Integer) session.save(cd);
//        session.getTransaction().commit();

//        //get data from  database
//        product = (Product) session.get(Product.class, productId);
//        System.out.println(product);

        //close session
//        HibernatePersistence.shutdown();
		
		
		client_DataServiceImpl.save(cd);
	
		return model8;
	}
	
	
	

}
