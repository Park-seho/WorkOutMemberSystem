import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import members.BronzeMember;
import members.DiamondMember;
import members.GoldMember;
import members.Member;
import members.MemberInput;
import members.MemberKind;

public class MemberManager implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5233741987784677279L;


	ArrayList<MemberInput> members = new ArrayList<MemberInput>();

	transient Scanner input;

	MemberManager(Scanner input){
		this.input = input;
	}

	public void addMember() {
		int kind = 0;
		MemberInput memberInput;
		while(kind < 1 || kind > 3) {
			try {
				System.out.println("1 for Diamond ");
				System.out.println("2 for Gold ");
				System.out.println("3 for Bronze ");
				System.out.print("Select num for Member Kind between 1 and 3: ");
				kind = input.nextInt();
				if(kind == 1) {
					memberInput = new DiamondMember(MemberKind.Diamond);
					memberInput.getUserInput(input);
					members.add(memberInput);
					break;
				}
				else if(kind == 2) {
					memberInput = new GoldMember(MemberKind.Gold);
					memberInput.getUserInput(input);
					members.add(memberInput);
					break;
				}
				else if(kind == 3) {
					memberInput = new BronzeMember(MemberKind.Bronze);
					memberInput.getUserInput(input);
					members.add(memberInput);
					break;
				}
				else {
					System.out.print("Select num for Member Kind between 1 and 3: ");
				}
			}
			catch(InputMismatchException e) {
				System.out.println("Please put an integer between 1 and 3!");
				if(input.hasNext()) {
					input.next();
				}
				kind = -1;
			}
		}
	}

	public void deleteMember() {

		System.out.print("Member Id: ");
		int memberId = input.nextInt();
		int index = findIndex(memberId);
		removefromMembers(index, memberId);
	}

	public int findIndex(int memberId) {
		int index = -1;
		for(int i = 0; i < members.size(); i++){
			if(members.get(i).getId() == memberId) {
				index = i;
				break;
			}
		}
		return index;
	}

	public int removefromMembers(int index, int memberId) {
		if(index >= 0) {
			members.remove(index);
			System.out.println("the member " + memberId + " is deleted");
			return 1;
		}
		else {
			System.out.println("the member has not been registered");
			return -1;
		}
	}

	public void editMember() {
		System.out.print("Member Id: ");
		int memberId = input.nextInt();
		for(int i = 0; i <members.size(); i++){
			MemberInput member = members.get(i);
			if(member.getId() == memberId) {
				int num = -1;
				while(num != 5) {
					showEditMenu();
					num = input.nextInt();
					switch(num) {
					case 1:
						member.setMemberID(input);
						break;
					case 2:
						member.setMemberName(input);
						break;
					case 3:
						member.setMemberEmail(input);
						break;
					case 4:
						member.setMemberPhone(input);
						break;
					default:
						continue;	
					}
				}
				break;
			}
		}
	}
	public void viewMembers() {
		System.out.println("# of registered members: " + members.size());
		for(int i = 0; i <members.size(); i++){
			members.get(i).printInfo();
		}
	}


	public void showEditMenu() {
		System.out.println("**Member Info Edit Menu**");
		System.out.println("1. Edit ID ");
		System.out.println("2. Edit Name ");
		System.out.println("3. Edit Email ");
		System.out.println("4. Edit Phone ");
		System.out.println("5. Exit ");
		System.out.println("Select one number between 1-5: ");
	}
}
