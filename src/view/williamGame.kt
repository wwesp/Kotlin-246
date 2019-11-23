package view

import app.Styles
import tornadofx.*
import view.willMain
import view.Story



class deathScreen (obj: Story): View("deathScreen") {
    var textHelper="hello"

    override val root = vbox {
        label(){
        }
    }

    init {
        with (root) {
        }
    }

}



class gameStart(obj: Story) : View("willMain") {
    var textHelper="Welcome to find the Pattern!"


    override val root = vbox {


        label(textHelper) {
            addClass(Styles.heading)
        }

        button("William").setOnAction {

            var h= obj;
            replaceWith(obj.storyTime(h,"R",gameStart(h)))
        }


    }

    init {
        with (root) {

            label("My label")
        }
    }

}




