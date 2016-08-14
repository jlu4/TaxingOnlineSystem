package com.inno.tax;

import java.io.IOException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "ClientData")
@JsonIgnoreProperties(value = { "handler", "hibernateLazyInitializer" })
public class Client_Data {

	
//	String firstname = person_info.get("firstname");
//	String lastname = person_info.get("lastname");
//	String id_num = person_info.get("id_num");
//	String home_addr = person_info.get("home_addr");
//	String city_state_zip = person_info.get("city_state_zip");
//	String country = person_info.get("country");
//	String province = person_info.get("province");
//	String zipcode = person_info.get("zipcode");
//	String isSingle = person_info.get("isSingle");
//	String wage = IncomeAndTax.get("wage");
//	String taxable_refunds = IncomeAndTax.get("taxable_refunds");
//	String scholarship = IncomeAndTax.get("scholarship");
//	String treaty = IncomeAndTax.get("treaty");
//	String treaty_type = IncomeAndTax.get("treaty_type");
	
//model3	
	private String firstname;
	private String lastname;
	private String id_num;
	private String home_addr;
	private String city_state_zip;
	private String country;
	private String province;
	private String zipcode;
	private String isSingle;
//model5	
	private String wage;
	private String taxable_refunds;
	private String scholarship;
	private String treaty;
	private String treaty_type;
	private String itemized_deduction;
	private String exemption;

//model6
	private String federal_withheld_W2;
	private String federal_withheld_1042S;
	private String return_of_2013;
	private String credit_1040C;
	
//model7
	
	private String refund;
	private String routing_num;
	private String checkingOrSaving;
	private String account_num;
	private String mail_outUS_add;
	private String tax_2015;
	
//model9
	
	private String citizenship;
	private String residence;
	private String greencard;
	private String US_citizen;
	private String greencard_holder;
	private String e;
	private String f;
	private String f_yes;
	private String enterUSA;
	private String departedUSA;
	private String h1;
	private String h2;
	private String h3;
	private String I;
	private String I2;
	private String country2;
	private String article_20;
	private String prior_tax_year_month;
	private String amount_of_exemption_5000;
	private String treaty_total;
	private String J;
	
	
	

	
	private double num7;
	private double num8;
	private double num9;
	private double num10;
	private double num12;
	private double num14;
	private double tax;
	private double num17;
	private Double totalPayments;
	private double overpaid;
	private double owe;
	private boolean overpaid_or_owe;// true:overpaid  false:owe
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
	private Integer id;
	
	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public void calculateOverpaidOrOwe(){
		overpaid = 0.0;
		owe = 0.0;
		
		if (totalPayments > tax) {
			overpaid = totalPayments-tax;
			overpaid_or_owe = true;
		} else {
			owe = tax - totalPayments;
			overpaid_or_owe = false;
		}
		
		
	}
	
	
	
    public void calculateTotalPayments(){
    	totalPayments = Double.parseDouble(federal_withheld_W2) + Double.parseDouble(federal_withheld_1042S)
    	+ Double.parseDouble(return_of_2013) + Double.parseDouble(credit_1040C);
    	
    }
	public void calculateNum12_14(){
		num12 = num10 - Double.parseDouble(itemized_deduction);
		num14 = num12 - Double.parseDouble(exemption);
	}
	
