package view

import tornadofx.*
import app.MyApp
import app.Styles
import tornadofx.*


class lilyMain : View("lilyMain") {

    override val root = hbox {
        label(title) {
            addClass(Styles.heading)
        }
    }
}