package lt.vu.usecases;

import lt.vu.interceptors.LoggedInvocation;
import lt.vu.services.MusicianService;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

@SessionScoped
@Named
public class GenerateMusicianInstrument implements Serializable {
    @Inject
    MusicianService musicianService;

    private CompletableFuture<String> instrumentGenerationTask = null;
    private static final Logger LOGGER = Logger.getLogger(GenerateMusicianInstrument.class.getName());

    @LoggedInvocation
    public String generateNewInstrument() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        instrumentGenerationTask = CompletableFuture.supplyAsync(() -> musicianService.generateInstrument());

        return  "/musicianDetails.xhtml?faces-redirect=true&musicianId=" + requestParameters.get("musicianId");
    }

    public boolean isInstrumentGenerationRunning() {
        return instrumentGenerationTask != null && !instrumentGenerationTask.isDone();
    }

    public String getInstrumentGenerationStatus() {
        if (instrumentGenerationTask == null) {
            return null;
        } else if (isInstrumentGenerationRunning()) {
            return "Instrument generation in progress";
        }
        try {
            return "Suggested instrument: " + instrumentGenerationTask.get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LOGGER.warning("Instrument generation was interrupted: " + e.getMessage());
            return "Error: Instrument generation interrupted";
        } catch (ExecutionException e) {
            LOGGER.severe("An error occurred during instrument generation: " + e.getMessage());
            return "Error: An error occurred during instrument generation";
        }
    }

}
