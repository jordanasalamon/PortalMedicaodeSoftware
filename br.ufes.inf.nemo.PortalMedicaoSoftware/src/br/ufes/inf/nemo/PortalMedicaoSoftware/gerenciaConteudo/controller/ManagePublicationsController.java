package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.Part;


import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.application.ManagePublicationsService;
import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain.Publication;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.application.filters.SimpleFilter;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;
import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain.PublicationType;
@Named
@SessionScoped
public class ManagePublicationsController extends CrudController<Publication> {

	private static final long serialVersionUID = 1L;
	@EJB
	private ManagePublicationsService managePublicationsService;
	private List<PublicationType> publicationsTypes;
	private Part file;
	
	private String year;
	private boolean nemo;
	private boolean outro;
	
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

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
	protected CrudService<Publication> getCrudService() {
		return managePublicationsService;
	}

	@Override
	protected Publication createNewEntity() {
		return new Publication();
	}

	public ManagePublicationsController() {
	    viewPath = "/managePublications/";
	    bundleName = "msgs";
	}

	@Override
	protected void initFilters() {
		// TODO Auto-generated method stub
		addFilter(new SimpleFilter("manageSemesters.filter.byYear", "year", "by Year"));

	}

	
	public List<PublicationType> getPublicationsTypes() {
        if (publicationsTypes == null) {
        	publicationsTypes = new ArrayList<>();
        	PublicationType[] equipmentType = PublicationType.values();
        	publicationsTypes.addAll(Arrays.asList(equipmentType));
        }       
        return publicationsTypes;
    }

	@PostConstruct
	public void init() {
	    super.selectedEntity = new Publication();
	}
	
	public void uploadAction () throws IOException{
		/*this.arquivo.fileUpload(file, ".pdf", "/ontologies/");
		super.selectedEntity.setFilepath((this.arquivo.getNome()));
		
        FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);*/
		
		 try (InputStream input = file.getInputStream()) {
		        Files.copy(input, new File("/uploads/publications/", file.getSubmittedFileName()).toPath());
		        FacesMessage message = new FacesMessage("Succesful", file.getSubmittedFileName() + " is uploaded.");
		        FacesContext.getCurrentInstance().addMessage(null, message);
		    }
		    catch (IOException e) {
		        // Show faces message?
		    }
	}
	
	
	@Override
	public String save(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy");
		Date data = null;
		try {
			data = new Date(format.parse(year).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		super.selectedEntity.setYear(data);
		if(nemo){
			super.selectedEntity.setIsByNemo(nemo);
		}
		else if(outro){
			super.selectedEntity.setIsByNemo(outro);
		}
		super.selectedEntity.setFilepath("/uploads/publications/" + file.getSubmittedFileName());
		managePublicationsService.getDAO().save(super.selectedEntity);
			
		super.selectedEntity = new Publication();
		return "/managePublications/listAdmin.faces?faces-redirect=true";
	}
}
