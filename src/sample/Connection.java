package sample;

import jdk.nashorn.internal.objects.NativeError;

import java.sql.*;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class Connection {

   private static final String sql = "SELECT * FROM mydb.userrecord WHERE NAME = ? and password= ? ";



    public boolean connect(String NAME, String password) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/mydb?serverTimezone=UTC", "root", "pranjal123");
            //jdbc:mysql://localhost:3306/Peoples?autoReconnect=true&useSSL=false


            PreparedStatement preparedStatement = con.prepareStatement(sql); {
                preparedStatement.setString(1,NAME);
                preparedStatement.setString(2,password);

                System.out.println(preparedStatement);
               ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next())
                    return true;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

//    public static void printSQLException(SQLException ex) {
//        for (Throwable e: ex) {
//            if (e instanceof SQLException) {
//                e.printStackTrace(System.err);
//                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
//                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
//                System.err.println("Message: " + e.getMessage());
//                Throwable t = ex.getCause();
//                while (t != null) {
//                    System.out.println("Cause: " + t);
//                    t = t.getCause();
//                }
//            }
//        }
//    }
}


