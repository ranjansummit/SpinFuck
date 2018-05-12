import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static String URL="jdbc:mysql://localhost/formd";
	private static String USERNAME="root";
	private static String PASSWORD="";
	private static Connection connection=null;
	public static void main(String[] args) {
		checkConnection();
		}
	public static Connection  checkConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded...");
			connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);
			System.out.println("Database connected...");
		} catch (ClassNotFoundException e) {
			System.out.println("Unable to load driver...");
		} catch (SQLException e) {
			System.out.println("Unable to connect database...");
		}
		return connection;
	}

}
