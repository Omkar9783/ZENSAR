import java.sql.*;
public class NKO_306 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "omkar@123";
        String dbName="NKOCET_TE"


        try{
        Class.forName(com.mysql.cj.jdbc.Driver);
        Connection conn = DriverManager.getConnection(url , user, password);
        System.out.println("DATABASE CONNECTED SUCCESSFULLY");

        Statement stmt=conn.createStatement();
        String sqlQuery="Create Database "=dbName

        

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
