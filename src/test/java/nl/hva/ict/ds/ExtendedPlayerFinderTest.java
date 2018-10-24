package nl.hva.ict.ds;

import java.util.List;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import org.junit.Test;

/**
 * If you have any tests that should be overwritten or added please put them to
 * this class.
 */
public class ExtendedPlayerFinderTest extends HighScorePlayerFinderTest {

    @Test
    public final void testForHeadless() {
        List<Player> headless = highscores.findPlayer(null, "de Mimsy-Porpington");
        for (Player player : headless) {
            System.out.println(player.getFirstName() + " " + player.getLastName());
        }
        assertEquals(1, headless.size());
        assertEquals(nearlyHeadlessNick, headless.get(0));
    }
    @Test
    public final void checkPotters() {
        List<Player> potters = highscores.findPlayer(null, "Potter");
        for (Player player : potters) {
            System.out.println(player.getFirstName() + " " + player.getLastName());
        }
        assertEquals(3, potters.size());
        assertTrue(potters.contains(harry));
        assertTrue(potters.contains(james));
        assertTrue(potters.contains(lily));
    }
}
