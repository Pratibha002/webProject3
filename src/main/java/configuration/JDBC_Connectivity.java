package configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JDBC_Connectivity {
	
	public static void main(String [] args) throws Exception {
		//load the driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//create the connection 
		
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","root");
		
		//// Define the query
		String query ="select * from student";
		
		// Create a PreparedStatement
		PreparedStatement p=con.prepareStatement(query);//PreparedStatement is used to prepare and execute the SQL query.
		
		 // Execute the query
		ResultSet r =p.executeQuery();//ResultSet is processed to extract data from the result set.
		//Columns are accessed by their names (or indices) to retrieve data.
		
		 // Process the ResultSet
		while(r.next()) {
			
			 // Retrieve the values from the columns
			int id=r.getInt("rollno");
			String name=r.getString("name");
			int marks=r.getInt("marks");
			//String grade= r.getString("grade");
			String city= r.getString("city");
			
			System.out.println("ID: "+id+" Name: "+name+" Marks: "+marks+" City: "+city);
		}
 		r.close();
        p.close();
        con.close();
		
	}
	public List<testDao> get_Connection() throws Exception {
		// Defines a public method named get_Connection that returns a List of testDao objects. 
		//The method is declared to throw Exception, allowing it to handle SQL and other exceptions.
		
        List<testDao> students = new ArrayList<>();
        //Initializes an empty ArrayList to hold testDao objects. 
        //This list will store the student data retrieved from the database.
        
		Class.forName("com.mysql.cj.jdbc.Driver");
		// Loads the MySQL JDBC driver class dynamically. 
		//This step is necessary for establishing a connection to the MySQL database.
		
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","root");
		//Establishes a connection to the MySQL database using the JDBC URL, username, and password. 
		//The DriverManager.getConnection method returns a Connection object that is used to interact with the database.
		
		String query ="select * from student";
		//Defines an SQL query string to select all columns from the student table.
		
		PreparedStatement p= con.prepareStatement(query);
		//Creates a PreparedStatement object from the Connection object using the SQL query string. 
		//This object is used to execute the SQL query.
		
		ResultSet r=p.executeQuery();
		//Executes the SQL query and returns a ResultSet object containing the result of the query.
		
		while(r.next()) {
			//Iterates through each row of the ResultSet. 
			//The r.next() method moves the cursor to the next row and returns true if there is a row to process.
			 
			 int id=(r.getInt("rollno"));
		     String name=(r.getString("name"));
		     int marks=(r.getInt("marks"));
			 String city=( r.getString("city"));
			 //Retrieves the value of the rollno,name,marks,city column as an int,String,int,String for the current row.
			
		    students.add(new testDao(id, name, marks, city));
		    //Creates a new testDao object using the retrieved values and adds it to the students list.
		}
		return  students;
		// Returns the list of testDao objects containing the student data from the database.
		
	}

}
