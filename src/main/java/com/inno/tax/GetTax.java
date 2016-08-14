package com.inno.tax;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class GetTax {
	
	
	
	
	public static int getTax(double texable_income) throws IOException {
		
		ArrayList<EZ_1040NR_TaxingTable> taxingTable = new ArrayList<EZ_1040NR_TaxingTable>();		
		BufferedReader br = null;
		String singleLine;
		boolean taxfound = false;
		int tax = 0;
		
		/**Load the taxing table*/
		
		try {
			String jsonPath = "";
			Path objPath = new Path();
			String path = objPath.getPath();
			boolean pathFlag = objPath.getFlag();
			System.out.println("getTax path is: " + path);
			//br = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/chengyangyan/Documents/workspaceEE/taxing/EZ_1040NR_TaxingTable")));
			br = new BufferedReader(new InputStreamReader(new FileInputStream(path + "EZ_1040NR_TaxingTable")));
		} catch(FileNotFoundException exception) {
			System.out.println("File Not Found!");
		}
		while((singleLine = br.readLine()) != null) {
			String[] ss = singleLine.split(" ");
			EZ_1040NR_TaxingTable cell = new EZ_1040NR_TaxingTable(
					Integer.parseInt(ss[0]), Integer.parseInt(ss[1]), Integer.parseInt(ss[2]));
			taxingTable.add(cell);
		}		
		br.close();
		
		/** compare taxable_income with the taxing table*/
		
		int gross = (int) Math.ceil(texable_income);	//round the texable_income to upper int
		System.out.println("taxable income= " + texable_income + " is round to= " +gross);
		
		while(!taxfound) {
			for(int i = 0; i < taxingTable.size(); i++) {
				if (gross > taxingTable.get(i).atleast) {
					tax = taxingTable.get(i).tax;
					taxfound = true;
				}
			}			
		}
		
		System.out.println("tax= " + tax);
		return tax;
	
	
	}
	
	
}
