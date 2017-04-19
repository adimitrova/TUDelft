import java.util.*;

public class MoneyUnitsConverter {

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int choice;
			System.out.println("Select 1 for Money or 2 for Units converter");
			choice = sc.nextInt();
			
			switch(choice)
				{
				case 1: {
					MoneyConvert();				
				}
				case 2: {
					UnitsConvert();
				}
			}
		}
			
			
		private static void MoneyConvert(){
			Scanner sc = new Scanner(System.in);
			double amount, converted;
			int convertFROM, convertTO;
			
			System.out.println("***** Money converter *****");
			System.out.print("Enter amount: ");
			amount = sc.nextDouble();
			System.out.println("Enter currency to convert FROM: ");
			System.out.println("1: EUR // 2: BGN // 3: GBP // 4: USD");
			convertFROM = sc.nextInt();
			System.out.print("Enter currency to convert TO (same options): ");
			convertTO = sc.nextInt();
			
			switch(convertFROM)
				{
				case 1: {
					// fromEURO
					switch(convertTO){
					case 1: System.out.println("Amount is already in Euro"); //toEURO
					case 2: converted = amount * 1.95411; System.out.println(converted); break; //toBGN
					case 3: converted = amount * 0.8901; System.out.println(converted); break; //toGBP
					case 4: converted = amount * 1.0887; System.out.println(converted); break; //toUSD
					}
					break;
				}
				case 2: {
					// fromBGN
					switch(convertTO){
					case 1: converted = amount * 0.5112; System.out.println(converted); break; //toEURO
					case 2: System.out.println("Amount is already in Bulgarian leva"); break; //toBGN
					case 3: converted = amount * 0.4551; System.out.println(converted); break; //toGBP
					case 4: converted = amount * 0.5566; System.out.println(converted); break; //toUSD
					}
					break;
				}
				case 3: {
					// fromGBP
					switch(convertTO){
					case 1: converted = amount * 1.1234; System.out.println(converted); break; //toEURO
					case 2: converted = amount * 2.1975; System.out.println(converted); break; //toBGN
					case 3: System.out.println("Amount is already in British pounds"); break;  //toGBP
					case 4: converted = amount * 1.2231; System.out.println(converted); break; //toUSD
					}
					break;
				}
				case 4: {
					// fromUSD
					switch(convertTO){
					case 1: converted = amount * 0.919566; System.out.println(converted); //toEURO
					case 2: converted = amount * 1.79692; System.out.println(converted); //toBGN
					case 3: converted = amount * 0.820041; System.out.println(converted); //toGBP
					case 4: System.out.println("Amount is already in US Dollars"); //toUSD
					}
					break;
				}
			}
		}
		
		private static void UnitsConvert(){
			Scanner sc = new Scanner(System.in);
			double value, converted;
			int convertFROM, convertTO, area;
			
			System.out.println("***** Units converter *****");
			System.out.println("Select area for the conversion: "); //area of interest: time conversion, distance, weight etc.
			System.out.println("1: Distance, height, length // 2: Speed // 3: Weight // 4: Area // 5. Temperature");
			area = sc.nextInt();
					
			System.out.print("Enter initial value: ");
			value = sc.nextDouble();
			
			switch(area)
			{
				// select Distance, height, length
				case 1: 
				{
					System.out.println("Unit to convert FROM: ");
					System.out.println("1: Feet // 2: Inches // 3: Yards // 4: Miles // 5.Light Years // 6. Km // 7. Meters // 8. Millimeters");
					convertFROM = sc.nextInt();
					
					System.out.print("Enter currency to convert TO: ");
					System.out.println("1: Feet // 2: Inches // 3: Yards // 4: Miles // 5.Light Years // 6. Km // 7. Meters // 8. Millimeters");
					convertTO = sc.nextInt();
					
					switch(convertFROM){
					//from Feet
					case 1: {
							switch(convertTO){
								case 1: System.out.println("Already in Feet"); break; //toFeet
								case 2: converted = value * 1.95411; System.out.println(converted); break; //toInches
								case 3: converted = value * 0.8901; System.out.println(converted); break; //toYards
								case 4: converted = value * 1.0887; System.out.println(converted); break; //toMiles
								case 5: converted = value * 1.0887; System.out.println(converted); break; //toLightYears
								case 6: converted = value * 1.95411; System.out.println(converted); break; //toKm
								case 7: converted = value * 0.8901; System.out.println(converted); break; //toMeters
								case 8: converted = value * 1.0887; System.out.println(converted); break; //toMillimeters
							}
							break;
						}
					// From Inches
					case 2: {
						switch(convertTO){
							case 1: converted = value * 1.95411; System.out.println(converted); break; //toFeet
							case 2: System.out.println("Already in Feet"); break; //toInches
							case 3: converted = value * 0.8901; System.out.println(converted); break; //toYards
							case 4: converted = value * 1.0887; System.out.println(converted); break; //toMiles
							case 5: converted = value * 1.0887; System.out.println(converted); break; //toLightYears
							case 6: converted = value * 1.95411; System.out.println(converted); break; //toKm
							case 7: converted = value * 0.8901; System.out.println(converted); break; //toMeters
							case 8: converted = value * 1.0887; System.out.println(converted); break; //toMillimeters
						}
						break;
					}
					// From Yards
					case 3: {
						switch(convertTO){
							case 1: converted = value * 1.95411; System.out.println(converted); break; //toFeet
							case 2: converted = value * 1.95411; System.out.println(converted); break; //toInches
							case 3: System.out.println("Already in Feet"); break; //toYards
							case 4: converted = value * 1.0887; System.out.println(converted); break; //toMiles
							case 5: converted = value * 1.0887; System.out.println(converted); break; //toLightYears
							case 6: converted = value * 1.95411; System.out.println(converted); break; //toKm
							case 7: converted = value * 0.8901; System.out.println(converted); break; //toMeters
							case 8: converted = value * 1.0887; System.out.println(converted); break; //toMillimeters
						}
						break;
					}
					// From Miles
					case 4: {
						switch(convertTO){
							case 1: converted = value * 1.95411; System.out.println(converted); break; //toFeet
							case 2: converted = value * 1.95411; System.out.println(converted); break; //toInches
							case 3: converted = value * 0.8901; System.out.println(converted); break; //toYards
							case 4: System.out.println("Already in Feet"); break; //toMiles
							case 5: converted = value * 1.0887; System.out.println(converted); break; //toLightYears
							case 6: converted = value * 1.95411; System.out.println(converted); break; //toKm
							case 7: converted = value * 0.8901; System.out.println(converted); break; //toMeters
							case 8: converted = value * 1.0887; System.out.println(converted); break; //toMillimeters
						}
						break;
					}
					// From LightYears
					case 5: {
						switch(convertTO){
							case 1: converted = value * 1.95411; System.out.println(converted); break; //toFeet
							case 2: converted = value * 1.95411; System.out.println(converted); break; //toInches
							case 3: converted = value * 0.8901; System.out.println(converted); break; //toYards
							case 4: converted = value * 1.0887; System.out.println(converted); break; //toMiles
							case 5: System.out.println("Already in Feet"); break; //toLightYears
							case 6: converted = value * 1.95411; System.out.println(converted); break; //toKm
							case 7: converted = value * 0.8901; System.out.println(converted); break; //toMeters
							case 8: converted = value * 1.0887; System.out.println(converted); break; //toMillimeters
						}
						break;
					}
					// From Km
					case 6: {
						switch(convertTO){
							case 1: converted = value * 1.95411; System.out.println(converted); break; //toFeet
							case 2: converted = value * 1.95411; System.out.println(converted); break; //toInches
							case 3: converted = value * 0.8901; System.out.println(converted); break; //toYards
							case 4: converted = value * 1.0887; System.out.println(converted); break; //toMiles
							case 5: converted = value * 1.0887; System.out.println(converted); break; //toLightYears
							case 6: System.out.println("Already in Feet"); break; //toKm
							case 7: converted = value * 0.8901; System.out.println(converted); break; //toMeters
							case 8: converted = value * 1.0887; System.out.println(converted); break; //toMillimeters
						}
						break;
					}
					// From Meters
					case 7: {
						switch(convertTO){
							case 1: converted = value * 1.95411; System.out.println(converted); break; //toFeet
							case 2: converted = value * 1.95411; System.out.println(converted); break; //toInches
							case 3: converted = value * 0.8901; System.out.println(converted); break; //toYards
							case 4: converted = value * 1.0887; System.out.println(converted); break; //toMiles
							case 5: converted = value * 1.0887; System.out.println(converted); break; //toLightYears
							case 6: converted = value * 1.95411; System.out.println(converted); break; //toKm
							case 7: System.out.println("Already in Feet"); break; //toMeters
							case 8: converted = value * 1.0887; System.out.println(converted); break; //toMillimeters
						}
						break;
					}
					// From Millimeters
					case 8: {
						switch(convertTO){
							case 1: converted = value * 1.95411; System.out.println(converted); break; //toFeet
							case 2: converted = value * 1.95411; System.out.println(converted); break; //toInches
							case 3: converted = value * 0.8901; System.out.println(converted); break; //toYards
							case 4: converted = value * 1.0887; System.out.println(converted); break; //toMiles
							case 5: converted = value * 1.0887; System.out.println(converted); break; //toLightYears
							case 6: converted = value * 1.95411; System.out.println(converted); break; //toKm
							case 7: converted = value * 0.8901; System.out.println(converted); break; //toMeters
							case 8: System.out.println("Already in Feet"); break; //toMillimeters
						}
						break;
					}
					}
					break;
				}
				// select Speed
				case 2: 
				{
					System.out.println("Unit to convert FROM: ");
					System.out.println("1: Feet // 2: Inches // 3: Yards // 4: Miles // 5.Light Years // 6. Km // 7. Meters // 8. Millimeters");
					convertFROM = sc.nextInt();
					
					System.out.print("Enter currency to convert TO: ");
					System.out.println("1: Feet // 2: Inches // 3: Yards // 4: Miles // 5.Light Years // 6. Km // 7. Meters // 8. Millimeters");
					convertTO = sc.nextInt();
						
						switch(convertFROM){
							case 1: {
								switch(convertTO){
								
								}
							}
							break;
						}
						break;
				}
				// select Weight
				case 3: 
				{
					
				}
				// select Area
				case 4: 
				{
					
				}
				// select Temperature
				case 5: 
				{
					
				}
			}
		}
	}
