package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain.Publication;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;

@Stateless
public class PublicationJPADAO extends
		BaseJPADAO<br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain.Publication>
		implements PublicationDAO {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	 private EntityManager entityManager;

	@Override
	public Class<Publication> getDomainClass() {
		return Publication.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}
}
