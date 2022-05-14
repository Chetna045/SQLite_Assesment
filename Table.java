import java.sql.*;

public class Table {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection c = null;

		Statement stmt = null;

		try {

		Class.forName("org.sqlite.JDBC");

		c = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\db\\movie.db");

		System.out.println("Database Opened...\n");

		stmt = c.createStatement();

		String sql = "CREATE TABLE MOVIE " +

		"(p_id INTEGER PRIMARY KEY AUTOINCREMENT," +

		" MovieName TEXT NOT NULL, " +

		" LeadActor TEXT NOT NULL, " +

		" LeadActress TEXT NOT NULL, " +
		
		" Director TEXT NOT NULL," + 
		
		" ReleaseDate TEXT NOT NULL)" ;
		

		stmt.executeUpdate(sql);

		stmt.close();

		c.close();

		}

		catch ( Exception e ) {

		System.err.println( e.getClass().getName() + ": " + e.getMessage() );

		System.exit(0);

		}

		System.out.println("Table MOVIE Created Successfully!!!");

		}

	}


