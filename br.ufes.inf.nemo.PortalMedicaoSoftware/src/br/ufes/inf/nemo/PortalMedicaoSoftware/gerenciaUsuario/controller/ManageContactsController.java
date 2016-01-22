package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

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
		// TODO Auto-generated method stub
		
	}
	
	@PostConstruct
	public void init() {
	    super.selectedEntity = new Contact();
	}
	
	private void sendEmail(String emailReceiver) throws EmailException{
		SimpleEmail email = new SimpleEmail();  
        email.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e-mail  
        email.addTo(emailReceiver, "Admin"); //destinatário  
        email.setFrom("noreply.portalMedicaoSoftware@gmail.com", "Portal de Medição de Software"); // remetente  
        email.setSubject("Você tem uma nova mensagem em Portal de Medição de Software"); // assunto do e-mail  
        email.setMsg("Olá," + "\n" + "Você tem uma nova mensagem no sistema Portal de medição de Software." + "\n" + "Para visualizá-la e respondê-la, acesse o sistema."); //conteudo do e-mail  
        email.setSmtpPort(465); 
        email.send();     
	}
	
	public String manageContact(){
		try{
			Contact contact = new Contact();
			contact = this.manageContactsService.createContact(super.selectedEntity.getMessageSubject(), super.selectedEntity.getMessageText(), manageUsersController.getCurrentUser());
			this.manageContactsService.create(contact);
			this.save();
			manageUsersController.setCurrentAdmin();
			sendEmail(manageUsersController.getCurrentAdmin().getEmail());
			if(contact != null){
				return "/home.faces";
			}
			return "/manageContacts/form.faces";
		} catch (Exception e){
			addGlobalI18nMessage("msgs", FacesMessage.SEVERITY_ERROR, "error.register.summary", "error.register.detail");
            return null;
		}
	}
	
}
