package net.softwarepage.battleship.spikes.javafx;

import net.softwarepage.battleship.code.model.Alignment;
import net.softwarepage.battleship.code.model.Game;
import net.softwarepage.battleship.code.model.Model;
import net.softwarepage.battleship.code.model.Player;
import net.softwarepage.battleship.code.model.Playingfield;
import net.softwarepage.battleship.code.model.Pos;
import net.softwarepage.battleship.code.model.Ship;
import net.softwarepage.battleship.code.model.ShipSelection;
import net.softwarepage.battleship.code.views.GameView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class GameViewSpike extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Model model = new Model();
			Playingfield pF = new Playingfield(10);
			Game game = new Game(pF, new Player("p1", 3), new Player("p2", 3));
			model.setGame(game);
			ShipSelection sel = new ShipSelection(Alignment.Horizontal);
			sel.addShips(new Ship(5, Alignment.Horizontal), 2);
			sel.addShips(new Ship(4, Alignment.Horizontal), 2);
			sel.addShips(new Ship(3,Alignment.Horizontal), 3);
			sel.addShips(new Ship(2, Alignment.Horizontal), 4);
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