package view

import tornadofx.*
import app.MyApp
import app.Styles
import tornadofx.*


class willMain : View("willMain") {
    var textHelper="hello";

    override val root = vbox {


        label(textHelper) {
            addClass(Styles.heading)
        }

        form {
            textfield {
                textHelper;
            }
        }
        button("William").setOnAction {
            textHelper="yeet";
        }

    }







    init {
        with (root) {
            prefWidth = 800.0
            prefHeight = 600.0
            label("My label")
        }
    }






}