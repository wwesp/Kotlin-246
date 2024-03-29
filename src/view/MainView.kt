package view

import app.MyApp
import app.Styles
import javafx.geometry.Pos
import tornadofx.*
import tornadofx.Stylesheet.Companion.button
import view.willMain;
import view.chuckMain;
import view.MalikMain;
import view.samMain;



class MainView : View("Hello TornadoFX") {
    override val root = vbox {
        setPrefSize(1600.0, 900.0)
        

        button("William").setOnAction {
            replaceWith(willMain())
        }

        button("Chuck").setOnAction {
            replaceWith(chuckMain())
        }
        button("Mailik").setOnAction {
            replaceWith(MalikMain())
        }
        button("Sam").setOnAction {
            replaceWith(samMain())
        }

    }







}





