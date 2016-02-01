package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.application;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain.Term;
import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.persistence.TermDAO;
import br.ufes.inf.nemo.util.ejb3.application.CrudServiceBean;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Stateless
public class ManageTermsServiceBean extends CrudServiceBean<Term> implements ManageTermsService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private TermDAO termDAO;
	
	@Override
	public BaseDAO<Term> getDAO() {
		return termDAO;
	}

	@Override
	protected Term createNewEntity() {
		return new Term();
	}

}
