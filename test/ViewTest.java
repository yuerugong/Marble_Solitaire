import static org.junit.Assert.assertEquals;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import org.junit.Before;
import org.junit.Test;

/**
 * the {@code ViewTest} represent the test for MarbleSolitaireTextView class.
 */
public class ViewTest {

  EnglishSolitaireModel mod;
  EnglishSolitaireModel m1;
  EnglishSolitaireModel m2;
  EnglishSolitaireModel m3;
  EnglishSolitaireModel m4;
  EnglishSolitaireModel m5;
  EnglishSolitaireModel m6;

  /**
   * to give the initinal value.
   */
  @Before
  public void setUp() {
    mod = new EnglishSolitaireModel();
    m1 = new EnglishSolitaireModel(4, 4);
    m2 = new EnglishSolitaireModel(1);
    m3 = new EnglishSolitaireModel(5, 4, 4);
    m4 = new EnglishSolitaireModel(5);
    m5 = new EnglishSolitaireModel(5, 6, 6);
    m6 = new EnglishSolitaireModel(7);
  }

  /**
   * to test ToString method.
   */
  @Test
  public void testToString() {
    this.setUp();
    String s1 = "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O";
    String s2 = "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O _ O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O";
    String s3 = "            O O O O O O O\n"
        + "            O O O O O O O\n"
        + "            O O O O O O O\n"
        + "            O O O O O O O\n"
        + "            O O O O O O O\n"
        + "            O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O _ O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O\n"
        + "            O O O O O O O\n"
        + "            O O O O O O O\n"
        + "            O O O O O O O\n"
        + "            O O O O O O O\n"
        + "            O O O O O O O\n"
        + "            O O O O O O O";
    assertEquals(s1, this.mod.toString());
    assertEquals(s2, this.m4.toString());
    assertEquals(s3, this.m6.toString());
  }
}
