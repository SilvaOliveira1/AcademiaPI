package br.fap.ce.View;

import Bridge.GeradorFuncoes;
import Bridge.GeradorTxt;
import Bridge.LogErros;
import Controller.DadosClientes;
import Model.UsuariosFuncoes;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Login extends Application {

    private AnchorPane pane;
    private TextField textFieldUserLogin;
    private PasswordField passwordFieldUserLogin;
    private Button buttonLogin, buttonCriarConta, buttonCriarConta2;
    private static Stage stage;
    private Hyperlink hyperlink, hyperExit;
    private Label labelAcademia, labelOu, labelEntrarAcademia;

    // arquitetura bÃ¡sica, tem esses trÃªs mÃ©todos
    // Methodo para inicializar tela e componentes
    public void initComponent() {
        pane = new AnchorPane();
        pane.setPrefSize(1000, 600);

        textFieldUserLogin = new TextField();
        textFieldUserLogin.setPromptText("Email ou telefone");

        passwordFieldUserLogin = new PasswordField();
        passwordFieldUserLogin.setPromptText("Senha");

        buttonLogin = new Button("Entrar");
        buttonCriarConta = new Button("Criar nova conta");
        buttonCriarConta2 = new Button("Criar nova conta");

        hyperlink = new Hyperlink("Esqueceu a conta?");
        hyperExit = new Hyperlink("Sair");

        labelAcademia = new Label("Cresça com a gente");
        labelOu = new Label("________ ou ________");
        labelEntrarAcademia = new Label("Entrar na Academia");

    }

    // Methodo para definir caracteristicas de componentes na tela
    public void initLayout() {
        // Header
        // Label with name Academia
        labelAcademia.setLayoutX(120);
        labelAcademia.setLayoutY(20);
        labelAcademia.setFont(new Font("italic", 40));

        // Body
        // Label with name Entrar no Academia
        labelEntrarAcademia.setLayoutX(430);
        labelEntrarAcademia.setLayoutY(200);
        labelEntrarAcademia.setFont(new Font("inherit", 18));

        // Input type text
        textFieldUserLogin.setLayoutX(430);
        textFieldUserLogin.setLayoutY(240);

        // Button Password
        passwordFieldUserLogin.setLayoutX(430);
        passwordFieldUserLogin.setLayoutY(270);

        // Button Login
        buttonLogin.setLayoutX(430);
        buttonLogin.setLayoutY(310);
        buttonLogin.setPrefSize(150, 5);
        buttonLogin.setStyle("-fx-background-color: #42b72a;");

        // Hyperlink forget password
        hyperlink.setLayoutX(450);
        hyperlink.setLayoutY(340);

        // Hyperlink Exit
        hyperExit.setLayoutX(900);
        hyperExit.setLayoutY(30);

        // Button CriarConta
        buttonCriarConta.setLayoutX(443);
        buttonCriarConta.setLayoutY(390);
        buttonCriarConta.setPrefSize(120, 5);
        buttonCriarConta.setStyle("-fx-background-color: #42b72a;");

        // Label with name ____ou____
        labelOu.setLayoutX(450);
        labelOu.setLayoutY(360);

        // Add componets the pane
        pane.getChildren().addAll(labelAcademia, labelEntrarAcademia, textFieldUserLogin, passwordFieldUserLogin,
                buttonLogin, hyperlink, buttonCriarConta, labelOu, hyperExit);

    }

    // Methods for adding action to each button
    public void initListeners() {
        // Hyperlink
        hyperlink.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(final ActionEvent event) {
                criarConta();
            }
        });

        // ButtonLogin
        buttonLogin.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(final ActionEvent event) {
                logar();
            }
        });
        
        // Button Criar conta
        buttonCriarConta.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {
                criarConta();
            }
        });
        // Hyperlink Exit
        hyperExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {
                Stage stage = (Stage) hyperExit.getScene().getWindow();
                stage.close();
            }
        });
    }

    // Create account method
    public void criarConta() {
        App newUser = new App();
        Stage stageHome = new Stage();
        try {
            newUser.start(stageHome);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void carregaUsuario() {
      
    }

    // Method to login authenticate
    public void logar() {
    	String email, senha;
    	email = textFieldUserLogin.getText();
    	senha = passwordFieldUserLogin.getText();
    	if(DadosClientes.preparaDadosBuscaUsuario(email, senha) == 1) {
    		System.out.println("Usuario valido");
    	}else {
    		GeradorFuncoes gerador = new GeradorTxt();
    		LogErros logErros = new LogErros("Usuario invalido, entre em contato com a equipe de suporte", gerador);
    		logErros.gerarArquivo();
    	}
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("InformaÃ§Ã£o");
        alert.setHeaderText(null);
//        if (newUser.buscaUsuario(textFieldUserLogin.getText(), passwordFieldUserLogin.getText()) == 1) {
//            alert.setContentText("Login Realizado com sucesso\n Seja bem vindo " + textFieldUserLogin.getText());
//            alert.showAndWait();
//        }
    }

    // Method start
    @Override
    public void start(Stage stage) {
        carregaUsuario();
        initComponent();
        initListeners();
        initLayout();
        initStage(stage);
        stage = Login.stage;
    }

    // Method InitStage
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
