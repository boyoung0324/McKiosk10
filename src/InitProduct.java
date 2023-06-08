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

    //상품 삭제
    public void delete() {
        Scanner sc = new Scanner(System.in);
        Mcdonald list = new Mcdonald();

        System.out.println(list.mainList);

        int choice = sc.nextInt();
        sc.nextLine();
        if (choice == 1) {
            if (burgerList != null) {
                burgerList.stream().forEach(burger -> System.out.println(burger.getName() + burger.getId()));
                System.out.println("삭제할 상품의 ID값을 입력해주세요.");
                String id = sc.nextLine();
                int index = 0;
                for (int i = 0; i < burgerList.size(); i++) {
                    if (burgerList.get(i).getId() == id) {
                        index = i;
                        break;
                    }
                }
                burgerList.remove(index);
                System.out.println(" 상품이 삭제되었습니다.\n");
                System.out.println("-------------------------------");
                System.out.println(list.mainList);
            } else {
                System.out.println("삭제할 상품이 존재하지 않습니다.");
                System.out.println(list.mainList);
            }
        } else if (choice == 2) {
            if (sideList != null) {
                sideList.stream().forEach(side -> System.out.println(side.getName() + side.getId()));
                System.out.println("삭제할 상품의 ID값을 입력해주세요.");
                String id = sc.nextLine();
                int index = 0;
                for (int i = 0; i < sideList.size(); i++) {
                    if (sideList.get(i).getId() == id) {
                        index = i;
                        break;
                    }
                }
                sideList.remove(index);
                System.out.println(" 상품이 삭제되었습니다.\n");
                System.out.println("-------------------------------");
                System.out.println(list.mainList);
            } else {
                System.out.println("삭제할 상품이 존재하지 않습니다.");
                System.out.println(list.mainList);
            }
        } else if (choice == 3) {
            if (drinkList != null) {
                drinkList.stream().forEach(drink -> System.out.println(drink.getName() + drink.getId()));
                System.out.println("삭제할 상품의 ID값을 입력해주세요.");
                String id = sc.nextLine();
                int index = 0;
                for (int i = 0; i < drinkList.size(); i++) {
                    if (drinkList.get(i).getId() == id) {
                        index = i;
                        break;
                    }
                }
                drinkList.remove(index);
                System.out.println(" 상품이 삭제되었습니다.\n");
                System.out.println("-------------------------------");
                System.out.println(list.mainList);
            } else {
                System.out.println("삭제할 상품이 존재하지 않습니다.");
                System.out.println(list.mainList);
            }
        }
    }
}
