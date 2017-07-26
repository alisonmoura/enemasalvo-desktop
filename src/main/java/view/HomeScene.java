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

public class HomeScene extends Scene {

    static VBox painel = new VBox();

    public HomeScene(Palco palco) {

        super(painel, 800, 500);
        
        this.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());

        Text titulo = new Text("Enem A Salvo");
        titulo.setFill(Paleta.CONTRASTE);
        titulo.setFont(Font.font("Arial", FontWeight.BOLD, 50));

        Button btnContinuar = new Button("Continuar");
        btnContinuar.setId("btn-continuar");
        btnContinuar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                palco.irParaLogin();
            }
        });

        painel.setAlignment(Pos.CENTER);
        painel.setSpacing(10);
        painel.setBackground(new Background(new BackgroundFill(Paleta.PRIMARIA, null, null)));
        painel.getChildren().addAll(titulo, btnContinuar);

    }
}
