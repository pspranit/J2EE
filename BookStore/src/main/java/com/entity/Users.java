package com.entity;

public class Users {

	private int uId;
	private String userName;
	private String contact;
	private String address;
	private String email;
	private String gender;
	private String password;
	public Users() {
		super();
	}
	public Users(String userName, String contact, String address, String email, String gender,
			String password) {
		super();
		this.userName = userName;
		this.contact = contact;
		this.address = address;
		this.email = email;
		this.gender = gender;
		this.password = password;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Users [uId=" + uId + ", userName=" + userName + ", contact=" + contact + ", address=" + address
				+ ", email=" + email + ", gender=" + gender + ", password=" + password + "]";
	}
	
	
}
