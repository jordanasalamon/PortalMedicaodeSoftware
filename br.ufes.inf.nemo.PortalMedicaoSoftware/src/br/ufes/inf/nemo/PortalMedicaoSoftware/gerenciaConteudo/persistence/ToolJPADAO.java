package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain.Tool;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;

@Stateless
public class ToolJPADAO extends
		BaseJPADAO<br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain.Tool>
		implements ToolDAO {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	 private EntityManager entityManager;

	@Override
	public Class<Tool> getDomainClass() {
		return Tool.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}
}
