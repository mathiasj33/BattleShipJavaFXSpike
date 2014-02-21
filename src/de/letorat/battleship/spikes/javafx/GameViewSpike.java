package de.letorat.battleship.spikes.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import de.letorat.battleship.code.model.Alignment;
import de.letorat.battleship.code.model.Game;
import de.letorat.battleship.code.model.Model;
import de.letorat.battleship.code.model.Player;
import de.letorat.battleship.code.model.Playingfield;
import de.letorat.battleship.code.model.Pos;
import de.letorat.battleship.code.model.Ship;
import de.letorat.battleship.code.model.ShipSelection;
import de.letorat.battleship.code.views.GameView;


public class GameViewSpike extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Model model = new Model();
			Playingfield pF = new Playingfield(10);
			Game game = new Game(pF, new Player("p1", 3), new Player("p2", 3));
			model.setGame(game);
			ShipSelection sel = new ShipSelection(Alignment.Horizontal);
			sel.addShips(1, new Ship(5, Alignment.Horizontal));
			sel.addShips(2, new Ship(4, Alignment.Horizontal));
			sel.addShips(3, new Ship(3,Alignment.Horizontal));
			sel.addShips(4, new Ship(2, Alignment.Horizontal));
			model.setShipSelection(sel);
			GameView root = new GameView(model);
			model.addView(root);
			Scene scene = new Scene(root,797,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			Ship s = new Ship(4, Alignment.Vertical);
			Ship s2 = new Ship(2, Alignment.Horizontal);
			model.addShip(s, new Pos(0,0));
			model.addShip(s2, new Pos(5,5));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}