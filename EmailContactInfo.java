package contacts;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Owner
 */
public class EmailContactInfo {

    /**
     * this method logs onto a gmail account that is specified with the email and password
     * then checks to make sure it can actually log in using the authenticator
     * then creates the message that you would like to send based off of parameters that are defined in the emailcontact class
     * @param reciever - where the email is being sent to
     * @param number - the number of the contact you selected
     * @param name - the name of the contact you selected
     */
    public static void sendEmail(String reciever, String number, String name) {
		Properties p = new Properties();

		p.put("mail.smtp.auth","true");
		p.put("mail.smtp.starttls.enable","true");
		p.put("mail.smtp.host","smtp.gmail.com");
		p.put("mail.smtp.port","587");

		String myEmail = "CSCI495testemail@gmail.com";
		String pass = "T3stpassword";

		Authenticator a = new Authenticator() {
			@SuppressWarnings("unused")
			protected PasswordAuthentication getPassworsAuthentication() {
				return new PasswordAuthentication(myEmail,pass);
			}
		};
		Session s = Session.getDefaultInstance(p, a);
		try {
			MimeMessage m = new MimeMessage(s);
			m.setFrom(new InternetAddress(myEmail));
			m.addRecipient(Message.RecipientType.TO,new InternetAddress(reciever));
			m.setSubject("Contact List");
			m.setText("You requested "+name+ "'s number: "+number);
			Transport.send(m);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
