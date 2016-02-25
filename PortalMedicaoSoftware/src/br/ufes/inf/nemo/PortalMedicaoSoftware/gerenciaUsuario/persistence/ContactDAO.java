package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.persistence;

import javax.ejb.Local;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.domain.Contact;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Local
public interface ContactDAO extends BaseDAO<Contact> {

}
