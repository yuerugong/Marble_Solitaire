package cs3500.marblesolitaire.model.hw02;


/**
 * the {@code EnglishSolitaireModel} represent the English Solitaire Model.
 */
public class EnglishSolitaireModel implements MarbleSolitaireModel {

  int armThickness;
  private SlotState[][] gameBoard;
  private int rowNumber;

  private void underLineBoard(int row, int col) {

    gameBoard[row][col] = SlotState.Empty;
  }


  /**
   * this method shows the ecch slot should be invalid or marble.
   *
   * @param armThickness the length of arm thickness
   */
  private void defaultBoard(int armThickness) {
    this.armThickness = armThickness;
    rowNumber = 3 * armThickness - 2;
    gameBoard = new SlotState[rowNumber][rowNumber];

    for (int i = 0; i < gameBoard.length; i++) {
      for (int j = 0; j < gameBoard[0].length; j++) {
        if (i < armThickness - 1 || i >= 2 * armThickness - 1) {
          if (j < armThickness - 1 || j >= 2 * armThickness - 1) {
            gameBoard[i][j] = SlotState.Invalid;
          } else {
            gameBoard[i][j] = SlotState.Marble;
          }
        } else {
          gameBoard[i][j] = SlotState.Marble;
        }
      }
    }
  }

  /**
   * the constructor of EnglishSolitaireModel.
   */
  public EnglishSolitaireModel() {
    defaultBoard(3);
    underLineBoard((rowNumber - 1) / 2, (rowNumber - 1) / 2);
  }

  /**
   * the constructor of EnglishSolitaireModel.
   *
   * @param sRow the row of empty
   * @param sCol the colum of empty
   */
  public EnglishSolitaireModel(int sRow, int sCol) {
    defaultBoard(3);
    if (gameBoard[sRow][sCol] == SlotState.Invalid) {
      throw new IllegalArgumentException("Invalid empty cell position (" + sRow + "," + sCol + ")");
    }
    underLineBoard(sRow, sCol);
  }

  /**
   * the constructor of EnglishSolitaireModel.
   *
   * @param armThickness the length of arm thickness
   */
  public EnglishSolitaireModel(int armThickness) {
    if (armThickness % 2 == 0 || armThickness <= 0) {
      throw new IllegalArgumentException("the arm thickness is not a positive odd number");
    }
    defaultBoard(armThickness);
    underLineBoard((rowNumber - 1) / 2, (rowNumber - 1) / 2);
  }

  /**
   * the constructor of EnglishSolitaireModel.
   *
   * @param armThickness the length of arm thickness
   * @param sRow         the row of empty
   * @param sCol         the colum of empty
   */
  public EnglishSolitaireModel(int armThickness, int sRow, int sCol) {
    if (armThickness % 2 == 0 || armThickness <= 0) {
      throw new IllegalArgumentException("the arm thickness is not a positive odd number");
    }
    defaultBoard(armThickness);
    if (gameBoard[sRow][sCol] == SlotState.Invalid) {
      throw new IllegalArgumentException("Invalid empty cell position (" + sRow + "," + sCol + ")");
    }
    underLineBoard(sRow, sCol);
  }

  /**
   * to give the condition of move.
   *
   * @param fromRow the marble's row that we want to move
   * @param fromCol the marble's colum that we want to move
   * @param toRow   the place's row that we want to move to
   * @param toCol   the place's colum that we want to move to
   * @return numbers of each condition
   * @throws IllegalArgumentException "Invalid move"
   */
  private int moveHelper(int fromRow, int fromCol, int toRow, int toCol)
      throws IllegalArgumentException {
    try {
      if (gameBoard[fromRow][fromCol] == SlotState.Marble
          && gameBoard[toRow][toCol] == SlotState.Empty) {
        if (fromRow == toRow) { // same row
          if (toCol - fromCol == 2) {
            if (gameBoard[fromRow][fromCol + 1] == SlotState.Marble) {
              return 1;
            }
          } else if (fromCol - toCol == 2) {
            if (gameBoard[fromRow][fromCol - 1] == SlotState.Marble) {
              return 2;
            }
          }
        } else if (fromCol == toCol) {
          if (toRow - fromRow == 2) {
            if (gameBoard[fromRow + 1][fromCol] == SlotState.Marble) {
              return 3;
            }
          } else if (fromRow - toRow == 2) {
            if (gameBoard[fromRow - 1][fromCol] == SlotState.Marble) {
              return 4;
            }
          }
        }
      }
    } catch (Exception e) {
      throw new IllegalArgumentException();
    }
    return -1;
  }

