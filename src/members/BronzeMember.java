package members;

import java.util.Scanner;

public class BronzeMember extends Member implements MemberInput{
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
		System.out.print("Member ID: ");
		int id = input.nextInt();
		this.setId(id);

		System.out.print("Member Name: ");
		String name = input.next();
		this.setName(name);

		char answer = 'x';
		while(answer != 'y' && answer != 'Y' && answer !='n' && answer != 'N') {
			System.out.print("Do you have an email address? (Y/N) ");
			answer = input.next().charAt(0);
			if(answer == 'y'|| answer == 'Y') {
				System.out.print("Email address: ");
				String email = input.next();
				this.setEmail(email);
				break;
			}
			else if(answer == 'n'|| answer == 'N') {
				this.setEmail("");
				break;
			}
			else {
			}
		}
		System.out.print("Phone Number: ");
		String phone = input.next();
		this.setPhone(phone);

		answer = 'x';
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
		String skind = "none";
		switch(this.kind) {
		case Diamond:
			skind = "Diamond";
			break;
		case Gold:
			skind = "Gold";
			break;
		case Silver:
			skind = "Silver";
			break;
		case Bronze:
			skind = "Bronze";
			break;
		default:
		}
		System.out.println("Kind: " + skind + "Name: " + name + "  ID: " + id + " Email: " + email + " PhoneNum: " + phone + " Resident registration num: " + residentregistrationnumber + " Home adress: " + homeadress);
	}
}
