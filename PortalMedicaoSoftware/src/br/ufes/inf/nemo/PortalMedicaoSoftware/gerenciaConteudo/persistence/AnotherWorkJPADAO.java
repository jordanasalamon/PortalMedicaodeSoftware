package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain.AnotherWork;
import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain.AnotherWork_;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;

@Stateless
public class AnotherWorkJPADAO extends BaseJPADAO<AnotherWork> implements AnotherWorkDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	 private EntityManager entityManager;

	@Override
	public Class<AnotherWork> getDomainClass() {
		return AnotherWork.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public AnotherWork retrieveByName(String name) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<AnotherWork> cq = cb.createQuery(AnotherWork.class);
        Root<AnotherWork> root = cq.from(AnotherWork.class);
        Predicate where = cb.equal(root.get(AnotherWork_.name), name);
        cq.where(where);
        AnotherWork anotherWork = null;
        try {
            anotherWork = entityManager.createQuery(cq).getSingleResult();
        } catch (RuntimeException e) {
        }
        return anotherWork;
	}

}
