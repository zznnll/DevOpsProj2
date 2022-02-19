
public class Worker {
	protected String name;
	protected String date;
	protected String gender;
	protected String phone;
	protected String role;
	protected String type;
	protected String email;

	public Worker(String name, String date, String gender, String phone, String role, String type, String email) {
		super();
		this.name = name;
		this.date = date;
		this.gender = gender;
		this.phone = phone;
		this.role = role;
		this.type = type;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
