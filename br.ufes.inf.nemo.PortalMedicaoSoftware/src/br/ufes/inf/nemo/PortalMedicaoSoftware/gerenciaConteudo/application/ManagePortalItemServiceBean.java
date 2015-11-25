package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.application;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain.PortalItem;
import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.persistence.PortalItemDAO;
import br.ufes.inf.nemo.util.ejb3.application.CrudServiceBean;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Stateless
public class ManagePortalItemServiceBean extends CrudServiceBean<PortalItem> implements
		ManagePortalItemService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private PortalItemDAO portalItemDAO;
	
	@Override
	public BaseDAO<PortalItem> getDAO() {
		return portalItemDAO;
	}

	@Override
	protected PortalItem createNewEntity() {
		return new PortalItem();
	}

}
