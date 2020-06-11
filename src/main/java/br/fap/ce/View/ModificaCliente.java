package br.fap.ce.View;

import Controller.DadosClientes;
import Model.User;
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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ModificaCliente extends Application {

	private AnchorPane pane;
	private TextField textFieldCodigo, textFieldNome, textFieldEmail;
	private PasswordField passwordFieldsenha;
	private Button buttonCadastrar, buttonAtualizar, buttonDeletar;
	private static Stage stage;
	private Hyperlink hyperHome, hyperExit, hyperLogin;
	private Label labelModificar;
	
	public void initComponent() {
		pane = new AnchorPane();
		pane.setPrefSize(1000, 600);

		textFieldCodigo = new TextField();
		textFieldCodigo.setPromptText("Código do Usuário");

		textFieldNome = new TextField();
		textFieldNome.setPromptText("Nome do Usário");

		textFieldEmail = new TextField();
		textFieldEmail.setPromptText("Email do Usuário");

		passwordFieldsenha = new PasswordField();
		passwordFieldsenha.setPromptText("Senha do Usuário");

		buttonCadastrar = new Button("Cadastrar");
		buttonAtualizar = new Button("Atualizar");
		buttonDeletar = new Button("Deletar");

		hyperHome = new Hyperlink("Home");
		hyperLogin = new Hyperlink("Login");
		hyperExit = new Hyperlink("Sair");

		labelModificar = new Label("Alterar Informações Cadastrais dos Usuários");

	}

	// Methodo para definir caracteristicas de componentes na tela
	public void initLayout() {
		// Header
		// Label with name Academia

		// Body
		// Label with name Entrar no Academia

		labelModificar.setLayoutX(120);
		labelModificar.setLayoutY(100);
		labelModificar.setFont(new Font("italic", 25));

		// Input type text
		textFieldCodigo.setLayoutX(200);
		textFieldCodigo.setLayoutY(240);

		textFieldNome.setLayoutX(350);
		textFieldNome.setLayoutY(240);

		textFieldEmail.setLayoutX(500);
		textFieldEmail.setLayoutY(240);

		passwordFieldsenha.setLayoutX(650);
		passwordFieldsenha.setLayoutY(240);

		// Button
		buttonCadastrar.setLayoutX(590);
		buttonCadastrar.setLayoutY(410);
		buttonCadastrar.setPrefSize(100, 5);
		buttonCadastrar.setStyle("-fx-background-color: #42b72a;");

		buttonAtualizar.setLayoutX(695);
		buttonAtualizar.setLayoutY(410);
		buttonAtualizar.setPrefSize(100, 5);
		buttonAtualizar.setStyle("-fx-background-color: #42b72a;");

		buttonDeletar.setLayoutX(800);
		buttonDeletar.setLayoutY(410);
		buttonDeletar.setPrefSize(100, 5);
		buttonDeletar.setStyle("-fx-background-color: #42b72a;");

		// Hyperlink back from home
		hyperHome.setLayoutX(450);
		hyperHome.setLayoutY(30);
		hyperHome.setFont(new Font("italic", 15));

		// Hyperlink back from home
		hyperLogin.setLayoutX(700);
		hyperLogin.setLayoutY(30);
		hyperLogin.setFont(new Font("italic", 15));

		// Hyperlink Exit
		hyperExit.setLayoutX(900);
		hyperExit.setLayoutY(30);
		hyperExit.setFont(new Font("italic", 15));

		// Add componets the pane
		pane.getChildren().addAll(textFieldCodigo, textFieldNome, textFieldEmail, passwordFieldsenha, buttonCadastrar,
				buttonAtualizar, buttonDeletar, hyperHome, hyperExit, labelModificar);
	}

	// Methods for adding action to each button
    public void initListeners() {
    	
    	 // Hyperlink Exit
        hyperExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {
                Stage stage = (Stage) hyperExit.getScene().getWindow();
                stage.close();
            }
        });
        
        buttonCadastrar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				App newUser = new App();
		        Stage stageHome = new Stage();
		        try {
		            newUser.start(stageHome);
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
			}
        	
		});
    }
    
    public void carregaDadosText() {
    	
    }
        // hyperLogin Quando clicado abre a tela de login
        /*hyperLogin.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
            public void handle(final ActionEvent event) {
                Stage stage = (Stage) hyperLogin.getScene().getWindow();
                logar();
        }});
    }*/
	
	// Method start
	@Override
	public void start(Stage stage) {
		initComponent();
		initListeners();
		initLayout();
		initStage(stage);
		stage = ModificaCliente.stage;
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


