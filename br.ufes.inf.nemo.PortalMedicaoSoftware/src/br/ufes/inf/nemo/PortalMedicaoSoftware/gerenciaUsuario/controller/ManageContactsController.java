package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.controller;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.application.ManageContactsService;
import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.domain.Contact;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;
@Named
@SessionScoped
public class ManageContactsController extends CrudController<Contact> {

	private static final long serialVersionUID = 1L;
	@EJB
	private ManageContactsService manageContactsService;
	
	@Override
	protected CrudService<Contact> getCrudService() {
		return manageContactsService;
	}

	@Override
	protected Contact createNewEntity() {
		return new Contact();
	}

	public ManageContactsController() {
	    viewPath = "/manageContacts/";
	    bundleName = "msgs";
	}

	@Override
	protected void initFilters() {
		// TODO Auto-generated method stub
		
	}
}
