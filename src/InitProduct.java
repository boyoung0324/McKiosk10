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

    public List<Menu> returnList(String key) {
        return menuMap.get(key);
    } //map에 value(List객체)를 반환


    //상품 삭제
    public void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. 햄버거 삭제.");
        System.out.println("2. 사이드 삭제.");
        System.out.println("3. 음료수 삭제.");

        int choice = sc.nextInt();
        sc.nextLine();
        if (choice == 1) {
            if (burgerList.size() != 0) {
                burgerList.stream().forEach(burger -> System.out.println(burger.getName() + "  /  " + burger.getId()));
                System.out.println("삭제할 상품의 ID값을 입력해주세요.");
                String id = sc.nextLine();
                int index = 0;
                for (int i = 0; i < burgerList.size(); i++) {
                    if (burgerList.get(i).getId().equals(id)) {
                        index = i;
                        burgerList.remove(index);
                        System.out.println(" 상품이 삭제되었습니다.\n");
                        System.out.println("-------------------------------");
                        break;
                    } else {
                        System.out.println("ID값이 일치하지 않습니다.");
                        break;
                    }
                }

            } else {
                System.out.println("삭제할 상품이 존재하지 않습니다.");
            }
        } if (choice == 2) {
            if (sideList.size() != 0) {
                sideList.stream().forEach(side -> System.out.println(side.getName() + "  /  " + side.getId()));
                System.out.println("삭제할 상품의 ID값을 입력해주세요.");
                String id = sc.nextLine();
                int index = 0;
                for (int i = 0; i < sideList.size(); i++) {
                    if (sideList.get(i).getId().equals(id)) {
                        index = i;
                        sideList.remove(index);
                        System.out.println(" 상품이 삭제되었습니다.\n");
                        System.out.println("-------------------------------");
                        break;
                    } else {
                        System.out.println("ID값이 일치하지 않습니다.");
                        break;
                    }
                }


            } else {
                System.out.println("삭제할 상품이 존재하지 않습니다.");
            }
        } if (choice == 3) {
            if (drinkList.size() != 0) {
                drinkList.stream().forEach(drink -> System.out.println(drink.getName() + "  /  " + drink.getId()));
                System.out.println("삭제할 상품의 ID값을 입력해주세요.");
                String id = sc.nextLine();
                int index = 0;
                for (int i = 0; i < drinkList.size(); i++) {
                    if (drinkList.get(i).getId().equals(id)) {
                        index = i;
                        drinkList.remove(index);
                        System.out.println(" 상품이 삭제되었습니다.\n");
                        System.out.println("-------------------------------");
                        break;
                    } else {
                        System.out.println("ID값이 일치하지 않습니다.");
                        break;
                    }
                }


            } else {
                System.out.println("삭제할 상품이 존재하지 않습니다.");
            }
        }
    }


}
