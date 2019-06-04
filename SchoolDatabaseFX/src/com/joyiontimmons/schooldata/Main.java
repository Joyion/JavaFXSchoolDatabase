package com.joyiontimmons.schooldata;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        primaryStage.setTitle("Lufkin High School");
        primaryStage.setScene(new Scene(root, 650, 400));
        primaryStage.show();
       
    }


    public static void main(String[] args) {
    	SqlDatabase data = SqlDatabase.getInstance();
    	try {
    	data.start();
    	data.createTables();
    	}
    	catch (Exception e ) {
    		e.printStackTrace();
    	}
        launch(args);
    }
    
}