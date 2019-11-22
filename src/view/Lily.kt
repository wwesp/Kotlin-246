package view

import tornadofx.*
import app.MyApp
import app.Styles
import javafx.scene.layout.Priority
import tornadofx.*
import view.MainView;


class lilyMain : View("lilyMain") {

    override val root = vbox {
        label(title) {
            addClass(Styles.heading)
        }
        button("Main").setOnAction {
            replaceWith(MainView())
        }
    }
}