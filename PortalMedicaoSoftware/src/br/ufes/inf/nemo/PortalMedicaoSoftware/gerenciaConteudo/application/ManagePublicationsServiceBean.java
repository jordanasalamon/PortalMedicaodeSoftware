package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.application;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain.Publication;
import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.persistence.PublicationDAO;
import br.ufes.inf.nemo.util.ejb3.application.CrudServiceBean;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Stateless
public class ManagePublicationsServiceBean extends CrudServiceBean<Publication> implements ManagePublicationsService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private PublicationDAO publicationDAO;
	
	@Override
	public BaseDAO<Publication> getDAO() {
		return publicationDAO;
	}

	@Override
	protected Publication createNewEntity() {
		return new Publication();
	}

}
