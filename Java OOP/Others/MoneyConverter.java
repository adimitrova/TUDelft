import java.util.*;

public class MoneyConverter {

		public static void main(String[] args) {
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
}
