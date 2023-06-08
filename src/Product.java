import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Product extends Menu {

    Integer bno;
    String request; //요청사항
    String orderDate; //주문일시
    String completionDate; //완료일시
    String state;



    public Product(Integer bno, String name, Integer price, String request, String orderDate,String completionDate,String state) {
        super(name, price);
        this.bno = bno;
        this.request = request;
        this.orderDate = orderDate;
        this.state = state;
        this.completionDate = completionDate;
    }


    public Integer getBno() {
        return bno;
    }

    public String getRequest() {
        return request;
    }

    public String getOrderDate() {
        return orderDate;
    }


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
     public String getCompletionDate() {
        return completionDate;
    }

}

