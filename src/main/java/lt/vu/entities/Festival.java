package lt.vu.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Festival.findAll", query = "select f from Festival as f")
})
public class Festival {
    private Long id;

    @GeneratedValue
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String name;

    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String shortName;

    @Basic
    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Festival festival = (Festival) o;
        return id.equals(festival.id) && Objects.equals(name, festival.name) && Objects.equals(shortName, festival.shortName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, shortName);
    }

    private List<Band> bands;

    @ManyToMany(mappedBy = "festivals")
    public List<Band> getBands() {
        return bands;
    }

    public void setBands(List<Band> bands) {
        this.bands = bands;
    }
}
