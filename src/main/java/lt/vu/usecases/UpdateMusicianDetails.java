package lt.vu.usecases;


import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Musician;
import lt.vu.interceptors.LoggedInvocation;
import lt.vu.persistence.MusiciansDAO;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Named
@Getter @Setter
public class UpdateMusicianDetails implements Serializable {

    private Musician musician;

    @Inject
    private MusiciansDAO musiciansDAO;

    @PostConstruct
    private void init() {
        System.out.println("UpdatePlayerDetails INIT CALLED");
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer musicianId = Integer.parseInt(requestParameters.get("musicianId"));
        this.musician = musiciansDAO.findOne(musicianId);
    }

    @Transactional
    @LoggedInvocation
    public String updateMusicianInstrument() {
        try{
            musiciansDAO.update(this.musician);
        } catch (OptimisticLockException e) {
            return "/musicianDetails.xhtml?faces-redirect=true&musicianId=" + this.musician.getId() + "&error=optimistic-lock-exception";
        }
        return "musicians.xhtml?bandId=" + this.musician.getBand().getId() + "&faces-redirect=true";
    }
}
