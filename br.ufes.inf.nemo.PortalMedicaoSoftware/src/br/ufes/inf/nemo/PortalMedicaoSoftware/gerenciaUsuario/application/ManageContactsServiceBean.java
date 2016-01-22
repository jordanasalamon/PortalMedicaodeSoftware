package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.application;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.domain.Contact;
import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.domain.User;
import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.persistence.ContactDAO;
import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.persistence.UserDAO;
import br.ufes.inf.nemo.util.ejb3.application.CrudServiceBean;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Stateless
public class ManageContactsServiceBean extends CrudServiceBean<Contact> implements
		ManageContactsService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private ContactDAO contactDAO;
	@EJB
	private UserDAO userDAO;
	
	@Override
	public BaseDAO<Contact> getDAO() {
		return contactDAO;
	}

	@Override
	protected Contact createNewEntity() {
		return new Contact();
	}

	@Override
	public Contact createContact(String messageSubject, String messageText, User sender) {
		try {
			User receiver = userDAO.retrieveAdmin();
			Contact newContact = new Contact();
			newContact.setMessageSubject(messageSubject);
			newContact.setMessageText(messageText);
			newContact.setMessageDate(new Date());
			newContact.setSender(sender);
			newContact.setReceiver(receiver);
			
			return newContact;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
