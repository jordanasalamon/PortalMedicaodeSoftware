package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.persistence;

import javax.ejb.Local;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain.Ontology;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Local
public interface OntologyDAO extends BaseDAO<Ontology> {

	Ontology retrieveByName(String nameOntologySelected);

}
