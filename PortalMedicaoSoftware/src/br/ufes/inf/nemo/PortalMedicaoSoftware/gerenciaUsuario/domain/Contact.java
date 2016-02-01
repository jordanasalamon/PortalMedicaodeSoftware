package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport;

@Entity
public class Contact extends PersistentObjectSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String messageSubject;
	private Date messageDate;
	private String messageText;
	private boolean isAnswered;
	private Date answerDate;
	private String answerMessage;
	@Column(columnDefinition = "LONGBLOB")
	private User sender;
	@Column(columnDefinition = "LONGBLOB")
	private User receiver;
	
	public String getMessageSubject() {
		return messageSubject;
	}
	public void setMessageSubject(String messageSubject) {
		this.messageSubject = messageSubject;
	}
	public Date getMessageDate() {
		return messageDate;
	}
	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
	}
	public String getMessageText() {
		return messageText;
	}
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	public boolean isAnswered() {
		return isAnswered;
	}
	public void setAnswered(boolean isAnswered) {
		this.isAnswered = isAnswered;
	}
	public Date getAnswerDate() {
		return answerDate;
	}
	public void setAnswerDate(Date answerDate) {
		this.answerDate = answerDate;
	}
	public String getAnswerMessage() {
		return answerMessage;
	}
	public void setAnswerMessage(String answerMessage) {
		this.answerMessage = answerMessage;
	}
	public User getSender() {
		return sender;
	}
	public void setSender(User sender) {
		this.sender = sender;
	}
	public User getReceiver() {
		return receiver;
	}
	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}
	
}
