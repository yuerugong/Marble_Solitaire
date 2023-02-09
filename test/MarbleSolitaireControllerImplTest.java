import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MockModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import java.io.StringReader;
import org.junit.Test;

/**
 * the {@code MarbleSolitaireControllerImplTest} represent the test for the methods in
 * MarbleSolitaireControllerImpl class.
 */
public class MarbleSolitaireControllerImplTest {

  /**
   * to test the Model.
   */
  @Test
  public void testModelMock() {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("4 2 4 -4 4 Q");
    MarbleSolitaireModel model = new MockModel(testOut);
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    controller.playGame();
    assertEquals("\nScore: 0\n"
        + "\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "\n"
        + "Score: 0", testOut.toString());
  }

  /**
   * to test the constructor when model is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testModelNull() {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("4 2 b 4 4 Q");
    MarbleSolitaireModel model = null;
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    controller.playGame();
  }

  /**
   * to test the constructor when view is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testViewNull() {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("4 2 b 4 4 Q");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = null;
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    controller.playGame();
  }

  /**
   * to test the constructor when readable is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testReadableNull() {
    Appendable testOut = new StringBuilder();
    Readable testIn = null;
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    controller.playGame();
  }

  /**
   * to test when the user input a word.
   */
  @Test(expected = IllegalStateException.class)
  public void testInvalidResultString() {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("Hi");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    try {
      controller.playGame();
      fail();
    } catch (IllegalStateException e) {
      assertEquals("Invalid enter", e.getMessage());
    }
    controller.playGame();
  }

  /**
   * to test when the user input a negative.
   */
  @Test(expected = IllegalStateException.class)
  public void testInvalidResultNum() {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("-7");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    try {
      controller.playGame();
      fail();
    } catch (IllegalStateException e) {
      assertEquals("Invalid enter", e.getMessage());
    }
    controller.playGame();
  }

  /**
   * to test when the user input a invalid num.
   */
  @Test(expected = IllegalStateException.class)
  public void testInvalidResultOutBoard() {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("4 6 2 6");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    try {
      controller.playGame();
      fail();
    } catch (IllegalStateException e) {
      assertEquals("Invalid enter", e.getMessage());
    }
    controller.playGame();
  }

  /**
   * to test when the user input a invalid move.
   */
  @Test(expected = IllegalStateException.class)
  public void testInvalidResultInvalidMove() {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("2 5 6 4");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    try {
      controller.playGame();
      fail();
    } catch (IllegalStateException e) {
      assertEquals("Invalid enter", e.getMessage());
    }
    controller.playGame();
  }

  /**
   * to test when the user input an empty.
   */
  @Test(expected = IllegalStateException.class)
  public void testInvalidResultEmpty() {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    try {
      controller.playGame();
      fail();
    } catch (IllegalStateException e) {
      assertEquals("Invalid enter", e.getMessage());
    }
    controller.playGame();
  }

  /**
   * to test when the user input a letter.
   */
  @Test(expected = IllegalStateException.class)
  public void testInvalidResultLetter() {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("A");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    try {
      controller.playGame();
      fail();
    } catch (IllegalStateException e) {
      assertEquals("Invalid enter", e.getMessage());
    }
    controller.playGame();
  }

  /**
   * to test when the user input a num with letter.
   */
  @Test(expected = IllegalStateException.class)
  public void testInvalidResultLetterMix() {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("7b6 7 5 3");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    try {
      controller.playGame();
      fail();
    } catch (IllegalStateException e) {
      assertEquals("Invalid enter", e.getMessage());
    }
    controller.playGame();
  }

  /**
   * to test when the user input a zero.
   */
  @Test(expected = IllegalStateException.class)
  public void testInvalidResultLetterZero() {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("0");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    try {
      controller.playGame();
      fail();
    } catch (IllegalStateException e) {
      assertEquals("Invalid enter", e.getMessage());
    }
    controller.playGame();
  }

  /**
   * to test when the user input's nums not enough.
   */
  @Test(expected = IllegalStateException.class)
  public void testInvalidResultLetterNotEnough() {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("2 4");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    try {
      controller.playGame();
      fail();
    } catch (IllegalStateException e) {
      assertEquals("Invalid enter", e.getMessage());
    }
    controller.playGame();
  }

