import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;

public class Order {

    //조회Read - 주문 후 이루어져야함
    //수정Update - 주문 후

    List<Menu> orderList = new ArrayList<>(); //장바구니
    List<Product> waitList = new ArrayList<>();//대기 목록
    List<Product> compList = new ArrayList<>();//완료 목록
    Integer orderPrice = 0; //주문 금액
    Integer waitPrice = 0; //대기 총 금액
    Integer compPrice = 0; //완료 총 금액
    Integer count = 0;//대기번호
    String request = ""; //요청사항


    public void cartAdd(Menu menu) { //장바구니에 담고, 장바구니 금액 합산
        orderList.add(menu);
        orderPrice += menu.price;
    }

    public void orderListPrint() { //장바구니 출력
        int i = 1;
        for (Menu menu : orderList)
            System.out.printf("%d. %s | %d원 | %s\n", i++, menu.getName(), menu.getPrice(), menu.getDesc());
    }


    public void count() { //주문 완료했을 때
        requestMsg();
        count++;
        addTotalOrder(orderList); // (1)주문이 완료되면, 장바구니에 든 목록을 대기 목록List에 저장하고
        System.out.println("주문이 완료되었습니다!");
        System.out.println("대기번호는 [" + count + "]번 입니다.");
        System.out.println("(3초후 메뉴판으로 돌아갑니다.)");
        clearCart(); //(2)장바구니는 비운다
    }

    public void addTotalOrder(List<Menu> list) { //장바구니List를 대기목록List에 저장하는 메서드
        LocalDateTime lt = LocalDateTime.now();
        String time = lt.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH:mm:ss")); //현재 시간

        for (Menu menu : list) {
            waitList.add(new Product(count, menu.getName(), menu.getPrice(), request, time, "대기"));
        }

    }


    public void requestMsg() { //주문 시 요청사항
        Scanner sc = new Scanner(System.in);
        System.out.print("요청사항을 작성해주세요 >>");
        request = sc.nextLine();
        if (request.length() > 0 && request.length() < 21) {
            return;
        } else {
            System.out.println("최대 작성가능 20자");
            requestMsg();
        }
    }

    public void clearCart() { //장바구니 비우기
        orderList.clear();
        orderPrice = 0;
    }


    //대기 목록 메서드
    public void totalOrderPrint() {
        System.out.println("[ 대기 주문 목록 ]");
        waitPrice = 0; //여기서, 0으로 선언 안 하면, 대기목록메서드 실행될 때마다 기존값이 계속 같이 플러스됨
        for (Product p : waitList) {

            waitPrice += p.getPrice();
            System.out.printf("주문번호 : %d | %s | %d원 | 요청사항 : %s | 주문일시 : %s | %s\n", p.getBno(), p.getName(), p.getPrice(), p.getRequest(), p.getOrderDate(), p.getState());

        }
        System.out.printf("[ 대기금액 현황 : %d원 ]\n", waitPrice);
        ChoiceComplet();
    }

    //대기 -> 완료로 넘어가는 메서드
    private void ChoiceComplet() { //완료시킬 상품 선택하는 메서드
        Scanner sc = new Scanner(System.in);
        System.out.print("완료하실 상품을 선택해주세요 >>");
        int choice = sc.nextInt();


        for (Product p : waitList) {
            if (choice == p.getBno()) compList.add(p);
        }

        waitList.removeIf(s -> s.getBno() == choice);
    }


    //완료목록 메서드

    //주문현황 메서드



    public Integer getOrderPrice() {
        return orderPrice;
    }

    public Integer getWaitPrice() {
        return waitPrice;
    }
}