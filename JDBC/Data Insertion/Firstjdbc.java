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
			String q="insert into Student(sid,sName,sCity) values(?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(q);
			pstmt.setInt(1,1);
			pstmt.setString(2,"Diptesh Varule");
			pstmt.setString(3,"Pune");

			pstmt.executeUpdate();

			System.out.println("Data inserted...");	
	
			
			}	

		catch(Exception e){
			e.printStackTrace();
		} 	
	}
}