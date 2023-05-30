package lt.vu.usecases;

import lt.vu.rest.contracts.MusicianDto;

public interface IValidator {
    public default boolean validate(MusicianDto musicianDtoDto) {
        return false;
    }
}
