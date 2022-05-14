import java.util.Scanner;

import java.sql.*;

class Function {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String flag="Y";

		do{

		System.out.println("Select DML Operation For Product Table...");

		System.out.println("1. Insert new record");

		System.out.println("2. Retrieve");

		System.out.println("3. QUIT");

		Scanner reader = new Scanner(System.in);

		System.out.println("Enter a choice: ");

		int n = reader.nextInt();

		Connection c = null;

		Statement stmt = null;

		try {

		Class.forName("org.sqlite.JDBC");

		c = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\db\\movie.db");
		
		c.setAutoCommit(false);

		stmt = c.createStatement();

		String MovieName ="", sql="";

		String LeadActor = ""; 
		
		String LeadActress = ""; 
		
		String Director = ""; 
		
		String  ReleaseDate = ""; 
		
		int id;

		Scanner scanName;

		switch(n){

		 

		case 1:

		scanName=new Scanner(System.in);

		System.out.println("Movie Name:");

		movie_name=scanName.nextLine();

		System.out.println("Lead actor");

		lead_actor=scanName.nextLine();
		
		System.out.println("Lead actress:");

        lead_actress=scanName.nextLine();
        
        System.out.println("entert Director name:");

        Dir_Name =scanName.nextLine();
        
        System.out.println("Realease date (mm/dd/yy)--- >");

        Release_Date =scanName.nextLine();

		sql = "INSERT INTO MOVIE (MovieName,LeadActor,LeadActress,Director,ReleaseDate) " +

		"VALUES ('" +MovieName+ "','" +

        LeadActor + "','" + LeadActress +  "','" + Director + "','" + ReleaseDate + "'" + ")";

		stmt.executeUpdate(sql);

		System.out.println("Inserted Successfully!!!");

		break;

		 
		 

		case 2:

		ResultSet rs = stmt.executeQuery("SELECT * FROM MOVIE_DB;");

		System.out.println("ID\t MovieName\t\t LeadActor\t LeadActress\t Director\t ReleaseDate");

		while ( rs.next() ) {

		id = rs.getInt("p_id");

		MovieName = rs.getString("MovieName");

		LeadActor = rs.getString("LeadActor");

		LeadActress = rs.getString("LeadActress");
		
		Director = rs.getString("Director");
		
		ReleaseDate = rs.getString("ReleaseDate");

		System.out.println(id+"\t "+MovieName+" \t "+LeadActor+"\t "+LeadActress+"\t "+Director+"\t "+ReleaseDate);

		}

		rs.close();

		break;

		 

		case 3:

		System.exit(0);

		break;

		 

		default:

		System.out.println("Oops!!! Wrong Choice...");

		break;

		}

		stmt.close();

		c.commit();

		c.close();

		}

		catch ( Exception e )

		{

		System.err.println( e.getClass().getName() + ": " + e.getMessage() );

		System.exit(0);

		}

		 

		System.out.println("Continue Y OR N?");

		reader=new Scanner(System.in);

		flag=reader.nextLine();

		 

		}while(flag.equalsIgnoreCase("Y"));

		System.exit(0);

		}
	}


