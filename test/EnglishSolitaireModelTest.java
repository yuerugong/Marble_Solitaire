import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

/**
 * the {@code EnglishSolitaireModelTest} represent the test for English Solitaire Model.
 */
public class EnglishSolitaireModelTest {

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
   * to test Move method.
   */
  @Test
  public void testMove() {
    this.setUp();
    MarbleSolitaireView view = new MarbleSolitaireTextView(mod);

    String s1 = "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O _ O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O";
    assertEquals(s1, view.toString());

    mod.move(3, 1, 3, 3);

    s1 = "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O _ _ O O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O";

    assertEquals(s1, view.toString());

    this.setUp();
    MarbleSolitaireView view1 = new MarbleSolitaireTextView(mod);

    String s2 = "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O _ O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O";

    assertEquals(s2, view1.toString());

    mod.move(3, 5, 3, 3);

    s2 = "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O O _ _ O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O";
    assertEquals(s2, view1.toString());

    this.setUp();
    MarbleSolitaireView view2 = new MarbleSolitaireTextView(mod);

    String s3 = "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O _ O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O";

    assertEquals(s3, view2.toString());

    mod.move(1, 3, 3, 3);

    s3 = "    O O O\n" +
        "    O _ O\n" +
        "O O O _ O O O\n" +
        "O O O O O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O";
    assertEquals(s3, view2.toString());

    this.setUp();
    MarbleSolitaireView view3 = new MarbleSolitaireTextView(mod);

    String s4 = "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O _ O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O";

    assertEquals(s4, view3.toString());

    mod.move(5, 3, 3, 3);

    s4 = "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O O O O O\n" +
        "O O O _ O O O\n" +
        "    O _ O\n" +
        "    O O O";
    assertEquals(s4, view3.toString());
  }

  /**
   * to test GetSlotAt method.
   */
  @Test
  public void testGetSlotAt() {
    this.setUp();
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.mod.getSlotAt(1, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.mod.getSlotAt(1, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.mod.getSlotAt(5, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.mod.getSlotAt(5, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.mod.getSlotAt(3, 3));

    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.m4.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.m4.getSlotAt(3, 9));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.m4.getSlotAt(9, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.m4.getSlotAt(9, 9));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.m4.getSlotAt(6, 6));

    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.m3.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.m3.getSlotAt(3, 9));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.m3.getSlotAt(9, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.m3.getSlotAt(9, 9));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.m3.getSlotAt(6, 6));
  }

  /**
   * to test GetBoardSize method.
   */
  @Test
  public void testGetBoardSize() {
    this.setUp();
    assertEquals(7, this.mod.getBoardSize());
    assertEquals(13, this.m4.getBoardSize());
    assertEquals(7, this.m1.getBoardSize());
    assertEquals(13, this.m5.getBoardSize());
    assertEquals(13, this.m3.getBoardSize());
    assertEquals(1, this.m2.getBoardSize());


  }

  /**
   * to test IsGameOver method.
   */
  @Test
  public void testIsGameOver() {
    this.setUp();
    assertFalse(mod.isGameOver());
    assertFalse(m1.isGameOver());
    assertFalse(m4.isGameOver());
    assertFalse(m3.isGameOver());
    assertFalse(m6.isGameOver());
  }

  /**
   * to test GetScore method.
   */
  @Test
  public void testGetScore() {
    this.setUp();
    assertEquals(32, mod.getScore());
    assertEquals(32, m1.getScore());
    assertEquals(104, m4.getScore());
    assertEquals(104, m5.getScore());
    assertEquals(216, m6.getScore());

  }


}


















