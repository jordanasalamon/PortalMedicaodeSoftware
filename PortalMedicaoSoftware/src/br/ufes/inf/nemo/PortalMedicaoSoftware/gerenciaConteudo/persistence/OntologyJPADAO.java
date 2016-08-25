package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain.Ontology;
import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain.Ontology_;
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

		@Override
		public Ontology retrieveByName(String nameOntologySelected) {
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	        CriteriaQuery<Ontology> cq = cb.createQuery(Ontology.class);
	        Root<Ontology> root = cq.from(Ontology.class);
	        Predicate where = cb.equal(root.get(Ontology_.name), nameOntologySelected);
	        cq.where(where);
	        Ontology ontology = null;
	        try {
	        	ontology = entityManager.createQuery(cq).getSingleResult();
	        } catch (RuntimeException e) {
	        }
	        return ontology;
		}

}
