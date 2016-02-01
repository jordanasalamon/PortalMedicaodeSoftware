package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.controller;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.application.ManageOntologiesService;
import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain.Ontology;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.application.filters.SimpleFilter;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;

@Named
@SessionScoped
public class ManageOntologiesController extends CrudController<Ontology> {

	private static final long serialVersionUID = 1L;
	@EJB
	private ManageOntologiesService manageOntologiesService;
	/*private Part file;

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}*/
	
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
		addFilter(new SimpleFilter("manageSemesters.filter.byName", "name", "by Name"));

	}
	
	/*	
	public void uploadAction () throws IOException {
		this.arquivo.fileUpload(file, ".pdf", "/ontologies/");
		super.selectedEntity.setFilepath((this.arquivo.getNome()));
		
        FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
		
		 try (InputStream input = file.getInputStream()) {
		        Files.copy(input, new File("/uploads/ontologies/", file.getSubmittedFileName()).toPath());
		        FacesMessage message = new FacesMessage("Succesful", file.getSubmittedFileName() + " is uploaded.");
		        FacesContext.getCurrentInstance().addMessage(null, message);
		    }
		    catch (IOException e) {
		        // Show faces message?
		    }
	}*/
	
	@Override
	public String save(){
		//super.selectedEntity.setFilepath("/uploads/ontologies/" + file.getSubmittedFileName());
		manageOntologiesService.getDAO().save(super.selectedEntity);
			
		super.selectedEntity = new Ontology();
		return list();
	}

}
