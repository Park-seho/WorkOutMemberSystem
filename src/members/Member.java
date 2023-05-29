package members;

import java.io.Serializable;
import java.util.Scanner;

import exception.EmailFormatException;

public abstract class Member implements MemberInput, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3914350200135220808L;

	protected MemberKind kind = MemberKind.Diamond;
	protected String name;
	protected int id;
	protected String email;
	protected String phone;

	public Member() {

	}

	public Member(MemberKind kind) {
		this.kind = kind;
	}
	public Member(String name, int id) {

		this.name = name;
		this.id = id;

	}

	public Member( MemberKind kind, String name, int id, String email, String phone) {
		this.kind = kind;
		this.name = name;
		this.id = id;
		this.email = email;
		this.phone = phone;
	}

	public Member(String name, int id, String email, String phone) {

		this.name = name;
		this.id = id;
		this.email = email;
		this.phone = phone;
	}

	public MemberKind getKind() {
		return kind;
	}

	public void setKind(MemberKind kind) {
		this.kind = kind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws EmailFormatException{
		if(!email.contains("@") && !email.equals("")) {
			throw new EmailFormatException();
		}
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public abstract void printInfo();


	public void setMemberID(Scanner input) {
		System.out.println("Member ID: ");
		int id = input.nextInt();
		this.setId(id);
	}

	public void setMemberName(Scanner input) {
		System.out.println("Member name: ");
		String name = input.next();
		this.setName(name);
	}

	public void setMemberEmail(Scanner input) {
		String email = "";
		while(!email.contains("@")) {
			System.out.println("Email address: ");
			email = input.next();
			try {
				this.setEmail(email);
			} catch (EmailFormatException e) {
				System.out.println("Incorrect Email Format. put the e=mail address that contains @");
			}
		}
	}

	public void setMemberPhone(Scanner input) {
		System.out.println("Phone number: ");
		String phone = input.next();
		this.setPhone(phone);
	}
	public String getKindString() {
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
		return skind;
	}

}
