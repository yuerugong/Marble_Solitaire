package cs3500.marblesolitaire;

import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;

import java.io.InputStreamReader;
import java.util.Objects;

/**
 * the {@code MarbleSolitaire} represent the MarbleSolitaire class that be the entry point for the
 * program.
 */
public final class MarbleSolitaire {

  /**
   * this method is the entrance of the game.
   * @param args the entrance of the game.
   */
  public static void main(String[] args) {
    if (Objects.equals(args.length, 0)) {
      System.out.println("Please at least select a mode");
    }

    if (args.length >= 1) {
      if (args[0].equals("english")) {
        if (args.length == 3) {
          EnglishSolitaireModel model = new EnglishSolitaireModel(Integer.parseInt(args[2]));
        }
        if (args.length == 4) {
          EnglishSolitaireModel model = new EnglishSolitaireModel(Integer.parseInt(args[2]),
              Integer.parseInt(args[3]));
        }
        if (args.length == 6) {
          if (args[1].equals("-size")) {
            EnglishSolitaireModel model = new EnglishSolitaireModel(Integer.parseInt(args[2]),
                Integer.parseInt(args[4]), Integer.parseInt(args[5]));
          } else {
            EnglishSolitaireModel model = new EnglishSolitaireModel(Integer.parseInt(args[5]),
                Integer.parseInt(args[2]), Integer.parseInt(args[3]));
          }
        }
        EnglishSolitaireModel model = new EnglishSolitaireModel();

        new MarbleSolitaireControllerImpl(model,
            new MarbleSolitaireTextView(model), new InputStreamReader(System.in)).playGame();
      }
      if (args[0].equals("european")) {
        if (args.length == 3) {
          EuropeanSolitaireModel model = new EuropeanSolitaireModel(Integer.parseInt(args[2]));
        }
        if (args.length == 4) {
          EuropeanSolitaireModel model = new EuropeanSolitaireModel(Integer.parseInt(args[2]),
              Integer.parseInt(args[3]));
        }
        if (args.length == 6) {
          if (args[1].equals("-size")) {
            EuropeanSolitaireModel model = new EuropeanSolitaireModel(Integer.parseInt(args[2]),
                Integer.parseInt(args[4]), Integer.parseInt(args[5]));
          } else {
            EuropeanSolitaireModel model = new EuropeanSolitaireModel(Integer.parseInt(args[5]),
                Integer.parseInt(args[2]), Integer.parseInt(args[3]));
          }
        }
        EuropeanSolitaireModel model = new EuropeanSolitaireModel();
        new MarbleSolitaireControllerImpl(model,
            new MarbleSolitaireTextView(model), new InputStreamReader(System.in)).playGame();
      }
      if (args[0].equals("triangular")) {

        if (args.length == 3) {
          TriangleSolitaireModel model = new TriangleSolitaireModel(Integer.parseInt(args[2]));
        }
        if (args.length == 4) {
          TriangleSolitaireModel model = new TriangleSolitaireModel(Integer.parseInt(args[2]),
              Integer.parseInt(args[3]));
        }
        if (args.length == 6) {
          if (args[1].equals("-size")) {
            TriangleSolitaireModel model = new TriangleSolitaireModel(Integer.parseInt(args[2]),
                Integer.parseInt(args[4]), Integer.parseInt(args[5]));
          } else {
            TriangleSolitaireModel model = new TriangleSolitaireModel(Integer.parseInt(args[5]),
                Integer.parseInt(args[2]), Integer.parseInt(args[3]));
          }
        }
        TriangleSolitaireModel model = new TriangleSolitaireModel();
        new MarbleSolitaireControllerImpl(model,
            new MarbleSolitaireTextView(model), new InputStreamReader(System.in)).playGame();
      }
    }
  }
}
