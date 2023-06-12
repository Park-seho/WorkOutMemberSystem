import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import log.EventLogger;

public class WorkOutMember {
	static EventLogger logger = new EventLogger("log.txt");

	public static void main(String[] args) {


		Scanner input = new Scanner(System.in);
		MemberManager membermanager = getObject("membermanager.ser");
		if(membermanager == null) {
			membermanager = new MemberManager(input);
		}

		selectmenu(input, membermanager);
		putObject(membermanager, "membermanager.ser");
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
					logger.log("add a member");
					break;
				case 2:
					membermanager.deleteMember();
					logger.log("delete a member");
					break;
				case 3:
					membermanager.editMember();
					logger.log("edit a member");
					break;
				case 4:
					membermanager.viewMembers();
					logger.log("view members");
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

	public static MemberManager getObject(String filename) {
		MemberManager membermanager = null;

		try {
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);

			membermanager = (MemberManager)in.readObject();

			in.close();
			file.close();

		} catch (FileNotFoundException e) {
			return membermanager;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return membermanager;

	}

	public static void putObject(MemberManager membermanager, String filename) {

		try {
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);

			out.writeObject(membermanager);

			out.close();
			file.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}