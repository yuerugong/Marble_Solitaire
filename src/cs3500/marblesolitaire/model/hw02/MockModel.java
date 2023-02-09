package cs3500.marblesolitaire.model.hw02;

import java.io.IOException;
import java.util.Objects;

/**
 * the {@code MockModel} represent the mock model which implements MarbleSolitaireModel interface.
 */
public class MockModel implements MarbleSolitaireModel {

  private final Appendable appendable;

  public MockModel(Appendable appendable) {
    this.appendable = Objects.requireNonNull(appendable);
  }

  /**
   * move shows how the marbles moving on the game board.
   *
   * @param fromRow the row number of the position to be moved from (starts at 0)
   * @param fromCol the column number of the position to be moved from (starts at 0)
   * @param toRow   the row number of the position to be moved to (starts at 0)
   * @param toCol   the column number of the position to be moved to (starts at 0)
   * @throws IllegalArgumentException to show if it's fail to append
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    try {
      this.appendable.append(fromRow + " " + fromCol + " " + toRow + " " + toCol);
    } catch (IOException e) {
      throw new IllegalStateException("fail to append");
    }
  }

  /**
   * to check is game over or not.
   *
   * @return
   */
  @Override
  public boolean isGameOver() {
    return false;
  }

  /**
   * to get the board Size.
   *
   * @return just 0 since needn't use
   */
  @Override
  public int getBoardSize() {
    return 0;
  }

  /**
   * to get the state of the marble.
   *
   * @param row the row of the position sought, starting at 0
   * @param col the column of the position sought, starting at 0
   * @return null since needn't use
   * @throws IllegalArgumentException null
   */
  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    return SlotState.Invalid;
  }

  /**
   * to get the score from the current game board.
   *
   * @return just 0 since needn't use
   */
  @Override
  public int getScore() {
    return 0;
  }
}
