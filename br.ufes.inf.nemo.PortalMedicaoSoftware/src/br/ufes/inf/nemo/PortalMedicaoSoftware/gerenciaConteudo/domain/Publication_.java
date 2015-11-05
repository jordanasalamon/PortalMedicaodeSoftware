package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain;

import java.util.Date;

import br.ufes.inf.nemo.PortalMedicaoSoftware.util.Authorship;
import br.ufes.inf.nemo.PortalMedicaoSoftware.util.Type;
import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport_;

import javax.persistence.metamodel.*;

@StaticMetamodel(Publication.class)
public class Publication_ extends PersistentObjectSupport_ {

	public static volatile SingularAttribute<Publication, String> Title;
	public static volatile SingularAttribute<Publication, Date> Year;
	public static volatile SingularAttribute<Publication, String> Filepath;
	public static volatile SingularAttribute<Publication, String> Reference;
	public static volatile SingularAttribute<Publication, String> Abstract;
	public static volatile SingularAttribute<Publication, Authorship> Authorship;
	public static volatile SingularAttribute<Publication, Type> Type;
	public static volatile SetAttribute<Publication, Author> Authors;

}
