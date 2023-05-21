package members;

import java.util.Scanner;

public class GoldMember extends AboutMember{

	public GoldMember(MemberKind kind) {
		super(kind);
	}

	public void getUserInput(Scanner input) {
		setMemberID(input);
		setMemberName(input);
		setMemberEmailwithYN(input);
		setMemberPhone(input);
	}

	
} 
