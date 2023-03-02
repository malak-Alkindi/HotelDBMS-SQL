import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
	
		  String url = "jdbc:sqlserver://localhost:1433;" +
	                "databaseName=HotelDBMS;" +
	                "encrypt=true;" +
	                "trustServerCertificate=true";
	        String user = "sa";
	        String pass = "root";
	Scanner scanner = new Scanner(System.in);
	System.out.println("enter name");
	        String name = scanner.next();
	System.out.println("enter roll no");
	Integer roll = scanner.nextInt();
	System.out.println("enter class");
	        String cls = scanner.next();
	 Connection con = null;
	
	 String sqQl = "CREATE TABLE IF NOT EXISTS warehouses (\n"
           + "	id integer PRIMARY KEY,\n"
           + "	name text NOT NULL,\n"
           + "	capacity real\n"
           + ");";



	        try {

	         // create a new table
	        	
	Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
	DriverManager.registerDriver(driver);
	            con = DriverManager.getConnection(url, user, pass);
	 Statement st = con.createStatement();
	 
	 
	    
	    String hotelsStr = "CREATE TABLE IF NOT EXISTS hotels " +
	    		 "(id INTEGER and Primary Key, " +
	    		 " hotel_name TEXT, " +
	    		 " hotel_location TEXT, " +
	    	       "created_date date, " + 
		              "updated_date date, " + 
		              "is_Active Boolean not NULL"; 

	    String RoomTypeStr = "CREATE TABLE IF NOT EXISTS Room_Type " +
              "(id INTEGER Primary Key, " +
              " room_type_name TEXT not NULL, " + 
              "created_date date, " + 
              "updated_date date, " + 
              "is_Active Boolean not NULL"; 


		 String roomsStr = "CREATE TABLE IF NOT EXISTS Rooms " +
		 "(id INTEGER and Primary Key, " +
		 " FOREIGN KEY (room_type_id) REFERENCES Rooms(room_type_id) " +
		 " FOREIGN KEY (hotel_id ) REFERENCES Rooms(hotel_id)" +
	       "created_date date, " + 
           "updated_date date, " + 
           "is_Active Boolean not NULL"; 
		 
	    String GuestsStr = "CREATE TABLE IF NOT EXISTS Guests " +
	              "(id INTEGER Primary Key, " +
	              " guest_name TEXT not NULL, " + 
	              " guest_phone TEXT not NULL, " +
	              " guest_payment_amount INTEGER not NULL, " +
"FOREIGN KEY (room_id) REFERENCES Rooms(id) ,"+
"FOREIGN KEY (hotel_id) REFERENCES Hotels(id) ,"+
	              "created_date date, " + 
	              "updated_date date, " + 
	              "is_Active Boolean not NULL"; 
	
	    		 String employeeTypeStr = "CREATE TABLE IF NOT EXISTS Employee_Type " +
	    		 "(id INTEGER and Primary Key, " +
	    		 " employee_type_name TEXT, " +
	    	       "created_date date, " + 
		              "updated_date date, " + 
		              "is_Active Boolean not NULL";   
	    
	    String EmployeesStr = "CREATE TABLE IF NOT EXISTS Employees " +
	              "(id INTEGER Primary Key, " +
	              "FOREIGN KEY (employee_type_id) REFERENCES Employee_Type(id) ,"+
	              "FOREIGN KEY (room_id) REFERENCES Hotels(id) ,"+	      
	              "created_date date, " + 
	              "updated_date date, " + 
	              "is_Active Boolean not NULL"; 
	    
	    st.executeUpdate(hotelsStr);
	    st.executeUpdate(RoomTypeStr);
	    st.executeUpdate(roomsStr);
	    st.executeUpdate(GuestsStr);
	    st.executeUpdate(employeeTypeStr);
	    st.executeUpdate(EmployeesStr);
	    
//	            String sql = "insert into sqlJava values('" + name
//	+ "'," + roll + ",'" + cls + "')";
//	Integer m = st.executeUpdate(sql);
//	            if (m >= 1) {
//	System.out.println("inserted successfully : " + sql);
//	} else {
//	System.out.println("insertion failed");
//	}
//	            String sql1 = "Select * from sqlJava";
//	ResultSet resultSet = st.executeQuery(sql1);
//	             while (resultSet.next()) {
//	System.out.println(resultSet.getString("name"));
//	System.out.println(resultSet.getInt("roll"));
//	System.out.println(resultSet.getString("cls"));
//	}
	            con.close();
	} catch (Exception ex) {
	System.err.println(ex);
	}
	}	
	}

}
