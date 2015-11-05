package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.application;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain.Tool;
import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.persistence.ToolDAO;
import br.ufes.inf.nemo.util.ejb3.application.CrudServiceBean;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Stateless
public class ManageToolsServiceBean extends CrudServiceBean<Tool> implements
		ManageToolsService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private ToolDAO toolDAO;
	
	@Override
	public BaseDAO<Tool> getDAO() {
		return toolDAO;
	}

	@Override
	protected Tool createNewEntity() {
		return new Tool();
	}

}
