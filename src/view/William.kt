package view

import tornadofx.*
import app.MyApp
import app.Styles
import tornadofx.*


class willMain : View("willMain") {

    override val root = hbox {
        label(title) {
            addClass(Styles.heading)
        }
    }
}