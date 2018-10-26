package nl.hva.ict.ds;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import nl.hva.ict.ds.util.NameReader;
import org.junit.Test;

/**
 * If you have any tests that should be overwritten or added please put them to
 * this class.
 */
public class ExtendedPlayerFinderTest extends HighScorePlayerFinderTest {

    private Random randomizer = new SecureRandom();

    @Test
    public final void testForHeadless() {
        List<Player> headless = highscores.findPlayer(null, "de Mimsy-Porpington");

        assertEquals(1, headless.size());
        assertEquals(nearlyHeadlessNick, headless.get(0));
    }

    @Test
    public final void lookForNonExisting() {
        List<Player> JohnDoe = highscores.findPlayer("John", "Doe");

        assertEquals(0, JohnDoe.size());
    }

    @Test
    public void ImprovedcollisionsShouldHappen() {
        String[] firstNames = new NameReader("/firstnames.txt").getNames();
        String[] lastNames = new NameReader("/lastnames.txt").getNames();

        int amount = 10000;
        int[] sizes = {10501, 11701, 13309, 15401};
        for (int size : sizes) {
            highscores = new HighScorePlayerFinder(size); // Please adjust this size!
            for (int i = 0; i < amount; i++) {
                String firstName = firstNames[randomizer.nextInt(firstNames.length)];
                String lastName = lastNames[randomizer.nextInt(lastNames.length)];
                highscores.add(new Player(firstName, lastName, randomizer.nextInt(1000)));
            }
            highscores.printCollisions(amount, size);
            System.out.println("");
        }
    }

}
