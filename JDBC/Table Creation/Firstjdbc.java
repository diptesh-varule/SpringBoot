import java.sql.*;

class Firstjdbc{

	public static void main(String args[]){

		try{
			
			//load the driver
			Class.forName("com.mysql.jdbc.Driver");

			//creating a connection
			String url="jdbc:mysql://localhost:3306/youtube";
			String username="root";
			String password="Diptesh@9";
			
			Connection con=DriverManager.getConnection(url,username,password); 
			String q="create table Student(sid int(20) primary key auto_increment,sName varchar(200) not null,sCity varchar(200))";
			Statement stmt=con.createStatement();
			stmt.executeUpdate(q);
			System.out.println("Table created in database...");	
	
			
			}	

		catch(Exception e){
			e.printStackTrace();
		} 	
	}
}