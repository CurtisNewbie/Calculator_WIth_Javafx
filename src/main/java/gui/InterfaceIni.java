package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InterfaceIni extends Application {
    
    public InterfaceIni() {
	// TODO Auto-generated constructor stub
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
	Parent root = FXMLLoader.load(this.getClass().getResource("CalculatorGui.fxml"));
	Scene scene = new Scene(root);
	primaryStage.setScene(scene);
	primaryStage.setTitle("Curtis's Calculator");
	primaryStage.show();

    }

    public static void main(String[] args) {
	try {
	    InterfaceIni ui = new InterfaceIni();
	    ui.launch(args);
	} catch (Exception e) {
	    System.out.println(e.getMessage());
	}
    }

}
