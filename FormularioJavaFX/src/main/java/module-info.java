module com.mycompany.formulariojavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.mycompany.formulariojavafx to javafx.fxml;
    exports com.mycompany.formulariojavafx;
}
