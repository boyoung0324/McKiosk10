package McKiosk10.src;

import java.util.*;

public class Mcdonald {

    InitProduct ip = new InitProduct();
    Order order = new Order();
    List<Menu> mainList = new ArrayList<>(); //(1)메인화면에서 보여질 List
    List<Menu> mainOrderList = new ArrayList<>(); //(2)메인화면에서 보여질 List
    List<Menu> mainManagerList = new ArrayList<>(); //(3)메인화면에서 보여질 List

    public Mcdonald() {
        init();
    } //클래스를 생성하면, init메서드로 List들 초기화

    public void init() {
        mainList.add(new Menu("햄버거", "주문 즉시 바로 조리해 더욱 맛있는, 맥도날드의 다양한 버거를 소개합니다"));
        mainList.add(new Menu("사이드", "가볍게 즐겨도, 버거와 함께 푸짐하게 즐겨도, 언제나 맛있는 사이드"));
        mainList.add(new Menu("음료수", "다양한 음료를 부담없이 즐기세요"));

        mainOrderList.add(new Menu("장바구니", "장바구니를 확인 후 주문합니다"));
        mainOrderList.add(new Menu("주문취소", "진행중인 주문을 취소하고 장바구니를 비웁니다"));

        mainManagerList.add(new Menu("주문 현황", "주문 현황을 보여줍니다"));
        mainManagerList.add(new Menu("대기 목록", "대기 중인 주문을 보여줍니다."));
        mainManagerList.add(new Menu("완료 목록", "완료된 주문을 보여줍니다."));
        mainManagerList.add(new Menu("상품 생성", "새 상품을 등록합니다."));
        mainManagerList.add(new Menu("상품 삭제", "상품을 삭제합니다."));
    }


    public void kiosk() { //1번
        java.lang.System.out.println("-------------------------------------");
        java.lang.System.out.println("★ 맥도날드에 오신걸 환영합니다 ★");
        java.lang.System.out.println("↓ 아래 메뉴판을 골라 입력해주세요.\n");

        java.lang.System.out.println("[MAIN MENU]");
        int nextnum = mainPrint(1, mainList);
        java.lang.System.out.println();

        java.lang.System.out.println("[ORDER MENU]");
        nextnum = mainPrint(nextnum, mainOrderList);
        java.lang.System.out.println();

        java.lang.System.out.println("[MANAGER MENU]");
        mainPrint(nextnum, mainManagerList);
        java.lang.System.out.println("-------------------------------------");

        ChoiceMenu();
    }

    public int mainPrint(int num, List<Menu> screen) { //main프린트 해주는 공통 메서드
        for (int i = 0; i < screen.size(); i++) {
            java.lang.System.out.printf("%d. %s | %s\n", num++, screen.get(i).getMenu(), screen.get(i).getDesc());
        }
        return num;
    }


