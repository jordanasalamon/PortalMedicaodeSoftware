package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.controller;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.application.ManageDictionaryService;
import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain.Dictionary;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;
@Named
@SessionScoped
public class ManageDictionaryController extends CrudController<Dictionary> {

	private static final long serialVersionUID = 1L;
	@EJB
	private ManageDictionaryService manageDictionaryService;
	
	@Override
	protected CrudService<Dictionary> getCrudService() {
		return manageDictionaryService;
	}

	@Override
	protected Dictionary createNewEntity() {
		return new Dictionary();
	}

	public ManageDictionaryController() {
	    viewPath = "/manageDictionary/";
	    bundleName = "msgs";
	}

	@Override
	protected void initFilters() {
		// TODO Auto-generated method stub
		
	}
}
