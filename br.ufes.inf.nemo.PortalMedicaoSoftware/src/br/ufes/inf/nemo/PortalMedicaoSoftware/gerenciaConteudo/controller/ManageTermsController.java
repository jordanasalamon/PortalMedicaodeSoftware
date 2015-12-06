package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.application.ManageTermsService;
import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain.Term;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;
@Named
@SessionScoped
public class ManageTermsController extends CrudController<Term> {

	private static final long serialVersionUID = 1L;
	@EJB
	private ManageTermsService manageTermsService;
	
	@Override
	protected CrudService<Term> getCrudService() {
		return manageTermsService;
	}

	@Override
	protected Term createNewEntity() {
		return new Term();
	}

	public ManageTermsController() {
	    viewPath = "/manageTerms/";
	    bundleName = "msgs";
	}

	@Override
	protected void initFilters() {
		// TODO Auto-generated method stub
		
	}
	
	public void cancelFilter(){
		
	}
	
	@PostConstruct
	public void init() {
	    super.selectedEntity = new Term();
	}
}
