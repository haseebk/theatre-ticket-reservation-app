package presentation.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.border.MatteBorder;

import domain.model.BackEnd;
import domain.model.User;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.SwingConstants;

/**
 * This class runs the Login panel view. It creates user name and password
 * fields for user input, which is then verified with database to confirm login.
 * 
 * @author Haseeb Khan
 *
 */
public class LoginPage extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Title Text Field
	 */
	private JLabel titleLabel;
	/**
	 * User name text field for user login input
	 */
	private JTextField usernameTextField;
	/**
	 * Password text field for user login input
	 */
	private JPasswordField passwordField;
	/**
	 * Display text label "Password"
	 */
	private JLabel passwordLabel;
	/**
	 * Display text label "Username"
	 */
	private JLabel usernameLabel;
	JLabel submitLoginButton;
	private JLabel registerButton;
	private JLabel guestButton;

	/**
	 * Create the panel.
	 * 
	 * @param frame   frame that the panel is being placed onto
	 * @param backend backend to obtain information and apply logic
	 */
	public LoginPage(JFrame frame, BackEnd backend) {
		setLayout(null);

		// CREATE TITLE TEXT LABEL
		titleLabel = new JLabel("MOVIE REGISTRATION APP");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		titleLabel.setBounds(515, 200, 350, 30);
		add(titleLabel);

		// CREATE GUEST LOGIN BUTTON
		guestButton = new JLabel("CONTINUE AS GUEST");
		guestButton.setHorizontalAlignment(SwingConstants.CENTER);
		guestButton.setForeground(Color.GRAY);
		guestButton.setFont(new Font("Arial", Font.BOLD, 11));
		guestButton.setBounds(632, 502, 118, 14);
		guestButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		/**
		 * When guest button is pressed, set user status to Guest and switch view to
		 * home page.
		 */
		guestButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				backend.guestUser();
				HomePage homePanel = new HomePage(frame, backend);
				frame.setContentPane(homePanel);
				frame.revalidate();
			}
		});
		add(guestButton);

		// CREATE REGISTER BUTTON
		registerButton = new JLabel("CREATE ACCOUNT");
		registerButton.setHorizontalAlignment(SwingConstants.CENTER);
		/**
		 * When register button is pressed, switch view to register page
		 */
		registerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegisterPage registerPanel = new RegisterPage(frame, backend);
				frame.setContentPane(registerPanel);
				frame.revalidate();
			}
		});
		registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		registerButton.setForeground(Color.GRAY);
		registerButton.setFont(new Font("Arial", Font.BOLD, 11));
		registerButton.setBounds(638, 524, 106, 14);
		add(registerButton);

		// CREATE USERNAME TEXT FIELD
		usernameTextField = new JTextField();
		usernameTextField.setToolTipText("Enter your username.");
		usernameTextField.setFont(new Font("Arial", Font.PLAIN, 13));
		usernameTextField.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.LIGHT_GRAY));
		usernameTextField.setForeground(Color.DARK_GRAY);
		usernameTextField.setBackground(Color.WHITE);
		usernameTextField.setBounds(564, 314, 254, 28);
		usernameTextField.setOpaque(true);
		usernameTextField.setColumns(10);
		usernameTextField.setOpaque(true);
		add(usernameTextField);

		// CREATE PASSWORD TEXT FIELD
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Enter your password.");
		passwordField.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.LIGHT_GRAY));
		passwordField.setForeground(Color.BLACK);
		passwordField.setBounds(564, 387, 254, 28);
		add(passwordField);

		// CREATE USERNAME TEXT LABEL
		usernameLabel = new JLabel("Username");
		usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usernameLabel.setForeground(Color.WHITE);
		usernameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		usernameLabel.setBounds(653, 299, 77, 14);
		add(usernameLabel);

		// CREATE PASSWORD TEXT LABEL
		passwordLabel = new JLabel("Password");
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		passwordLabel.setBounds(653, 372, 77, 14);
		add(passwordLabel);

		// CREATE ERROR TEXT LABEL
		JLabel invalidLoginErrorLabel = new JLabel("<html>"
				+ "Entered login credentials do not match \r\na registered account in our system. (not yet implemented)"
				+ "</html>");
		invalidLoginErrorLabel.setHorizontalAlignment(SwingConstants.LEFT);
		invalidLoginErrorLabel.setForeground(Color.RED);
		invalidLoginErrorLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		invalidLoginErrorLabel.setBounds(564, 235, 254, 45);
		invalidLoginErrorLabel.setVisible(false);
		add(invalidLoginErrorLabel);

		// CREATE SUBMIT LOGIN BUTTON
		submitLoginButton = new JLabel("");
		submitLoginButton.setToolTipText("Login");
		submitLoginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		/**
		 * When submit login button is pressed, pull all text field inputs and verify
		 * login details. If matching credentials are found, log the user in and change
		 * the view to home page. Otherwise, display error message appropriately.
		 */
		submitLoginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String user = usernameTextField.getText().toLowerCase();
				String pass = String.valueOf(passwordField.getPassword());
				if (backend.verifyLogin(user, pass) != null) {
					HomePage homePanel = new HomePage(frame, backend);
					frame.setContentPane(homePanel);
				} else {
					invalidLoginErrorLabel.setVisible(true);
				}
				frame.revalidate();
			}
		});
		submitLoginButton.setBounds(564, 442, 254, 50);
		submitLoginButton.setIcon(new ImageIcon(LoginPage.class.getResource("/enterButton.png")));
		add(submitLoginButton);

		// CREATE BACKGROUND VIEW
		JLabel loginBackground = new JLabel("");
		loginBackground.setBounds(-2, -1, 1366, 768);
		loginBackground.setIcon(new ImageIcon(LoginPage.class.getResource("/backgroundA.png")));
		add(loginBackground);
	}
}