  /**
   * to test when the user input's nums not enough for the second move.
   */
  @Test(expected = IllegalStateException.class)
  public void testInvalidResultLetterNotEnough1() {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader(" 2 4 4 4 5 7");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    try {
      controller.playGame();
      fail();
    } catch (IllegalStateException e) {
      assertEquals("Invalid enter", e.getMessage());
    }
    controller.playGame();
  }

  /**
   * to test when the user inputs Q twice.
   */
  @Test
  public void playGameDoubleQ() throws Exception {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("4 2 4 4 Q 2 3 4 3 Q");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O _ _ O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O _ _ O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31", testOut.toString());
  }

  /**
   * to test when the user inputs q twice.
   */
  @Test
  public void playGameDoubleq() throws Exception {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("4 2 4 4 q 2 3 4 3 q");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O _ _ O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O _ _ O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31", testOut.toString());
  }

  /**
   * to test when the user inputs a move with \n.
   */
  @Test
  public void playGameSlash() throws Exception {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("4 6 \n 4 4 Q");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O _ _ O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O _ _ O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31", testOut.toString());

  }

  /**
   * to test when the user inputs the move with a letter with Q.
   */
  @Test
  public void playGameWithb_Q() throws Exception {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("4 2 b 4 4 Q");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O _ _ O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O _ _ O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31", testOut.toString());
  }

  /**
   * to test when the user inputs the move with a negative num with Q.
   */
  @Test
  public void playGameWithNegativeToCol_Q() throws Exception {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("4 2 4 -4 4 Q");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O _ _ O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O _ _ O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31", testOut.toString());
  }

  /**
   * to test when the user inputs the move with a negative at front with Q.
   */
  @Test
  public void playGameWithNegativeBad_Q() throws Exception {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("-2 4 2 4 4 Q");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O _ _ O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O _ _ O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31", testOut.toString());
  }

