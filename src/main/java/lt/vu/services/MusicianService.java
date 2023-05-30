package lt.vu.services;

import javax.enterprise.context.ApplicationScoped;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@ApplicationScoped
public class MusicianService {

    private final List<String> instruments = Arrays.asList("Guitar", "Piano", "Violin", "Drums", "Bass", "Saxophone", "Trumpet", "Flute");

    private final Random random = new Random();

    public String generateInstrument() {
        // Sleep for a while to simulate a long-running task
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Pick a random instrument
        int index = random.nextInt(instruments.size());
        return instruments.get(index);
    }
}
