import java.util.*;

public class InitProduct {

    //Create 상품 생성
    //Delete 상품 삭제
    String menu = "";
    String name = "";
    Integer price = 0;
    String desc = "";


    Map<String, List<Menu>> menuMap = new HashMap<>(); //메뉴List가 들어갈 Map. 메뉴(카테고리)를 키로 설정
    List<Menu> burgerList = new ArrayList<>(); //햄버거메뉴가 들어갈 List
    List<Menu> sideList = new ArrayList<>();//사이드메뉴가 들어갈 List
    List<Menu> drinkList = new ArrayList<>();//음료수메뉴가 들어갈 List


    //상품 생성(상품 입력)
    public void write() {

        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴를 입력하세요 >>");
        menu = sc.nextLine();

        System.out.print("상품명을 입력하세요 >>");
        name = sc.nextLine();

        System.out.print("가격을 입력하세요 >>");
        price = sc.nextInt();
        sc.nextLine();

        System.out.print("상품 설명을 입력하세요 >>");
        desc = sc.nextLine();

        addMap();
    }
    public void addMap() {
        Menu menuToAdd = new Menu(name, price, desc);
        // Menu 객체를 생성하여 추가할 메뉴를 미리 준비한다(중복 코드를 피하기 위해)

        if (menu.equals("햄버거")) {
            burgerList.add(menuToAdd);
            menuMap.put("햄버거", burgerList);
        } else if (menu.equals("사이드")) {
            sideList.add(menuToAdd);
            menuMap.put("사이드", sideList);
        } else if (menu.equals("음료수")) {
            drinkList.add(menuToAdd);
            menuMap.put("음료수", drinkList);
        }

    }

    //상품 삭제







}
