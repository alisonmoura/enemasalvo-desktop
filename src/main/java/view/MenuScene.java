package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class MenuScene extends Scene {

	static VBox painel = new VBox();

	public MenuScene(Palco palco) {

		super(painel, 800, 500);

		this.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());

		Text titulo = new Text("Bem-vindo!");
		titulo.setFill(Paleta.CONTRASTE);
		titulo.setFont(Font.font("Arial", FontWeight.BOLD, 50));

		Button btnGerarSimulado = new Button("Gerar Simulado");
		btnGerarSimulado.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				palco.irParaSimulado();
			}
		});

		Button btnGerarSimuladoArea = new Button("Gerar Simulado por Área");
		btnGerarSimuladoArea.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {

			}
		});

		Button btnSair = new Button("Sair");
		btnSair.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				palco.irParaHome();
			}
		});

		painel.setAlignment(Pos.CENTER);
		painel.setSpacing(10);
		painel.setBackground(new Background(new BackgroundFill(Paleta.PRIMARIA, null, null)));
		painel.getChildren().addAll(titulo, btnGerarSimulado, btnGerarSimuladoArea, btnSair);

	}
}
