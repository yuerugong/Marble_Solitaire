package cs3500.marblesolitaire.controller;

/**
 * this interface represent the controller for the Marble Solitaire game.
 */
public interface MarbleSolitaireController {

  /**
   * this method is to play a new game for Marble Solitaire game.
   * @throws IllegalStateException if the controller cannot get the input or transmit the output
   *                               successfully.
   */
  void playGame() throws IllegalStateException;
}
