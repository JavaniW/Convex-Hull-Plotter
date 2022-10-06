module com.github.javaniw.convexhullproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.github.javaniw.convexhullproject to javafx.fxml;
    exports com.github.javaniw.convexhullproject;
}