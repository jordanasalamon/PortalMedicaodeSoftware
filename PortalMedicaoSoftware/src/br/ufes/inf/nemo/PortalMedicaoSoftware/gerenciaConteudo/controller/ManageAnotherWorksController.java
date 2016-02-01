package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.controller;

import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.Part;

import org.primefaces.context.RequestContext;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.logging.Level;

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
	private static final Logger logger = Logger.getLogger(CrudController.class.getCanonicalName());

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
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
		viewPath = "/manageAnotherWorks/";
		bundleName = "msgs";
	}

	@Override
	protected void initFilters() {
		addFilter(new SimpleFilter("manageSemesters.filter.byName", "name", "by Name"));
		addFilter(new SimpleFilter("manageSemesters.filter.byAuthorship", "isByNemo", "by Authorship"));

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

	@Override
	public String save() {
		try {
			file.write("/uploads/anotherworks/");
		} catch (IOException e) {
			e.printStackTrace();
		}
		super.selectedEntity.setFilepath("/uploads/anotherworks/" + file.getSubmittedFileName());
		manageAnotherWorkService.getDAO().save(super.selectedEntity);

		super.selectedEntity = new AnotherWork();
		return list();
	}

}
