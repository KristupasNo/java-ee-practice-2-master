package lt.vu.usecases;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Band;
import lt.vu.entities.Musician;
import lt.vu.interceptors.LoggedInvocation;
import lt.vu.persistence.MusiciansDAO;
import lt.vu.persistence.BandsDAO;

@Model
public class MusiciansForBand implements Serializable {

    @Inject
    private BandsDAO bandsDAO;
    @Inject
    private MusiciansDAO musiciansDAO;

    @Getter @Setter
    private Band band;

    @Getter @Setter
    private Musician musicianToCreate = new Musician();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer bandId = Integer.parseInt(requestParameters.get("bandId"));
        this.band = bandsDAO.findOne(bandId);
    }

    @Transactional
    @LoggedInvocation
    public void createMusician() {
        musicianToCreate.setBand(this.band);
        musiciansDAO.persist(musicianToCreate);
    }
}
