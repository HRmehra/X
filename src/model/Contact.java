package model;

public class Contact {
	private int id;
	private String name;
	private String email;
	private String contact_no;

	public Contact(Integer id, String name, String email, String contact_no) {
		
		this(name,email,contact_no);
		this.id = id;
	}
	
	public Contact( String name, String email, String contact_no) {
	
		this.name = name;
		this.email = email;
		this.contact_no = contact_no;
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

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}

}
