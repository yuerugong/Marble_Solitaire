package cs3500.marblesolitaire.controller;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import java.io.IOException;
import java.util.Scanner;

/**
 * the {@code MarbleSolitaireControllerImpl} represent the Marble Solitaire Controller
 * Implementation, which implements the Marble Solitaire Controller.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {

  private Readable in = null;
  private MarbleSolitaireModel model;
  private MarbleSolitaireView view;

  /**
   * this is the constructor of MarbleSolitaireControllerImpl class.
   * @param model the model of this game
   * @param view  the image of the board
   * @param in    the input from the user
   * @throws IllegalArgumentException when whatever model, view, or in is null
   */
  public MarbleSolitaireControllerImpl(MarbleSolitaireModel model, MarbleSolitaireView view,
      Readable in) throws IllegalArgumentException {
    if (model == null || view == null || in == null) {
      throw new IllegalArgumentException();
    }
    this.model = model;
    this.view = view;
    this.in = in;
  }

  /**
   * to show the image of the board when the game is over.
   * @throws IOException when the game is not over
   */
  private void gameOver() throws IOException {
    this.view.renderMessage("Game quit!");
    this.view.renderMessage("\n");
    this.view.renderMessage("State of game when quit:");
    this.view.renderMessage("\n");
    this.view.renderBoard();
    this.view.renderMessage("\n");
    this.view.renderMessage("Score: " + this.model.getScore());
  }

  /**
   * a helper method to determine the user enters Q, q, or valid number that bigger than zero and
   * smaller than the board size.
   * @param scan the String that the user input
   * @return
   */
  private String inputHelper(Scanner scan) {
    try {
      int num = 0;
      do {
        while (!scan.hasNextInt()) {
          String word = scan.next();
          if (word.equals("Q") || word.equals("q")) {
            return "q";
          }
        }
        num = scan.nextInt();
      }
      while (num <= 0 || num > this.model.getBoardSize());
      return num + "";
    } catch (Exception e) {
      throw new IllegalStateException("should write a right number");
    }
  }

  /**
   * set the game to help users play this game. When the player input 4 ints, the marble moves once.
   * if the input not up to 4 int, the marble cannot move.
   * if the player enter q or Q, the game will be quit directly.
   * if users enter anything that is not related to positive integers or q,Q,
   * the computer should ignore it.
   * after the pieces are unable to move, the reality should be game over.
   */
  @Override
  public void playGame() {
    try {
      Scanner scan = new Scanner(this.in);
      int fromRow;
      int fromCol;
      int toRow;
      int toCol;
      this.view.renderBoard();
      this.view.renderMessage("\n");
      this.view.renderMessage("Score: " + this.model.getScore());
      this.view.renderMessage("\n");
      this.view.renderMessage("\n");
      while (true) {
        String a = inputHelper(scan);
        if (a.equals("q")) {
          this.gameOver();
          return;
        }
        String b = inputHelper(scan);
        if (b.equals("q")) {
          this.gameOver();
          return;
        }
        String c = inputHelper(scan);
        if (c.equals("q")) {
          this.gameOver();
          return;
        }
        String d = inputHelper(scan);
        if (d.equals("q")) {
          this.gameOver();
          return;
        }
        fromRow = Integer.parseInt(a);
        fromCol = Integer.parseInt(b);
        toRow = Integer.parseInt(c);
        toCol = Integer.parseInt(d);

        try {
          fromCol -= 1;
          fromRow -= 1;
          toRow -= 1;
          toCol -= 1;
          this.model.move(fromRow, fromCol, toRow, toCol);
          if (this.model.isGameOver()) {
            this.view.renderBoard();
            this.view.renderMessage("\n");
            this.view.renderMessage("Score: " + this.model.getScore());
            this.view.renderMessage("\n");
            this.view.renderMessage("Game over!");
            this.view.renderMessage("\n");
            this.view.renderBoard();
            this.view.renderMessage("\n");
            this.view.renderMessage("Score: " + this.model.getScore());
            return;
          } else {
            this.view.renderBoard();
            this.view.renderMessage("\n");
            this.view.renderMessage("Score: " + this.model.getScore());
            this.view.renderMessage("\n");
            this.view.renderMessage("\n");
          }
        } catch (IllegalArgumentException e) {
          this.view.renderMessage("Invalid move. Play again. X");
        }
      }
    } catch (Exception e) {
      throw new IllegalStateException("Invalid enter");
    }
  }
}
