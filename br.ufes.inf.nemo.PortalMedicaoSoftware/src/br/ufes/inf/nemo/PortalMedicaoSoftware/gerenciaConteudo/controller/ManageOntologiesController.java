package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.application.ManageOntologiesService;
import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain.Ontology;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;
@Named
@SessionScoped
public class ManageOntologiesController extends CrudController<Ontology> {

	private static final long serialVersionUID = 1L;
	@EJB
	private ManageOntologiesService manageOntologiesService;
	
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
		// TODO Auto-generated method stub
		
	}
	
	public void cancelFilter(){
		
	}
	
	@PostConstruct
	public void init() {
	    super.selectedEntity = new Ontology();
	}
}
