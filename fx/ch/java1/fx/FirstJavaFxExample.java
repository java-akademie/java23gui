package ch.java1.fx;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FirstJavaFxExample extends Application
{

	public static void main(String[] args)
	{
		launch(args);
	}


	@Override
	public void start(Stage stage) throws Exception
	{
		final StackPane stackPane = new StackPane();

		final Node labelNode = new Label("Hallo JavaFX World!");
		stackPane.getChildren().add(labelNode);

		stage.setScene(new Scene(stackPane, 250, 75));
		stage.setTitle("FirstJavaFxExample");
		stage.setResizable(true);
		stage.centerOnScreen();

		stage.show();
	}

}
