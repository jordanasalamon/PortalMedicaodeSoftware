package teste;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;
@Stateless
public class SemesterJPADAO extends BaseJPADAO<teste.Semester> implements SemesterDAO {

	@PersistenceContext 
	private EntityManager entityManager;
	
	@Override
	public Class<Semester> getDomainClass() {
		// TODO Auto-generated method stub
		return Semester.class;
	}

	public EntityManager getEntityManager(){
		return entityManager;
	}
	

}
