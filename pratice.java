import java.util.Scanner;

class practice {
  public static void main(String[] args) {
    Scanner data = new Scanner(System.in);
    System.out.println("Enter Item Code");
    String code = data.next();
    System.out.println("Enter how many orders");
    int orders = data.nextInt();

    float[] price ={56.78f, 99.99f, 12.78f, 500.00f};
    String[] beverage = {"Pasta", "Burger", "Drinks", "Cake"};
    String[] dataCode = {"XS33", "PO45", "MB67", "WE67"};

    if (code.equals(dataCode[0])){
        System.out.println("Item:" + code);
        System.out.println("Order:" + beverage[0]);
        System.out.println("Price:" + price[0]*orders);
    }
    if (code.equals(dataCode[1])){
        System.out.println("Item:" + code);
        System.out.println("Order:" + beverage[1]);
        System.out.println("Price:" + price[1]*orders);
    }
    if (code.equals(dataCode[2])){
        System.out.println("Item:" + code);
        System.out.println("Order:" + beverage[2]);
        System.out.println("Price:" + price[2]*orders);
    }
    if (code.equals(dataCode[3])){
        System.out.println("Item:" + code);
        System.out.println("Order:" + beverage[3]);
        System.out.println("Price:" + price[3]*orders);
    }
    else  {
        String x = "Invalid Order Item";
        System.out.println(x);
    }
}
}
   