package lt.vu.entities;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "ConcertHall.findAll", query = "select f from Festival as f")
})
public class ConcertHall {
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

    private String address;

    @Basic
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private Long capacity;

    @Basic
    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    private Band homeBand;

    @OneToOne(mappedBy = "homeConcertHall", optional = false)
    public Band getHomeBand() {
        return homeBand;
    }

    public void setHomeBand(Band homeBand) {
        this.homeBand = homeBand;
    }
}
