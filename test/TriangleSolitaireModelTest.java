import static org.junit.Assert.assertEquals;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;
import org.junit.Test;

/**
 * the {@code TriangleSolitaireModelTest} represent Triangle SolitaireModel Test * to test all
 * method in TriangleSolitaireModel class..
 */
public class TriangleSolitaireModelTest {

  private MarbleSolitaireModel m;

  /**
   * to test the default constructor.
   */
  @Test
  public void testDefaultConstructor() {
    this.m = new TriangleSolitaireModel();
    MarbleSolitaireView view = new TriangleSolitaireTextView(m);
    assertEquals("    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O", view.toString());
  }

  /**
   * to test the constructor when the user gives an arm thickness.
   */
  @Test
  public void testSingleParameterConstructor() {
    this.m = new TriangleSolitaireModel(3);
    MarbleSolitaireView view = new TriangleSolitaireTextView(m);
    assertEquals("  _\n"
        + " O O\n"
        + "O O O", view.toString());
  }

  /**
   * to test the constructor when the user gives the place of an empty marble.
   */
  @Test
  public void testConstructorWithRowCol() {
    this.m = new TriangleSolitaireModel(3, 3);
    MarbleSolitaireView view = new TriangleSolitaireTextView(m);
    assertEquals("    O\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O _\n"
        + "O O O O O", view.toString());
  }

  /**
   * to test the constructor when the user gives arm thickness and the place of an empty marble for
   * board size 5.
   */
  @Test
  public void testConstructorThreeParameter() {
    this.m = new TriangleSolitaireModel(5, 0, 0);
    MarbleSolitaireView view = new TriangleSolitaireTextView(m);
    assertEquals("    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O", view.toString());
  }

  /**
   * to test the constructor when the user gives arm thickness and the place of an empty marble for
   * board size 3.
   */
  @Test
  public void testConstructorThreeParameter3() {
    this.m = new TriangleSolitaireModel(3, 2, 1);
    MarbleSolitaireView view = new TriangleSolitaireTextView(m);
    assertEquals("  O\n"
        + " O O\n"
        + "O _ O", view.toString());
  }

  /**
   * to test the constructor when the user gives arm thickness and the place of an empty marble for
   * 1 0.
   */
  @Test
  public void testConstructorThreeParameterCustom() {
    this.m = new TriangleSolitaireModel(5, 1, 0);
    MarbleSolitaireView view = new TriangleSolitaireTextView(m);
    assertEquals("    O\n"
        + "   _ O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O", view.toString());
  }

  /**
   * to test the constructor when the user gives the negative row.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorRow() {
    this.m = new TriangleSolitaireModel(-1, 0);
    MarbleSolitaireView view = new TriangleSolitaireTextView(m);
    assertEquals("", view.toString());
  }

  /**
   * to test the constructor when the user gives the negative col.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorCol() {
    this.m = new TriangleSolitaireModel(0, -1);
    MarbleSolitaireView view = new TriangleSolitaireTextView(m);
    assertEquals("", view.toString());
  }

  /**
   * to test the constructor when the user gives the negative row with armThickness.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorRowWithArmThickness() {
    this.m = new TriangleSolitaireModel(3, -3, 3);
  }

  /**
   * to test the constructor when the user gives the negative col with armThickness.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorColWithArmThickness() {
    this.m = new TriangleSolitaireModel(3, 3, -3);
  }


  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorOutBoard() {
    this.m = new TriangleSolitaireModel(3, 0, 5);
    assertEquals("", m.toString());
  }

  /**
   * to test the constructor when the user gives the negative armThickness.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorArmNegative() {
    this.m = new TriangleSolitaireModel(-5, 3, 3);
  }

  /**
   * to test the constructor when the user gives the negative armThickness with one argument.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorArmNegative1() {
    this.m = new TriangleSolitaireModel(-3);
  }

  /**
   * to test the move method when from does not exist.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveFrom() {
    this.m = new TriangleSolitaireModel(5, 3, 1);
    m.move(5, 6, 5, 4);
  }

  /**
   * to test the move method when to does not exist.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveTo() {
    this.m = new EuropeanSolitaireModel(5, 3, 1);
    m.move(5, 4, 5, 6);
  }

  /**
   * to test the move method when from does have marble.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveFromNoMarble() {
    this.m = new EuropeanSolitaireModel(5, 3, 1);
    m.move(3, 1, 1, 1);
  }

  /**
   * to test the move method when to is not empty.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveToNotEmpty() {
    this.m = new EuropeanSolitaireModel(5, 3, 1);
    m.move(5, 2, 3, 2);
  }

  /**
   * to test the move method when middle is empty.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveMiddleEmpty() {
    this.m = new EuropeanSolitaireModel(5, 3, 1);
    m.move(4, 1, 2, 1);
  }

  /**
   * to test the move method when the from and to positions are more than two positions apart.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidJumpOver1() {
    this.m = new EuropeanSolitaireModel(5, 3, 1);
    m.move(4, 0, 4, 3);
  }

  /**
   * to test the move method when the from and to positions are more than two positions apart.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidJumpOver2() {
    this.m = new TriangleSolitaireModel(5, 3, 2);
    m.move(5, 0, 3, 2);
  }

  /**
   * to test the move method when the marble move to left.
   */
  @Test
  public void testMoveLeft() {
    this.m = new TriangleSolitaireModel(5, 3, 1);
    m.move(3, 3, 3, 1);
    MarbleSolitaireView view = new TriangleSolitaireTextView(m);
    assertEquals("    O\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O _ _\n"
        + "O O O O O", view.toString());
  }

