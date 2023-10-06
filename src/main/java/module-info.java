module alrosa.staa.gatekeeper {
    requires javafx.controls;
    requires javafx.fxml;
    opens alrosa.staa.gatekeeper to javafx.fxml;
    exports alrosa.staa.gatekeeper;
    exports alrosa.staa.gatekeeper.objects;
    opens alrosa.staa.gatekeeper.objects to javafx.fxml;
    exports alrosa.staa.gatekeeper.containers;
    opens alrosa.staa.gatekeeper.containers to javafx.fxml;
    exports alrosa.staa.gatekeeper.objects.global;
    opens alrosa.staa.gatekeeper.objects.global to javafx.fxml;
    exports alrosa.staa.gatekeeper.objects.server;
    opens alrosa.staa.gatekeeper.objects.server to javafx.fxml;
    exports alrosa.staa.gatekeeper.objects.bureau;
    opens alrosa.staa.gatekeeper.objects.bureau to javafx.fxml;
    exports alrosa.staa.gatekeeper.objects.computer;
    opens alrosa.staa.gatekeeper.objects.computer to javafx.fxml;
    exports alrosa.staa.gatekeeper.objects.mainsystem;
    opens alrosa.staa.gatekeeper.objects.mainsystem to javafx.fxml;
    exports alrosa.staa.gatekeeper.objects.server.perco;
    opens alrosa.staa.gatekeeper.objects.server.perco to javafx.fxml;
}