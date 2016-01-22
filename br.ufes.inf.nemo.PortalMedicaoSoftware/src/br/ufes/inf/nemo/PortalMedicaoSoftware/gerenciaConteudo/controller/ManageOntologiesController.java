package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.Part;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.application.ManageOntologiesService;
import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain.Ontology;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.application.filters.SimpleFilter;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;

@Named
@SessionScoped
@ManagedBean
public class ManageOntologiesController extends CrudController<Ontology> {

	private static final long serialVersionUID = 1L;
	@EJB
	private ManageOntologiesService manageOntologiesService;
	private Part file;

	
	@Override
	protected CrudService<Ontology> getCrudService() {
		return manageOntologiesService;
	}

	@Override
	protected Ontology createNewEntity() {
		return new Ontology();
	}

	public ManageOntologiesController() {
	    viewPath = "/manageOntologies/";
	    bundleName = "msgs";
	}

	@Override
	protected void initFilters() {
		// TODO Auto-generated method stub
		addFilter(new SimpleFilter("manageSemesters.filter.byName", "name", "by Name"));

	}
	
		
	public void uploadAction () throws IOException {
		/*this.arquivo.fileUpload(file, ".pdf", "/ontologies/");
		super.selectedEntity.setFilepath((this.arquivo.getNome()));
		
        FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);*/
		
		 try (InputStream input = file.getInputStream()) {
		        Files.copy(input, new File("/uploads/ontologies/", file.getSubmittedFileName()).toPath());
		        FacesMessage message = new FacesMessage("Succesful", file.getSubmittedFileName() + " is uploaded.");
		        FacesContext.getCurrentInstance().addMessage(null, message);
		    }
		    catch (IOException e) {
		        // Show faces message?
		    }
	}
	
	@Override
	public String save(){
		//super.selectedEntity.setFilepath("/uploads/ontologies/" + file.getSubmittedFileName());
		manageOntologiesService.getDAO().save(super.selectedEntity);
			
		super.selectedEntity = new Ontology();
		return "/manageOntologies/list.xhtml?faces-redirect=true";
	}

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}


}
