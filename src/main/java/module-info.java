module com.example.task_7 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.task_7 to javafx.fxml;
    exports com.example.task_7;
}