package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.controller;


import javax.faces.convert.EnumConverter;
import javax.faces.convert.FacesConverter;
import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain.PublicationType;

@FacesConverter(value = "publicationTypeConverter")
public class PublicationTypeConverter extends EnumConverter {
	
	public PublicationTypeConverter() {
	    super(PublicationType.class);
	}
}
