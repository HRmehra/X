package contact.dao;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
 
import java.lang.Object;

import org.springframework.jdbc.support.JdbcAccessor;


import model.Contact;

public class ContactDAOimpl implements contactDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public ContactDAOimpl(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource); 
	}
	@Override
	public int save(Contact c) {
		String sql = "INSERT INTO contactdb (name , email , contact_no ) VALUES (?,?,?)";
		return jdbcTemplate.Update(sql, c.getName(), c.getEmail(), c.getContact_no());
		
	}

	@Override
	public int update(Contact contact) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Contact get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Contact> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