  /**
   * to test the move method when the marble move to right.
   */
  @Test
  public void testMoveRight() {
    this.m = new TriangleSolitaireModel(5, 3, 2);
    m.move(3, 0, 3, 2);
    MarbleSolitaireView view = new TriangleSolitaireTextView(m);
    assertEquals("    O\n"
        + "   O O\n"
        + "  O O O\n"
        + " _ _ O O\n"
        + "O O O O O", view.toString());

  }

  /**
   * to test the move method when the marble move to up.
   */
  @Test
  public void testMoveUp() {
    this.m = new TriangleSolitaireModel(6, 3, 1);
    m.move(5, 1, 3, 1);
    MarbleSolitaireView view = new TriangleSolitaireTextView(m);
    assertEquals("     O\n"
        + "    O O\n"
        + "   O O O\n"
        + "  O O O O\n"
        + " O _ O O O\n"
        + "O _ O O O O", view.toString());
  }

  /**
   * to test the move method when the marble move to down.
   */
  @Test
  public void testMoveDown() {
    this.m = new TriangleSolitaireModel(6, 3, 1);
    m.move(1, 1, 3, 1);
    MarbleSolitaireView view = new TriangleSolitaireTextView(m);
    assertEquals("     O\n"
        + "    O _\n"
        + "   O _ O\n"
        + "  O O O O\n"
        + " O O O O O\n"
        + "O O O O O O", view.toString());
  }

  /**
   * to test the move method when the marble move Up with diagonal.
   */
  @Test
  public void testMoveUpDiagonal() {
    this.m = new TriangleSolitaireModel(6, 3, 1);
    m.move(5, 3, 3, 1);
    MarbleSolitaireView view = new TriangleSolitaireTextView(m);
    assertEquals("     O\n"
        + "    O O\n"
        + "   O O O\n"
        + "  O O O O\n"
        + " O O _ O O\n"
        + "O O O _ O O", view.toString());
  }

  /**
   * to test the move method when the marble move down with diagonal.
   */
  @Test
  public void testMoveDownDiagonal() {
    this.m = new TriangleSolitaireModel(6, 5, 3);
    m.move(3, 1, 5, 3);
    MarbleSolitaireView view = new TriangleSolitaireTextView(m);
    assertEquals("     O\n"
        + "    O O\n"
        + "   O O O\n"
        + "  O _ O O\n"
        + " O O _ O O\n"
        + "O O O O O O", view.toString());
  }

  /**
   * to test getScore method work correctly.
   */
  @Test
  public void testScore() {
    this.m = new TriangleSolitaireModel(5, 4, 2);
    assertEquals(14, m.getScore());
    m.move(2, 2, 4, 2);
    assertEquals(13, m.getScore());

  }

  /**
   * to test isGameOver method works correctly when is not finish.
   */
  @Test
  public void testIsGameOverFalse1() {
    this.m = new TriangleSolitaireModel(6, 3, 1);
    assertEquals(false, m.isGameOver());
    m.move(1, 1, 3, 1);
    assertEquals(false, m.isGameOver());
  }

  /**
   * move several times to test isGameOver method works correctly when is not finish.
   */
  @Test
  public void testIsGameOverFalse2() {
    this.m = new TriangleSolitaireModel(5, 4, 2);
    m.move(4, 4, 4, 2);
    m.move(4, 1, 4, 3);
    m.move(2, 1, 4, 1);
    m.move(2, 2, 4, 2);
    m.move(4, 2, 4, 4);
    m.move(4, 4, 2, 2);
    m.move(1, 1, 3, 3);
    m.move(4, 0, 4, 2);
    m.move(2, 0, 4, 0);
    assertEquals(false, m.isGameOver());
  }

  /**
   * to test isGameOver method works correctly when is finish.
   */
  @Test
  public void testIsGameOverTrue() {
    this.m = new TriangleSolitaireModel(3);
    m.move(2, 0, 0, 0);
    m.move(2, 2, 2, 0);
    m.move(0, 0, 2, 2);
    assertEquals(true, this.m.isGameOver());
  }

  /**
   * to test GetBoardSize method.
   */
  @Test
  public void testGetBoardSize() {
    this.m = new TriangleSolitaireModel();
    assertEquals(5, this.m.getBoardSize());
    this.m = new TriangleSolitaireModel(6);
    assertEquals(6, this.m.getBoardSize());
  }

  /**
   * to test GetSlotAt method.
   */
  @Test
  public void testGetSlotAt() {
    this.m = new TriangleSolitaireModel(6, 3, 1);
    assertEquals(SlotState.Marble, this.m.getSlotAt(1, 1));
    assertEquals(SlotState.Marble, this.m.getSlotAt(2, 1));
    assertEquals(SlotState.Empty, this.m.getSlotAt(3, 1));
    m.move(1, 1, 3, 1);
    assertEquals(SlotState.Empty, this.m.getSlotAt(1, 1));
    assertEquals(SlotState.Empty, this.m.getSlotAt(2, 1));
    assertEquals(SlotState.Marble, this.m.getSlotAt(3, 1));
  }
}



































































