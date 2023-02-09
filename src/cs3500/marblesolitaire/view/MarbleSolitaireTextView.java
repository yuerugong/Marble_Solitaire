package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState;
import java.io.IOException;

/**
 * the {@code MarbleSolitaireTextView} represent the text view for Marble Solitaire.
 */
public class MarbleSolitaireTextView implements MarbleSolitaireView {

  public Appendable appendable;
  public MarbleSolitaireModelState model;

  /**
   * this is the Constructor for the MarbleSolitaireTextView.
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState model, Appendable appendable) {
    if (model == null || appendable == null) {
      throw new IllegalArgumentException("Please give correct parameters");
    }
    this.model = model;
    this.appendable = appendable;
  }

  public MarbleSolitaireTextView(MarbleSolitaireModelState model) {
    this(model, System.out);
  }


  /**
   * Return a string that represents the current state of the board.
   *
   * @return the game state as a string
   */
  @Override
  public String toString() {
    StringBuilder res = new StringBuilder();
    for (int i = 0; i < this.model.getBoardSize(); i++) {
      for (int j = 0; j < this.model.getBoardSize(); j++) {
        if (this.model.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Marble) {
          res.append("O");
          if (j + 1 < this.model.getBoardSize()
              && this.model.getSlotAt(i, j + 1) != SlotState.Invalid) {
            res.append(" ");
          } else if (j + 1 < this.model.getBoardSize()
              && this.model.getSlotAt(i, j + 1) == SlotState.Invalid) {
            break;
          }
        }
        if (this.model.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Invalid) {
          res.append(" ");
          res.append(" ");
        }
        if (this.model.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Empty) {
          res.append("_");
          if (j + 1 < this.model.getBoardSize()
              && this.model.getSlotAt(i, j + 1) != SlotState.Invalid) {
            res.append(" ");
          } else if (j + 1 < this.model.getBoardSize()
              && this.model.getSlotAt(i, j + 1) == SlotState.Invalid) {
            break;
          }
        }
      }
      if (i + 1 != this.model.getBoardSize()) {
        res.append("\n");
      }
    }
    return res.toString();
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


