package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Musician.findAll", query = "select m from Musician as m")
})
@Table(name = "MUSICIAN")
@Getter @Setter
public class Musician implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "NAME")
    private String name;

    @Column(name = "INSTRUMENT")
    private String instrument;

    @ManyToOne
    @JoinColumn(name="BAND_ID")
    private Band band;

    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private Integer version;

    public Musician() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Musician musician = (Musician) o;
        return Objects.equals(id, musician.id) &&
                Objects.equals(name, musician.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
