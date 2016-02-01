package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.domain.Contact;
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

}