  /**
   * to test when the user inputs the move with a negative to row with Q.
   */
  @Test
  public void playGameWithNegativeToRow_Q() throws Exception {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("2 4 4 -4 4 Q");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "\n"
        + "    O O O\n"
        + "    O _ O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O _ O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31", testOut.toString());
  }

  /**
   * to test when the user inputs the move with a negative from row with Q.
   */
  @Test
  public void playGameWithNegativeFromRow_Q() throws Exception {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("6 4 4 -4 4 Q");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "    O _ O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "    O _ O\n"
        + "    O O O\n"
        + "Score: 31", testOut.toString());
  }

  /**
   * to test when the user inputs the move with a negative from col with Q.
   */
  @Test
  public void playGameWithNegativeFromCol_Q() throws Exception {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("4 -4 6 4 4 Q");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O _ _ O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O _ _ O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31", testOut.toString());
  }

  /**
   * to test when the user inputs the move with a negative to col with Q.
   */
  @Test
  public void playGameWithb_q() throws Exception {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("4 2 b 4 4 q");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O _ _ O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O _ _ O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31", testOut.toString());
  }

  /**
   * to test when the user inputs the move with a negative to col with q.
   */
  @Test
  public void playGameWithNegativeToCol_q() throws Exception {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("4 2 4 -4 4 q");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O _ _ O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O _ _ O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31", testOut.toString());
  }

  /**
   * to test when the user inputs the move with a negative bad with q.
   */
  @Test
  public void playGameWithNegativeBad_q() throws Exception {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("-2 4 2 4 4 q");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O _ _ O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O _ _ O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31", testOut.toString());
  }

  /**
   * to test when the user inputs the move with a negative to row with q.
   */
  @Test
  public void playGameWithNegativeToRow_q() throws Exception {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("2 4 4 -4 4 q");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "\n"
        + "    O O O\n"
        + "    O _ O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O _ O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31", testOut.toString());
  }

  /**
   * to test when the user inputs the move with a negative from row with q.
   */
  @Test
  public void playGameWithNegativeFromRow_q() throws Exception {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("6 4 4 -4 4 q");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "    O _ O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "    O _ O\n"
        + "    O O O\n"
        + "Score: 31", testOut.toString());
  }

  /**
   * to test when the user inputs the move with a negative from col with q.
   */
  @Test
  public void playGameWithNegativeFromCol_q() throws Exception {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("4 -4 6 4 4 q");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O _ _ O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O _ _ O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31", testOut.toString());
  }

  /**
   * to test when the user inputs the move left with Q.
   */
  @Test
  public void playGameLeftQ() throws Exception {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("4 6 4 4 Q");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O _ _ O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O _ _ O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31", testOut.toString());

  }

  /**
   * to test when the user inputs the move right with Q.
   */
  @Test
  public void playGameRightQ() throws Exception {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("4 2 4 4 Q");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O _ _ O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O _ _ O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31", testOut.toString());
  }

  /**
   * to test when the user inputs the move left with Q.
   */
  @Test
  public void playGameDownQ() throws Exception {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("2 4 4 4 Q");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "\n"
        + "    O O O\n"
        + "    O _ O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O _ O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31", testOut.toString());
  }

  /**
   * to test when the user inputs the move up with Q.
   */
  @Test
  public void playGameUpQ() throws Exception {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("6 4 4 4 Q");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "    O _ O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "    O _ O\n"
        + "    O O O\n"
        + "Score: 31", testOut.toString());
  }

  /**
   * to test when the user inputs the move left with q.
   */
  @Test
  public void playGameLeftq() throws Exception {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("4 6 4 4 q");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O _ _ O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O _ _ O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31", testOut.toString());

  }

  /**
   * to test when the user inputs the move right with q.
   */
  @Test
  public void playGameRightq() throws Exception {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("4 2 4 4 q");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O _ _ O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O _ _ O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31", testOut.toString());
  }

  /**
   * to test when the user inputs the move down with q.
   */
  @Test
  public void playGameDownq() throws Exception {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("2 4 4 4 q");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "\n"
        + "    O O O\n"
        + "    O _ O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O _ O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31", testOut.toString());
  }

  /**
   * to test when the user inputs the move up with q.
   */
  @Test
  public void playGameUpq() throws Exception {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("6 4 4 4 q");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "    O _ O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "    O _ O\n"
        + "    O O O\n"
        + "Score: 31", testOut.toString());
  }

  /**
   * to test when the user inputs the q inside of num.
   */
  @Test
  public void playGame4q2() throws Exception {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("4 q 2");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32", testOut.toString());
  }

  /**
   * to test when the user inputs the q inside of num.
   */
  @Test
  public void playGameq42() throws Exception {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("q 4 2");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32", testOut.toString());
  }

  /**
   * to test when the user inputs the q inside of num.
   */
  @Test
  public void playGame42q() throws Exception {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("4 2 q");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32", testOut.toString());
  }

  /**
   * to test when the user inputs the q inside of num.
   */
  @Test
  public void playGame424q4() throws Exception {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("4 2 4 q 4");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32", testOut.toString());
  }

  /**
   * to test when the user inputs the q inside of num.
   */
  @Test
  public void playGame42442343q() throws Exception {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("4 2 4 4 2 3 4 3 q");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O _ _ O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "\n"
        + "    O O O\n"
        + "    _ O O\n"
        + "O O _ O O O O\n"
        + "O _ O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 30\n"
        + "\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    _ O O\n"
        + "O O _ O O O O\n"
        + "O _ O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 30", testOut.toString());
  }

  /**
   * to test when the user inputs the q inside of num.
   */
  @Test
  public void playGame4244234q() throws Exception {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("4 2 4 4 2 3 4 q");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O _ _ O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O _ _ O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31", testOut.toString());
  }

  /**
   * to test when the user inputs the Q inside of num.
   */
  @Test
  public void playGame4Q2() throws Exception {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("4 Q 2");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32", testOut.toString());
  }

  /**
   * to test when the user inputs the Q inside of num.
   */
  @Test
  public void playGameQ42() throws Exception {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("Q 4 2");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32", testOut.toString());
  }

  /**
   * to test when the user inputs the Q inside of num.
   */
  @Test
  public void playGame42Q() throws Exception {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("4 2 Q");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32", testOut.toString());
  }

  /**
   * to test when the user inputs the Q inside of num.
   */
  @Test
  public void playGame424Q4() throws Exception {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("4 2 4 Q 4");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32", testOut.toString());
  }

  /**
   * to test when the user inputs the Q inside of num.
   */
  @Test
  public void playGame42442343Q() throws Exception {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("4 2 4 4 2 3 4 3 Q");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O _ _ O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "\n"
        + "    O O O\n"
        + "    _ O O\n"
        + "O O _ O O O O\n"
        + "O _ O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 30\n"
        + "\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    _ O O\n"
        + "O O _ O O O O\n"
        + "O _ O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 30", testOut.toString());
  }

  /**
   * to test when the user inputs the Q inside of num.
   */
  @Test
  public void playGame4244234Q() throws Exception {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("4 2 4 4 2 3 4 Q");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O _ _ O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O _ _ O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31", testOut.toString());
  }

  /**
   * to test when the user inputs the num till win.
   */
  @Test
  public void playGameWin() throws Exception {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader(new StringBuilder().
        append("2 4 4 4 3 6 3 4 1 5 3 5 4 5 2 5 6 5 4 5 5 7 5 5 5 4 5 6 3 7 5 7 5 7 5 5")
        .append(" 3 3 3 5 3 1 3 3 5 2 5 4 5 4 5 6 5 6 3 6 3 6 3 4 3 ")
        .append("4 3 2 1 3 1 5 1 5 3 5 3 5 5 5 7 3 5 3 4 ")
        .append(
            "3 6 3 7 5 7 3 7 3 5 3 5 1 3 1 3 1 3 3 2 3 4 3 4 3 6 3 6 3 6 5 6 5 4 5 4 5 4 3 4 2 4 4")
        .toString());
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "\n"
        + "    O O O\n"
        + "    O _ O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "\n"
        + "    O O O\n"
        + "    O _ O\n"
        + "O O O O _ _ O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 30\n"
        + "\n"
        + "    O O _\n"
        + "    O _ _\n"
        + "O O O O O _ O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 29\n"
        + "\n"
        + "    O O _\n"
        + "    O _ O\n"
        + "O O O O _ _ O\n"
        + "O O O O _ O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 28\n"
        + "\n"
        + "    O O _\n"
        + "    O _ O\n"
        + "O O O O _ _ O\n"
        + "O O O O O O O\n"
        + "O O O O _ O O\n"
        + "    O O _\n"
        + "    O O O\n"
        + "Score: 27\n"
        + "\n"
        + "    O O _\n"
        + "    O _ O\n"
        + "O O O O _ _ O\n"
        + "O O O O O O O\n"
        + "O O O O O _ _\n"
        + "    O O _\n"
        + "    O O O\n"
        + "Score: 26\n"
        + "\n"
        + "    O O _\n"
        + "    O _ O\n"
        + "O O O O _ _ O\n"
        + "O O O O O O O\n"
        + "O O O _ _ O _\n"
        + "    O O _\n"
        + "    O O O\n"
        + "Score: 25\n"
        + "\n"
        + "    O O _\n"
        + "    O _ O\n"
        + "O O O O _ _ _\n"
        + "O O O O O O _\n"
        + "O O O _ _ O O\n"
        + "    O O _\n"
        + "    O O O\n"
        + "Score: 24\n"
        + "\n"
        + "    O O _\n"
        + "    O _ O\n"
        + "O O O O _ _ _\n"
        + "O O O O O O _\n"
        + "O O O _ O _ _\n"
        + "    O O _\n"
        + "    O O O\n"
        + "Score: 23\n"
        + "\n"
        + "    O O _\n"
        + "    O _ O\n"
        + "O O _ _ O _ _\n"
        + "O O O O O O _\n"
        + "O O O _ O _ _\n"
        + "    O O _\n"
        + "    O O O\n"
        + "Score: 22\n"
        + "\n"
        + "    O O _\n"
        + "    O _ O\n"
        + "_ _ O _ O _ _\n"
        + "O O O O O O _\n"
        + "O O O _ O _ _\n"
        + "    O O _\n"
        + "    O O O\n"
        + "Score: 21\n"
        + "\n"
        + "    O O _\n"
        + "    O _ O\n"
        + "_ _ O _ O _ _\n"
        + "O O O O O O _\n"
        + "O _ _ O O _ _\n"
        + "    O O _\n"
        + "    O O O\n"
        + "Score: 20\n"
        + "\n"
        + "    O O _\n"
        + "    O _ O\n"
        + "_ _ O _ O _ _\n"
        + "O O O O O O _\n"
        + "O _ _ _ _ O _\n"
        + "    O O _\n"
        + "    O O O\n"
        + "Score: 19\n"
        + "\n"
        + "    O O _\n"
        + "    O _ O\n"
        + "_ _ O _ O O _\n"
        + "O O O O O _ _\n"
        + "O _ _ _ _ _ _\n"
        + "    O O _\n"
        + "    O O O\n"
        + "Score: 18\n"
        + "\n"
        + "    O O _\n"
        + "    O _ O\n"
        + "_ _ O O _ _ _\n"
        + "O O O O O _ _\n"
        + "O _ _ _ _ _ _\n"
        + "    O O _\n"
        + "    O O O\n"
        + "Score: 17\n"
        + "\n"
        + "    O O _\n"
        + "    O _ O\n"
        + "_ O _ _ _ _ _\n"
        + "O O O O O _ _\n"
        + "O _ _ _ _ _ _\n"
        + "    O O _\n"
        + "    O O O\n"
        + "Score: 16\n"
        + "\n"
        + "    _ _ O\n"
        + "    O _ O\n"
        + "_ O _ _ _ _ _\n"
        + "O O O O O _ _\n"
        + "O _ _ _ _ _ _\n"
        + "    O O _\n"
        + "    O O O\n"
        + "Score: 15\n"
        + "\n"
        + "    _ _ _\n"
        + "    O _ _\n"
        + "_ O _ _ O _ _\n"
        + "O O O O O _ _\n"
        + "O _ _ _ _ _ _\n"
        + "    O O _\n"
        + "    O O O\n"
        + "Score: 14\n"
        + "\n"
        + "    _ _ _\n"
        + "    O _ _\n"
        + "_ O _ _ _ _ _\n"
        + "O O O O _ _ _\n"
        + "O _ _ _ O _ _\n"
        + "    O O _\n"
        + "    O O O\n"
        + "Score: 13\n"
        + "\n"
        + "    _ _ _\n"
        + "    O _ _\n"
        + "_ O _ _ _ _ _\n"
        + "O O O O _ _ _\n"
        + "O _ O _ O _ _\n"
        + "    _ O _\n"
        + "    _ O O\n"
        + "Score: 12\n"
        + "\n"
        + "    _ _ _\n"
        + "    O _ _\n"
        + "_ O _ _ _ _ _\n"
        + "O O _ O _ _ _\n"
        + "O _ _ _ O _ _\n"
        + "    O O _\n"
        + "    _ O O\n"
        + "Score: 11\n"
        + "\n"
        + "    _ _ _\n"
        + "    O _ _\n"
        + "_ O _ _ _ _ _\n"
        + "O O _ O _ _ _\n"
        + "O _ _ _ O _ _\n"
        + "    O O _\n"
        + "    O _ _\n"
        + "Score: 10\n"
        + "\n"
        + "    _ _ _\n"
        + "    O _ _\n"
        + "_ O _ _ _ _ _\n"
        + "O O _ O _ _ _\n"
        + "O _ O _ O _ _\n"
        + "    _ O _\n"
        + "    _ _ _\n"
        + "Score: 9\n"
        + "\n"
        + "    _ _ _\n"
        + "    O _ _\n"
        + "O O _ _ _ _ _\n"
        + "_ O _ O _ _ _\n"
        + "_ _ O _ O _ _\n"
        + "    _ O _\n"
        + "    _ _ _\n"
        + "Score: 8\n"
        + "\n"
        + "    _ _ _\n"
        + "    O _ _\n"
        + "_ _ O _ _ _ _\n"
        + "_ O _ O _ _ _\n"
        + "_ _ O _ O _ _\n"
        + "    _ O _\n"
        + "    _ _ _\n"
        + "Score: 7\n"
        + "\n"
        + "    _ _ _\n"
        + "    _ _ _\n"
        + "_ _ _ _ _ _ _\n"
        + "_ O O O _ _ _\n"
        + "_ _ O _ O _ _\n"
        + "    _ O _\n"
        + "    _ _ _\n"
        + "Score: 6\n"
        + "\n"
        + "    _ _ _\n"
        + "    _ _ _\n"
        + "_ _ _ _ _ _ _\n"
        + "_ O _ O _ _ _\n"
        + "_ _ _ _ O _ _\n"
        + "    O O _\n"
        + "    _ _ _\n"
        + "Score: 5\n"
        + "\n"
        + "    _ _ _\n"
        + "    _ _ _\n"
        + "_ _ _ _ _ _ _\n"
        + "_ O _ O _ _ _\n"
        + "_ _ _ _ O _ _\n"
        + "    _ _ O\n"
        + "    _ _ _\n"
        + "Score: 4\n"
        + "\n"
        + "    _ _ _\n"
        + "    _ _ _\n"
        + "_ _ _ _ _ _ _\n"
        + "_ O _ O O _ _\n"
        + "_ _ _ _ _ _ _\n"
        + "    _ _ _\n"
        + "    _ _ _\n"
        + "Score: 3\n"
        + "\n"
        + "    _ _ _\n"
        + "    _ _ _\n"
        + "_ _ _ _ _ _ _\n"
        + "_ O O _ _ _ _\n"
        + "_ _ _ _ _ _ _\n"
        + "    _ _ _\n"
        + "    _ _ _\n"
        + "Score: 2\n"
        + "\n"
        + "    _ _ _\n"
        + "    _ _ _\n"
        + "_ _ _ _ _ _ _\n"
        + "_ _ _ O _ _ _\n"
        + "_ _ _ _ _ _ _\n"
        + "    _ _ _\n"
        + "    _ _ _\n"
        + "Score: 1\n"
        + "Game over!\n"
        + "    _ _ _\n"
        + "    _ _ _\n"
        + "_ _ _ _ _ _ _\n"
        + "_ _ _ O _ _ _\n"
        + "_ _ _ _ _ _ _\n"
        + "    _ _ _\n"
        + "    _ _ _\n"
        + "Score: 1", testOut.toString());
  }

  /**
   * to test when the user inputs the num till game over.
   */
  @Test
  public void playGameFinish() throws Exception {
    Appendable testOut = new StringBuilder();
    Readable testIn = new StringReader("2 4 4 4 5 4 3 4 7 4 5 4 4 6 4 4 4 3 4 5 4 1 4 3");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, testOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, testIn);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "\n"
        + "    O O O\n"
        + "    O _ O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "\n"
        + "    O O O\n"
        + "    O _ O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O _ O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 30\n"
        + "\n"
        + "    O O O\n"
        + "    O _ O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O _ O\n"
        + "    O _ O\n"
        + "Score: 29\n"
        + "\n"
        + "    O O O\n"
        + "    O _ O\n"
        + "O O O O O O O\n"
        + "O O O O _ _ O\n"
        + "O O O O O O O\n"
        + "    O _ O\n"
        + "    O _ O\n"
        + "Score: 28\n"
        + "\n"
        + "    O O O\n"
        + "    O _ O\n"
        + "O O O O O O O\n"
        + "O O _ _ O _ O\n"
        + "O O O O O O O\n"
        + "    O _ O\n"
        + "    O _ O\n"
        + "Score: 27\n"
        + "\n"
        + "    O O O\n"
        + "    O _ O\n"
        + "O O O O O O O\n"
        + "_ _ O _ O _ O\n"
        + "O O O O O O O\n"
        + "    O _ O\n"
        + "    O _ O\n"
        + "Score: 26\n"
        + "Game over!\n"
        + "    O O O\n"
        + "    O _ O\n"
        + "O O O O O O O\n"
        + "_ _ O _ O _ O\n"
        + "O O O O O O O\n"
        + "    O _ O\n"
        + "    O _ O\n"
        + "Score: 26", testOut.toString());
  }

}

























