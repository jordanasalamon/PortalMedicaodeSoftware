package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.application;

import javax.ejb.Local;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain.Author;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;

@Local
public interface ManageAuthorsService extends CrudService<Author> {

}
