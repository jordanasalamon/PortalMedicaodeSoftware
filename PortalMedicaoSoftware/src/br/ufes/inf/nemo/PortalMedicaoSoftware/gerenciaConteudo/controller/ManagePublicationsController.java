package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.application.ManagePublicationsService;
import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain.Publication;
import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain.PublicationType;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.application.filters.SimpleFilter;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;

@Named
@SessionScoped
public class ManagePublicationsController extends CrudController<Publication> {

	private static final long serialVersionUID = 1L;
	@EJB
	private ManagePublicationsService managePublicationsService;
	private List<PublicationType> publicationsTypes;
	//private Part file;
	
	private String year;
	
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
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
		addFilter(new SimpleFilter("manageSemesters.filter.byYear", "Year", "by Year"));
		addFilter(new SimpleFilter("manageSemesters.filter.byTitle", "Title", "by Title"));
		addFilter(new SimpleFilter("manageSemesters.filter.byAuthorship", "isByNemo", "by Authorship"));
		addFilter(new SimpleFilter("manageSemesters.filter.byType", "Type", "by Type"));


	}
	
	public List<PublicationType> getPublicationsTypes() {
        if (publicationsTypes == null) {
        	publicationsTypes = new ArrayList<>();
        	PublicationType[] equipmentType = PublicationType.values();
        	publicationsTypes.addAll(Arrays.asList(equipmentType));
        }       
        return publicationsTypes;
    }
	
	/*public void uploadAction () throws IOException{
		this.arquivo.fileUpload(file, ".pdf", "/ontologies/");
		super.selectedEntity.setFilepath((this.arquivo.getNome()));
		
        FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
		
		 try (InputStream input = file.getInputStream()) {
		        Files.copy(input, new File("/uploads/publications/", file.getSubmittedFileName()).toPath());
		        FacesMessage message = new FacesMessage("Succesful", file.getSubmittedFileName() + " is uploaded.");
		        FacesContext.getCurrentInstance().addMessage(null, message);
		    }
		    catch (IOException e) {
		        // Show faces message?
		    }
	}*/
	
	
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
		super.selectedEntity.setName(super.selectedEntity.getTitle());
		super.selectedEntity.setDescription(super.selectedEntity.getAbstract());
		
		//super.selectedEntity.setFilepath("/uploads/publications/" + file.getSubmittedFileName());
		managePublicationsService.getDAO().save(super.selectedEntity);
			
		super.selectedEntity = new Publication();
		return list();
	}

}
