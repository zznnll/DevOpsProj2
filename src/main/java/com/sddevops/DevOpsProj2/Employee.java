package com.sddevops.DevOpsProj2;

import java.util.Comparator;
import java.util.Objects;

public class Employee {
	
	private String id;
	private String name;
	private String date;
	private String gender;
	private String phone;
	private String role;
	private String type;
	private String email;

	/**
	 * @param id
	 * @param name
	 * @param date
	 * @param gender
	 * @param phone
	 * @param role
	 * @param type
	 * @param email
	 */
	public Employee(String id, String name, String date, String gender, String phone, String role, String type, String email) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.gender = gender;
		this.phone = phone;
		this.role = role;
		this.type = type;
		this.email = email;
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param id the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, date, gender, phone, role, type, email);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Employee))
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(name, other.name) && Objects.equals(date, other.date)
				&& Objects.equals(gender, other.gender)
				&& Objects.equals(phone, other.phone)&& Objects.equals(role, other.role)
				&& Objects.equals(type, other.type)&& Objects.equals(email, other.email)&&
				Objects.equals(id, other.id);
	}

	public static Comparator<Employee> roleComparator = new Comparator<Employee>() {
		@Override
		public int compare(Employee s1, Employee s2) {
			return (int) (s1.getRole().compareTo(s2.getRole()));
		}
	};
	
	public static Comparator<Employee> typeComparator = new Comparator<Employee>() {
		@Override
		public int compare(Employee s1, Employee s2) {
			return (int) (s1.getType().compareTo(s2.getType()));
		}
	};

	
}
