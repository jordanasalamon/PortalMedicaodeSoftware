package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.persistence;

import javax.ejb.Local;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain.Publication;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Local
public interface PublicationDAO extends BaseDAO<Publication> {

}
