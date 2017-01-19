import java.util.*;
public class splitInTeams {

	public static void main(String[] args) {
		System.out.print("Enter number of students: ");
		int students, group, noGroup, teams;
		Scanner inp = new Scanner(System.in);
		students = inp.nextInt();
		System.out.print("Enter how many people are in 1 group: ");
		group = inp.nextInt();
		noGroup = students % group;
		teams = students/group; 
		System.out.println("No of teams: " + teams);
		System.out.println("No of students without group: " + noGroup);
	}
}
