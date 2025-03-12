package cleancode.minesweeper.tobe.exception;

public class NoItemInOrderException extends InvalidOrderException{

  public NoItemInOrderException(String message, Long orderId) {
    super(message, orderId);
  }
}
