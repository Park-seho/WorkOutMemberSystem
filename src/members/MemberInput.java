package members;

import java.util.Scanner;

import exception.EmailFormatException;

public interface MemberInput {

	public int getId();

	public void setId(int id);
	
	public String getName();

	public void setName(String name);
	
	public String getEmail();

	public void setEmail(String email) throws EmailFormatException;
	
	public String getPhone();

	public void setPhone(String phone);

	public void getUserInput(Scanner input);

	public void printInfo();

	public void setMemberID(Scanner input);

	public void setMemberName(Scanner input);

	public void setMemberEmail(Scanner input);

	public void setMemberPhone(Scanner input);

}
