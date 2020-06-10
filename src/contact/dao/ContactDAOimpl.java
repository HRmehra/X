package contact.dao;

import java.io.Serializable;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;


 
import java.lang.Object;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.jdbc.support.JdbcAccessor;

import model.Contact;

public class ContactDAOimpl implements contactDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public ContactDAOimpl(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource); 
	}
	@Override
	public int saveOrUpdate(Contact contact) {
		
		
		String sql = "UPDATE contactdb SET  name = ? , email= ? , number = ? WHERE id =?";
		return jdbcTemplate.update(sql, contact.getName(), contact.getEmail(),
            contact.getnumber(), contact.getId());
		
	}


	@Override
	public Contact get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Contact> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
