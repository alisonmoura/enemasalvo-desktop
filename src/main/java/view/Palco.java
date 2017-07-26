package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Palco extends Application {

    private Stage palco;
    private Scene home = new HomeScene(this);
    private Scene login = new LoginScene(this);
    private Scene cadastro = new CadastroScene(this);
    private Scene menu = new MenuScene(this);
    private Scene simulado = new SimuladoScene(this);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage palco) throws Exception {
        this.palco = palco;

        palco.setScene(home);
        palco.setTitle("Enem A Savlo");
        palco.show();

    }

    public void irParaHome(){
        palco.setScene(home);
    }
    
    public void irParaLogin(){
        palco.setScene(login);
    }

	public void irParaCadastro() {
		palco.setScene(cadastro);
	}
	
	public void irParaMenu() {
		palco.setScene(menu);
	}
	
	public void irParaSimulado() {
		palco.setScene(simulado);
	}
}