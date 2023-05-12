import java.util.ArrayList;
import java.util.Scanner;

import members.BronzeMember;
import members.DiamondMember;
import members.GoldMember;
import members.Member;
import members.MemberInput;
import members.MemberKind;

public class MemberManager {
	ArrayList<MemberInput> members = new ArrayList<MemberInput>();

	Scanner input;

	MemberManager(Scanner input){
		this.input = input;
	}

	public void addMember() {
		int kind = 0;
		MemberInput memberInput;
		while(kind != 1 && kind != 2) {
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
	}

	public void deleteMember() {

		System.out.print("Member Id: ");
		int memberId = input.nextInt();
		int index = -1;
		for(int i = 0; i < members.size(); i++){
			if(members.get(i).getId() == memberId) {
				index = i;
				break;
			}
		}

		if(index >= 0) {
			members.remove(index);
			System.out.println("the member " + memberId + " is deleted");
		}
		else {
			System.out.println("the member has not been registered");
			return;
		}

	}

	public void editMember() {
		System.out.print("Member Id: ");
		int memberId = input.nextInt();
		for(int i = 0; i <members.size(); i++){
			MemberInput memberInput = members.get(i);
			if(memberInput.getId() == memberId) {
				int num = -1;
				while(num != 5) {
					System.out.println("**Member Info Edit Menu**");
					System.out.println("1. Edit ID ");
					System.out.println("2. Edit Name ");
					System.out.println("3. Edit Email ");
					System.out.println("4. Edit Phone ");
					System.out.println("5. Exit ");
					System.out.println("Select one number between 1-5: ");
					num = input.nextInt();
					if(num==1) {
						System.out.println("Member ID: ");
						int id = input.nextInt();
						memberInput.setId(id);
					}
					else if(num==2) {
						System.out.println("Member name: ");
						String name = input.next();
						memberInput.setName(name);
					}
					else if(num==3) {
						System.out.println("Email address: ");
						String email = input.next();
						memberInput.setEmail(email);
					}
					else if(num==4) {
						System.out.println("Phone number: ");
						String phone = input.next();
						memberInput.setPhone(phone);
					}
					else {
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
}
