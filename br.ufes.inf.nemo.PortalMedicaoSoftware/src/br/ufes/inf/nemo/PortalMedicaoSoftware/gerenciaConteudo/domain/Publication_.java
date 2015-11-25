package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain;

import java.util.Date;

import javax.persistence.metamodel.*;

@StaticMetamodel(Publication.class)
public class Publication_ extends PortalItem_ {

	public static volatile SingularAttribute<Publication, String> Title;
	public static volatile SingularAttribute<Publication, Date> Year;
	public static volatile SingularAttribute<Publication, String> Filepath;
	public static volatile SingularAttribute<Publication, String> Reference;
	public static volatile SingularAttribute<Publication, String> Abstract;
	public static volatile SingularAttribute<Publication, Boolean> isByNemo;
	public static volatile SingularAttribute<Publication, PublicationType> Type;
	public static volatile SetAttribute<Publication, Author> Authors;

}
