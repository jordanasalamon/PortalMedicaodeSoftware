package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.persistence;

import java.util.List;

import javax.ejb.Local;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain.Publication;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Local
public interface PublicationDAO extends BaseDAO<Publication> {

	
	public List<Publication> retrieveAllOrderedByYear();
	
}
