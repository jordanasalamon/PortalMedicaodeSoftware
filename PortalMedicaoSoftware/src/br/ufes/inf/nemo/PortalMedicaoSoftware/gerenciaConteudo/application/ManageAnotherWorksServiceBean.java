package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.application;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain.AnotherWork;
import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.persistence.AnotherWorkDAO;
import br.ufes.inf.nemo.util.ejb3.application.CrudServiceBean;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Stateless
public class ManageAnotherWorksServiceBean extends CrudServiceBean<AnotherWork> implements ManageAnotherWorksService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private AnotherWorkDAO anotherWorkDAO;
	
	@Override
	public BaseDAO<AnotherWork> getDAO() {
		return anotherWorkDAO;
	}

	@Override
	protected AnotherWork createNewEntity() {
		return new AnotherWork();
	}

}
