package view

import tornadofx.*
import app.MyApp
import app.Styles
import tornadofx.*
import javax.xml.soap.Node


class willMain : View("willMain") {
    var textHelper="Welcome to find the Pattern!"
    var hello = Story(100)

    override val root = vbox {


        label(textHelper) {
            addClass(Styles.heading)
        }

        button("William").setOnAction {

            var h= hello;
            replaceWith(hello.storyTime(h,"R",willMain()))
        }


    }

    init {
        with (root) {

            label("My label")
        }
    }

}













open class Story(h: Int) {
    private var health: Int = 0
    var order = listOf("L","R","L","R","U","D","U","D","A","B","A","B")
    var accList = ArrayList<String>()

    init{
        health=h
        accList= ArrayList();
    }


    //returns the page name
    fun storyTime(obj: Story, turn: String, currentView: View): View {


        if(order.get(accList.size).equals(turn)){
            println("EQUAL")
            accList.add(turn)
            println(accList.size)
        }
        else{
            print(health)
            health=-10
            return currentView
        }
        if(health==0){
            return deathScreen(obj)
        }





        return willMain()

    }







}


