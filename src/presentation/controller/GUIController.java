package presentation.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import database.DatabasePopulator;
import presentation.view.*;
import domain.model.*;

public class GUIController {
	private FrontEnd frontEnd;

	public GUIController(FrontEnd frontEnd) {
		this.setFrontEnd(frontEnd);
	}

	public static void main(String[] args) throws IOException{
		FrontEnd frontEnd = null;
		BackEnd backEnd = new BackEnd();
		frontEnd = new FrontEnd(backEnd);

		DatabasePopulator dp = new DatabasePopulator();
		dp.loadDatabase();

		GUIController controller = new GUIController(frontEnd);
		controller.runClient();
	}

	public FrontEnd getFrontEnd() {
		return frontEnd;
	}

	public void setFrontEnd(FrontEnd frontEnd) {
		this.frontEnd = frontEnd;
	}

	public void runClient() {
		getFrontEnd().displayGUI();
	}

}
