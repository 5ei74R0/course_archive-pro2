import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BuggyTest {

    private Buggy buggy = new Buggy();

    @Test
    void testIsPrimeFor1() {
        assertFalse(buggy.isPrime(1));
    }

    @Test
    void testIsPrimeFor4() {
        assertFalse(buggy.isPrime(4));
    }
}
