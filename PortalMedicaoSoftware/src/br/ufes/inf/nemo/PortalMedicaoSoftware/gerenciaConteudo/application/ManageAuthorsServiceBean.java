package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.application;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain.Author;
import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.persistence.AuthorDAO;
import br.ufes.inf.nemo.util.ejb3.application.CrudServiceBean;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Stateless
public class ManageAuthorsServiceBean extends CrudServiceBean<Author> implements ManageAuthorsService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private AuthorDAO authorDAO;
	
	@Override
	public BaseDAO<Author> getDAO() {
		return authorDAO;
	}

	@Override
	protected Author createNewEntity() {
		return new Author();
	}

}
