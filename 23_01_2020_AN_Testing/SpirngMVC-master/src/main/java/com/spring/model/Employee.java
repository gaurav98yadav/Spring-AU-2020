package com.spring.model;

public class Employee {

	private int id;
	private String f_name;
	private String l_name;
	private String email;
	private String telephone;

	public Employee(String string, String string2, String string3, String string4) {
		// TODO Auto-generated constructor stub
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", f_name=" + f_name + ", l_name=" + l_name + ", email=" + email + ", telephone="
				+ telephone + "]";
	}

	public Employee(int i, String string, String string2, String string3, String string4) {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}