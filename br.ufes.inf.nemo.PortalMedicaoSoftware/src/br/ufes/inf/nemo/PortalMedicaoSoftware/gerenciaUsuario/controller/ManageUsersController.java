package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.controller;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
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

	private User currentUser;
	private String currentUserLogin;
	private String currentUserPassword;

	@Override
	protected CrudService<User> getCrudService() {
		return manageUsersService;
	}

	@Override
	protected User createNewEntity() {
		return new User();
	}

	public ManageUsersController() {
		bundleName = "msgs";
	}

	@Override
	protected void initFilters() {
		// TODO Auto-generated method stub

	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public String getCurrentUserLogin() {
		return currentUserLogin;
	}

	public void setCurrentUserLogin(String currentUserLogin) {
		this.currentUserLogin = currentUserLogin;
	}

	public String getCurrentUserPassword() {
		return currentUserPassword;
	}

	public void setCurrentUserPassword(String currentUserPassword) {
		this.currentUserPassword = currentUserPassword;
	}

	public boolean isLoggedIn() {
		return currentUser != null;
	}

	public boolean isAdmin() {
		return currentUser.getIsAdmin() == true;
	}
	
	public boolean isUser(){
		return currentUser.getIsAdmin() == false;
	}

	public String getLoginName() {
		return getI18nMessage("msgs", "navbar.welcome") + " "
				+ currentUser.getUsername();
	}
	
	public boolean beforeLogin(){
		this.currentUser = null;
		return true;
	}
	
	public String login(){
		try {
			this.currentUser = this.manageUsersService.login(currentUserLogin, currentUserPassword);
			if(this.currentUser != null){
				return "/home.faces";
			}
		} catch (Exception e) {
			addGlobalI18nMessage("msgs", FacesMessage.SEVERITY_ERROR, "error.login.summary", "error.login.detail");
            return null;
		}
		return "/index.faces";
	}
	
	public String logout() {
		this.currentUserLogin = "";
		this.currentUserPassword = "";
		currentUser = null;
		return "/index.faces";
	}
	
}
