package cs3500.marblesolitaire.model.hw04;

import java.util.ArrayList;

/**
 * the {@code EuropeanSolitaireModel} represent the European SolitaireModel class to represent the
 * EuropeanSolitaire game.
 */
public class EuropeanSolitaireModel extends AbstractSolitaireModel {

  /**
   * the constructor for the EuropeanSolitaireModel with default.
   */
  public EuropeanSolitaireModel() {
    this(3, 3, 3);
  }

  /**
   * the constructor for the EuropeanSolitaireModel with an arm thickness.
   *
   * @param armThickness the length of the arm thickness.
   */
  public EuropeanSolitaireModel(int armThickness) {
    this(armThickness, (3 * armThickness - 3) / 2, (3 * armThickness - 3) / 2);
  }

  /**
   * the constructor for the EuropeanSolitaireModel with the empty slot's location.
   *
   * @param row the empty slot's row
   * @param col the empty slot's col
   */
  public EuropeanSolitaireModel(int row, int col) {
    this(3, row, col);
  }

  /**
   * the constructor for the EuropeanSolitaireModel with the arm thickness and the empty slot's
   * location.
   *
   * @param armThickness the length of the arm thickness.
   * @param row          the empty slot's row
   * @param col          the empty slot's col
   */
  public EuropeanSolitaireModel(int armThickness, int row, int col) {
    super(armThickness, row, col);

    if (armThickness < 3 || (armThickness % 2 == 0)) {
      throw new IllegalArgumentException();
    }
    if (row >= rowNumber || col >= rowNumber || row < 0 || col < 0) {
      throw new IllegalArgumentException("Invalid empty cell position (" + row + "," + col + ")");
    }

    int a;
    int b;
    for (int i = 0; i < rowNumber; i++) {
      board.add(new ArrayList<SlotState>());
      for (int j = 0; j < rowNumber; j++) {

        if (i < rowNumber - armThickness) {
          a = armThickness - i - 1;
          b = rowNumber - (armThickness - i);
        } else {
          a = i + armThickness - rowNumber;
          b = 2 * rowNumber - armThickness - i - 1;
        }

        if (j < a || j > b) {
          if (row == i && col == j) {
            throw new IllegalArgumentException(
                "Invalid empty cell position (" + row + "," + col + ")");
          }
          board.get(i).add(SlotState.Invalid);
        } else {
          if (row == i && col == j) {
            board.get(i).add(SlotState.Empty);
          } else {
            board.get(i).add(SlotState.Marble);
            this.score++;
          }
        }
      }
    }
  }
}
