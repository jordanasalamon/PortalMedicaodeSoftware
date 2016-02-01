package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.persistence;

import javax.ejb.Local;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain.Term;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Local
public interface TermDAO extends BaseDAO<Term> {

}
