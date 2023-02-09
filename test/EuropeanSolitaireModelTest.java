import static org.junit.Assert.assertEquals;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import org.junit.Test;

/**
 * the {@code EuropeanSolitaireModelTest} represent European SolitaireModel Test to test all method
 * in EuropeanSolitaireModel class.
 */
public class EuropeanSolitaireModelTest {

  private MarbleSolitaireModel m;

  /**
   * to test the default constructor.
   */
  @Test
  public void testDefaultConstructor() {
    this.m = new EuropeanSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(m);
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", view.toString());
  }

  /**
   * to test the constructor when the user gives an arm thickness.
   */
  @Test
  public void testSingleParameterConstructor() {
    this.m = new EuropeanSolitaireModel(3);
    MarbleSolitaireView view = new MarbleSolitaireTextView(m);
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", view.toString());
  }

  /**
   * to test the constructor when the user gives the place of an empty marble.
   */
  @Test
  public void testConstructorWithRowCol() {
    this.m = new EuropeanSolitaireModel(3, 3);
    MarbleSolitaireView view = new MarbleSolitaireTextView(m);
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", view.toString());
  }

  /**
   * to test the constructor when the user gives arm thickness and the place of an empty marble for
   * board size 5.
   */
  @Test
  public void testConstructorThreeParameter() {
    this.m = new EuropeanSolitaireModel(5, 5, 5);
    MarbleSolitaireView view = new MarbleSolitaireTextView(m);
    assertEquals("        O O O O O\n"
        + "      O O O O O O O\n"
        + "    O O O O O O O O O\n"
        + "  O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O _ O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "  O O O O O O O O O O O\n"
        + "    O O O O O O O O O\n"
        + "      O O O O O O O\n"
        + "        O O O O O", view.toString());
  }

  /**
   * to test the constructor when the user gives arm thickness and the place of an empty marble for
   * board size 3.
   */
  @Test
  public void testConstructorThreeParameter3() {
    this.m = new EuropeanSolitaireModel(3, 3, 3);
    MarbleSolitaireView view = new MarbleSolitaireTextView(m);
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", view.toString());
  }

  /**
   * to test the constructor when the user gives arm thickness and the place of an empty marble for
   * 2 6.
   */
  @Test
  public void testConstructorThreeParameterCustom() {
    this.m = new EuropeanSolitaireModel(3, 2, 6);
    MarbleSolitaireView view = new MarbleSolitaireTextView(m);
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O _\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", view.toString());
  }

  /**
   * to test the constructor when the user gives the negative row.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorRow() {
    this.m = new EuropeanSolitaireModel(-3, 3);
  }

  /**
   * to test the constructor when the user gives the negative col.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorCol() {
    this.m = new EuropeanSolitaireModel(3, -3);
  }

  /**
   * to test the constructor when the user gives the negative row with armThickness.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorRowWithArmThickness() {
    this.m = new EuropeanSolitaireModel(3, -3, 3);
  }

  /**
   * to test the constructor when the user gives the negative col with armThickness.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorColWithArmThickness() {
    this.m = new EuropeanSolitaireModel(3, 3, -3);
  }

  /**
   * to test the constructor when the user gives the longer even armThickness.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorArmOverLong() {
    this.m = new EuropeanSolitaireModel(6, 3, 3);
  }

  /**
   * to test the constructor when the user gives the negative armThickness.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorArmNegative() {
    this.m = new EuropeanSolitaireModel(-3, 3, 3);
  }

  /**
   * to test the constructor when the user gives the longer even armThickness with one argument.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorArmOverLong1() {
    this.m = new EuropeanSolitaireModel(6);
  }

  /**
   * to test the constructor when the user gives the negative armThickness with one argument.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorArmNegative1() {
    this.m = new EuropeanSolitaireModel(-3);
  }

  /**
   * to test the move method when from does not exist.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveFrom() {
    this.m = new EuropeanSolitaireModel(3, 3, 3);
    m.move(6, 6, 4, 6);
  }

  /**
   * to test the move method when to does not exist.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveTo() {
    this.m = new EuropeanSolitaireModel(3, 3, 3);
    m.move(5, 4, 3, 4);
  }

  /**
   * to test the move method when from does have marble.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveFromNoMarble() {
    this.m = new EuropeanSolitaireModel(3, 3, 3);
    m.move(3, 3, 1, 3);
  }

  /**
   * to test the move method when to is not empty.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveToNotEmpty() {
    this.m = new EuropeanSolitaireModel(3, 3, 3);
    m.move(5, 2, 5, 4);
  }

  /**
   * to test the move method when middle is empty.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveMiddleEmpty() {
    this.m = new EuropeanSolitaireModel(3, 3, 3);
    m.move(3, 2, 3, 4);
  }

  /**
   * to test the move method when the from and to positions are more than two positions apart.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidJumpOver() {
    this.m = new EuropeanSolitaireModel(3, 3, 3);
    m.move(3, 0, 3, 3);
  }

  /**
   * to test the move method when the move is diagonal.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveDiagonal() {
    this.m = new EuropeanSolitaireModel(3, 2, 2);
    m.move(4, 4, 2, 2);
  }

  /**
   * to test the move method when the marble move to left.
   */
  @Test
  public void testMoveLeft() {
    this.m = new EuropeanSolitaireModel(3, 3, 3);
    m.move(3, 5, 3, 3);
    MarbleSolitaireView view = new MarbleSolitaireTextView(m);
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O _ _ O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", view.toString());
  }

