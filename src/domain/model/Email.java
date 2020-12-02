package domain.model;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import database.DataController;

public class Email {
	public void sendEmail(BackEnd backend, String email) {
		// Put recipient’s address
		String to = backend.getCurrentRegisteredUser().getEmail();

		// Put sender’s address
		String from = "theatreapp-1ad633@inbox.mailtrap.io";
		final String username = "7f485fdfd984fe";
		final String password = "6be69ebed624ae";
		String host = "smtp.mailtrap.io";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "2525");

		// Get the Session object.
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field
			message.setFrom(new InternetAddress(from));

			// Set To: header field
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

			// Set Subject: header field
			message.setSubject("VHEW Booking Confirmation");

			String emailBody = "Thank you for shopping with VHEW! \n" + "Please find the receipt of your purchase below:" + email;
			
			// Put the content of your message
			message.setText(emailBody);

			// Send message
			Transport.send(message);

			System.out.println("Sent message successfully");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
