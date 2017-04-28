package java23gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class FirstJavaFxActionHandlingExample extends Application
{

	public static void main(String[] args)
	{
		launch(args);
	}


	@Override
	public void start(Stage stage) throws Exception
	{
		final Button button = new Button("Add 'Hello World' Label");


		final FlowPane pane = new FlowPane();

		pane.getChildren().add(button);

		button.setOnAction(event -> {
			pane.getChildren().add(new Label("Hallo JavaFX World!"));
		});


		stage.setScene(new Scene(pane, 400, 100));
		stage.setTitle("FirstJavaFxExample");
		stage.setResizable(true);
		stage.centerOnScreen();

		stage.show();
	}

}
