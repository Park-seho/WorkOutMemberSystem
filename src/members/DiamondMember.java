package members;

import java.util.Scanner;

public class DiamondMember extends Member{

	public DiamondMember(MemberKind kind) {
		super(kind);
	}

	public void getUserInput(Scanner input) {
		setMemberID(input);
		setMemberName(input);
		setMemberEmail(input);
		setMemberPhone(input);
	}

	public void printInfo() {
		String skind = getKindString();
		System.out.println("Kind: " + skind + "Name: " + name + "  ID: " + id + " Email: " + email + " PhoneNum: " + phone);
	}
}