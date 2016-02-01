package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.controller;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.application.ManagePortalItemsService;
import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain.PortalItem;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.application.filters.SimpleFilter;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;

@Named
@SessionScoped
public class ManagePortalItemsController extends CrudController<PortalItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private ManagePortalItemsService managePortalItemsService;
	
	@Override
	protected CrudService<PortalItem> getCrudService() {
		return managePortalItemsService;
	}

	@Override
	protected PortalItem createNewEntity() {
		return new PortalItem();
	}

	public ManagePortalItemsController() {
	    viewPath = "/managePortalItems/";
	    bundleName = "msgs";
	}
	
	@Override
	protected void initFilters() {
		addFilter(new SimpleFilter("managePortalItems.filter.byName", "name", getI18nMessage("msgs", "managePortalItems.text.filter.byYear")));

	}

}
