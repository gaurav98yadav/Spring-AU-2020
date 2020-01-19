package database;

import java.sql.*;

public class jdcb {
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
	   Class.forName("com.mysql.cj.jdbc.Driver");
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb","root","root");
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      CallableStatement cs = conn.prepareCall("{call jdbc}");
      ResultSet rs = cs.executeQuery();
      while(rs.next()){
         int id  = rs.getInt("id");
         String first = rs.getString("firstNm");
         String last = rs.getString("lastNm");
         int dept_id=rs.getInt("Department_ID");
         String dept_name=rs.getString("Deptartment_Name");
         String dept_head=rs.getString("Department_Head");
         EmployeeData e=new EmployeeData();
         e.set_id(id);
         e.set_firstname(first);
         e.set_lastname(last);
         e.set_deptid(dept_id);
         e.set_deptname(dept_name);
   	  		System.out.println(e.toString());

//         System.out.print("ID: " + id);
//         System.out.print(", First: " + first);
//         System.out.println(", Last: " + last);
      }
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      se.printStackTrace();
   }catch(Exception e){
      e.printStackTrace();
   }finally{
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }
   }
}
}