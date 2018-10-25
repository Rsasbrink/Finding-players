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
     
        assertEquals(1, headless.size());
        assertEquals(nearlyHeadlessNick, headless.get(0));
    }
  

}
