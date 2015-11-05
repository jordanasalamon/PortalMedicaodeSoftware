package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.domain;

import java.util.Date;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport_;

import javax.persistence.metamodel.*;

@StaticMetamodel(Contact.class)
public class Contact_ extends PersistentObjectSupport_ {

	public static volatile SingularAttribute<Contact, String> TitleMessage;
	public static volatile SingularAttribute<Contact, Date> DateMessage;
	public static volatile SingularAttribute<Contact, String> TextMessage;
	public static volatile SingularAttribute<Contact, Boolean> Answered;
	public static volatile SingularAttribute<Contact, Date> DateAnswer;
	public static volatile SingularAttribute<Contact, String> AnsweredMessage;
	public static volatile SingularAttribute<Contact, User> Sender;
	public static volatile SingularAttribute<Contact, User> Receiver;

}
