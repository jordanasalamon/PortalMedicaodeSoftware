package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.domain;

import java.util.Date;

import javax.persistence.Entity;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport;

@Entity
public class Contact extends PersistentObjectSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String TitleMessage;
	private Date DateMessage;
	private String TextMessage;
	private boolean Answered;
	private Date DateAnswer;
	private String AnsweredMessage;
	private User Sender;
	private User Receiver;
	
	public String getTitleMessage() {
		return TitleMessage;
	}
	public void setTitleMessage(String titleMessage) {
		TitleMessage = titleMessage;
	}
	public Date getDateMessage() {
		return DateMessage;
	}
	public void setDateMessage(Date dateMessage) {
		DateMessage = dateMessage;
	}
	public String getTextMessage() {
		return TextMessage;
	}
	public void setTextMessage(String textMessage) {
		TextMessage = textMessage;
	}
	public boolean isAnswered() {
		return Answered;
	}
	public void setAnswered(boolean answered) {
		Answered = answered;
	}
	public Date getDateAnswer() {
		return DateAnswer;
	}
	public void setDateAnswer(Date dateAnswer) {
		DateAnswer = dateAnswer;
	}
	public String getAnsweredMessage() {
		return AnsweredMessage;
	}
	public void setAnsweredMessage(String answeredMessage) {
		AnsweredMessage = answeredMessage;
	}
	public User getSender() {
		return Sender;
	}
	public void setSender(User sender) {
		Sender = sender;
	}
	public User getReceiver() {
		return Receiver;
	}
	public void setReceiver(User receiver) {
		Receiver = receiver;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
