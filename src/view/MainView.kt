package view

import app.MyApp
import app.Styles
import tornadofx.*
import view.willMain;
import view.chuckMain;
import view.malikMain;
import view.lillyMain;



class MainView : View("Hello TornadoFX") {
    override val root = hbox {

        button("William").setOnAction {
            replaceWith(willMain())
        }

        button("Chuck").setOnAction {
            replaceWith(chuckMain())
        }
        button("Mailik").setOnAction {
            replaceWith(malikMain())
        }
        button("Lilly").setOnAction {
            replaceWith(lillyMain())
        }





    }
}





