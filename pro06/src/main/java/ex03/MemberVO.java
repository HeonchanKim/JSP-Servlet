package ex03;

import java.sql.Date;

public class MemberVO {
	private int id;
	private String account;
	private String passwd;
	private String name;
	private String email;
	private Date regdate;
	
	public MemberVO(int id, String account, String passwd, String name, String email, Date regdate) {
		this.id = id;
		this.account = account;
		this.passwd = passwd;
		this.name = name;
		this.email = email;
		this.regdate = regdate;
	}

	public MemberVO() { this(0, null, null, null, null, null); }	
	
	public int getId() {return id;}
	public String getAccount() {return account;}
	public String getPasswd() {return passwd;}
	public String getName() {return name;}
	public String getEmail() {return email;}
	public Date getRegdate() {return regdate;}
	
	public void setId(int id) {this.id = id;}
	public void setAccount(String account) {this.account = account;}
	public void setPasswd(String passwd) {this.passwd = passwd;}
	public void setName(String name) {this.name = name;}
	public void setEmail(String email) {this.email = email;}
	public void setRegdate(Date regdate) {this.regdate = regdate;}
	
	
}
