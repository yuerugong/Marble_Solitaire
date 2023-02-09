
import static org.junit.Assert.assertEquals;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;
import org.junit.Test;

/**
 * the {@code TriangleSolitaireViewTest} represent Triangle SolitaireModel view class to test all
 * method in TriangleSolitaireView class.
 */
public class TriangleSolitaireViewTest {


  /**
   * to test the constructor when the model is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor() {
    MarbleSolitaireModelState model = null;
    Appendable appendable = new StringBuilder();
    MarbleSolitaireView view = new TriangleSolitaireTextView(model, appendable);
  }

  /**
   * to test the tostring method is correct.
   */
  @Test
  public void testInitialBoard() {
    MarbleSolitaireModel mod;
    mod = new TriangleSolitaireModel();
    MarbleSolitaireView view = new TriangleSolitaireTextView(mod);

    String s1 = "    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O";

    assertEquals(s1, view.toString());

    mod.move(2, 2, 0, 0);

    s1 = "    O\n"
        + "   O _\n"
        + "  O O _\n"
        + " O O O O\n"
        + "O O O O O";

    assertEquals(s1, view.toString());
  }
}