  /**
   * to test the move method when the marble move to right.
   */
  @Test
  public void testMoveRight() {
    this.m = new EuropeanSolitaireModel(3, 3, 3);
    m.move(3, 1, 3, 3);
    MarbleSolitaireView view = new MarbleSolitaireTextView(m);
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O _ _ O O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", view.toString());

  }

  /**
   * to test the move method when the marble move to up.
   */
  @Test
  public void testMoveUp() {
    this.m = new EuropeanSolitaireModel(3, 3, 3);
    m.move(5, 3, 3, 3);
    MarbleSolitaireView view = new MarbleSolitaireTextView(m);
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "  O O _ O O\n"
        + "    O O O", view.toString());
  }

  /**
   * to test the move method when the marble move to down.
   */
  @Test
  public void testMoveDown() {
    this.m = new EuropeanSolitaireModel(3, 3, 3);
    m.move(1, 3, 3, 3);
    MarbleSolitaireView view = new MarbleSolitaireTextView(m);
    assertEquals("    O O O\n"
        + "  O O _ O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", view.toString());
  }

  /**
   * to test getScore method work correctly.
   */
  @Test
  public void testScore() {
    this.m = new EuropeanSolitaireModel(3, 3, 3);
    assertEquals(36, m.getScore());
    m.move(3, 1, 3, 3);
    assertEquals(35, m.getScore());
    m.move(1, 2, 3, 2);
    assertEquals(34, m.getScore());
  }

  /**
   * to test isGameOver method works correctly when is not finish.
   */
  @Test
  public void testIsGameOverFalse() {
    this.m = new EuropeanSolitaireModel(3, 3, 3);
    assertEquals(false, m.isGameOver());
    m.move(1, 3, 3, 3);
    assertEquals(false, m.isGameOver());

  }

  /**
   * to test isGameOver method works correctly when is finish.
   */
  @Test
  public void testIsGameOverTrue() {
    this.m = new EuropeanSolitaireModel();
    this.m.move(1, 3, 3, 3);
    this.m.move(4, 3, 2, 3);
    this.m.move(6, 3, 4, 3);
    this.m.move(3, 5, 3, 3);
    this.m.move(3, 2, 3, 4);
    this.m.move(3, 0, 3, 2);
    this.m.move(1, 5, 1, 3);
    this.m.move(1, 2, 1, 4);
    this.m.move(5, 5, 5, 3);
    this.m.move(5, 2, 5, 4);
    this.m.move(3, 2, 1, 2);
    this.m.move(1, 1, 1, 3);
    this.m.move(2, 0, 2, 2);
    this.m.move(5, 1, 3, 1);
    this.m.move(4, 3, 4, 1);
    this.m.move(1, 4, 1, 2);
    this.m.move(2, 3, 2, 1);
    this.m.move(2, 5, 2, 3);
    this.m.move(4, 5, 4, 3);
    this.m.move(4, 0, 4, 2);
    this.m.move(0, 2, 2, 2);
    this.m.move(4, 2, 4, 4);
    this.m.move(4, 4, 2, 4);
    this.m.move(2, 2, 2, 0);
    this.m.move(2, 4, 2, 2);
    this.m.move(0, 4, 0, 2);
    this.m.move(6, 4, 4, 4);
    assertEquals(true, this.m.isGameOver());
  }

  /**
   * to test GetBoardSize method.
   */
  @Test
  public void testGetBoardSize() {
    this.m = new EuropeanSolitaireModel();
    assertEquals(7, this.m.getBoardSize());
    this.m = new EuropeanSolitaireModel(5);
    assertEquals(13, this.m.getBoardSize());
  }

  /**
   * to test GetSlotAt method.
   */
  @Test
  public void testGetSlotAt() {
    this.m = new EuropeanSolitaireModel();
    assertEquals(SlotState.Marble, this.m.getSlotAt(3, 1));
    assertEquals(SlotState.Marble, this.m.getSlotAt(3, 2));
    assertEquals(SlotState.Empty, this.m.getSlotAt(3, 3));
    m.move(3, 1, 3, 3);
    assertEquals(SlotState.Empty, this.m.getSlotAt(3, 1));
    assertEquals(SlotState.Empty, this.m.getSlotAt(3, 2));
    assertEquals(SlotState.Marble, this.m.getSlotAt(3, 3));
  }
}












