package ie.atu.jdbc.pool;


import java.sql.*;

public class SelectExample {
    public static void main(String[] args) {

        String selectSQL = "select * from person;";

        try (Connection connection = DatabaseUtils.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)) {

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String age = resultSet.getString("age");

                System.out.println("name: " + name + ", age: " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}