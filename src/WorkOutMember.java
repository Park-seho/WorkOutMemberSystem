import java.util.InputMismatchException;
import java.util.Scanner;

public class WorkOutMember {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		MemberManager membermanager = new MemberManager(input);

		selectmenu(input, membermanager);
	}

	public static void selectmenu(Scanner input, MemberManager membermanager) {
		int num = -1;
		while(num != 5) {
			try {
				showmenu();
				num = input.nextInt();
				switch(num) {
				case 1:
					membermanager.addMember();
					break;
				case 2:
					membermanager.deleteMember();
					break;
				case 3:
					membermanager.editMember();
					break;
				case 4:
					membermanager.viewMembers();
					break;
				default:
					continue;
				}
			}
			catch(InputMismatchException e) {
				System.out.println("Please put an integer between 1 and 5!");
				if(input.hasNext()) {
					input.next();
				}
				num = -1;
			}
		}
	}

	public static void showmenu() {
		System.out.println("***Member System Menu***");
		System.out.println("1. Add Members ");
		System.out.println("2. Delete Members ");
		System.out.println("3. Edit Members ");
		System.out.println("4. View Members ");
		System.out.println("5. Exit ");
		System.out.println("Select one number between 1-5: ");
	}

}