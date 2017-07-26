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

public class LoginScene extends Scene {

	static VBox painel = new VBox();
	private TextField inputEmail;
	private TextField inputSenha;
	private Usuario usuario = new Usuario();
	private UsuarioDAO usuarioDAO = new UsuarioDAO();

	public LoginScene(Palco palco) {

		super(painel, 800, 500);

		this.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());

		Text titulo = new Text("Login");
		titulo.setFill(Paleta.CONTRASTE);
		titulo.setFont(Font.font("Arial", FontWeight.BOLD, 50));
		
		Label msg = new Label();
		msg.setTextFill(Paleta.ERROR);

		Button btnEntrar = new Button("Entrar");
		btnEntrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	usuario.setEmail(inputEmail.getText());
            	usuario.setSenha(inputSenha.getText());
            	
            	limparFormulario();
            	
            	usuario = usuarioDAO.login(usuario);
            	if(usuario != null){
            		palco.irParaMenu();
            	}else{
            		msg.setText("Usuário não encontrado");
            		usuario = new Usuario();
            	}
            }
        });
		
		Button btnCadastrar = new Button("Cadastrar");
		btnCadastrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                palco.irParaCadastro();
            }
        });


		painel.setAlignment(Pos.CENTER);
		painel.setSpacing(10);
		painel.setBackground(new Background(new BackgroundFill(Paleta.PRIMARIA, null, null)));
		painel.getChildren().addAll(titulo, msg, getCampoEmail(), getCampoSenha(), btnEntrar, btnCadastrar);

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
		inputEmail.setText("");
		inputSenha.setText("");
	}
}
