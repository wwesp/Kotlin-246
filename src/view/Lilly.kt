package view

import tornadofx.*
import app.MyApp
import app.Styles
import tornadofx.*


class lillyMain : View("lillyMain") {

    override val root = hbox {
        label(title) {
            addClass(Styles.heading)
        }
    }
}