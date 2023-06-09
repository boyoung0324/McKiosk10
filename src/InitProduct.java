import java.util.*;

public class InitProduct {

    //Create 상품 생성
    //Delete 상품 삭제
    private String menu = "";
    private String name = "";
    private Integer price = 0;
    private String desc = "";


    private Map<String, List<Menu>> menuMap = new HashMap<>(); //메뉴List가 들어갈 Map. 메뉴(카테고리)를 키로 설정
    private List<Menu> burgerList = new ArrayList<>(); //햄버거메뉴가 들어갈 List
    private List<Menu> sideList = new ArrayList<>();//사이드메뉴가 들어갈 List
    private List<Menu> drinkList = new ArrayList<>();//음료수메뉴가 들어갈 List


    //상품 생성(상품 입력)
    public void write() {
        Scanner sc = new Scanner(System.in);
        System.out.println("생성할 메뉴를 선택하세요 >>");
        System.out.println("1.햄버거  |  2.사이드  |  3.음료수");
        String input = sc.nextLine();
        int choice = Integer.parseInt(input);

        writeInput(choice);

        System.out.print("상품명을 입력하세요 >>");
        name = sc.nextLine();


        System.out.print("가격을 입력하세요 >>");
        input = sc.nextLine();
        price = Integer.parseInt(input);

        System.out.print("상품 설명을 입력하세요 >>");
        desc = sc.nextLine();

        addMap();
    }

    public void writeInput(int choice) {

        switch (choice) {
            case 1:
                menu = "햄버거";
                break;
            case 2:
                menu = "사이드";
                break;
            case 3:
                menu = "음료수";
                break;
            default:
                System.out.println("없는 메뉴입니다.");
                write();
        }
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
        System.out.println("삭제할 메뉴를 선택하세요 >>");
        System.out.println("1.햄버거  |  2.사이드  |  3.음료수");
        String input = sc.nextLine();
        int choice = Integer.parseInt(input);

        switch (choice) {
            case 1:
                deleteChoice(burgerList, sc);
                break;
            case 2:
                deleteChoice(sideList, sc);
                break;
            case 3:
                deleteChoice(drinkList, sc);
                break;
            default:
                System.out.println("해당하는 메뉴가 없습니다.");
                delete();
        }

    }

    public void deleteChoice(List<Menu> menuList, Scanner sc) {
        if (menuList.size() != 0) {
            menuList.stream().forEach(data -> System.out.printf("상품 : %s   |   ID : %s\n", data.getName(), data.getId()));
            System.out.print("삭제할 상품의 ID값을 입력해주세요 >> ");
            String id = sc.nextLine();
            menuList.removeIf(data -> id.equals(data.getId()));
            System.out.println();
            System.out.println("상품이 삭제되었습니다.");
        } else {
            System.out.println("삭제할 상품이 존재하지 않습니다.");
        }
    }


}
