package presentation.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

<<<<<<< HEAD

=======
import database.DatabasePopulator;
>>>>>>> 894e77af10f4a039a72e9a3bf4b3d8bff9f91556
import presentation.view.*;
import domain.model.*;


public class GUIController {
	private FrontEnd frontEnd;
	
	public GUIController(FrontEnd frontEnd) {
		this.setFrontEnd(frontEnd);
	}
	
	public static void main(String[] args){
		FrontEnd frontEnd = null;
		BackEnd backEnd = new BackEnd();
		frontEnd = new FrontEnd(backEnd);
<<<<<<< HEAD
		
		
=======

		DatabasePopulator dp = new DatabasePopulator();
		dp.loadDatabase();

>>>>>>> 894e77af10f4a039a72e9a3bf4b3d8bff9f91556
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

