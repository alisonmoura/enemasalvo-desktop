package view;

import java.util.ArrayList;
import java.util.List;

import dao.QuestaoDAO;
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
import model.Questao;
import model.Simulado;

public class SimuladoScene extends Scene {

	static VBox painel = new VBox();
	Simulado simulado = new Simulado();
	QuestaoDAO questaoDAO = new QuestaoDAO();
	private Text simuladoText = new Text("");
	
	public SimuladoScene(Palco palco) {

		super(painel, 800, 500);

		this.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());

		Text titulo = new Text("Simulado");
		titulo.setFill(Paleta.CONTRASTE);
		titulo.setFont(Font.font("Arial", FontWeight.BOLD, 50));
		
		simuladoText.setFill(Paleta.CONTRASTE);

		Button btnMaisSimulado = new Button("Gerar mais simulado");
		btnMaisSimulado.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				gerarSimulado();
			}
		});

		Button btnSair = new Button("Voltar");
		btnSair.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				palco.irParaMenu();
			}
		});

		painel.setAlignment(Pos.CENTER);
		painel.setSpacing(10);
		painel.setBackground(new Background(new BackgroundFill(Paleta.PRIMARIA, null, null)));
		painel.getChildren().addAll(titulo, simuladoText, btnMaisSimulado, btnSair);

		gerarSimulado();

	}

	private void gerarSimulado() {
		simulado.setQuestoes(questaoDAO.buscarTodos());
		for (Questao questao : simulado.getQuestoes()) {
			simuladoText.setText(
					simuladoText.getText() + questao.getCategoria() + "\n\n" + questao.getTexto() + "\n\n");
		}
	}
}
