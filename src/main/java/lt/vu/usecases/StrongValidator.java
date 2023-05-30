package lt.vu.usecases;

import lt.vu.rest.contracts.MusicianDto;

import javax.annotation.Priority;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;
import java.io.Serializable;

@RequestScoped
@Alternative
@Priority(1)
public class StrongValidator implements Serializable, IValidator {
    public StrongValidator() {}

    @Override
    public boolean validate(MusicianDto musicianDto){
        // Ensure name is not null and not empty
        boolean isNameValid = musicianDto.getName() != null
                && !musicianDto.getName().isEmpty();

        // Ensure instrument name is not null, not empty and is at least 3 characters long
        boolean isInstrumentValid = musicianDto.getInstrument() != null
                && !musicianDto.getInstrument().isEmpty()
                && musicianDto.getInstrument().length() >= 3;

        return isNameValid && isInstrumentValid;
    }



}
