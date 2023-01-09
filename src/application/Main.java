package application;
	
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {


	
	}
	
	public static void main(String[] args) throws SQLException {
		
		Student stu = new Student();
		stu.insertStudent();
		
		
		
		
		
		
	}
}

class Student
{
	private String userName;
	private String userpw;
	private String usercountry ;
	private double userMark;
//getter and setter
	
	public void setUserInputInfo() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter your name.");
		userName= scan.next();
		System.out.println("Please enter your  password.");
		userpw=scan.next();
		System.out.println("Please enter your country ");
		usercountry = scan.next();
		System.out.println("Please enter your mark ");
		 userMark = scan.nextDouble();
		
		 System.out.println("user completed input into database.");
		 
		 scan.close();
		
	}
	
	public void insertStudent() throws SQLException {
		
		//here  we are going to work with a database
		//we need to open a database connection
		
		DBMSconnection mydbconn= new DBMSconnection("jdbc:mysql://localhost:3307/satishlesson","root","Yoonja7979!!");
		Connection con =mydbconn.getConnection();
		Student stdnt = new Student();
		stdnt.setUserInputInfo();
		String query = "insert into student values(?,?,?,?);";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, stdnt.userName);
		stmt.setString(2,stdnt.userpw);
		stmt.setString(3, stdnt.usercountry);
		stmt.setDouble(4, stdnt.userMark);
		
		stmt.execute();
		System.out.println("User input has been inserted to database");
		mydbconn.closeConnection(con, stmt);
	    
	}
	
}

class DBMSconnection
{
	String  url;
	String  username;
	String  password;
	
	// the three above need to be initialized.
	public DBMSconnection(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection(url,username,password);
		System.out.println("database connected successfully");
		return conn;
	}

	public void closeConnection(Connection con, Statement stmt) throws SQLException {
		con.close();
		stmt.close();
		System.out.println("The connection is closed");
	}
	
}