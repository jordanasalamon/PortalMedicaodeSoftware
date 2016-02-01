package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain.Ontology;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;

@Stateless
public class OntologyJPADAO extends BaseJPADAO<Ontology> implements OntologyDAO {

	 /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		@PersistenceContext
		 private EntityManager entityManager;

		@Override
		public Class<Ontology> getDomainClass() {
			return Ontology.class;
		}

		@Override
		protected EntityManager getEntityManager() {
			return entityManager;
		}

}
