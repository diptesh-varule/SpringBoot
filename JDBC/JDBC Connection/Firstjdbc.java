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

			
			if(con.isClosed()){
				System.out.println("Connection is still closed...");	
			}
			else{
				System.out.println("Connection created...");		
			}
		}
		catch(Exception e){
			e.printStackTrace();
		} 	
	}
}