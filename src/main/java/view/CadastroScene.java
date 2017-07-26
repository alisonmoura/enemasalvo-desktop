package view;

import dao.UsuarioDAO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import model.Usuario;

public class CadastroScene extends Scene {

	static VBox painel = new VBox();
	private TextField inputNome;
	private TextField inputEmail;
	private TextField inputSenha;
	private Usuario usuario = new Usuario();
	private UsuarioDAO usuarioDAO = new UsuarioDAO();

	public CadastroScene(Palco palco) {

		super(painel, 800, 500);

		this.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());

		Text titulo = new Text("Cadastro");
		titulo.setFill(Paleta.CONTRASTE);
		titulo.setFont(Font.font("Arial", FontWeight.BOLD, 50));

		Button btnCadastrar = new Button("Cadastrar");
		btnCadastrar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				usuario.setNome(inputNome.getText());
				usuario.setEmail(inputEmail.getText());
				usuario.setSenha(inputSenha.getText());

				usuarioDAO.cadastrar(usuario);
				limparFormulario();

				usuario = new Usuario();
				palco.irParaHome();
			}
		});

		Button btnVoltar = new Button("Voltar");
		btnVoltar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				palco.irParaLogin();
			}
		});

		painel.setAlignment(Pos.CENTER);
		painel.setSpacing(10);
		painel.setBackground(new Background(new BackgroundFill(Paleta.PRIMARIA, null, null)));
		painel.getChildren().addAll(titulo, getCampoNome(), getCampoEmail(), getCampoSenha(), btnCadastrar, btnVoltar);

	}

	private HBox getCampoNome() {
		HBox linha = new HBox();
		Label label = new Label("Nome");
		label.setTextFill(Paleta.CONTRASTE);
		inputNome = new TextField();
		linha.setAlignment(Pos.CENTER);
		linha.setSpacing(10);
		linha.getChildren().addAll(label, inputNome);
		return linha;
	}

	private HBox getCampoEmail() {
		HBox linha = new HBox();
		Label label = new Label("Email");
		label.setTextFill(Paleta.CONTRASTE);
		inputEmail = new TextField();
		linha.setAlignment(Pos.CENTER);
		linha.setSpacing(10);
		linha.getChildren().addAll(label, inputEmail);
		return linha;
	}

	private HBox getCampoSenha() {
		HBox linha = new HBox();
		Label label = new Label("Senha");
		label.setTextFill(Paleta.CONTRASTE);
		inputSenha = new TextField();
		linha.setAlignment(Pos.CENTER);
		linha.setSpacing(10);
		linha.getChildren().addAll(label, inputSenha);
		return linha;
	}

	private void limparFormulario() {
		inputNome.setText("");
		inputEmail.setText("");
		inputSenha.setText("");
	}

}
