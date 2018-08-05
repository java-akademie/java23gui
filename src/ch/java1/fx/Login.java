package ch.java1.fx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Login extends Application
{
	private Pane pane;

	Label ueberschrift = new Label("Bitte loggen Sie sich ein");


	final private Label lbName = new Label("Name");
	final private TextField tfName = new TextField();

	final private Label lbPassword = new Label("Password");
	final private PasswordField tfPassword = new PasswordField();

	final private Button btLogin = new Button("LOGIN");
	final private Button btInit = new Button("INIT");
	final private Button btClear = new Button("CLEAR");
	final private Button btExit = new Button("EXIT");

	final private CheckBox cbShow = new CheckBox("ShowGridlines");


	@Override
	public void start(Stage stage) throws Exception
	{
		makeTheLayout();
		addTheListener();
		showTheLayout(stage);
	}


	private void addTheListener()
	{
		cbShow.setOnAction(e -> {
			((GridPane) pane).setGridLinesVisible(cbShow.isSelected());
		});

		btInit.setOnAction(e -> fillNameAndPassword());
		btClear.setOnAction(e -> clear());
	}


	private void fillNameAndPassword()
	{
		tfName.setText("scott");
		tfPassword.setText("tiger");
	}


	private void clear()
	{
		tfName.setText("");
		tfPassword.setText("");
	}



	private void showTheLayout(Stage stage)
	{
		stage.setScene(new Scene(pane));
		stage.setTitle("Login");
		stage.setResizable(true);
		stage.setX(600);
		stage.setY(30);
		stage.show();
	}



	private void makeTheLayout()
	{
		GridPane p = new GridPane();
		tfName.setPrefWidth(300);
		tfPassword.setPrefWidth(300);

		p.setPadding(new Insets(15, 15, 15, 15));
		p.setHgap(7);
		p.setVgap(7);

		int zeile = 0;

		zeile++;
		ueberschrift.setFont(Font.font(24));
		p.add(ueberschrift, 1, zeile);

		zeile++;
		p.add(lbName, 0, zeile);
		p.add(tfName, 1, zeile, 2, 1);

		zeile++;
		p.add(lbPassword, 0, zeile);
		p.add(tfPassword, 1, zeile, 2, 1);

		zeile++;
		HBox hb = new HBox(5);
		hb.getChildren().addAll(btLogin, btInit, btClear, btExit);
		p.add(hb, 2, zeile);

		zeile++;
		p.add(cbShow, 0, zeile);

		this.pane = p;
	}


	public static void main(String[] args)
	{
		Application.launch(args);
	}
}
