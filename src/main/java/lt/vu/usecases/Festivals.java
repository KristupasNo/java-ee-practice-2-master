package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Festival;
import lt.vu.persistence.FestivalsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Festivals {

    @Inject
    private FestivalsDAO festivalsDAO;

    @Getter
    @Setter
    private Festival festivalToCreate = new Festival();

    @Getter
    private List<Festival> allFestivals;
    @Getter
    private List<Festival> loadedFestivals;
    @Getter @Setter
    private String festivalToSearch = "";

    @PostConstruct
    public void init(){
        loadAllFestivals();
    }

    @Transactional
    public void createFestival(){
        this.festivalsDAO.persist(festivalToCreate);
    }

    private void loadAllFestivals(){
        this.allFestivals = festivalsDAO.loadAll();
    }
    @Transactional
    public void loadFestivalLike(){
        this.loadedFestivals = festivalsDAO.loadFestival(festivalToSearch);
    }
}
