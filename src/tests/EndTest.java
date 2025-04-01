package tests;

import static org.junit.jupiter.api.Assertions.*;
import command.End;
import org.junit.jupiter.api.Test;

public class EndTest {

    @Test

    void execute() {
        End end = new End();

        String expected = "\uD83C\uDFAE The game is over!";
        assertEquals(expected , end.execute());
    }

}