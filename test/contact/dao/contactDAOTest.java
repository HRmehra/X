package contact.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import model.Contact;

class contactDAOTest {
	private DriverManagerDataSource dataSource;
	private contactDAO dao;
	@Test
	void testSave() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres/contactdb");
		dataSource.setUsername("postgres");
		dataSource.setPassword("1234");
		
		dao =new ContactDAOimpl(dataSource);
		
		Contact contact = new Contact("rassell","r@gmail.com","12313");
		int result = dao.save(contact);
		
		assertTrue(result>0);
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testGet() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	void testList() {
		fail("Not yet implemented");
	}

}
