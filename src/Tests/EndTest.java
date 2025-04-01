package Tests;

import command.End;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EndTest {

    @Test

    void execute() {
        End end = new End();
        assertEquals("The game is over!", end.execute());
    }

}