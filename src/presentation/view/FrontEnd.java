package presentation.view;

import java.awt.event.MouseListener;
import javax.swing.JFrame;
import domain.model.BackEnd;
import presentation.view.LoginPage;

public class FrontEnd extends JFrame {
	private JFrame MainFrame;
	private LoginPage loginPanel;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FrontEnd(BackEnd backend) {
		loginPanel = new LoginPage(getMainFrame(), backend);

	}

	public void addSubmitLoginMouseClicked(MouseListener e) {
		loginPanel.submitLoginButton.addMouseListener(e);
	}

	public JFrame getMainFrame() {
		return MainFrame;
	}

	public void setMainFrame(JFrame mainFrame) {
		MainFrame = mainFrame;
	}

}
