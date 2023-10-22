module com.example.proyectoBaseJDBCYJavaFX {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires lombok;
//    requires lombok;


    opens com.example.proyectoBaseJDBCYJavaFX to javafx.fxml;
    exports com.example.proyectoBaseJDBCYJavaFX;


}