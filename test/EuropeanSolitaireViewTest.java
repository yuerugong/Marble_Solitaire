import static org.junit.Assert.assertEquals;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import org.junit.Test;

/**
 * the {@code EuropeanSolitaireViewTest} represent European SolitaireModel view class to test all
 * method in EuropeanSolitaireView class.
 */
public class EuropeanSolitaireViewTest {


  /**
   * to test the constructor when the model is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor() {
    MarbleSolitaireModelState model = null;
    Appendable appendable = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, appendable);
  }

  /**
   * to test the tostring method is correct.
   */
  @Test
  public void testInitialBoard() {
    MarbleSolitaireModel mod;
    mod = new EuropeanSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(mod);

    String s1 = "    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O";

    assertEquals(s1, view.toString());

    mod.move(3, 5, 3, 3);

    s1 = "    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O _ _ O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O";

    assertEquals(s1, view.toString());
  }
}
