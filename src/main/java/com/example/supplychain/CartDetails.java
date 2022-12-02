package com.example.supplychain;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CartDetails {
  /*  public SimpleIntegerProperty id;
    public SimpleStringProperty name;
    public SimpleDoubleProperty price;
    // to bind these variable in table view
    Product(int id,String name,double price){
        this.id=new SimpleIntegerProperty(id);
        this.name=new SimpleStringProperty(name);
        this.price=new SimpleDoubleProperty(price);
    } */
    static public TableView<Object> cartTable;
    ProductDetails productDetails=new ProductDetails();
    Product product=productDetails.getSelectedProduct();
    public Pane getAllCartProducts() {
        TableColumn id=new TableColumn( "Id");
        id.setCellValueFactory(new PropertyValueFactory<>( "id"));

        TableColumn name=new TableColumn("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn price=new TableColumn("Price");
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

        final ObservableList<Product> data= FXCollections.observableArrayList();
       // data.add(new Product(1,"Lenovo",8999));
        //data.add(new Product(2,"RealMe",15500));

       // data.add(new Product(product.getInt("Id"),rs.getString("name"),rs.getDouble("price")));

        ObservableList<Object> item =Product.getAllCartProducts();
        cartTable=new TableView<>();

        cartTable.setItems(item);
        cartTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        cartTable.getColumns().addAll(id,name,price);
        cartTable.setMinSize(SupplyChain.width,SupplyChain.height-70);
        // productTable.set
        Pane tablePane=new Pane();
        tablePane.getChildren().addAll(cartTable);
        return  tablePane;

    }
  /*  public int getId(){
        return id.get();
    }
    public String getName(){
        return  name.get();
    }
    public double getPrice(){
        return  price.get();
    } */
}
