package sample;

import sun.security.util.Password;

import java.sql.*;
import java.sql.Connection;

public class MainConnection {



    private static final String INSERT_QUERY = "INSERT INTO userrecord (NAME, Email, Password) VALUES (?, ?, ?)";


    public void connect(String NAME, String Email,String Password) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/mydb?serverTimezone=UTC", "root", "pranjal123");
            //jdbc:mysql://localhost:3306/Peoples?autoReconnect=true&useSSL=false


            PreparedStatement preparedStatement = con.prepareStatement(INSERT_QUERY);
            {
                preparedStatement.setString(1, NAME);
                preparedStatement.setString(2, Email);
                preparedStatement.setString(3, Password);

                System.out.println(preparedStatement);
                 preparedStatement.executeUpdate();

            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    }