package members;

import java.util.Scanner;

public class DiamondMember extends Member implements MemberInput{

	public DiamondMember(MemberKind kind) {
		super(kind);
	}

	public void getUserInput(Scanner input) {
		System.out.print("Member ID: ");
		int id = input.nextInt();
		this.setId(id);

		System.out.print("Member Name: ");
		String name = input.next();
		this.setName(name);

		System.out.print("Email address: ");
		String email = input.next();
		this.setEmail(email);

		System.out.print("Phone Number: ");
		String phone = input.next();
		this.setPhone(phone);
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
		System.out.println("Kind: " + skind + "Name: " + name + "  ID: " + id + " Email: " + email + " PhoneNum: " + phone);
	}
}