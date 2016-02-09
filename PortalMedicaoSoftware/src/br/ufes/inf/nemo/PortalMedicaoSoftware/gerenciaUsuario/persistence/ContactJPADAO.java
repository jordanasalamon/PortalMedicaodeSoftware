package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.persistence;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.domain.Contact;
import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.domain.Contact_;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;

@Stateless
public class ContactJPADAO extends BaseJPADAO<Contact> implements ContactDAO {

	 /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		@PersistenceContext
		 private EntityManager entityManager;

		@Override
		public Class<Contact> getDomainClass() {
			return Contact.class;
		}

		@Override
		protected EntityManager getEntityManager() {
			return entityManager;
		}

		@Override
		public List<Contact> retrieveAllUnreadMessages() {
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	        CriteriaQuery<Contact> cq = cb.createQuery(Contact.class);
	        Root<Contact> root = cq.from(Contact.class);
	        Predicate where = cb.equal(root.get(Contact_.isAnswered),true);
	        cq.where(where);
	        List<Contact> contacts = null;
			try {
	            contacts = entityManager.createQuery(cq).getResultList();
	        } catch (RuntimeException e) {
	        }
	        return contacts;
		}

}
