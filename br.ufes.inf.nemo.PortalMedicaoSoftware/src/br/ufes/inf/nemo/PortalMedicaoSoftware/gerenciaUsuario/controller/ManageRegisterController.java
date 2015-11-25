package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.controller;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.application.ManageRegisterService;
import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.domain.User;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;

@Named
@SessionScoped
public class ManageRegisterController extends CrudController<User> {

	private static final long serialVersionUID = 1L;
	@EJB
	private ManageRegisterService manageRegisterService;

	private String name;
	private String email;
	private String username;
	private String password;
	
	private User newUser;

	@Override
	protected CrudService<User> getCrudService() {
		return manageRegisterService;
	}

	@Override
	protected User createNewEntity() {
		return new User();
	}

	public ManageRegisterController() {
		bundleName = "msgs";
	}

	@Override
	protected void initFilters() {
		// TODO Auto-generated method stub

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getNewUser() {
		return newUser;
	}

	public void setNewUser(User newUser) {
		this.newUser = newUser;
	}

	public String register(){
		try{
			this.newUser = this.manageRegisterService.register(name, email, username, password);
			this.manageRegisterService.create(newUser);
			this.save();
			if(this.newUser != null){
				return "/index.faces";
			}
			return "/manageRegister/form.faces";
		} catch (Exception e){
			addGlobalI18nMessage("msgs", FacesMessage.SEVERITY_ERROR, "error.register.summary", "error.register.detail");
            return null;
		}
	}
}
