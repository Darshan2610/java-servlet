import java.sql.*;
import java.util.Scanner;
import java.sql.Connection;
class jdbc{
    public static void main(String args[]) {
        String  name,eid,phone,password;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter name");
        name = s.next();
        System.out.println("Enter Email");
        eid = s.next();
        System.out.println("Enter phone");
        phone = s.next();
        System.out.println("Enter password");
        password = s.next();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost/pes","root","");
            if(con!=null){
                System.out.println("connected");
                PreparedStatement ps =con.prepareStatement("insert into user(name,eid,phone,password)values(?,?,?,?)");
                ps.setString(1, name);
                ps.setString(2, eid);
                ps.setString(3, phone);
                ps.setString(4, password);
                int i = ps.executeUpdate();
                if(i>0){
                    System.out.println("record saved");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}