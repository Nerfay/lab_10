package com.example.lab_10;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static SquareList squareList = new SquareList();
    private ObservableList<Square> getSquare() {
        final int N = 10;
        int side;
        ObservableList<Square> list1 = FXCollections.observableArrayList();
        for (int i = 0; i < N; i++) {
            Square Square = new Square((int) (Math.random() * 70 + 1));
            squareList.add(Square);
            list1.add(Square);
        }
        return list1;
    }
    public static PrismList prismList = new PrismList();
    private ObservableList<Prism> getPrism() {
        final int M = 10;
        ObservableList<Prism> list1 = FXCollections.observableArrayList();
        for (int i = 0; i < M; i++) {
            Prism Prism = new Prism((int) (Math.random() * 70 + 1), (int) (Math.random() * 70 + 1));
            prismList.add(Prism);
            list1.add(Prism);
        }
        return list1;
    }
    @Override
    public void start(Stage stage) {
        TableView<Square> SquareTable = new TableView<Square>();


        TableColumn<Square, Integer> Side = new TableColumn<Square, Integer>("Side");

        TableColumn<Square, Double> Diagonal = new TableColumn<Square, Double>("Diagonal");

        TableColumn<Square, Integer> Perimeter = new TableColumn<Square, Integer>("Perimeter");

        TableColumn<Square, Float> Square = new TableColumn<Square, Float>("Square");

        Side.setCellValueFactory(new PropertyValueFactory<>("side"));
        Diagonal.setCellValueFactory(new PropertyValueFactory<>("D"));
        Perimeter.setCellValueFactory(new PropertyValueFactory<>("Perimeter"));
        Square.setCellValueFactory(new PropertyValueFactory<>("SquareOfSquare"));

        Side.setSortType(TableColumn.SortType.DESCENDING);
        ObservableList<Square> list1 = getSquare();
        SquareTable.setItems(list1);

        SquareTable.getColumns().addAll(Side , Diagonal , Perimeter , Square);
        Label labelS = new Label("Squares");
        VBox root1 = new VBox();
        VBox.setVgrow(SquareTable, Priority.ALWAYS);
        root1.setPadding(new Insets(5));
        root1.getChildren().add(labelS);
        root1.getChildren().add(SquareTable);
        root1.getChildren().add(new Label("MaxSquare = " + squareList.getMaxSquare()));
        root1.setAlignment(Pos.CENTER);

        /*--------------------------------------------------------------------------------------------------------------------------------*/
        TableView<Prism> PrismTable = new TableView<Prism>();


        TableColumn<Prism, Integer> SideOfPrism = new TableColumn<Prism, Integer>("SideOfPrism");

        TableColumn<Prism, Double> Height = new TableColumn<Prism, Double>("Height");

        TableColumn<Prism, Integer> SquareOfSide = new TableColumn<Prism, Integer>("SquareOfSide");

        TableColumn<Prism, Float> SqureOfPrism = new TableColumn<Prism, Float>("SqureOfPrism");

        TableColumn<Prism, Integer> Volume = new TableColumn<Prism, Integer>("Volume");

        TableColumn<Prism, Float> DiagonalOfPrism = new TableColumn<Prism, Float>("DiagonalOfPrism");

        SideOfPrism.setCellValueFactory(new PropertyValueFactory<>("side"));
        Height.setCellValueFactory(new PropertyValueFactory<>("Height"));
        SquareOfSide.setCellValueFactory(new PropertyValueFactory<>("SquareOfSide"));
        SqureOfPrism.setCellValueFactory(new PropertyValueFactory<>("SqureOfPrism"));
        Volume.setCellValueFactory(new PropertyValueFactory<>("Volume"));
        DiagonalOfPrism.setCellValueFactory(new PropertyValueFactory<>("Diagonal"));

        Side.setSortType(TableColumn.SortType.DESCENDING);
        ObservableList<Prism> list = getPrism();
        PrismTable.setItems(list);

        PrismTable.getColumns().addAll(SideOfPrism , Height , SquareOfSide , SqureOfPrism, Volume ,DiagonalOfPrism);
        Label label = new Label("Prisms");
        VBox root = new VBox();
        VBox.setVgrow(PrismTable, Priority.ALWAYS);
        root.setPadding(new Insets(5));
        root.getChildren().add(label);
        root.getChildren().add(PrismTable);
        root.getChildren().add(new Label("MaxDiagonal: " + prismList.getMaxDiagonal()));
        root.setAlignment(Pos.CENTER);
        stage.setTitle("Squares and Prism");

        HBox hBox = new HBox();
        HBox.setHgrow(root, Priority.ALWAYS);
        HBox.setHgrow(root1, Priority.ALWAYS);
        hBox.getChildren().add(root1);
        hBox.getChildren().add(root);
        /*--------------------------------------------------------------------------------------------------------------------------------*/
        Scene scene = new Scene(hBox, 1300, 640);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}