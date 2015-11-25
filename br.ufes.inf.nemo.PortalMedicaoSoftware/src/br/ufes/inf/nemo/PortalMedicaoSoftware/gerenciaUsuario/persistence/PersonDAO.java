package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.persistence;

import javax.ejb.Local;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.domain.Person;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Local
public interface PersonDAO extends BaseDAO<Person> {
}
