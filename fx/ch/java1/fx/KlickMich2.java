package ch.java1.fx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class KlickMich2 extends Application
{
	private Pane pane;

	final private Button klick1 = new Button("KlickMich1");
	final private Button klick2 = new Button("KlickMich2");
	final private Button clear = new Button("CLEAR");
	final private Button exit = new Button("EXIT");
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
		klick1.setOnAction(e -> klick(1));
		klick2.setOnAction(e -> klick(2));
		clear.setOnAction(e -> clear());
		exit.setOnAction(e -> exit());
	}


	private void clear()
	{
		tf1.setText("");
		tf2.setText("");
	}


	private void exit()
	{
		if (tf1.getText().equals(""))
		{
			tf1.setText("exit geklickt");
		}
		else
		{
			tf2.setText("exit geklickt");
		}
	}


	private void klick(int i)
	{
		if (tf1.getText().equals(""))
		{
			tf1.setText("danke fuers klicken " + i);
			tf2.setText("");
		}
		else
		{
			tf2.setText("danke fuers klicken " + i);
			tf1.setText("");
		}
	}


	private void showTheLayout(Stage stage)
	{
		stage.setScene(new Scene(pane));
		stage.setTitle("KlickMich2");
		stage.setResizable(true);
		// stage.centerOnScreen();
		stage.setX(600);
		stage.setY(30);
		stage.show();
	}



	private void makeTheLayout()
	{
		FlowPane rootPane = new FlowPane();

		int ins = 10;

		VBox pane1 = new VBox(10);
		VBox pane2 = new VBox(10);
		HBox pane3 = new HBox(10);

		pane1.setPadding(new Insets(ins, ins, ins, ins));
		pane2.setPadding(new Insets(ins, ins, ins, ins));
		pane3.setPadding(new Insets(ins, ins, ins, ins));

		tf1.setPrefWidth(200);
		tf2.setPrefWidth(200);
		tf2.setPrefHeight(24);

		pane1.getChildren().addAll(klick1, klick2);
		pane2.getChildren().addAll(tf1, tf2);
		pane3.getChildren().addAll(clear, exit);

		rootPane.getChildren().addAll(pane1, pane2, pane3);

		Tooltip ttKlick1 = new Tooltip(
				"klicken Sie und es wird Ihnen gezeigt");
		klick1.setTooltip(ttKlick1);
		klick2.setTooltip(ttKlick1);
tf1.setTooltip(new Tooltip("hier wird der Text ausgegeben"));
		Tooltip.install(rootPane, new Tooltip("tt fuer das rootPane"));
		this.pane = rootPane;
	}


	public static void main(String[] args)
	{
		Application.launch(args);
	}
}