    public void ChoiceMenu() { //2번
        Scanner sc = new Scanner(java.lang.System.in);
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                burgerPrint();
                break;
            case 2:
                sidePrint();
                break;
            case 3:
                drinkPrint();
                break;
            case 4:
                cartList();
                break;
//            case 6:
//
//            case 7:
//
//            case 8:
//
//            case 9:


            default:
                java.lang.System.out.println("해당하는 메뉴가 없습니다.");
                returnMain();
        }
    }
    //private List<Menu> burgerList = new ArrayList<>();

    public void burgerPrint() {
        java.lang.System.out.println("★ 맥도날드에 오신걸 환영합니다 ★");
        java.lang.System.out.println("↓ 아래 메뉴판을 골라 입력해주세요.\n");
        java.lang.System.out.println("[BURGER MENU]");

        if (burgerList != null) {
            //CRUD클래스에서 생성한 상품이 보여지도록. null이 아니면 출력
            foodPrint();//생성한 상품의 list를 매개변수로담기
        } else {
            java.lang.System.out.println("상품이 없습니다."); //null이면 메세지 띄움
            returnMain();
        }
    }
    //private List<Menu> sideList = new ArrayList<>();

    public void sidePrint() {
        java.lang.System.out.println("★ 맥도날드에 오신걸 환영합니다 ★");
        java.lang.System.out.println("↓ 아래 메뉴판을 골라 입력해주세요.\n");
        java.lang.System.out.println("[SIDE MENU]");

        if (sideList != null) {
            //CRUD클래스에서 생성한 상품이 보여지도록. null이 아니면 출력
            foodPrint();//생성한 상품의 list를 매개변수로담기

        } else {
            java.lang.System.out.println("상품이 없습니다.");
            returnMain();
        }
    }
   // private List<Menu> drinkList = new ArrayList<>();

    public void drinkPrint() {
        java.lang.System.out.println("★ 맥도날드에 오신걸 환영합니다 ★");
        java.lang.System.out.println("↓ 아래 메뉴판을 골라 입력해주세요.\n");
        java.lang.System.out.println("[DRINK MENU]");
        if (drinkList != null) {
            //CRUD클래스에서 생성한 상품이 보여지도록. null이 아니면 출력
            foodPrint();//생성한 상품의 list를 매개변수로담기
        } else {
            java.lang.System.out.println("상품이 없습니다.");
            returnMain();
        }

    }


    void foodPrint(List<Menu> foodList) { //상품 프린트되는 공통 메서드
        for (int i = 0; i < foodList.size(); i++) {
            java.lang.System.out.printf("%d. %s | %d원 | %s\n", i + 1, foodList.get(i).name, foodList.get(i).price, foodList.get(i).desc);
        }
        foodChoice(foodList);
    }

    void foodChoice(List<Menu> foodList) { //상품 선택하는 공동 메서드
        Scanner sc = new Scanner(java.lang.System.in);
        int choice = sc.nextInt();
        if (choice >= 1 && choice <= foodList.size()) { //상품 사이즈내에서 선택하도록 (ex_1.상하이 2.빅맥 3.슈슈버거 )
            Menu menu = foodList.get(choice - 1); // (ex_(1)내가 1번 상하이를 선택함 -> 상하이는 0번째 인덱스에 위치 -> 상품번호에서 -1하면 인덱스랑 맞춰짐 ->상하이 객체를 꺼내서 Menu로 받음
            orderCart(menu); //(2)상하이 객체를 장바구니에 넣기
        } else {
            java.lang.System.out.println("해당하는 상품이 없습니다.");
            returnMain();
        }

    }

    void orderCart(Menu menu) { //1.장바구니 추가하는 공통 메서드
        java.lang.System.out.printf("[%s | %d원 | %s]\n", menu.getName(), menu.getPrice(), menu.getDesc()); //위에서 받은 Menu객체 꺼내기
        java.lang.System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        java.lang.System.out.println("1. 확인\t 2. 취소");
        cartInput(menu);
    }


    void cartInput(Menu menu) { //2.장바구니 추가하는 공통 메서드
        Scanner sc = new Scanner(java.lang.System.in);
        int choice = sc.nextInt();
        if (choice == 1) {
            order.cartAdd(menu); //장바구니List에 담는 메서드
            java.lang.System.out.println("장바구니에 추가되었습니다.");
            kiosk();
        } else if (choice == 2) {
            kiosk();
        } else {
            java.lang.System.out.println("해당하는 메뉴가 없습니다.");
            returnMain();
        }
    }




    public void cartList() { //(1)장바구니 상품들 주문하는 메서드
        if (order.orderList.size() != 0) { //장바구니 List에 상품이 있으면,출력

            java.lang.System.out.println("[Order]");
            order.orderListPrint();
            java.lang.System.out.println();

            java.lang.System.out.println("[Total]");
            java.lang.System.out.println("총 가격 : " + order.getOrderPrice() + "원");

            java.lang.System.out.println("위와 같이 주문 하시겠습니까?");
            java.lang.System.out.println("1. 주문\t 2. 메뉴판");
            orderInput();
        } else {
            java.lang.System.out.println("[  장바구니가 비었습니다. ]");
            returnMain();

        }

    }

    void orderInput() { //(2)장바구니 상품들 주문하는 메서드
        Scanner sc = new Scanner(java.lang.System.in);
        int choice = sc.nextInt();
        if (choice == 1) {
            orderSuccess();
        } else if (choice == 2) {
            kiosk();
        } else {
            java.lang.System.out.println("해당하는 메뉴가 없습니다.");
            returnMain();
        }
    }

    public void orderSuccess() { //주문 완료
        order.count();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        kiosk();
    }

    public void returnMain() { //메인으로 돌아가는 메서드. 여기저기 끝에 붙여주면 좋음
        Scanner sc = new Scanner(java.lang.System.in);
        java.lang.System.out.println();
        java.lang.System.out.println("0. 메인으로 돌아가기");
        int choice = sc.nextInt();
        if (choice == 0) {
            kiosk();
        }
    }





}
