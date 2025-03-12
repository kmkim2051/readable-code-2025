package cleancode.minesweeper.tobe.exception;

public class InvalidOrderTotalPriceException extends InvalidOrderException {

  public InvalidOrderTotalPriceException(String message, Long orderId) {
    super(message, orderId);
  }
}
