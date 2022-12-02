package com.example.supplychain;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.sql.ResultSet;

public class Product {

    public SimpleIntegerProperty id;
    public SimpleStringProperty name;
    public SimpleDoubleProperty price;
    // to bind these variable in table view
    Product(int id,String name,double price){
        this.id=new SimpleIntegerProperty(id);
        this.name=new SimpleStringProperty(name);
        this.price=new SimpleDoubleProperty(price);
    }

    public static  ObservableList<Object> getAllProduct(){
        DatabaseConnection dbConn=new DatabaseConnection();
        ObservableList<Object> data= FXCollections.observableArrayList();
        String selectAllProducts="SELECT * FROM product";
        try {
            ResultSet rs=dbConn.getQueryTable(selectAllProducts);
            while(rs.next()) {
                data.add(new Product(rs.getInt("pid"),rs.getString("pame"),rs.getDouble("price")));
            }
            rs.close();
            }catch (Exception e){
                 e.printStackTrace();
        }
         return data;
    }
    public static  ObservableList<Object> getProductByName(String name){
        DatabaseConnection dbConn=new DatabaseConnection();
        ObservableList<Object> data= FXCollections.observableArrayList();
        String selectAllProducts= String.format("SELECT * FROM product WHERE LOWER(pame) like '%%%s%%' ",name.toLowerCase());
        try {
            ResultSet rs=dbConn.getQueryTable(selectAllProducts);
            while(rs.next()) {
                data.add(new Product(rs.getInt("pid"),rs.getString("pame"),rs.getDouble("price")));
            }
            rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }
    public static  ObservableList<Object> getAllCartProducts(){

        DatabaseConnection dbConn=new DatabaseConnection();
        ObservableList<Object>data=FXCollections.observableArrayList();
       String selectAllProducts="SELECT * FROM cart_table";
        try {
            ResultSet rs=dbConn.getQueryTable(selectAllProducts);
            while(rs.next()) {
                data.add(new Product(rs.getInt("prid"),rs.getString("pname"),rs.getDouble("pprice")));
            }
            rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return data;

    }

    public int getId(){
        return id.get();
    }
     public String getName(){
        return  name.get();
    }
    public double getPrice(){
        return  price.get();
    }
}
