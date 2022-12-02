package com.example.supplychain;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

 public class ProductDetails {
  public static TableView<Object> productTable;


 //static Product product=new Product();


  public Pane getAllProducts(){
    TableColumn id=new TableColumn( "Id");
    id.setCellValueFactory(new PropertyValueFactory<>( "id"));

    TableColumn name=new TableColumn("Name");
    name.setCellValueFactory(new PropertyValueFactory<>("name"));

    TableColumn price=new TableColumn("Price");
    price.setCellValueFactory(new PropertyValueFactory<>("price"));

    // final ObservableList<Product> data= FXCollections.observableArrayList();
    //  data.add(new Product(1,"Lenovo",8999));
      // data.add(new Product(2,"RealMe",15500));

      ObservableList<Object> item =Product.getAllProduct();
      productTable=new TableView<>();

      productTable.setItems(item);
      productTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
      productTable.getColumns().addAll(id,name,price);
      productTable.setMinSize(SupplyChain.width,SupplyChain.height-70);
     // productTable.set
      Pane tablePane=new Pane();
      tablePane.getChildren().addAll(productTable);
      return  tablePane;

  }
  public  Pane getProductsByName(String searchName){
      TableColumn id=new TableColumn( "Id");
      id.setCellValueFactory(new PropertyValueFactory<>( "id"));

      TableColumn name=new TableColumn("Name");
      name.setCellValueFactory(new PropertyValueFactory<>("name"));

      TableColumn price=new TableColumn("Price");
      price.setCellValueFactory(new PropertyValueFactory<>("price"));



      ObservableList<Object> item =Product.getProductByName(searchName);
      productTable=new TableView<>();

      productTable.setItems(item);
      productTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY); // to delete extra column.

      productTable.getColumns().addAll(id,name,price);
      Pane tablePane=new Pane();
      tablePane.setMinSize(SupplyChain.width,SupplyChain. height);
      tablePane.getChildren().addAll(productTable);
      return  tablePane;

  }
  public static Product getSelectedProduct(){
      if(productTable==null){
          System.out.println("Item not found");
          return  null;
      }
      if(productTable.getSelectionModel().getSelectedIndex()!=-1){
             Product selectedProduct= (Product) productTable.getSelectionModel().getSelectedItem();
          System.out.println(selectedProduct.getId()+" "+selectedProduct.getName()+" "+selectedProduct.getPrice());
          return  selectedProduct;
      }
      else{
          System.out.println("Nothing Selected");
          return  null;
       }
      // extra


  }
}
