package view

import tornadofx.*
import app.MyApp
import app.Styles
import tornadofx.*
import javax.xml.soap.Node


class willMain : View("willMain") {
    var textHelper="hello"
    var hello = Story()

    override val root = vbox {


        label(textHelper) {
            addClass(Styles.heading)
        }

        form {
            textfield {
                textHelper
            }
        }
        button("William").setOnAction {

            var h= hello;
            replaceWith(hello.storyTime(h))
        }

    }

    init {
        with (root) {

            label("My label")
        }
    }

}













open class Story() {
    public open var dead: Int = 1


    //returns the page name
    fun storyTime(obj: Story): View {

        if(dead==1){
            return deathScreen(obj)
        }

        return willMain()

    }
}


