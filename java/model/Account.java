package model;

public class Account {
	private String account;
	private String password;
	private Boolean admin;
	public Account() {
		super();
	}
	public Account(String account, String password, Boolean admin) {
		super();
		this.account = account;
		this.password = password;
		this.admin = admin;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
}
