package br.ufes.inf.nemo.PortalMedicaoSoftware.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail implements Runnable {

	private String assunto;
	private String corpo;
	private String destinatario;

	public SendEmail(String a, String c, String d) {
		assunto = a;
		corpo = c;
		destinatario = d;
	}

	@Override
	public void run() {
		try {
			if (destinatario != null) {
				Properties props = System.getProperties();
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.user", "noreply.portalmedicaosoftware@gmail.com");
			    props.put("mail.smtp.port", "465");
			    props.put("mail.smtp.starttls.enable","true");
			    props.put("mail.smtp.debug", "true");
			    props.put("mail.smtp.auth", "true");
			    props.put("mail.smtp.socketFactory.port", "465");
			    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			    props.put("mail.smtp.socketFactory.fallback", "false");
			    
				Authenticator auth = new Authenticator() {
					public PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("noreply.portalmedicaosoftware@gmail.com", "portalmedicao123");
					}
				};

				Session session = Session.getInstance(props, auth);
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress("noreply.portalmedicaosoftware@gmail.com"));

				message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));

				message.setSubject(assunto);
				message.setContent(corpo, "text/plain");

				
				Transport transport = session.getTransport("smtps");
	            transport.connect("smtp.gmail.com", Integer.valueOf("465"), "Portal de Medição de Software", "portalmedicao123");
	            transport.sendMessage(message, message.getAllRecipients());
	            transport.close();	            
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sendMail(String destinatario, String assunto, String corpo) {

	Runnable runnable = new SendEmail(assunto, corpo, destinatario);
	Thread thread = new Thread(runnable);
	thread.start();
	}
}