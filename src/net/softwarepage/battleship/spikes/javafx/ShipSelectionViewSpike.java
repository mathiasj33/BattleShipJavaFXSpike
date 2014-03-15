package net.softwarepage.battleship.spikes.javafx;

import net.softwarepage.battleship.code.model.Alignment;
import net.softwarepage.battleship.code.model.Game;
import net.softwarepage.battleship.code.model.Model;
import net.softwarepage.battleship.code.model.Player;
import net.softwarepage.battleship.code.model.Playingfield;
import net.softwarepage.battleship.code.model.Ship;
import net.softwarepage.battleship.code.model.ShipSelection;
import net.softwarepage.battleship.code.views.ShipSelectionView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ShipSelectionViewSpike extends Application {

	@Override
	public void start(Stage primaryStage) {
		Model model = new Model();
		Playingfield pF = new Playingfield(10);
		Game game = new Game(pF, new Player("p1", 3), new Player("p2", 3));
		ShipSelection sel = new ShipSelection(Alignment.Vertical);
		sel.addShips(new Ship(5, Alignment.Vertical), 2);
		sel.addShips(new Ship(4, Alignment.Vertical), 2);
		sel.addShips(new Ship(3,Alignment.Vertical), 3);
		sel.addShips(new Ship(2, Alignment.Vertical), 4);
		model.setGame(game);
		model.setShipSelection(sel);
		ShipSelectionView root = new ShipSelectionView(40, model);
		model.addView(root);
		Scene scene = new Scene(root,300,500);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
