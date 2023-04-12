/**
 * A class to present data from a company into a Quarterly report
 * This version only presents: Total Sales per quarter, Tax to be paid at 17%, a new sales target for the next quarter
 * @author AM
 * @version 1.0.0.0
 */




public class Quarterly_Report {
	
	 // create and populate 2D array for each departmentSales 
		int [][] departmentSales = {{67, 63, 78, 78, 104, 103}, //electrical 
				{65, 67, 56, 45, 56, 72}, //kitchen
				{63, 63, 65, 71, 73, 69}, //bathroom
				{18, 24, 22, 19, 17, 16}, //soft furnishing
				{16, 23, 21, 19, 20, 19}}; //accessories
	// 	
		String[] departmentNames = {"Electrical", "Kitchen", "Bathroom", "Soft Furnishing", "Accessories"};

		int[][] quarterTotal = new int[5][2];

		
	/* algorithm 1 - The total sales for each departmentSales per quarter 
	 			i.e. “2nd Quarter totals: Electrical, £208,000” */
		
	public void totalSalesPerQuarter() {		
		//  Loop through departmentSales
		for (int i = 0; i < 5; i++) {
		    // Loop through each month
		    for (int i1 = 0; i1 < 6; i1++) {
		        // Check if the month is in the first or second quarter
		        if (i1 < 3) {
		            // Add the sales to the first quarter total 
		            quarterTotal[i][0] = quarterTotal[i][0] + departmentSales[i][i1];
		        } 
		        else {
		            // Add the sales to the second quarter total 
		            quarterTotal[i][1] = quarterTotal[i][1] + departmentSales[i][i1];
		        }
		    }
		}
		
		// return sales for quarter
		for (int i = 0; i < 2; i++) {
			System.out.print("\nTotal Sales - Quarter ");
			System.out.println(i+2);
			
			// return sales for department
			for (int i1 = 0; i1 < 5; i1++) {
				System.out.print("\t"); //format
				System.out.print(departmentNames[i1] + " ");
				System.out.print("  £ ");
				System.out.print(1000 * quarterTotal[i1][i]); //convert from £000 to £
				System.out.print("\t"); //format
			}
			System.out.println(); // formatting
		}
	}

	/* algorithm 2 - given the total sales for each quarter, 
	 		calculate the tax that needs to be paid at 17%. */
	
	public void taxOwed () {
		int taxRate = 17; //17% tax rate set
		int sumToBeTaxed = 0; // set sum to be taxed.
		for(int i = 0; i < 2; i++) { //for loop run through quarters
				for(int i1 = 0; i1 < 5; i1++) { //for loop run through departments
					sumToBeTaxed = sumToBeTaxed + quarterTotal[i1][i]; //add each dept into sumToBeTaxed
					
			}
		System.out.print("\nTotal tax owed for Quarter ");
		System.out.print(i+2); //adjust for actual quarter
		System.out.print("\t £ "); //formatting
		System.out.println(sumToBeTaxed*10*taxRate); //adjustment made to convert to £ from £000
		}
	}
	
	/* algorithm 3 - given the average sales for each department across the last reported quarter, 
	provide a new sales target for each departmentSales with an increase of 12% */

	public void salesTarget () {
		double targetIncrease = 1.12; //target increase 12%. Used 1.12, as can times this to get a 12% increase
	
		for (int i = 1; i < 2; i++) { //for loop to run through quarters
			System.out.print("Sales Target - Quarter ");
			System.out.println(i+3); //adjust for actual quarter 4
			
			   for (int i1 = 0; i1 < 5; i1++) { //nested for loop to run through department 
				   	System.out.print("\t"); //formatting
				   	System.out.print(departmentNames[i1] + " "); //print department names
				   	System.out.print("  £ "); // print out £ sign
				   	int target = (int)(1000 * quarterTotal[i1][i] * targetIncrease); 
				   	//set target as wrapper class to avoid printing double with loads of zeros after decimal point. Converted to £, from £000 within this line.
				   	System.out.print(target); // print the above target wrapper class.
				   	System.out.print("\t"); //formatting.
		        }           
		    }
		}
		
	/*main method*/
	public static void main(String[] args) {
		Quarterly_Report qr = new Quarterly_Report(); //new obj within main method
		
		System.out.println("************\t QUARTERLY REPORT \t************"); //heading for report

		
		System.out.print("\n*******\t TOTAL SALES PER QUARTER \t*******");  //heading for algorithm 1
		qr.totalSalesPerQuarter(); 
		System.out.println();
		
		System.out.print("\n*******\t TAX OWED \t*******"); //heading for algorithm 2
		qr.taxOwed();
		System.out.println();

		System.out.println("\n*******\t SALES TARGET \t*******"); //heading for algorithm 3
		qr.salesTarget();
		System.out.println(); 
		
		System.out.print("\n************\t END OF REPORT \t************"); //heading for report
		
	}

}
