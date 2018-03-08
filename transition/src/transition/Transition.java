package transition;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Transition extends Application
{
	public static void main(String[] args)
	{
		launch();
	}

	@Override
	public void start(Stage myStage) throws Exception
	{		
		Rectangle typ = new Rectangle(50, 50, 100, 150);
		typ.setArcHeight(20);
		typ.setArcWidth(20);
		typ.setFill(Color.BLACK);
		
		Rectangle tisch = new Rectangle(1000, 300, 200, 500);
		tisch.setArcHeight(30);
		tisch.setArcWidth(30);
		tisch.setFill(Color.BURLYWOOD);
		
		TranslateTransition goToTisch = new TranslateTransition();
		goToTisch.setAutoReverse(false);
		goToTisch.setCycleCount(1);
		goToTisch.setNode(typ);
		goToTisch.setDuration(Duration.seconds(5));
		goToTisch.setToX(845);
		goToTisch.setToY(250);
		goToTisch.play();
		
		/*
		RotateTransition rotate = new RotateTransition();
		rotate.setCycleCount(Animation.INDEFINITE);
		rotate.setNode(rec);
		rotate.setDuration(Duration.seconds(1));
		rotate.setAutoReverse(true);
		rotate.setByAngle(90);
		rotate.play();
		*/
		
		/*
		TranslateTransition transition = new TranslateTransition();
		transition.setCycleCount(Animation.INDEFINITE);
		transition.setAutoReverse(true);
		transition.setToX(400);
		transition.setToY(400);
		transition.setNode(rec);
		transition.setDuration(Duration.seconds(3));
		transition.play();
		*/
		
		/*
		Path path = new Path();
		path.getElements().add(new MoveTo(0f, 50f));
		path.getElements().add(new CubicCurveTo(40f, 10f, 390f, 240f, 2600, 50f));

		PathTransition pathTransition = new PathTransition();
		pathTransition.setDuration(Duration.seconds(4));
		pathTransition.setNode(rec);
		pathTransition.setPath(path);
		pathTransition.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
		pathTransition.setCycleCount(Animation.INDEFINITE);
		pathTransition.setAutoReverse(true);
		pathTransition.play();
		*/
		
		Pane root = new Pane();
		root.getChildren().addAll(typ, tisch);
		
		Scene myScene = new Scene(root, 600, 600);
		
		myStage.setTitle("Transition");
		myStage.setScene(myScene);
		myStage.show();
	}
}
