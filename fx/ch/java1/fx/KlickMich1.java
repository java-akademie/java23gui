package ch.java1.fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class KlickMich1 extends Application
{
	final private Button button = new Button("klickMich");
	final private TextField tf1 = new TextField();
	final private TextField tf2 = new TextField();


	@Override
	public void start(Stage stage) throws Exception
	{
		Pane pane = makeTheLayout("GRID");
		addTheListener(pane);

		showTheLayout(stage, pane);
	}



	private void addTheListener(Pane pane)
	{

		button.setOnAction(event -> {
			if (tf2.getText().equals(""))
			{
				tf2.setText("danke dass du micht geklickt hast");
				tf1.setText("");
			}
			else
			{
				tf1.setText("danke dass du micht geklickt hast");
				tf2.setText("");
			}
		});
	}



	private void showTheLayout(Stage stage, Pane pane)
	{
		stage.setScene(new Scene(pane, 500, 100));
		stage.setTitle("KlickMich1");
		stage.setResizable(true);
		stage.centerOnScreen();
		stage.sizeToScene();
		stage.show();
	}



	private Pane makeTheLayout(String s)
	{
		Pane p = null;

		switch (s)
		{
			case "FLOW":
				p = new FlowPane();
				break;
			case "GRID":
				p = new GridPane();
				break;
			case "STACK":
				p = new StackPane();
				break;
		}


		p.getChildren().add(button);

		tf1.setPrefColumnCount(20);
		p.getChildren().add(tf1);

		tf2.setPrefColumnCount(20);
		p.getChildren().add(tf2);

		return p;
	}


	public static void main(String[] args)
	{
		launch(args);
	}



}
