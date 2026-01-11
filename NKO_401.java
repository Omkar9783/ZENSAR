import java.sql.*;
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.Statement;
// import java.sql.PreparedStatement;
// import java.sql.ParameterMetaData;
// import java.sql.ResultSet;


public class NKO_401 {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/";
        String user="root";
        String password="omkar@123";
        String dbName = "ZENSAR_JAVA";
try{

    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection con = DriverManager.getConnection(url,user,password);
    System.out.println("Database connected successfully");

    Statement stmt=con.createStatement();
    stmt.executeUpdate("create database if not exists " + dbName);
    stmt.executeUpdate("use " + dbName);
    stmt.executeUpdate("drop table if exists stds_nkocet");
    String createTableQuery="create table if not exists stds_nkocet (stds_no int primary key, stds_name varchar(100), stds_stipend double)";  
    stmt.executeUpdate(createTableQuery);
    System.out.println("Table created successfully");

    PreparedStatement pst = con.prepareStatement("insert into stds_nkocet(stds_no,stds_name,stds_stipend) values(?,?,?)");  


    pst.setInt(1,401);
    pst.setString(2,"omkar");
    pst.setDouble(3,10000);
    pst.executeUpdate();


    pst.setInt(1,402);
    pst.setString(2,"aditya");
    pst.setDouble(3,20000);
    pst.executeUpdate();

    pst.setInt(1,403);
    pst.setString(2,"pratik");
    pst.setDouble(3,30000);
    pst.executeUpdate();

    pst.setInt(1,404);
    pst.setString(2,"anas");
    pst.setDouble(3,40000);     
    pst.executeUpdate();

    pst.setInt(1,405);
    pst.setString(2,"rohan");
    pst.setDouble(3,50000);     
    pst.executeUpdate();

    pst.setInt(1,406);
    pst.setString(2,"rohit");
    pst.setDouble(3,60000);   
    pst.executeUpdate();      

    pst.setInt(1,407);
    pst.setString(2,"patange");
    pst.setDouble(3,70000);         
    pst.executeUpdate();

    pst.setInt(1,408);
    pst.setString(2,"tarang");
    pst.setDouble(3,80000);
    pst.executeUpdate();        

    pst.setInt(1,409);
    pst.setString(2,"suraj");
    pst.setDouble(3,90000);
    pst.executeUpdate();         

    pst.setInt(1,410);
    pst.setString(2,"chetan");
    pst.setDouble(3,100000);     
    pst.executeUpdate();         

    System.out.println("Data inserted successfully");

    
    




}
catch(Exception e){
e.printStackTrace();
}
    }
    
}
