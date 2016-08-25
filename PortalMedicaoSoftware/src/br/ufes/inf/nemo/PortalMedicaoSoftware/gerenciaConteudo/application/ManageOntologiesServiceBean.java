package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.application;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain.Ontology;
import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.persistence.OntologyDAO;
import br.ufes.inf.nemo.util.ejb3.application.CrudServiceBean;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Stateless
public class ManageOntologiesServiceBean extends CrudServiceBean<Ontology> implements ManageOntologiesService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private OntologyDAO ontologyDAO;
	
	@Override
	public BaseDAO<Ontology> getDAO() {
		return ontologyDAO;
	}

	@Override
	protected Ontology createNewEntity() {
		return new Ontology();
	}

	@Override
	public Ontology retrieveByName(String nameOntologySelected) {
		return ontologyDAO.retrieveByName(nameOntologySelected);

	}

}
