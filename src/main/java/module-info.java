module com.example.dp_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.testng;
    requires org.junit.jupiter.api;


    opens GUI_Package to javafx.fxml;
    opens Account_Package to javafx.base;
    exports GUI_Package;
}