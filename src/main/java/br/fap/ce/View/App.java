package br.fap.ce.View;

import java.util.ArrayList;

import Controller.DadosClientes;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class App extends Application {
    private static Stage stage;
    private AnchorPane pane;
    private Button buttonAdd;
    private TextField textFieldNome, textFieldEmail;
    private PasswordField passwordFieldSenha;
    private Label labelCriaConta, labelRapido, labelAcademia;
    private Hyperlink hyperlinkSair;

    // arquitetura bÃ¡sica, tem esses trÃªs mÃ©todos
    // Methodo para inicializar tela e componentes
    public void initComponent() {
        pane = new AnchorPane();
        pane.setPrefSize(400, 300);

        textFieldNome = new TextField();
        textFieldNome.setPromptText("Nome");

        textFieldEmail = new TextField();
        textFieldEmail.setPromptText("Email");

        passwordFieldSenha = new PasswordField();
        passwordFieldSenha.setPromptText("Senha");

        labelCriaConta = new Label("Criar uma nova conta");
        labelRapido = new Label("Cresça com a gente");
        labelAcademia = new Label("Academia");

        buttonAdd = new Button("Cadastre-se");

        hyperlinkSair = new Hyperlink("Sair");
    }

    // Methodo para definir caracteristicas de componentes na tela
    public void initLayout() {
        hyperlinkSair.setLayoutX(360);
        hyperlinkSair.setLayoutY(10);

        labelAcademia.setLayoutX(120);
        labelAcademia.setLayoutY(30);
        labelAcademia.setFont(new Font("italic", 40));

        labelCriaConta.setLayoutX(145);
        labelCriaConta.setLayoutY(95);

        labelRapido.setLayoutX(160);
        labelRapido.setLayoutY(115);

        textFieldNome.setLayoutX(129);
        textFieldNome.setLayoutY(140);

        textFieldEmail.setLayoutX(129);
        textFieldEmail.setLayoutY(170);

        passwordFieldSenha.setLayoutX(129);
        passwordFieldSenha.setLayoutY(200);

        buttonAdd.setLayoutX(165);
        buttonAdd.setLayoutY(235);
        buttonAdd.setStyle("-fx-background-color: #42b72a;");

        pane.getChildren().addAll(labelAcademia, labelCriaConta, labelRapido, textFieldNome, textFieldEmail,
                passwordFieldSenha, buttonAdd, hyperlinkSair);
    }

    // Methods for adding action to each button
    public void initListeners() {
        buttonAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	boolean verificado = false;
            	String nome, email, senha;
            	nome = textFieldNome.getText();
            	email = textFieldEmail.getText();
            	senha = passwordFieldSenha.getText();
            	System.out.println(nome + email + senha);
            	DadosClientes.preparadaDadosInsercaoUsuario(nome, email, senha);
            		Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Informações");
                    alert.setHeaderText(null);
                    alert.setContentText("Usuario cadastrado com sucesso!");
                    alert.showAndWait();

                try {
                	Login home = new Login();
                    Stage stageHome = new Stage();
                    home.start(stageHome);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        hyperlinkSair.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) hyperlinkSair.getScene().getWindow();
                stage.close();
            }
        });
    }

    @Override
    public void start(Stage stage) {
        initComponent();
        initListeners();
        initLayout();
        initStage(stage);
        // logar();
        stage = App.stage;
    }

    private void initStage(Stage stage) {
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // Method Launcher
    public static void main(final String[] args) {
        launch();
    }
}