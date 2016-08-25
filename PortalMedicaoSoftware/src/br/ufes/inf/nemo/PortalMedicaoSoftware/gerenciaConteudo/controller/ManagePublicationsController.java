package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.application.ManageAuthorsService;
import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.application.ManagePublicationsService;
import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain.Author;
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
	@EJB
	private ManageAuthorsService manageAuthorsService;
	private List<PublicationType> publicationsTypes;
	private String authors;
	private String year;
	
	private UploadedFile file;
	private String destination;
	
	private DefaultStreamedContent fileDownload;

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public StreamedContent getFileDownload() {
		return fileDownload;
	}

	public void setFileDownload(DefaultStreamedContent fileDownload) {
		this.fileDownload = fileDownload;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}
	
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
		addFilter(new SimpleFilter("managePublications.filter.byYear", "Year", getI18nMessage("msgs", "managePublications.text.filter.byYear")));
		addFilter(new SimpleFilter("managePublications.filter.byTitle", "Title", getI18nMessage("msgs", "managePublications.text.filter.byTitle")));
		addFilter(new SimpleFilter("managePublications.filter.byAuthorship", "isByNemo", getI18nMessage("msgs", "managePublications.text.filter.byAuthorship")));
		addFilter(new SimpleFilter("managePublications.filter.byType", "Type", getI18nMessage("msgs", "managePublications.text.filter.byType")));


	}
	
	public List<PublicationType> getPublicationsTypes() {
        if (publicationsTypes == null) {
        	publicationsTypes = new ArrayList<>();
        	PublicationType[] equipmentType = PublicationType.values();
        	publicationsTypes.addAll(Arrays.asList(equipmentType));
        }       
        return publicationsTypes;
    }
	
	
	private void saveAuthors(String authors) {
		Set<Author> selected = new HashSet<Author>();
		String[] splitedString = authors.split(",");
		for(int i = 0; i < splitedString.length; i++){
			Author a = new Author();
			a.setName(splitedString[i]);
			selected.add(a);
		}
		this.selectedEntity.setAuthors(selected);
		
	}
	
	public void copyFile(String fileName, InputStream in) {
		try {
			destination = System.getProperty("user.home")+ "/portalMedicao/upload/publications/";

			if(System.getProperty("os.name").contains("Windows")){
				destination = destination.replaceAll("/", "\\\\");
			}			
			// write the inputStream to a FileOutputStream
			File diretorio = new File(destination);
            if (!diretorio.exists()){
                diretorio.mkdirs();
            }
			OutputStream out = new FileOutputStream(new File(destination + fileName));

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = in.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}

			in.close();
			out.flush();
			out.close();

			System.out.println("New file created!");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void download(String namePublicationSelected) {
		Publication publicationSelected = this.managePublicationsService.retrieveByName(namePublicationSelected);
		String filepath = publicationSelected.getFilepath();
		File file = new File(filepath);
		FileInputStream input = null;
		try {
			input = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		setFileDownload(new DefaultStreamedContent(input, externalContext.getMimeType(file.getName()), file.getName()));
		
	}

	@Override
	public String save(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy");
		Date data = null;
		try {
			data = new Date(format.parse(year).getTime());
			if (file != null && !file.getFileName().equals("")) {
				FacesMessage msg = new FacesMessage("Succesful" + file.getFileName() + " is uploaded.");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				copyFile(file.getFileName(), file.getInputstream());
			}
		} catch (ParseException | IOException e) {
			e.printStackTrace();
		}
		super.selectedEntity.setYear(data);
		super.selectedEntity.setName(super.selectedEntity.getTitle());
		super.selectedEntity.setDescription(super.selectedEntity.getAbstract());
		saveAuthors(this.authors);
		super.selectedEntity.setFilepath(destination + file.getFileName());
		managePublicationsService.getDAO().save(super.selectedEntity);
			
		super.selectedEntity = new Publication();
		return list();
	}
}
