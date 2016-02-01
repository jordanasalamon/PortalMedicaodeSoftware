package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain.Dictionary;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;

@Stateless
public class DictionaryJPADAO extends BaseJPADAO<Dictionary> implements DictionaryDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	 private EntityManager entityManager;

	@Override
	public Class<Dictionary> getDomainClass() {
		return Dictionary.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
