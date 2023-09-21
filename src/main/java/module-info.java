module alrosa.staa.gatekeeper {
    requires javafx.controls;
    requires javafx.fxml;
    opens alrosa.staa.gatekeeper to javafx.fxml;
    exports alrosa.staa.gatekeeper;
    exports alrosa.staa.gatekeeper.objects;
    opens alrosa.staa.gatekeeper.objects to javafx.fxml;
}