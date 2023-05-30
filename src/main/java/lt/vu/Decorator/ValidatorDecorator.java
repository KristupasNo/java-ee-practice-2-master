package lt.vu.Decorator;

import lt.vu.rest.contracts.MusicianDto;
import lt.vu.usecases.IValidator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Decorator
public abstract class ValidatorDecorator implements IValidator {

    @Inject
    @Delegate
    IValidator validator;

    @Override
    public boolean validate(MusicianDto musicianDto) {
        System.out.println("ValidatorDecorator");

        if (!musicianDto.getName().matches("[a-zA-Z]+")) {
            System.out.println("Name contains invalid characters.");
            return false;
        }

        if (!musicianDto.getInstrument().matches("[a-zA-Z]+")) {
            System.out.println("Instrument contains invalid characters.");
            return false;
        }

        return validator.validate(musicianDto);
    }
}

