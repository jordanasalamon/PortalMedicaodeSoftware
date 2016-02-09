package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain.Author;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;


@Stateless
public class AuthorJPADAO extends BaseJPADAO<Author> implements AuthorDAO{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager entityManager;
	
	public EntityManager getEntityManager(){
		return entityManager;
	}

	@Override
	public Class<Author> getDomainClass() {
		return Author.class;
	}
	
}
