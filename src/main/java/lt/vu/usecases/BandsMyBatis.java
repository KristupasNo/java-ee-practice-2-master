package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.mybatis.dao.BandMapper;
import lt.vu.mybatis.model.Band;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class BandsMyBatis {
    @Inject
    private BandMapper bandMapper;

    @Getter
    private List<Band> allBands;

    @Getter @Setter
    private Band bandToCreate = new Band();

    @PostConstruct
    public void init() {
        this.loadAllBands();
    }

    private void loadAllBands() {
        this.allBands = bandMapper.selectAll();
    }

    @Transactional
    public String createBand() {
        bandMapper.insert(bandToCreate);
        return "/myBatis/bands?faces-redirect=true";
    }
}
