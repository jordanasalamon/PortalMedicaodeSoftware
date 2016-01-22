package teste;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.util.ejb3.application.CrudServiceBean;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Stateless
public class ManageSemestersServiceBean extends CrudServiceBean<Semester> implements ManageSemestersService {

	@EJB 
	private SemesterDAO semesterDAO;
	
	@Override
	public BaseDAO<Semester> getDAO() {
		// TODO Auto-generated method stub
		return semesterDAO;
	}

	@Override
	protected Semester createNewEntity() {
		// TODO Auto-generated method stub
		return new Semester();
	}

}
