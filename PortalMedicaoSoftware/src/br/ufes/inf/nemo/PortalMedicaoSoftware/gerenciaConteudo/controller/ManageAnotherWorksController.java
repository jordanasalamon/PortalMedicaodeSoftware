package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

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
		addFilter(new SimpleFilter("manageAnotherWorks.filter.byName", "name", "by Name"));
		addFilter(new SimpleFilter("manageAnotherWorks.filter.byAuthorship", "isByNemo", "by Authorship"));

	}

	public void copyFile(String fileName, InputStream in) {
		try {
			destination = System.getProperty("user.home") + "/portalMedicao/upload/anotherworks/";

			if (System.getProperty("os.name").contains("Windows")) {
				destination = destination.replaceAll("/", "\\\\");
			}
			// write the inputStream to a FileOutputStream
			File diretorio = new File(destination);
			if (!diretorio.exists()) {
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

	public void download(String nameWorkSelected) {
		AnotherWork workSelected = this.manageAnotherWorkService.retrieveByName(nameWorkSelected);
		String filepath = workSelected.getFilepath();
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
	public String save() {

		try {
			if (file != null && !file.getFileName().equals("")) {
				FacesMessage msg = new FacesMessage("Succesful" + file.getFileName() + " is uploaded.");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				copyFile(file.getFileName(), file.getInputstream());
				super.selectedEntity.setFilepath(destination + file.getFileName());
			} else {
				super.selectedEntity.setFilepath(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		manageAnotherWorkService.getDAO().save(super.selectedEntity);
		super.selectedEntity = new AnotherWork();
		return list();
	}

}
