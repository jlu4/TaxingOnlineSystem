package com.inno.tax;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class EZ_1040NR_TaxingTable {
	
	int atleast = 0;
	int lessthan = 0;
	int tax = 0;
	
	public EZ_1040NR_TaxingTable(int atleast, int lessthan, int tax) {
		super();
		this.atleast = atleast;
		this.lessthan = lessthan;
		this.tax = tax;
	}

	@Override
	public String toString() {
		return atleast + " " + lessthan + " " + tax + "\n";
	}
	
	public static void main1(String[] args) throws IOException {
		
		ArrayList<EZ_1040NR_TaxingTable> taxingtable = new ArrayList<EZ_1040NR_TaxingTable>();
		BufferedWriter bw = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream("EZ_1040NR_TaxingTable")));
		
		
		/** first 3 elements
		 * 	0 to 50,tax rate = 10%, base tax = 0
		 */
		taxingtable.add(new EZ_1040NR_TaxingTable(0, 5, 0)); //1st element
		taxingtable.add(new EZ_1040NR_TaxingTable(5, 15, 1)); //2nd element
		taxingtable.add(new EZ_1040NR_TaxingTable(15, 25, 2)); //3rd element

		
		/** from 4th to 122th
		 * 	50 to 3000, 25 per increment, 119 elements,tax rate = 10%,base tax = 0
		 */
		for (int i = 0; i < 119; i++) {
			EZ_1040NR_TaxingTable tt = new EZ_1040NR_TaxingTable(
					(i+1)*25, (i+2)*25, (int) Math.round((2*i+3)*25*0.1/2));
			taxingtable.add(tt);
		}
		
		/** from 123th to 244th
		 * 	3000 to 9100, 50 per increment, 122 elements,tax rate = 10%
		 */
		for (int i = 0; i < 122; i++) {
			EZ_1040NR_TaxingTable tt = new EZ_1040NR_TaxingTable(
					(i+60)*50, (i+61)*50, (int) Math.round((2*i+121)*50*0.1/2));
			taxingtable.add(tt);
		}
		
		/** from 245th to 800th
		 * 	9100to 36900, 50 per increment, 556 elements,tax rate = 15%, base tax = 908
		 */
		
		for (int i = 0; i < 556; i++) {
			EZ_1040NR_TaxingTable tt = new EZ_1040NR_TaxingTable(
					(i+182)*50, (i+183)*50, (908 + (int) ((i+1)*50*0.15)));
			taxingtable.add(tt);
		}
		
		/**801th element, unique!!*/
		taxingtable.add(new EZ_1040NR_TaxingTable(36900, 36950, 5088)); 
		
		/** from 802th to 1849th
		 * 	36950to 89350, 50 per increment, 1048 elements,tax rate = 25%, base tax = 5088
		 */		
		for (int i = 0; i < 1048; i++) {
			EZ_1040NR_TaxingTable tt = new EZ_1040NR_TaxingTable(
					(i+739)*50, (i+740)*50, (5088 + (int) ((i+1)*50*0.25)));
			taxingtable.add(tt);
		}
		
		/**1850th element, unique!!*/
		taxingtable.add(new EZ_1040NR_TaxingTable(89350, 89400, 18201)); 
		
		/** from 1851th to 2062th
		 * 	89400 to 100000, 50 per increment, 212 elements,tax rate = 28%, base tax = 18201
		 */
		
		for (int i = 0; i < 212; i++) {
			EZ_1040NR_TaxingTable tt = new EZ_1040NR_TaxingTable(
					(i+1788)*50, (i+1789)*50, (18201 + (int) ((i+1)*50*0.28)));
			taxingtable.add(tt);
		}
		
		/**write taxing table to file
		 *  
		 */				
		for (int i =0 ; i <taxingtable.size(); i++) {
			bw.write(taxingtable.get(i).toString());
		}		
		bw.flush();
		bw.close();
	}

}


