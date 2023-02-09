package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

import java.util.ArrayList;

/**
 * the {@code AbstractSolitaireModel} represent the Abstract solitaire model class that implement in
 * MarbleSolitaireModel class.
 */
public class AbstractSolitaireModel implements MarbleSolitaireModel {

  protected int armThickness;
  protected int rowNumber;
  protected ArrayList<ArrayList<SlotState>> board = new ArrayList<>();
  protected int score;

  /**
   * the constructor for the abstract solitaire model.
   *
   * @param armThickness the length of arm thickness for the board.
   * @param row          the row location for the empty slot
   * @param col          the col location for the empty slot
   */
  public AbstractSolitaireModel(int armThickness, int row, int col) {
    this.armThickness = armThickness;
    this.rowNumber = 3 * armThickness - 2;
    this.score = 0;
  }

  /**
   * this is the abstract method for the move to show how the marble move when the marble move to
   * up, down, left, right. Also, check the marble move correctly or not.
   *
   * @param fromRow the row number of the position to be moved from (starts at 0)
   * @param fromCol the column number of the position to be moved from (starts at 0)
   * @param toRow   the row number of the position to be moved to (starts at 0)
   * @param toCol   the column number of the position to be moved to (starts at 0)
   * @throws IllegalArgumentException when the marble cannot move.
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    if (!(emptyCheck(toRow, toCol) && marbleCheck(fromRow, fromCol) && (
        marbleCheck(toRow, (toCol + fromCol) / 2) || marbleCheck((toRow + fromRow) / 2, toCol)))) {
      throw new IllegalArgumentException();
    }
    if (!(Math.abs(fromCol - toCol) == 2 || Math.abs(fromRow - toRow) == 2)) {
      throw new IllegalArgumentException();
    }
    if ((Math.abs(fromCol - toCol) == 2 && Math.abs(fromRow - toRow) == 2)) {
      throw new IllegalArgumentException();
    }
    if ((fromRow != toRow) && (fromCol != toCol)) {
      throw new IllegalArgumentException();
    }
    board.get(toRow).set(toCol, SlotState.Marble);
    board.get(fromRow).set(fromCol, SlotState.Empty);
    if (fromRow == toRow) {
      board.get(fromRow).set((fromCol + toCol) / 2, SlotState.Empty);
    } else {
      board.get((fromRow + toRow) / 2).set(toCol, SlotState.Empty);
    }
    score--;
  }

  /**
   * to check there is a marble or not.
   *
   * @param row the row number for the place that we want to check
   * @param col the col number for the place that we want to check
   * @return is there is a marble, return true.
   */
  protected boolean marbleCheck(int row, int col) {
    boolean flag = false;
    if (!(row < 0 || col < 0 || row >= rowNumber || col >= rowNumber)) {
      if (board.get(row).get(col) == SlotState.Marble) {
        flag = true;
      }
    }
    return flag;
  }

  /**
   * to check there is empty or not.
   *
   * @param row the row number for the place that we want to check
   * @param col the col number for the place that we want to check
   * @return is there is empty, return true.
   */
  protected boolean emptyCheck(int row, int col) {
    boolean flag = false;
    if (!(row < 0 || col < 0 || row >= rowNumber || col >= rowNumber)) {
      if (board.get(row).get(col) == SlotState.Empty) {
        flag = true;
      }
    }
    return flag;
  }

  /**
   * to check the game is over or not.
   *
   * @return if the game over, return true.
   */
  @Override
  public boolean isGameOver() {
    return rowHelper(this.rowNumber) && colHelper(this.rowNumber);
  }

  /**
   * to check the marble can move or not if they are in the same row.
   *
   * @param rowNumber the number of row
   * @return if the marble cannot move, return true.
   */
  protected boolean rowHelper(int rowNumber) {
    boolean flag = true;
    loop:
    for (int i = 0; i < rowNumber; i++) {
      for (int j = 0; j < rowNumber - 2; j++) {
        flag = !((marbleCheck(i, j) && emptyCheck(i, j + 2) && marbleCheck(i, j + 1))
            || (emptyCheck(i, j) && marbleCheck(i, j + 2) && marbleCheck(i, j + 1)));
        if (!flag) {
          break loop;
        }
      }
    }
    return flag;
  }

  /**
   * to check the marble can move or not if they are in the same col.
   *
   * @param rowNumber the number of row
   * @return if the marble cannot move, return true.
   */
  protected boolean colHelper(int rowNumber) {
    boolean flag = true;
    loop:
    for (int i = 0; i < rowNumber - 2; i++) {
      for (int j = 0; j < rowNumber; j++) {
        flag = !((marbleCheck(i, j) && emptyCheck(i + 2, j) && marbleCheck(i + 1, j))
            || (emptyCheck(i, j) && marbleCheck(i + 2, j) && marbleCheck(i + 1, j)));
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
   * @return the length of the board
   */
  @Override
  public int getBoardSize() {
    return this.rowNumber;
  }

  /**
   * to check the state of the slot.
   *
   * @param row the row of the position sought, starting at 0
   * @param col the column of the position sought, starting at 0
   * @return the state of the slot.
   * @throws IllegalArgumentException if the col and row are out of board.
   */
  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    return board.get(row).get(col);
  }

  /**
   * to get the score when playing game.
   *
   * @return the score for current game.
   */
  @Override
  public int getScore() {
    return score;
  }
}
