package members;

import java.util.Scanner;

import exception.EmailFormatException;

public abstract class AboutMember extends Member {
	
	public AboutMember(MemberKind kind) {
		super(kind);
	}

	@Override
	public abstract void getUserInput(Scanner input);

	@Override
	public void printInfo() {
		String skind = getKindString();
		System.out.println("Kind: " + skind + "Name: " + name + "  ID: " + id + " Email: " + email + " PhoneNum: " + phone);
	}
	
	public void setMemberEmailwithYN(Scanner input) {
		char answer = 'x';
		while(answer != 'y' && answer != 'Y' && answer !='n' && answer != 'N') {
			System.out.print("Do you have an email address? (Y/N) ");
			answer = input.next().charAt(0);
			try {
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
			catch(EmailFormatException e) {
				System.out.println("Incorrect Email Format. put the e=mail address that contains @");
			}
		}
	}


}
