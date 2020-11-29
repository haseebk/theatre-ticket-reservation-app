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
	 * @param auth    authorizer
	 */
//		public Login(JFrame frame, BackEnd backend, Authenticator auth) (to be added)

	public LoginPage(JFrame frame, BackEnd backend) {
		setLayout(null);

		// CREATE GUEST CHECKOUT BUTTON
		guestButton = new JLabel("CONTINUE AS GUEST");
		guestButton.setHorizontalAlignment(SwingConstants.CENTER);
		guestButton.setForeground(Color.GRAY);
		guestButton.setFont(new Font("Arial", Font.BOLD, 11));
		guestButton.setBounds(632, 502, 118, 14);
		add(guestButton);

		// CREATE REGISTER BUTTON
		registerButton = new JLabel("CREATE ACCOUNT");
		registerButton.setHorizontalAlignment(SwingConstants.CENTER);
		registerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//					Register registerPanel = new Register(frame, backend, auth);
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
		usernameLabel.setForeground(Color.GRAY);
		usernameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		usernameLabel.setBounds(653, 299, 77, 14);
		add(usernameLabel);

		// CREATE PASSWORD TEXT LABEL
		passwordLabel = new JLabel("Password");
		passwordLabel.setForeground(Color.GRAY);
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
		submitLoginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String user = usernameTextField.getText();
				String pass = String.valueOf(passwordField.getPassword());
				invalidLoginErrorLabel.setVisible(true);
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