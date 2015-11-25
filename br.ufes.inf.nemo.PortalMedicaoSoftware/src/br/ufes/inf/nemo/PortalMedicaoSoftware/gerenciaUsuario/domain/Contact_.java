package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.domain;

import java.util.Date;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport_;

import javax.persistence.metamodel.*;

@StaticMetamodel(Contact.class)
public class Contact_ extends PersistentObjectSupport_ {

	public static volatile SingularAttribute<Contact, String> messageSubject;
	public static volatile SingularAttribute<Contact, Date> messageDate;
	public static volatile SingularAttribute<Contact, String> messageText;
	public static volatile SingularAttribute<Contact, Boolean> isAnswered;
	public static volatile SingularAttribute<Contact, Date> answerDate;
	public static volatile SingularAttribute<Contact, String> answerMessage;
	public static volatile SingularAttribute<Contact, User> sender;
	public static volatile SingularAttribute<Contact, User> receiver;

}
