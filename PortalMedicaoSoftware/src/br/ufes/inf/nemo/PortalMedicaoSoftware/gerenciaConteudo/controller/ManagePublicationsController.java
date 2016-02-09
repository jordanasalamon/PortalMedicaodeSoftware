package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.Part;

import org.primefaces.context.RequestContext;

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
	
	private Part file;
	
	private static final Logger logger = Logger.getLogger(CrudController.class.getCanonicalName());

	
	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
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
		saveAuthors(this.authors);
		//super.selectedEntity.setFilepath("/uploads/publications/" + file.getSubmittedFileName());
		managePublicationsService.getDAO().save(super.selectedEntity);
			
		super.selectedEntity = new Publication();
		return list();
	}
	
	private void saveAuthors(String authors) {
		String[] splitedString = authors.split(",");
		for(int i = 0; i < splitedString.length; i++){
			Author a = new Author();
			a.setName(splitedString[i]);
			this.manageAuthorsService.getDAO().save(a);
		}
		
	}

	private byte[] arquivoByte;

	public void importFile() throws Exception {
		try {
			RequestContext.getCurrentInstance().execute("PF('dialogCarregaPaper').show();");
			arquivoByte = fileToByte(file.getInputStream());
			ByteBuffer arquivoBuffer = ByteBuffer.wrap(arquivoByte);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static byte[] fileToByte(InputStream inputFile) {
		byte[] arquivo = null;
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] buffer = new byte[34394702];
			int bytesRead = 0;
			while ((bytesRead = inputFile.read(buffer, 0, 34394702)) != -1) {
				baos.write(buffer, 0, bytesRead);
			}
			arquivo = baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return arquivo;
	}
	
	public void upload() {
		logger.info("call upload...");
		logger.log(Level.INFO, "content-type:{0}", file.getContentType());
		logger.log(Level.INFO, "filename:{0}", file.getName());
		logger.log(Level.INFO, "submitted filename:{0}", file.getSubmittedFileName());
		logger.log(Level.INFO, "size:{0}", file.getSize());
		try {

			byte[] results = new byte[(int) file.getSize()];
			InputStream in = file.getInputStream();
			in.read(results);
		} catch (IOException ex) {
			logger.log(Level.SEVERE, " ex @{0}", ex);
		}

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Uploaded!"));
	}

}
