package model;

public class Contact {
	private int id;
	private String name;
	private String email;
	private String number;

	public Contact(Integer id, String name, String email, String number) {
		
		this(name,email,number);
		this.id = id;
	}
	
	public Contact( String name, String email, String number) {
	
		this.name = name;
		this.email = email;
		this.number = number;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getnumber() {
		return number;
	}

	public void setnumber(String number) {
		this.number = number;
	}

}
