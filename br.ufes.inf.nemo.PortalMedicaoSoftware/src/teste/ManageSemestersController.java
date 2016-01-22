package teste;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.application.filters.SimpleFilter;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;

@Named
@SessionScoped
public class ManageSemestersController extends CrudController<Semester> {

	@EJB
	private ManageSemestersService manageSemestersService;
	
	@Override
	protected CrudService<Semester> getCrudService() {
		// TODO Auto-generated method stub
		return manageSemestersService;
	}

	@Override
	protected Semester createNewEntity() {
		// TODO Auto-generated method stub
		return new Semester();
	}

	@Override
	protected void initFilters() {
		// TODO Auto-generated method stub
		addFilter(new SimpleFilter("manageSemesters.filter.byYear", "year", "by Year"));

	}
	
	public ManageSemestersController() {
	    viewPath = "/teste/";
	    bundleName = "msgs";
	}

}
