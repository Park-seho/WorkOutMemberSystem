import java.util.Scanner;

public class WorkOutMember {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		MemberManager membermanager = new MemberManager(input);
		int num = -1;
		while(num != 5) {
			System.out.println("***Member System Menu***");
			System.out.println("1. Add Members ");
			System.out.println("2. Delete Members ");
			System.out.println("3. Edit Members ");
			System.out.println("4. View Members ");
			System.out.println("5. Exit ");
			System.out.println("Select one number between 1-5: ");
			num = input.nextInt();
			if(num==1) {
				membermanager.addMember();
			}
			else if(num==2) {
				membermanager.deleteMember();
			}
			else if(num==3) {
				membermanager.editMember();
			}
			else if(num==4) {
				membermanager.viewMembers();
			}
			else {
				continue;
			}
		}

	}

}