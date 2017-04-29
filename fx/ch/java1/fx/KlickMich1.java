package ch.java1.fx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class KlickMich1 extends Application
		implements EventHandler<ActionEvent>
{
	private Pane pane;

	final private Button klick = new Button("KLICK-MICH");
	final private Button clear = new Button("CLEAR");
	final private TextField tf1 = new TextField();
	final private TextField tf2 = new TextField();


	@Override
	public void start(Stage stage) throws Exception
	{
		makeTheLayout();
		addTheListener();
		showTheLayout(stage);
	}


	private void addTheListener()
	{
		klick.setOnAction(this);
		clear.setOnAction(this);

		// button.setOnAction(event -> {
		// if (tf2.getText().equals(""))
		// {
		// tf2.setText("danke fuers klicken");
		// tf1.setText("");
		// }
		// else
		// {
		// tf1.setText("danke fuers klicken");
		// tf2.setText("");
		// }
		// });
	}



	private void showTheLayout(Stage stage)
	{
		stage.setScene(new Scene(pane, 220, 100));
		stage.setTitle("KlickMich1");
		stage.setResizable(true);
		stage.centerOnScreen();
		stage.show();
	}



	private void makeTheLayout()
	{
		pane = new FlowPane();

		// button.setPrefWidth(200);
		// tf1.setPrefWidth(200);
		// tf2.setPrefWidth(200);
		// tf2.setPrefHeight(24);
		pane.getChildren().addAll(klick, clear, tf1, tf2);
	}


	public static void main(String[] args)
	{
		Application.launch(args);
	}



	@Override
	public void handle(ActionEvent event)
	{
		System.out.println(event);

		if (event.getSource() == klick)
		{
			if (tf2.getText().equals(""))
			{
				tf2.setText("danke fuers klicken");
				tf1.setText("");
			}
			else
			{
				tf1.setText("danke fuers klicken");
				tf2.setText("");
			}
		}
		else
			if (event.getSource() == clear)
			{
				tf1.setText("");
				tf2.setText("");
			}
	}



}
