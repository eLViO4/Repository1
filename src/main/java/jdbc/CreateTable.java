package jdbc;

import java.sql.*;

public class CreateTable {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/my_db";
        String user = "bestuser";
        String password = "bestuser";

        String createTableSQL = "CREATE TABLE Employees ("
                + "id INT(11) NOT NULL AUTO_INCREMENT,"
                + "name VARCHAR(100) NOT NULL,"
                + "surname VARCHAR(100),"
                + "salary DECIMAL(10, 2),"
                + "PRIMARY KEY (id)"
                + ")";

        String insertSQL = "INSERT INTO Employees (name, surname, salary) VALUES (?, ?, ?)";

        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        statement.execute(createTableSQL);

      //  Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);

        preparedStatement.setString(1, "Name1");
        preparedStatement.setString(2, "Surname1");
        preparedStatement.setDouble(3, 1000);
        preparedStatement.addBatch();

        preparedStatement.setString(1, "Name2");
        preparedStatement.setString(2, "Surname2");
        preparedStatement.setDouble(3, 2000);
        preparedStatement.addBatch();
    }
}

