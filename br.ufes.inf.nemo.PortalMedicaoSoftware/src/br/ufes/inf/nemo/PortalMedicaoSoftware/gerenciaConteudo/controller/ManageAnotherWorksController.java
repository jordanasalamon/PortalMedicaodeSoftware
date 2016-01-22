package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.Part;


import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.application.ManageAnotherWorksService;
import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain.AnotherWork;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.application.filters.SimpleFilter;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;
@Named
@SessionScoped
public class ManageAnotherWorksController extends CrudController<AnotherWork> {

	private static final long serialVersionUID = 1L;
	@EJB
	private ManageAnotherWorksService manageAnotherWorkService;
	private Part file;

	private boolean nemo;
	private boolean outro;
	
	public boolean isNemo() {
		return nemo;
	}

	public void setNemo(boolean nemo) {
		this.nemo = nemo;
	}

	public boolean isOutro() {
		return outro;
	}

	public void setOutro(boolean outro) {
		this.outro = outro;
	}

	
	@Override
	protected CrudService<AnotherWork> getCrudService() {
		return manageAnotherWorkService;
	}

	@Override
	protected AnotherWork createNewEntity() {
		return new AnotherWork();
	}

	public ManageAnotherWorksController() {
	    viewPath = "/manageAnotherWork/";
	    bundleName = "msgs";
	}

	@Override
	protected void initFilters() {
		// TODO Auto-generated method stub
		addFilter(new SimpleFilter("manageSemesters.filter.byName", "name", "by Name"));

	}
	
	public void uploadAction () throws IOException{
		/*this.arquivo.fileUpload(file, ".pdf", "/ontologies/");
		super.selectedEntity.setFilepath((this.arquivo.getNome()));
		
        FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);*/
		
		 try (InputStream input = file.getInputStream()) {
		        Files.copy(input, new File("/uploads/anotherworks/", file.getSubmittedFileName()).toPath());
		        FacesMessage message = new FacesMessage("Succesful", file.getSubmittedFileName() + " is uploaded.");
		        FacesContext.getCurrentInstance().addMessage(null, message);
		    }
		    catch (IOException e) {
		        // Show faces message?
		    }
	}
	
	@Override
	public String save(){
		if(nemo){
			super.selectedEntity.setIsByNemo(nemo);
		}
		else if(outro){
			super.selectedEntity.setIsByNemo(outro);
		}
		super.selectedEntity.setFilepath("/uploads/anotherworks/" + file.getSubmittedFileName());
		manageAnotherWorkService.getDAO().save(super.selectedEntity);
			
		super.selectedEntity = new AnotherWork();
		return "/manageWorks/listAdmin.xhtml?faces-redirect=true";
	}
	
}
