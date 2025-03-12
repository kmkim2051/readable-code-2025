package cleancode.minesweeper.tobe.exception;

public class InvalidOrderCustomerException extends InvalidOrderException {

  public InvalidOrderCustomerException(String message, Long orderId) {
    super(message, orderId);
  }
}
