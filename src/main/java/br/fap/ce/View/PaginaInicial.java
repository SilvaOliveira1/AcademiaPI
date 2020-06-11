package br.fap.ce.View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PaginaInicial extends Application{
    private AnchorPane pane;

    private static Stage stage;

	public void initComponent() {
    	
    }
	public void initLayout() {
		
	}
    public void initListeners() {

    }
	// Method start
    @Override
    public void start(Stage stage) {
        initComponent();
        initListeners();
        initLayout();
        initStage(stage);
        stage = PaginaInicial.stage;
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