  /**
   * to check the valid move for the marble.
   *
   * @param fromRow the row number of the position to be moved from (starts at 0)
   * @param fromCol the column number of the position to be moved from (starts at 0)
   * @param toRow   the row number of the position to be moved to (starts at 0)
   * @param toCol   the column number of the position to be moved to (starts at 0)
   * @throws IllegalArgumentException "Invalid move"
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    int checkRes = moveHelper(fromRow, fromCol, toRow, toCol);
    if (checkRes == 1) {
      gameBoard[fromRow][fromCol] = SlotState.Empty;
      gameBoard[fromRow][fromCol + 1] = SlotState.Empty;
      gameBoard[toRow][toCol] = SlotState.Marble;
    } else if (checkRes == 2) {
      gameBoard[fromRow][fromCol] = SlotState.Empty;
      gameBoard[fromRow][fromCol - 1] = SlotState.Empty;
      gameBoard[toRow][toCol] = SlotState.Marble;
    } else if (checkRes == 3) {
      gameBoard[fromRow][fromCol] = SlotState.Empty;
      gameBoard[fromRow + 1][fromCol] = SlotState.Empty;
      gameBoard[toRow][toCol] = SlotState.Marble;
    } else if (checkRes == 4) {
      gameBoard[fromRow][fromCol] = SlotState.Empty;
      gameBoard[fromRow - 1][fromCol] = SlotState.Empty;
      gameBoard[toRow][toCol] = SlotState.Marble;
    } else if (checkRes == -1) {
      throw new IllegalArgumentException();
    }
  }

  /**
   * to check is game over or not.
   *
   * @return if game over, return ture; if game not over, return false
   */
  @Override
  public boolean isGameOver() {
    if (getScore() == 1) {
      return true;
    }
    for (int i = 0; i < gameBoard.length; i++) {
      for (int j = 0; j < gameBoard[0].length; j++) {
        if (gameBoard[i][j] == SlotState.Marble) {
          if (i + 2 < gameBoard.length) {
            if (moveHelper(i, j, i + 2, j) != -1) {
              return false;
            }
          }
          if (i - 2 >= 0) {
            if (moveHelper(i, j, i - 2, j) != -1) {
              return false;
            }
          }
          if (j - 2 >= 0) {
            if (moveHelper(i, j, i, j - 2) != -1) {
              return false;
            }
          }
          if (j + 2 < gameBoard[0].length) {
            if (moveHelper(i, j, i, j + 2) != -1) {
              return false;
            }
          }
        }
      }
    }
    return true;
  }

  /**
   * to check the gameboard's size.
   *
   * @return the size of gameboard
   */
  @Override
  public int getBoardSize() {
    return gameBoard.length;
  }

  /**
   * Get the state of the slot at a given position on the board.
   *
   * @param row the row of the position sought, starting at 0
   * @param col the column of the position sought, starting at 0
   * @return the state of the slot at the given row and column
   * @throws IllegalArgumentException Illegal argument Exception
   */
  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    return gameBoard[row][col];
  }

  /**
   * Return the number of marbles currently on the board.
   *
   * @return the number of marbles currently on the board.
   */
  @Override
  public int getScore() {
    int score = 0;
    for (int i = 0; i < gameBoard.length; i++) {
      for (int j = 0; j < gameBoard[0].length; j++) {
        if (gameBoard[i][j] == SlotState.Marble) {
          score++;
        }
      }
    }
    return score;
  }

}


