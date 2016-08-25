package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.persistence;

import java.util.Collections;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain.Publication_;
import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain.Publication;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;

@Stateless
public class PublicationJPADAO extends BaseJPADAO<Publication> implements PublicationDAO {

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

	public List<Publication> retrieveAllOrderedByYear() {
		List<Publication> all = this.retrieveAll();
		Collections.sort(all);
		return all;
	}

	@Override
	public Publication retrieveByName(String namePublicationSelected) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Publication> cq = cb.createQuery(Publication.class);
        Root<Publication> root = cq.from(Publication.class);
        Predicate where = cb.equal(root.get(Publication_.name), namePublicationSelected);
        cq.where(where);
        Publication publication = null;
        try {
        	publication = entityManager.createQuery(cq).getSingleResult();
        } catch (RuntimeException e) {
        }
        return publication;
	}

}
