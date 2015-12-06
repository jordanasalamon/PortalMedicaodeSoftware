package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.controller;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain.Publication;
import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain.PublicationType;
import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.persistence.PublicationDAO;
import br.ufes.inf.nemo.util.ejb3.controller.PersistentObjectConverterFromId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.convert.Converter;
import javax.inject.Named;

@Named
@ApplicationScoped
public class PublicationTypeController {

	    private List<PublicationType> publicationTypes;
	    private List<Publication> publications;

	    @EJB
	    private PublicationDAO publicationDAO;

	    private PersistentObjectConverterFromId<Publication> publicationConverter;

	    public List<PublicationType> getPublicationTypes() {
	        if (publicationTypes == null) {
	        	publicationTypes = new ArrayList<>();
	        	publicationTypes.addAll(Arrays.asList(PublicationType.values()));
	        }
	        return publicationTypes;
	    }

	    public void setPublicationTypes(List<PublicationType> publicationTypes) {
	        this.publicationTypes = publicationTypes;
	    }


	    public Converter getPublicationController() {
	        if (publicationConverter == null) {
	        	publicationConverter = new PersistentObjectConverterFromId<>(publicationDAO);
	        }
	        return publicationConverter;
	    }

		    public List<Publication> getPublications() {
	        if (publications == null) {
	        	publications = publicationDAO.retrieveAll();
	        }
	        return publications;
	    }
}
