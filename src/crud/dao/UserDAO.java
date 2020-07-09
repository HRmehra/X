package crud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import crud.model.User;

public class UserDAO {
	
		private String URL = "jdbc:postgresql://localhost:5432/postgres";
	    private String Username = "postgres";
	    private String Password = "1234";

	    
	    
	    public UserDAO() {}

	    protected Connection getConnection() {
	        Connection connection = null;
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            connection = DriverManager.getConnection(URL, Username, Password);
	        } catch (SQLException e) {
	           
	            e.printStackTrace();
	            
	        } catch (ClassNotFoundException e) {
	          
	            e.printStackTrace();
	        }
	        return connection;
	    }
	    
	    
	    public void insertUser(User user) throws SQLException {
	    	String INSERT = ("INSERT INTO person (id, name, sername, address, email)" + "VALUES (?,?,?,?,?)" );

	        System.out.println(INSERT);
	      
	        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
	            preparedStatement.setString(1, user.getName());
	            preparedStatement.setString(2, user.getSurname());
	            preparedStatement.setString(3, user.getEmail());
	            preparedStatement.setString(4, user.getAddress());
	            System.out.println(preparedStatement);
	            preparedStatement.executeUpdate();
	            
	        } catch (SQLException e) {
	        	
	        	  e.printStackTrace();
	        }
	    }
	    
	    
	    public User selectUser(int id) {
	    	String SELECT_BY_ID = ("select id,name,email,country from users where id =?");
	        User user = null;
	       
	        try (Connection connection = getConnection();
	            
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID); 
	        		) {
	            preparedStatement.setInt(1, id);
	            System.out.println(preparedStatement);
	          
	            ResultSet rs = preparedStatement.executeQuery();

	            
	            while (rs.next()) {
	                String name = rs.getString("name");
	                String surname = rs.getString("surname");
	                String email = rs.getString("email");
	                String address = rs.getString("address");
	                
	                user = new User(id, name, surname, email, address);
	            }
	        } catch (SQLException e) {
	        	 e.printStackTrace();
	        }
	        
	        return user;
	    }

	    
	    
	    public List < User > selectAllUsers() {
	    	String SELECT_ALL = ("select * from users");

	      
	        List < User > users = new ArrayList < > ();
	      
	        try (Connection connection = getConnection();

	          
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);) {
	            System.out.println(preparedStatement);
	          
	            ResultSet rs = preparedStatement.executeQuery();

	           
	            while (rs.next()) {
	                int id = rs.getInt("id");
	                String name = rs.getString("name");
	                String surname = rs.getString("surname");
	                String email = rs.getString("email");
	                String address = rs.getString("address");
	                users.add(new User(id, name, surname, email, address));
	            }
	        } catch (SQLException e) {
	        	e.printStackTrace();
	        }
	        return users;
	    }
	    
	    public boolean updateUser(User user) throws SQLException {
	    	String UPDATE = ("update users set name = ? , email= ? , country =? where id = ?");
	        boolean rowUpdated;
	        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE);) {
	            statement.setString(1, user.getName());
	            statement.setString(2, user.getSurname());
	            statement.setString(3, user.getEmail());
	            statement.setString(4, user.getAddress());
	            statement.setInt(5, user.getId());

	            rowUpdated = statement.executeUpdate() > 0;
	        }
	        return rowUpdated;
	    }
	    
	    public boolean deleteUser(int id) throws SQLException {
	    	String DELETE = ("delete from users where id = ?");
	    	
	        boolean rowDeleted;
	        try (Connection connection = getConnection();
	        	PreparedStatement statement = connection.prepareStatement(DELETE);) {
	            statement.setInt(1, id);
	            rowDeleted = statement.executeUpdate() > 0;
	        }
	        return rowDeleted;
	    }
	    
	    
}
