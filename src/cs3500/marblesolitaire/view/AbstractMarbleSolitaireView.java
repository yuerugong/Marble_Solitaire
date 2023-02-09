package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

import java.io.IOException;

/**
 * the {@code AbstractMarbleSolitaireView} represent the Abstract MarbleSolitaire View class to
 * abstract view.
 */
public class AbstractMarbleSolitaireView implements MarbleSolitaireView {

  public Appendable appendable;
  public MarbleSolitaireModelState model;

  /**
   * the constructor for AbstractMarbleSolitaireView class with model and appendable.
   *
   * @param model      the model of the game.
   * @param appendable the appendable of the game.
   */
  public AbstractMarbleSolitaireView(MarbleSolitaireModelState model, Appendable appendable) {
    if (model == null || appendable == null) {
      throw new IllegalArgumentException("Please give correct parameters");
    }
    this.model = model;
    this.appendable = appendable;
  }

  /**
   * the constructor for AbstractMarbleSolitaireView class with model.
   *
   * @param model the model of the game.
   */
  public AbstractMarbleSolitaireView(MarbleSolitaireModelState model) {
    this(model, System.out);
  }

  /**
   * the toString method return null.
   *
   * @return the empty
   */
  @Override
  public String toString() {
    return "";
  }

  /**
   * render the board to the given destination.
   *
   * @throws IOException if transmission the board fails
   */
  @Override
  public void renderBoard() throws IOException {
    this.appendable.append(this.toString());
  }

  /**
   * render the message to the given destination.
   *
   * @param message the message to be transmitted
   * @throws IOException if transmission the message fails
   */
  @Override
  public void renderMessage(String message) throws IOException {
    this.appendable.append(message);
  }
}
