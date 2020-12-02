package presentation.view;

import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
		setMainFrame(new JFrame());
		loginPanel = new LoginPage(getMainFrame(), backend);
		getMainFrame().setTitle("Ticket Reservation System");
		getMainFrame().setResizable(false);
		getMainFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getMainFrame().addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.out.println("Closing application");
            }
        });
		getMainFrame().setSize(1366, 768);
		getMainFrame().setContentPane(loginPanel);
		getMainFrame().revalidate();
		getMainFrame().setLocationRelativeTo(null);
		getMainFrame().setLayout(null);
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

	public void displayGUI() {
		getMainFrame().setVisible(true);
	}

}
