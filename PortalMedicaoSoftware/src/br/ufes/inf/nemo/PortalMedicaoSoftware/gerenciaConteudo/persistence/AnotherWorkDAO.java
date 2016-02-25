package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.persistence;

import javax.ejb.Local;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain.AnotherWork;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Local
public interface AnotherWorkDAO extends BaseDAO<AnotherWork> {

	AnotherWork retrieveByName(String name);

}
