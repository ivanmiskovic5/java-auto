module ba.sum.fpmoz.pjavaprojektauto {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires org.kordamp.bootstrapfx.core;

    opens ba.sum.fpmoz.pjavaprojektauto to javafx.fxml;
    opens ba.sum.fpmoz.pjavaprojektauto.model to javafx.fxml;
    exports ba.sum.fpmoz.pjavaprojektauto;
    exports ba.sum.fpmoz.pjavaprojektauto.controller;
    exports ba.sum.fpmoz.pjavaprojektauto.model;
    opens ba.sum.fpmoz.pjavaprojektauto.controller to javafx.fxml;
}