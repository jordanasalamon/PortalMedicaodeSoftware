package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.model.UploadedFile;

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
	private UploadedFile file;
	private String destination;

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

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

	public void copyFile(String fileName, InputStream in) {
		try {
			destination = System.getProperty("user.home") + "/portalMedicao/upload/ontologies/";

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

	@Override
	public String save() {
		try {
			if (file != null) {
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
		
		manageOntologiesService.getDAO().save(super.selectedEntity);

		super.selectedEntity = new Ontology();
		return list();
	}

}
