import java.util.UUID;

public class Menu {

    private String menu;
    private String name;
    private Integer price;
    private String desc;
    private String id;

    public Menu(String menu, String desc) { //메뉴 카테고리 출력할 때 사용할 생성자
        this.menu = menu;
        this.desc = desc;
    }

    public Menu(String name, Integer price) { //Product에서 사용할 생성자
        this.name = name;
        this.price = price;
    }

    public Menu(String name, Integer price, String desc) { // 상품 등록, 상품 출력 등등
        this.name = name;
        this.price = price;
        this.desc = desc;
        this.id = UUID.randomUUID().toString();
    }


    public String getMenu() {
        return menu;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public String getDesc() {
        return desc;
    }

    public String getId() {
        return id;
    }
}
