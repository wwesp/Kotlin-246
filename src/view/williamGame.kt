package view

import app.Styles
import tornadofx.*
import view.willMain
import view.Story



class deathScreen (obj: Story): View("deathScreen") {
    var textHelper="hello"

    override val root = vbox {
        label(obj.dead.toString()){

        }
    }

    init {
        with (root) {


        }
    }

}



