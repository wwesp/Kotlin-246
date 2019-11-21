package view

import tornadofx.*

import tornadofx.*
import app.MyApp
import app.Styles
import tornadofx.*

class chuckMain : View("chuckMain") {

    override val root = hbox {
        label(title) {
            addClass(Styles.heading)
        }
    }
}