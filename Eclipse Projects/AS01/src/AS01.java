import java.util.Scanner; 

public class AS01 {
	public static void MarginalTax (double venit, int categorie){
		
		double taxa = 0;
		
		if (categorie == 0) { 
			 if (venit <= 8350)
				 
				 taxa = venit * 0.10;
			 else if (venit <= 33950)
				 
				 taxa = 8350 * 0.10 + (venit - 8350) * 0.15;
			 else if (venit <= 82250)
				 
				 taxa = 8350 * 0.10 + (33950 - 8350) * 0.15 + (venit - 33950) * 0.25;
			 else if (venit <= 171550)
				 
				 taxa = 8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 - 33950) * 0.25 + (venit - 82250) * 0.28;
			 else if (venit <= 372950)
				 
				 taxa = 8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28 + (venit - 171550) * 0.35;
			 else
				 
				 taxa = 8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28 + (372950 - 171550) * 0.33 + (venit - 372950) * 0.35;
		}
		else if (categorie == 1) { 
			 if (venit <= 16700)
				 
				 taxa = venit * 0.10;
			 else if (venit <= 67900)
				 
				 taxa = 16700 * 0.10 + (venit - 16700) * 0.15;
			 else if (venit <= 137050)
				 
				 taxa = 16700 * 0.10 + (67900 - 16700) * 0.15 + (venit - 67900) * 0.25;
			 else if (venit <= 208850)
				 
				 taxa = 16700 * 0.10 + (67900 - 16700) * 0.15 + (137050 - 67900) * 0.25 + (venit - 137050) * 0.28;
			 else if (venit <= 372950)
				 
				 taxa = 16700 * 0.10 + (67900 - 16700) * 0.15 + (137050 - 67900) * 0.25 + (208850 - 137050) * 0.28 + (venit - 208850) * 0.35;
			 else
				 
				 taxa = 16700 * 0.10 + (67900 - 16700) * 0.15 + (137050 - 67900) * 0.25 + (208850 - 137050) * 0.28 + (372950 - 208850) * 0.33 + (venit - 372950) * 0.35;
		}
		else if (categorie == 2) { 
			if (venit <= 8350)
				 
				 taxa = venit * 0.10;
			 else if (venit <= 33950)
				 
				 taxa = 8350 * 0.10 + (venit - 8350) * 0.15;
			 else if (venit <= 68525)
				 
				 taxa = 8350 * 0.10 + (33950 - 8350) * 0.15 + (venit - 33950) * 0.25;
			 else if (venit <= 104425)
				 
				 taxa = 8350 * 0.10 + (33950 - 8350) * 0.15 + (68525 - 33950) * 0.25 + (venit - 68525) * 0.28;
			 else if (venit <= 186475)
				 
				 taxa = 8350 * 0.10 + (33950 - 8350) * 0.15 + (68525 - 33950) * 0.25 + (104425 - 68525) * 0.28 + (venit - 104425) * 0.35;
			 else
				 
				 taxa = 8350 * 0.10 + (33950 - 8350) * 0.15 + (68525 - 33950) * 0.25 + (104425 - 68525) * 0.28 + (186475 - 104425) * 0.33 + (venit - 186475) * 0.35;
		}
		else if (categorie == 3) {  
			if (venit <= 11950)
				 
				 taxa = venit * 0.10;
			 else if (venit <= 45500)
				 
				 taxa = 11950 * 0.10 + (venit - 11950) * 0.15;
			 else if (venit <= 117450)
				 
				 taxa = 11950 * 0.10 + (45500 - 11950) * 0.15 + (venit - 45500) * 0.25;
			 else if (venit <= 190200)
				 
				 taxa = 11950 * 0.10 + (45500 - 11950) * 0.15 + (117450 - 45500) * 0.25 + (venit - 117450) * 0.28;
			 else if (venit <= 372950)
				 
				 taxa = 11950 * 0.10 + (45500 - 11950) * 0.15 + (117450 - 45500) * 0.25 + (190200 - 117450) * 0.28 + (venit - 190200) * 0.35;
			 else
				 
				 taxa = 11950 * 0.10 + (45500 - 11950) * 0.15 + (117450 - 45500) * 0.25 + (190200 - 117450) * 0.28 + (372950 - 190200) * 0.33 + (venit - 372950) * 0.35;
		
		}
		
		if(categorie>=0 && categorie<=3){
			System.out.println( (int)(taxa * 100) / 100.0 );
	
		}
		else {
			 System.out.println("Categorie Invalida...");
			
		}
			
		
	}

	public static void main (String[] args){
            
		Scanner input = new Scanner(System.in);
				 
		System.out.print("(0-single filer, 1-married jointly,\n" +  "2-married separately, 3-head of household)\n" + "Enter the filing status: ");
		int status = input.nextInt();	
				
		System.out.print("Enter the taxable income: ");
		double income = input.nextDouble();
		
		MarginalTax(income,status);
		System.exit(0);
            
		input.close();
	}  
}
