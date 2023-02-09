package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * the {@code TriangleSolitaireTextView} represent the Triangle Solitaire Text View.
 */
public class TriangleSolitaireTextView extends AbstractMarbleSolitaireView {

  /**
   * the constructor for the TriangleSolitaireTextView class with model of game and appendable.
   *
   * @param model      the model of the game.
   * @param appendable the appendable of the game.
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState model, Appendable appendable) {
    super(model, appendable);
  }

  /**
   * the constructor for the TriangleSolitaireTextView class with model of game.
   *
   * @param model the model of the game.
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState model) {
    super(model);
  }

  /**
   * to make the board virtualize.
   *
   * @return the board with string
   */
  @Override
  public String toString() {
    StringBuilder res = new StringBuilder();
    int dimension = model.getBoardSize();
    for (int i = 0; i < dimension; i++) {
      for (int j = dimension; j > i + 1; j--) {
        res.append(" ");
      }
      for (int k = 0; k < dimension; k++) {
        MarbleSolitaireModelState.SlotState item = model.getSlotAt(i, k);
        if (item == MarbleSolitaireModelState.SlotState.Empty) {
          if (k == dimension - 1) {
            res.append("_");
          } else {
            if (model.getSlotAt(i, k + 1) == MarbleSolitaireModelState.SlotState.Invalid) {
              res.append("_");
            } else {
              res.append("_ ");
            }
          }
        }
        if (item == MarbleSolitaireModelState.SlotState.Marble) {
          if (k == dimension - 1) {
            res.append("O");
          } else {
            if (model.getSlotAt(i, k + 1) == MarbleSolitaireModelState.SlotState.Invalid) {
              res.append("O");
            } else {
              res.append("O ");
            }
          }
        }
      }
      if (i != model.getBoardSize() - 1) {
        res.append("\n");
      }
    }
    return res.toString();
  }
}
