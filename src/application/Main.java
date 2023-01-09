package application;
	
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery("select * from student");
			
//			if(!result.next()) {
//				System.out.println("The table is empty.");
//			}else {
			
				while(result.next()) {
				System.out.println(result.getString(1)+"    "+result.getString(2)+"  "+result.getString(3)+"   "+result.getInt(4));
			}
//			
			
			conn.close();
//			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
