
import java.sql.SQLException;
import java.util.*;


public class Main {
	
	
	
	public static void main(String[] args) throws SQLException, Exception {
		
		
		
		
		System.out.println("Bobs AutoCare");
		System.out.println(); System.out.println();
		
				
	    Scanner in = new Scanner(System.in);
		
		//Prompt info for car
		System.out.println("Please provide us with the following information.");
		
		
		String number = RandomString.getAlphaNumericString(5);
		System.out.print("Brand of Car: ");
		String brand = in.next();
		System.out.print("Model of Car: ");
		String model = in.next();
		System.out.print("Year of Car[YYYY]: ");
		int year = in.nextInt();
		System.out.print("Date of appointment[Mmm_dd]: ");
		String date = in.next();
		System.out.print("Time of appointment[(m)hh:mm]: ");
		String time = in.next();
		boolean oilChange = false;
		boolean tireRotation = false;
		boolean alignment = false;
		
		
		//Car info Class
		CarInfo c = new CarInfo(number, brand, model, year, oilChange, tireRotation, alignment, date, time);
		
		//Service class
		Menus m = new Menus();
		
		//Variable for menu choice
		int choice = 0;
		
		
		//Loop to repeat menu while still
		//looking at options
		do {
			
			m.menu();
			
			System.out.print("Menu Option--->>: ");
			choice = in.nextInt();
			
			switch (choice) {
			case 1:
				displayInfo(c.number, c.brand, c.model , c.year, c.oilChange, c.tireRotation, c.alignment, c.date, c.time);
				break;
			case 2:
				do {
				m.services();
				choice = in.nextInt();
				if (choice == 1) {
					System.out.println();
					System.out.print("Added Oil Change--> ");
					c.setOilChange(true); 
					Cnct.updateB("Oil_Change", true, number);  // Column, with What, in Account Number
				}
				else if (choice == 2) {
					System.out.println();
					System.out.print("Added Tire Rotation--> ");
					c.setTireRotation(true);
					Cnct.updateB("Tire_Rotation", true, number);  // Column, with What, in Account Number
				}
				
				else if (choice == 3) {
					System.out.println();
					System.out.println("Added Alignment Service--> ");
					c.setAlignment(true);
					Cnct.updateB("Alignment", true, number);  // Column, with What, in Account Number
				}
				else if (choice == 4) {
					System.out.println();
					System.out.println("Removed Oil Change --> ");
					c.setAlignment(true);
					Cnct.updateB("Oil_Change", false, number);  // Column, with What, in Account Number
					}
				else if (choice == 5) {
					System.out.println();
					System.out.println("Removed Tire Rotation --> ");
					c.setAlignment(false);
					Cnct.updateB("Tire_Rotation", false, number);  // Column, with What, in Account Number
					}
				else if (choice == 6) {
					System.out.println();
					System.out.println("Removed Alignment Service--> ");
					c.setAlignment(false);
					Cnct.updateB("Alignment", false, number);  // Column, with What, in Account Number
				}
				else 
				{
					break;
				}
				}while(choice!=7); break;
			case 3:
				do {
				m.appointment();
				choice = in.nextInt();
				if (choice == 1) {
					System.out.print("Enter New Date[Mmm_dd]: "); 
					String nd = in.next();
					System.out.print("\nDate Change--> ");
					c.setDate(nd);
					Cnct.updateS("Date", nd, number);  // Column, with What, in Account Number
				}
				else if (choice == 2) 
				{
					System.out.print("Enter New Time[(m)hh:mm]: ");
					String nt = in.next();
					System.out.print("\nTime Change--> ");
					c.setTime(nt);
					Cnct.updateS("Time", nt, number);
				}
				else if (choice == 3)
				{
					break;
				}
				}while(choice!=3); break; 
				
			case 4:
				do{
					m.editinfo();
					choice = in.nextInt();
					if (choice==1)
					{
						displayInfo(c.number, c.brand, c.model, c.year, c.oilChange, c.tireRotation, c.alignment, c.date, c.time);
					}
					else if(choice == 2) {
						Cnct.print();
						System.out.println("\n**Note: Services need to be changed in Service Menu**\n");
						System.out.print("Field to update: "); 
						String fld = in.next();
							if(fld.equals("AcctNum")) 
							{
							System.out.print("\n**Note: Account Number cannot be changed!\n");
							}
							else if(fld.equals("Year"))
							{
							System.out.print("New value: ");
							int vl2 = in.nextInt();
							System.out.print("Which Account Number?: ");
							String nm2 = in.next();
							System.out.print("Value Change--> ");
							c.setYear(vl2);
							Cnct.updateI(vl2, nm2);  // Column, with What, in Account Number
							Cnct.print();
							}
							else
							{
							System.out.print("New value: ");
							String vl = in.next();
							System.out.print("Which Account Number?: ");
							String nm = in.next();
							System.out.print("Value Change--> ");
							c.setDate(vl);
							Cnct.updateS(fld, vl, nm);  // Column, with What, in Account Number
							Cnct.print();
							if(vl.equals("Make")) 
							{
								c.setMake(vl);
								}
							else if(vl.equals("Model")) 
							{
								c.setModel(vl);
							}
							else {
								System.out.print("");
								}
							
							}
					
					}
					else if (choice == 3) 
					{
						System.out.print("Delete Appointment\nEnter Account Number:  ");
						String ay = in.next();
						System.out.println();
						System.out.print("Row Deleted--> ");
						Cnct.remove(ay);
					}
					else if (choice == 4)
					{
						Cnct.print();
					}
					else 
					{
						break;
					}
					
				}while(choice!=5); break;
			case 5:
				displayInfo(c.number, c.brand, c.model , c.year, c.oilChange, c.tireRotation, c.alignment, c.date, c.time);
				
				String number3 = RandomString.getAlphaNumericString(5);
				System.out.print("Brand of Car: ");
				String brand3 = in.next();
				System.out.print("Model of Car: ");
				String model3 = in.next();
				System.out.print("Year of Car: ");
				int year3 = in.nextInt();
				System.out.print("Date of appointment[Mmm_dd]: ");
				String date3 = in.next();
				System.out.print("Time of appointment[(m)hh:mm]: ");
				String time3 = in.next();
				boolean oilChange3 = false;
				boolean tireRotation3 = false;
				boolean alignment3 = false;
				c.setOilChange(oilChange3); c.setTireRotation(tireRotation3); c.setAlignment(alignment3);
				c.setDate(date3); c.setTime(time3); c.setYear(year3); c.setMake(brand3); c.setModel(model3); 
				c.setNumber(number3);
				displayInfo(c.number, c.brand, c.model , c.year, c.oilChange, c.tireRotation, c.alignment, c.date, c.time);
			}
			
		} while(choice != 0);
		in.close();
		
		
		System.out.println("\n\nThank You! Have A Nice Day!");
		
		//displayInfo(c.number, c.brand, c.model, c.year, c.oilChange, c.tireRotation, c.alignment, c.date, c.time);
	}
	
	

	

	//Method to display car information
	public static void displayInfo(String number, String brand, String model, int year, boolean oilChange, boolean tireRotation, boolean alignment, String date, String time) throws SQLException, Exception {
		System.out.println();
		System.out.println("-----------------------------------");
		System.out.println("Account Number    " + number);
		System.out.println("Brand:            " + brand);
		System.out.println("Model:            " + model);
		System.out.println("Year:             " + year);
		System.out.println("Oil Change:       " + oilChange);
		System.out.println("Tire Rotation:    " + tireRotation);
		System.out.println("Alignment:        " + alignment);
		System.out.println("Appointment Date: " + date);
		System.out.println("Appointment Time: " + time);
		System.out.println("-----------------------------------");
		System.out.println();
		System.out.print("Store Information[Y/N]");
		Scanner i = new Scanner(System.in);
		String write = i.next();
		if(write.equals("y")||write.equals("Y")) 
		{
			Cnct.insert(number, brand, model, year, oilChange, tireRotation, alignment, date, time);
			
		}
	}

}