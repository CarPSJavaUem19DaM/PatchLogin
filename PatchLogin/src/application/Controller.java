package application;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Controller {

	@FXML
	private Pane pane1;

	@FXML
	private Pane pane2;

	@FXML
	private Pane pane3;

	@FXML
	private Pane pane4;

	private AnchorPane mypane;
	
//	@FXML
//	private URL location;
//	
//	@FXML
//	private ResourceBundle resources;
	

	public void initialize() {//Lanza el método

		/*pane1.setStyle("-fx-background-image: url('../img/1.jpg')");
		pane2.setStyle("-fx-background-image: url('../img/2.jpg')");
		pane3.setStyle("-fx-background-image: url('../img/3.jpg')");
		pane4.setStyle("-fx-background-image: url('../img/4.jpg')");*/

		backgroundAnimation();

	}
	
	@FXML //Metodo Ernesto para q abra otra ventana
	private void reportButtonHandler(ActionEvent event) {	    
	   try {
		   FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
		   mypane = (AnchorPane) loader.load();
		   Scene scene = new Scene(mypane);		   
		   Stage stage = new Stage();	//En el main hay un star stage pero aqui hay q ponerlo	    
		   stage.setScene(scene);
		   //stage.setResizable(false);
		   stage.show();
	   } catch (Exception e) {		
	   }
	}
	
	/*@FXML //Metodo para q abra otra ventana
	private void reportButtonHandler(ActionEvent event) {	    
	   try {
		   FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Home.fxml"));
		   Parent root1 = (Parent) fxmlLoader.load();
		    Stage stage = new Stage();
		    //set what you want on your stage
		    stage.initModality(Modality.APPLICATION_MODAL);
		    stage.setTitle("Bienvenido a la app");
		    stage.setScene(new Scene(root1));
		    //stage.setResizable(false);
		    stage.show();
	   } catch (Exception e) {		
	   }
	}*/

	private void backgroundAnimation() {

		FadeTransition fadeTransition = new FadeTransition(Duration.seconds(5),
				pane4);
		fadeTransition.setFromValue(1);//Va desde la máxima opacidad(1) 
		fadeTransition.setToValue(0); // a desaparecer (0)
		fadeTransition.play();

		fadeTransition
				.setOnFinished(event -> {

					FadeTransition fadeTransition1 = new FadeTransition(
							Duration.seconds(3), pane3);//Cada 3 segundos cambia de panel
					fadeTransition1.setFromValue(1);
					fadeTransition1.setToValue(0);
					fadeTransition1.play();

					fadeTransition1.setOnFinished(event1 -> {
						FadeTransition fadeTransition2 = new FadeTransition(
								Duration.seconds(3), pane2);
						fadeTransition2.setFromValue(1);
						fadeTransition2.setToValue(0);
						fadeTransition2.play();

						fadeTransition2.setOnFinished(event2 -> {

							FadeTransition fadeTransition0 = new FadeTransition(
									Duration.seconds(3), pane2);
							fadeTransition0.setFromValue(0);
							fadeTransition0.setToValue(1);
							fadeTransition0.play();

							fadeTransition0.setOnFinished(event3 -> {

								FadeTransition fadeTransition11 = new FadeTransition(
										Duration.seconds(3), pane3);

								fadeTransition11.setFromValue(0);
								fadeTransition11.setToValue(1);
								fadeTransition11.play();

								fadeTransition11.setOnFinished(event4 -> {

									FadeTransition fadeTransition22 = new FadeTransition(
											Duration.seconds(3), pane4);

									fadeTransition22.setFromValue(0);
									fadeTransition22.setToValue(1);
									fadeTransition22.play();

									fadeTransition22.setOnFinished(event5 -> {

										backgroundAnimation();
									});

								});

							});

						});
					});

				});

	}
	
}
