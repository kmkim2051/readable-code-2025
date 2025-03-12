package cleancode.minesweeper.tobe.exception;

public abstract class InvalidOrderException extends RuntimeException {
  private final String message;
  private final Long orderId;
  public InvalidOrderException(String message, Long orderId) {
    this.message = message;
    this.orderId = orderId;
  }
}
