package cs3500.marblesolitaire.model.hw04;

import java.util.ArrayList;

/**
 * the {@code TriangleSolitaireModel} represent the Triangle SolitaireModel class to represent the
 * TriangleSolitaire game.
 */
public class TriangleSolitaireModel extends AbstractSolitaireModel {

  private int dimensions;

  /**
   * the constructor for the TriangleSolitaireModel with default.
   */
  public TriangleSolitaireModel() {
    this(5, 0, 0);
  }

  /**
   * the constructor for the TriangleSolitaireModel with a dimension.
   *
   * @param dimensions the length of the triangle.
   */
  public TriangleSolitaireModel(int dimensions) {
    this(dimensions, 0, 0);
  }

  /**
   * the constructor for the TriangleSolitaireModel with the empty slot's location.
   *
   * @param row the empty slot's row
   * @param col the empty slot's col
   */
  public TriangleSolitaireModel(int row, int col) {
    this(5, row, col);
  }

  /**
   * the constructor for the TriangleSolitaireModel with the dimension and the empty slot's
   * location.
   *
   * @param dimensions the length of the triangle.
   * @param row        the empty slot's row
   * @param col        the empty slot's col
   */
  public TriangleSolitaireModel(int dimensions, int row, int col) {
    super(dimensions, row, col);
    this.dimensions = dimensions;
    this.rowNumber = dimensions;

    if (dimensions < 0) {
      throw new IllegalArgumentException();
    }

    if (row < 0 || col < 0 || row >= dimensions || col >= dimensions) {
      throw new IllegalArgumentException();
    }

    for (int i = 0; i < dimensions; i++) {
      board.add(new ArrayList<SlotState>());
      for (int j = 0; j < dimensions; j++) {
        if (j <= i) {
          if (row == i && col == j) {
            board.get(i).add(SlotState.Empty);
          } else {
            board.get(i).add(SlotState.Marble);
            score++;
          }
        } else {
          if (row == i && col == j) {
            throw new IllegalArgumentException();
          }
          board.get(i).add(SlotState.Invalid);
        }
      }
    }
  }

  /**
   * the helper method to check the marble can just jump one layer.
   *
   * @param fromRow the row location that the user want to move the marble from
   * @param fromCol the col location that the user want to move the marble from
   * @param toRow   the row location that the user want to move the marble to
   * @param toCol   the col location that the user want to move the marble to
   * @return return true if the marble just jump one layer
   */
  private boolean layerNumberCheck(int fromRow, int fromCol, int toRow, int toCol) {
    boolean flag = false;
    if (8 == Math.pow(toCol - fromCol, 2) + Math.pow(toRow - fromRow, 2)) {
      flag = true;
    }
    return flag;
  }

  /**
   * the method is to move the marble to up down, left, right. Also check the marble can move or
   * not.
   *
   * @param fromRow the row number of the position to be moved from (starts at 0)
   * @param fromCol the column number of the position to be moved from (starts at 0)
   * @param toRow   the row number of the position to be moved to (starts at 0)
   * @param toCol   the column number of the position to be moved to (starts at 0)
   * @throws IllegalArgumentException if the marble can not move
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    if ((fromCol == toCol) || (fromRow == toRow)) {
      super.move(fromRow, fromCol, toRow, toCol);
    } else {
      if (emptyCheck(toRow, toCol) && marbleCheck(fromRow, fromCol) && marbleCheck(
          (toRow + fromRow) / 2, (toCol + fromCol) / 2)) {
        if (layerNumberCheck(fromRow, fromCol, toRow, toCol)) {
          if ((fromCol < toCol && fromRow > toRow) || (fromRow < toRow && fromCol > toCol)) {
            throw new IllegalArgumentException();
          } else {
            board.get(toRow).set(toCol, SlotState.Marble);
            board.get(fromRow).set(fromCol, SlotState.Empty);
            board.get((toRow + fromRow) / 2).set((toCol + fromCol) / 2, SlotState.Empty);
            score--;
          }
        } else {
          throw new IllegalArgumentException();
        }
      } else {
        throw new IllegalArgumentException();
      }

    }
  }

  /**
   * to chcek the game is over or not.
   *
   * @return if the game over, return true.
   */
  @Override
  public boolean isGameOver() {
    return rowHelper(this.dimensions) && colHelper(this.dimensions) && layerHelper(this.dimensions);
  }

  /**
   * to check the marble can move or not if the layer is correct.
   *
   * @param dimensions the length of triangle
   * @return true if the layer is correct
   */
  private boolean layerHelper(int dimensions) {
    boolean flag = true;
    loop:
    for (int i = 0; i < dimensions - 2; i++) {
      for (int j = 0; j < dimensions - 2; j++) {
        flag = !((marbleCheck(i, j) && emptyCheck(i + 2, j + 2) && marbleCheck(i + 1, j + 1))
            || (emptyCheck(i, j) && marbleCheck(i + 2, j + 2) && marbleCheck(i + 1, j + 1)));
        if (!flag) {
          break loop;
        }
      }
    }
    return flag;
  }

  /**
   * to check the board size.
   *
   * @return the length of the board.
   */
  @Override
  public int getBoardSize() {
    return this.dimensions;
  }
}

