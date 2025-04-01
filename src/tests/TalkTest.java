package tests;

import static org.junit.jupiter.api.Assertions.*;
import command.Talk;
import org.junit.jupiter.api.Test;

public class TalkTest {

    @Test
    void execute() {
        Talk talk = new Talk();

        String expected = "❌ Silence... There's no one in sight.";
        assertEquals(expected , talk.execute());
    }
}
