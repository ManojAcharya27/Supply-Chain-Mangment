package com.example.supplychain;

public class Order {
    public  static boolean  placeSingleOrder(Product product,String customerEmail){
        String orderQuery=String.format(" INSERT INTO orders (qunatity,customer_id,product_id,status) VALUES(1,(SELECT cid FROM customer WHERE email= '%s'), %s, 'Ordered')"
        ,customerEmail,product.getId());
        System.out.println(orderQuery);

        DatabaseConnection dbConn=new DatabaseConnection();

        if(dbConn.insertData(orderQuery)>=1)
        {
            return  true;
        }
        System.out.println(orderQuery);

        return false;


    }
   static ProductDetails productDetails=new ProductDetails();
   static Product product=productDetails.getSelectedProduct();
    public  static boolean insertingIntoCart()
    {
        String cartQuerry=String.format("INSERT INTO cart_table(prid,pname,pprice) Values('%s','%s','%s')"
                ,product.getId(),product.getName(),product.getPrice());
        DatabaseConnection dbConn=new DatabaseConnection();

        if(dbConn.insertData(cartQuerry)>=1)
        {
            return  true;
        }
        System.out.println(cartQuerry);
        return false;
    }
}
