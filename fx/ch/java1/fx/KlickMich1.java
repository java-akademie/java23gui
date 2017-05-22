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

	final private Button klick1 = new Button("KlickMich1");
	final private Button klick2 = new Button("KlickMich2");
	final private Button klick3 = new Button("KlickMich3");
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
		EventHandler<ActionEvent> eh = new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent ae)
			{
				if (tf1.getText().equals(""))
				{
					tf1.setText("danke fuers klicken 1");
					tf2.setText("");
				}
				else
				{
					tf2.setText("danke fuers klicken 1");
					tf1.setText("");
				}
			}
		};

		klick1.setOnAction(eh);
		klick2.setOnAction(this);

		clear.setOnAction(new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent e)
			{
				clear();
			}

		});

		klick3.setOnAction(ex -> klick3());
	}


	private void clear()
	{
		tf1.setText("");
		tf2.setText("");
	}


	private void klick3()
	{
		if (tf1.getText().equals(""))
		{
			tf1.setText("danke fuers klicken 3");
			tf2.setText("");
		}
		else
		{
			tf2.setText("danke fuers klicken 3");
			tf1.setText("");
		}
	}


	private void showTheLayout(Stage stage)
	{
		stage.setScene(new Scene(pane, 350, 120));
		stage.setTitle("KlickMich1");
		stage.setResizable(true);
		// stage.centerOnScreen();
		stage.setX(600);
		stage.setY(30);
		stage.show();
		System.out.println(stage.getX());
		System.out.println(stage.getY());
	}



	private void makeTheLayout()
	{
		pane = new FlowPane();

		// button.setPrefWidth(200);
		// tf1.setPrefWidth(200);
		// tf2.setPrefWidth(200);
		// tf2.setPrefHeight(24);
		pane.getChildren().addAll(klick1, klick2, klick3, tf1, tf2,
				clear);
	}


	public static void main(String[] args)
	{
		Application.launch(args);
	}



	@Override
	public void handle(ActionEvent e)
	{
		System.out.println(e);

		if (e.getSource() == klick2)
		{
			if (tf1.getText().equals(""))
			{
				tf1.setText("danke fuers klicken 2");
				tf2.setText("");
			}
			else
			{
				tf2.setText("danke fuers klicken 2");
				tf1.setText("");
			}
		}
	}

}
