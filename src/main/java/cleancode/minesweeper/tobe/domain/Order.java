package cleancode.minesweeper.tobe.domain;

public class Order {

  public Long getId() {
    return 0L;
  }
  public String getName() {
    return "";
  }

  public boolean hasNoItem() {
    return false;
  }

  public boolean hasCustomerInfo() {
    return false;
  }

  public int getTotalPrice() {
    return 0;
  }

  public boolean isValidTotalPrice() {
    return false;
  }

  public boolean isValidCustomerInfo() {
    return false;
  }
}
