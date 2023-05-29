package members;

import java.util.Scanner;

public class BronzeMember extends AboutMember{
	protected String residentregistrationnumber = "x";
	protected String homeadress ="y";

	public BronzeMember(MemberKind kind) {
		super(kind);
	}

	public String getResidentregistrationnumber() {
		return residentregistrationnumber;
	}

	public void setResidentregistrationnumber(String residentregistrationnumber) {
		this.residentregistrationnumber = residentregistrationnumber;
	}

	public String getHomeadress() {
		return homeadress;
	}

	public void setHomeadress(String homeadress) {
		this.homeadress = homeadress;
	}

	public void getUserInput(Scanner input) {
		setMemberID(input);
		setMemberName(input);
		setMemberEmailwithYN(input);
		setMemberPhone(input);

		char answer = 'x';
		while(answer != 'y' && answer != 'Y' && answer !='n' && answer != 'N') {
			System.out.print("Are you the first member in our gym? (Y/N) ");
			answer = input.next().charAt(0);
			if(answer == 'y'|| answer == 'Y') {
				System.out.print("Enter your resident registration number: ");
				String residentregistrationnumber = input.next();
				this.setResidentregistrationnumber(residentregistrationnumber);
				break;
			}
			else if(answer == 'n'|| answer == 'N') {
				this.setResidentregistrationnumber("");
				break;
			}
			else {
			}
		}

		System.out.print("Enter Home adress: ");
		String homeadress = input.next();
		this.setHomeadress(homeadress);
	}

	public void printInfo() {
		String skind = getKindString();
		System.out.println("Kind: " + skind + "Name: " + name + "  ID: " + id + " Email: " + email + " PhoneNum: " + phone + " Resident registration num: " + residentregistrationnumber + " Home adress: " + homeadress);
	}


}
