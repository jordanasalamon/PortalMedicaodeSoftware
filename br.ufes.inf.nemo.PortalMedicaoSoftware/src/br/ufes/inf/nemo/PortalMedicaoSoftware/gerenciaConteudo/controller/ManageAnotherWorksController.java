package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.controller;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.application.ManageAnotherWorksService;
import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain.AnotherWork;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;
@Named
@SessionScoped
public class ManageAnotherWorksController extends CrudController<AnotherWork> {

	private static final long serialVersionUID = 1L;
	@EJB
	private ManageAnotherWorksService manageAnotherWorkService;
	
	@Override
	protected CrudService<AnotherWork> getCrudService() {
		return manageAnotherWorkService;
	}

	@Override
	protected AnotherWork createNewEntity() {
		return new AnotherWork();
	}

	public ManageAnotherWorksController() {
	    viewPath = "/manageAnotherWork/";
	    bundleName = "msgs";
	}

	@Override
	protected void initFilters() {
		// TODO Auto-generated method stub
		
	}
}
