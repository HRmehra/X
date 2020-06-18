package register.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import register.model.Person;

public class PersonDao {
	
	public int registerPerson(Person person) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO person" +
            " (id, name, sername, address, email) VALUES " +
            " (?, ?, ?, ?, ?,?,?);";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/postgres/databases/person", "postgres", "1234");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(1, person.getId());
            preparedStatement.setString(2, person.getName());
            preparedStatement.setString(3, person.getSername());
            preparedStatement.setString(4, person.getEmail());
            preparedStatement.setString(5, person.getAddress());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            
        	e.printStackTrace();
        }
        return result;
    }

}
