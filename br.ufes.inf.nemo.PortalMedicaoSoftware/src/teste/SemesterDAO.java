package teste;
import javax.ejb.Local;

import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Local
public interface SemesterDAO extends BaseDAO<teste.Semester> {

}