	public void calcualteTax(){
		
		
		try {
			tax = (double) GetTax.getTax(num14);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		double num17 = tax;

	}
	
	
	
	
	public void calculateNum7_8_9_10(){
		
		num7 = Double.parseDouble(wage) + Double.parseDouble(taxable_refunds) + Double.parseDouble(scholarship);
		num8 = 0.0;
		num9 = 0.0;
		num10 = num7;
	}
	
	
	public String getExemption() {
		return exemption;
	}


	public void setExemption(String exemption) {
		this.exemption = exemption;
	}


	public double getNum12() {
		return num12;
	}


	public void setNum12(double num12) {
		this.num12 = num12;
	}


	public double getNum14() {
		return num14;
	}


	public void setNum14(double num14) {
		this.num14 = num14;
	}


	public double getTax() {
		return tax;
	}


	public void setTax(double tax) {
		this.tax = tax;
	}


	public double getNum7() {
		return num7;
	}
	public void setNum7(double num7) {
		this.num7 = num7;
	}
	public double getNum8() {
		return num8;
	}
	public void setNum8(double num8) {
		this.num8 = num8;
	}
	public double getNum9() {
		return num9;
	}
	public void setNum9(double num9) {
		this.num9 = num9;
	}
	public double getNum10() {
		return num10;
	}
	public void setNum10(double num10) {
		this.num10 = num10;
	}
	public String getWage() {
		return wage;
	}
	public void setWage(String wage) {
		this.wage = wage;
	}
	public String getTaxable_refunds() {
		return taxable_refunds;
	}
	public void setTaxable_refunds(String taxable_refunds) {
		this.taxable_refunds = taxable_refunds;
	}
	public String getScholarship() {
		return scholarship;
	}
	public void setScholarship(String scholarship) {
		this.scholarship = scholarship;
	}
	public String getTreaty() {
		return treaty;
	}
	public void setTreaty(String treaty) {
		this.treaty = treaty;
	}
	public String getTreaty_type() {
		return treaty_type;
	}
	public void setTreaty_type(String treaty_type) {
		this.treaty_type = treaty_type;
	}
	public Client_Data() {
		super();
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getId_num() {
		return id_num;
	}
	public void setId_num(String id_num) {
		this.id_num = id_num;
	}
	public String getHome_addr() {
		return home_addr;
	}
	public void setHome_addr(String home_addr) {
		this.home_addr = home_addr;
	}
	public String getCity_state_zip() {
		return city_state_zip;
	}
	public void setCity_state_zip(String city_state_zip) {
		this.city_state_zip = city_state_zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getIsSingle() {
		return isSingle;
	}
	public void setIsSingle(String isSingle) {
		this.isSingle = isSingle;
	}





	public String getItemized_deduction() {
		return itemized_deduction;
	}





	public void setItemized_deduction(String itemized_deduction) {
		this.itemized_deduction = itemized_deduction;
	}
	
	public double getNum17() {
		return num17;
	}

	public void setNum17(double num17) {
		this.num17 = num17;
	}

	public String getFederal_withheld_W2() {
		return federal_withheld_W2;
	}

	public void setFederal_withheld_W2(String federal_withheld_W2) {
		this.federal_withheld_W2 = federal_withheld_W2;
	}

	public String getFederal_withheld_1042S() {
		return federal_withheld_1042S;
	}

	public void setFederal_withheld_1042S(String federal_withheld_1042S) {
		this.federal_withheld_1042S = federal_withheld_1042S;
	}

	public String getReturn_of_2013() {
		return return_of_2013;
	}

	public void setReturn_of_2013(String return_of_2013) {
		this.return_of_2013 = return_of_2013;
	}

	public String getCredit_1040C() {
		return credit_1040C;
	}

	public void setCredit_1040C(String credit_1040c) {
		credit_1040C = credit_1040c;
	}
	public Double getTotalPayments() {
		return totalPayments;
	}
	public void setTotalPayments(Double totalPayments) {
		this.totalPayments = totalPayments;
	}
	public double getOverpaid() {
		return overpaid;
	}
	public void setOverpaid(double overpaid) {
		this.overpaid = overpaid;
	}
	public double getOwe() {
		return owe;
	}
	public void setOwe(double owe) {
		this.owe = owe;
	}



	public boolean isOverpaid_or_owe() {
		return overpaid_or_owe;
	}



	public void setOverpaid_or_owe(boolean overpaid_or_owe) {
		this.overpaid_or_owe = overpaid_or_owe;
	}



	public String getRefund() {
		return refund;
	}



	public void setRefund(String refund) {
		this.refund = refund;
	}



	public String getRouting_num() {
		return routing_num;
	}



	public void setRouting_num(String routing_num) {
		this.routing_num = routing_num;
	}



	public String getCheckingOrSaving() {
		return checkingOrSaving;
	}



	public void setCheckingOrSaving(String checkingOrSaving) {
		this.checkingOrSaving = checkingOrSaving;
	}



	public String getAccount_num() {
		return account_num;
	}



	public void setAccount_num(String account_num) {
		this.account_num = account_num;
	}



	public String getMail_outUS_add() {
		return mail_outUS_add;
	}



	public void setMail_outUS_add(String mail_outUS_add) {
		this.mail_outUS_add = mail_outUS_add;
	}



	public String getTax_2015() {
		return tax_2015;
	}



	public void setTax_2015(String tax_2015) {
		this.tax_2015 = tax_2015;
	}



	public String getCitizenship() {
		return citizenship;
	}



	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}



	public String getResidence() {
		return residence;
	}



	public void setResidence(String residence) {
		this.residence = residence;
	}



	public String getGreencard() {
		return greencard;
	}



	public void setGreencard(String greencard) {
		this.greencard = greencard;
	}



	public String getUS_citizen() {
		return US_citizen;
	}



	public void setUS_citizen(String uS_citizen) {
		US_citizen = uS_citizen;
	}



	public String getGreencard_holder() {
		return greencard_holder;
	}



	public void setGreencard_holder(String greencard_holder) {
		this.greencard_holder = greencard_holder;
	}



	public String getE() {
		return e;
	}



	public void setE(String e) {
		this.e = e;
	}



	public String getF() {
		return f;
	}



	public void setF(String f) {
		this.f = f;
	}



	public String getF_yes() {
		return f_yes;
	}



	public void setF_yes(String f_yes) {
		this.f_yes = f_yes;
	}



	public String getEnterUSA() {
		return enterUSA;
	}



	public void setEnterUSA(String enterUSA) {
		this.enterUSA = enterUSA;
	}



	public String getDepartedUSA() {
		return departedUSA;
	}



	public void setDepartedUSA(String departedUSA) {
		this.departedUSA = departedUSA;
	}



	public String getH1() {
		return h1;
	}



	public void setH1(String h1) {
		this.h1 = h1;
	}



	public String getH2() {
		return h2;
	}



	public void setH2(String h2) {
		this.h2 = h2;
	}



	public String getH3() {
		return h3;
	}



	public void setH3(String h3) {
		this.h3 = h3;
	}



	public String getI() {
		return I;
	}



	public void setI(String i) {
		I = i;
	}



	public String getI2() {
		return I2;
	}



	public void setI2(String i2) {
		I2 = i2;
	}



	public String getCountry2() {
		return country2;
	}



	public void setCountry2(String country2) {
		this.country2 = country2;
	}



	public String getArticle_20() {
		return article_20;
	}



	public void setArticle_20(String article_20) {
		this.article_20 = article_20;
	}



	public String getPrior_tax_year_month() {
		return prior_tax_year_month;
	}



	public void setPrior_tax_year_month(String prior_tax_year_month) {
		this.prior_tax_year_month = prior_tax_year_month;
	}



	public String getAmount_of_exemption_5000() {
		return amount_of_exemption_5000;
	}



	public void setAmount_of_exemption_5000(String amount_of_exemption_5000) {
		this.amount_of_exemption_5000 = amount_of_exemption_5000;
	}



	public String getTreaty_total() {
		return treaty_total;
	}



	public void setTreaty_total(String treaty_total) {
		this.treaty_total = treaty_total;
	}



	public String getJ() {
		return J;
	}



	public void setJ(String j) {
		J = j;
	}
	
	
	
	
}
