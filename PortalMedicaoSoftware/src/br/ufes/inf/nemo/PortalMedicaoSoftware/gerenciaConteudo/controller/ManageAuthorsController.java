package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.application.ManageAuthorsService;
import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain.Author;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;

@Named
@SessionScoped
public class ManageAuthorsController extends CrudController<Author>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Author> allAuthors;

	@EJB
	ManageAuthorsService manageAuthorsService;

	@Override
	protected CrudService<Author> getCrudService() {
		return manageAuthorsService;
	}

	@Override
	protected Author createNewEntity() {
		return new Author();
	}

	@Override
	protected void initFilters() {
	}
	

	public ManageAuthorsController() {
	    viewPath = "/manageAuthors/";
	    bundleName = "msgs";
	}
	
	public void init() {
		setAllAuthors(manageAuthorsService.getDAO().retrieveAll());
    }

	public List<Author> getAllAuthors() {
		return allAuthors;
	}

	public void setAllAuthors(List<Author> allAuthors) {
		this.allAuthors = allAuthors;
	}

}
