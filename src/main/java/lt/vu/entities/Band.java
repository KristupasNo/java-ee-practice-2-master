package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Band.findAll", query = "select b from Band as b")
})
@Table(name = "BAND")
@Getter @Setter
public class Band {

    public Band(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "band")
    private List<Musician> musicians = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Band band = (Band) o;
        return Objects.equals(name, band.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    @OneToOne
    private ConcertHall homeConcertHall;

    public ConcertHall getHomeConcertHall() {
        return homeConcertHall;
    }

    public void setHomeConcertHall(ConcertHall homeConcertHall) {
        this.homeConcertHall = homeConcertHall;
    }

    @ManyToMany
    private List<Festival> festivals;

    public List<Festival> getFestivals() {
        return festivals;
    }

    public void setFestivals(List<Festival> festivals) {
        this.festivals = festivals;
    }
}
