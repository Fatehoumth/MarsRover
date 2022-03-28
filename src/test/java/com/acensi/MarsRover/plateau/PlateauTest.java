package com.acensi.MarsRover.plateau;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlateauTest {
    private static Instant startedAt;
    private Plateau plateau;

    @BeforeAll
    static public void initStartingTime() {
        startedAt = Instant.now();
    }

    @BeforeEach
    public void init(){
        plateau = new Plateau(3,3);
    }

    @Test
    public void whenPlateauIsInitialisedThenHisCoordinatesAreSameAsTheGivenCoordinates() throws Exception {

        assertEquals(0, plateau.getLowerCoordinateX());
        assertEquals(0, plateau.getLowerCoordinateY());
        assertEquals(3, plateau.getUpperCoordinateX());
        assertEquals(3, plateau.getUpperCoordinateY());
    }

    @AfterAll
    static public void showTestDuration() {
        Instant endedAt = Instant.now();
        long duration = Duration.between(startedAt, endedAt).toMillis();
        System.out.println(MessageFormat.format("Durée des tests : {0} ms", duration));
    }
}
