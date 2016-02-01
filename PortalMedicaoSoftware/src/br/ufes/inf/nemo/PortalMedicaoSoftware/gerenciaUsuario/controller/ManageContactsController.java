package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.controller;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.application.ManageContactsService;
import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.domain.Contact;
import br.ufes.inf.nemo.PortalMedicaoSoftware.util.SendEmail;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;

@Named
@SessionScoped
public class ManageContactsController extends CrudController<Contact> {

	private static final long serialVersionUID = 1L;
	@EJB
	private ManageContactsService manageContactsService;
	
	@Inject
	private ManageUsersController manageUsersController;
	
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
	}
	
	public String manageContact(){
		try{
			Contact contact = new Contact();
			contact = this.manageContactsService.createContact(super.selectedEntity.getMessageSubject(), super.selectedEntity.getMessageText(), manageUsersController.getCurrentUser());
			this.manageContactsService.create(contact);
			this.save();
			manageUsersController.setCurrentAdmin();
			String emailSubject = "Você tem uma nova mensagem em Portal de Medição de Software";
			String emailBody = "Olá," + "\n" + "Você tem uma nova mensagem no sistema Portal de medição de Software." + "\n" + "Para visualizá-la e respondê-la, acesse o sistema.";
			SendEmail.sendMail(manageUsersController.getCurrentAdmin().getEmail(), emailSubject, emailBody);
			if(contact != null){
				return "/home.xhtml?faces-redirect=true";
			}
			return "/manageContacts/form.xhtml?faces-redirect=true";
		} catch (Exception e){
			addGlobalI18nMessage("msgs", FacesMessage.SEVERITY_ERROR, "error.register.summary", "error.register.detail");
            return null;
		}
	}
	
	public String answerContact(){
		return null;
	}

}
