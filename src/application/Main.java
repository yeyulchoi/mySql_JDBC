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

		
		try {
			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/satishlesson","root","Yoonja7979!!");
			System.out.println("database connected successfully");
			  //ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			Scanner scan = new Scanner(System.in);
			
			System.out.println("Please enter your name.");
			String userName= scan.next();
			System.out.println("Please enter your  password.");
			String userpw=scan.next();
			System.out.println("Please enter your country ");
			String usercountry = scan.next();
			System.out.println("Please enter your mark ");
			Double userMark = scan.nextDouble();
			
			String query = "insert into student values(?,?,?,?);";
		
//<<<<<<<<<<<<<<<<<<USE of PrepareStatement to mapping input from user to ? >>>>>>>>>>>>>>>>>>>			
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, userName);
			stmt.setString(2,userpw);
			stmt.setString(3, usercountry);
			stmt.setDouble(4, userMark);
			
			stmt.execute();
			System.out.println("User input has been inserted to database");
			stmt.close();
			conn.close();
				
			
//			ResultSet result = stmt.executeQuery("select * from student");
//			
//			if(!result.next()) {
//				System.out.println("NO SEARCH FROM THE TABLE.");
//			}else 
//			{
//				
//				result.previous();
//				while(result.next()) {
//				System.out.println(result.getString(1)+"    "+result.getString(2)+"  "+result.getString(3)+"   "+result.getInt(4));
//			}
			
			
			
			
			
		
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
