module com.example.gestordepedidos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires lombok;
//    requires lombok;


    opens com.example.gestordepedidos to javafx.fxml;
    exports com.example.gestordepedidos;


}