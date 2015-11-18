package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.domain.User;
import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.domain.User_;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;

@Stateless
public class UserJPADAO extends
		BaseJPADAO<br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.domain.User>
		implements UserDAO {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	 private EntityManager entityManager;

	@Override
	public Class<User> getDomainClass() {
		return User.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public User retrieveByUsername(String username) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        Predicate where = cb.equal(root.get(User_.Username), username);
        cq.where(where);
        User user = null;
        try {
            user = entityManager.createQuery(cq).getSingleResult();
        } catch (RuntimeException e) {
        }
        return user;
	}
}
