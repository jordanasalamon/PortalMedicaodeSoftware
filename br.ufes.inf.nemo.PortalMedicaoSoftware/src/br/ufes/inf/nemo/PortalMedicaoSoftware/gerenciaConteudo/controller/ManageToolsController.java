package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.controller;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.application.ManageToolsService;
import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain.Tool;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.application.filters.SimpleFilter;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;
@Named
@SessionScoped
public class ManageToolsController extends CrudController<Tool> {

	private static final long serialVersionUID = 1L;
	@EJB
	private ManageToolsService manageToolsService;
	
	@Override
	protected CrudService<Tool> getCrudService() {
		return manageToolsService;
	}

	@Override
	protected Tool createNewEntity() {
		return new Tool();
	}

	public ManageToolsController() {
	    viewPath = "/manageTools/";
	    bundleName = "msgs";
	}

	@Override
	protected void initFilters() {
		// TODO Auto-generated method stub
		addFilter(new SimpleFilter("manageTools.filter.byName", "name", "by Name"));

	}
}
