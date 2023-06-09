import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Product extends Menu {

     private Integer bno;
     private String request; //요청사항
     private String orderDate; //주문일시
     private String completionDate; //완료일시
     private String state;


    public Product(Integer bno, String name, Integer price, String request, String orderDate, String state) {
        super(name, price);
        this.bno = bno;
        this.request = request;
        this.orderDate = orderDate;
        this.state = state;
    }

    public Product(Integer bno, String name, Integer price, String request, String orderDate, String completionDate, String state) {
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

    public String getCompletionDate() {
        return completionDate;
    }

}

