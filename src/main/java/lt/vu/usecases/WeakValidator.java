package lt.vu.usecases;

import lt.vu.rest.contracts.MusicianDto;

import javax.annotation.Priority;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;
import java.io.Serializable;

@RequestScoped
@Alternative
@Priority(2)
public class WeakValidator implements Serializable, IValidator {
    public WeakValidator() {}
    @Override
    public boolean validate(MusicianDto musicianDto){
        // Ensure name is not null and not empty
        return musicianDto.getName() != null
                && !musicianDto.getName().isEmpty();
    }

}
