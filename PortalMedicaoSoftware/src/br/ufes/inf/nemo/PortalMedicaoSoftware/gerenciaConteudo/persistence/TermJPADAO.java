package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain.Term;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;

@Stateless
public class TermJPADAO extends BaseJPADAO<Term> implements TermDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	 private EntityManager entityManager;

	@Override
	public Class<Term> getDomainClass() {
		return Term.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}
	
}
