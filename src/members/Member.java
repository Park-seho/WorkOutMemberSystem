package members;

import java.util.Scanner;

public abstract class Member {
	protected MemberKind kind = MemberKind.Diamond;
	protected String name;
	protected int id;
	protected String email;
	protected String phone;
	//	protected String residentregistrationnumber;
	//	protected String homeadress;

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

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	//	public String getResidentregistrationnumber() {
	//		return residentregistrationnumber;
	//	}
	//	
	//	public void setResidentregistrationnumber(String residentregistrationnumber) {
	//		this.residentregistrationnumber = residentregistrationnumber;
	//	}
	//	
	//	public String getHomeadress() {
	//		return homeadress;
	//	}
	//	
	//	public void setHomeadress(String homeadress) {
	//		this.homeadress = homeadress;
	//	}


	public abstract void printInfo();
}
