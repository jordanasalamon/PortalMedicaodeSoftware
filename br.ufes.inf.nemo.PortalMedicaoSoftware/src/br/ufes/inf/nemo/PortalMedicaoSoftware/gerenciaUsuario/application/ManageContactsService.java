package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.application;

import javax.ejb.Local;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.domain.Contact;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;

@Local
public interface ManageContactsService extends CrudService<Contact> {

}
