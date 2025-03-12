package cleancode.minesweeper;

import cleancode.minesweeper.tobe.domain.Order;
import cleancode.minesweeper.tobe.exception.InvalidOrderCustomerException;
import cleancode.minesweeper.tobe.exception.InvalidOrderException;
import cleancode.minesweeper.tobe.exception.InvalidOrderTotalPriceException;
import cleancode.minesweeper.tobe.exception.NoItemInOrderException;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class OrderTest {
  /*
   * version 1
   * (1) 메서드 추출
   * (2) early return
   * */
  public boolean validateOrder(Order order) {
    if (order.hasNoItem()) {
      log.info("주문 항목이 없습니다.");
      return false;
    }
    if (!(order.getTotalPrice() > 0)) {
      log.info("올바르지 않은 총 가격입니다.");
      return false;
    }

    if (!order.hasCustomerInfo()) {
      log.info("사용자 정보가 없습니다.");
      return false;
    }
    return true;
  }

  /*
  * version 2
  * (0) order Id가 생성된 이후라고 가정한다. (save가 아닌 Read, Update 시)
  * (1) return type 변경
  * (2) Order rhksfus Custom Exception 던지도록
  *   - 각 if문 내부 예외는 InvalidOrderException을 상속, orderId를 받는다고 가정
  * */
  public void validateOrder2(Order order) throws InvalidOrderException {
    final Long orderId = order.getId();
    if (order.hasNoItem()) {
      log.error("주문 항목이 없습니다. order id: {}", orderId);
      throw new NoItemInOrderException("주문 항목이 없습니다.", orderId);
    }

    if (!order.isValidTotalPrice()) {
      log.error("올바르지 않은 총 가격입니다. order id: {}", orderId);
      throw new InvalidOrderTotalPriceException("주문 항목이 없습니다.", orderId);
    }

    if (!order.isValidCustomerInfo()) {
      log.error("사용자 정보가 없습니다. order id: {}", orderId);
      throw new InvalidOrderCustomerException("사용자 정보가 없습니다.", orderId);
    }

    log.info("유효한 주문 정보입니다. Order(id: {}, name: {})", orderId, order.getName());
  }

}
