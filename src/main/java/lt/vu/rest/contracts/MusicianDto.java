package lt.vu.rest.contracts;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MusicianDto {

    private String Name;

    private String Instrument;

    private Integer BandId;
}
