package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.application;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.domain.Contact;
import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.persistence.ContactDAO;
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
	
	@Override
	public BaseDAO<Contact> getDAO() {
		return contactDAO;
	}

	@Override
	protected Contact createNewEntity() {
		return new Contact();
	}

}
