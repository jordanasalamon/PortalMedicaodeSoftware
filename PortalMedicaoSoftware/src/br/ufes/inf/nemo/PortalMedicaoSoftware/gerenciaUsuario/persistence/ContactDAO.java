package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.persistence;

import java.util.List;

import javax.ejb.Local;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.domain.Contact;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Local
public interface ContactDAO extends BaseDAO<Contact> {

	List<Contact> retrieveAllUnreadMessages();

}
