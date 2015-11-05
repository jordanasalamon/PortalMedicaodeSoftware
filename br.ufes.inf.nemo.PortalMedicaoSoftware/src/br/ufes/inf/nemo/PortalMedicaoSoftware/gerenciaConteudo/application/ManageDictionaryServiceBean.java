package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.application;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain.Dictionary;
import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.persistence.DictionaryDAO;
import br.ufes.inf.nemo.util.ejb3.application.CrudServiceBean;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Stateless
public class ManageDictionaryServiceBean extends CrudServiceBean<Dictionary> implements
		ManageDictionaryService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private DictionaryDAO dictionaryDAO;
	
	@Override
	public BaseDAO<Dictionary> getDAO() {
		return dictionaryDAO;
	}

	@Override
	protected Dictionary createNewEntity() {
		return new Dictionary();
	}

}
