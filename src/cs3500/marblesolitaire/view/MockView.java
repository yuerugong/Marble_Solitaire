package cs3500.marblesolitaire.view;

import java.io.IOException;
import java.util.Objects;

/**
 * the {@code MockView} represent the MockView.
 */
public class MockView implements MarbleSolitaireView {

  private final Appendable appendable;

  public MockView(Appendable appendable) {
    this.appendable = Objects.requireNonNull(appendable);
  }

  /**
   * this is the method about appendable.
   *
   * @throws IOException when the appendable failed
   */
  @Override
  public void renderBoard() throws IOException {
    this.appendable.append("board is rendered");
  }

  /**
   * this is the method about appendable.
   *
   * @param message the message to be transmitted
   * @throws IOException when the appendable failed
   */
  @Override
  public void renderMessage(String message) throws IOException {
    this.appendable.append("board is rendered");
  }
}
