package contact.dao;

import java.util.List;

import model.Contact;

public interface contactDAO {
	
	public int  saveOrUpdate(Contact contact);
	
	public Contact get(int id);
	
	public int delete(int id);
	
	public List<Contact> list();
}
 