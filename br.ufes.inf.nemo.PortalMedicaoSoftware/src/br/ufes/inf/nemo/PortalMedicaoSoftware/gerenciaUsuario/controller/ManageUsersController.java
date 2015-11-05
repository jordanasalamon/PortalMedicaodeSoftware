package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.controller;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.application.ManageUsersService;
import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.domain.User;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;
@Named
@SessionScoped
public class ManageUsersController extends CrudController<User> {

	private static final long serialVersionUID = 1L;
	@EJB
	private ManageUsersService manageUsersService;
	
	@Override
	protected CrudService<User> getCrudService() {
		return manageUsersService;
	}

	@Override
	protected User createNewEntity() {
		return new User();
	}

	public ManageUsersController() {
	    viewPath = "/manageUsers/";
	    bundleName = "msgs";
	}

	@Override
	protected void initFilters() {
		// TODO Auto-generated method stub
		
	}
}
