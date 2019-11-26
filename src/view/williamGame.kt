package view

import app.Styles
import tornadofx.*
import view.willMain
import view.Story


class startScreen (obj: Story, message: String): View("you're on path :"+ obj.getPageImOn()+ " of 12 ") {
    var textHelper=message


    override val root = vbox {
        label(textHelper)
        var options =  obj.returnOptions()



                //Considered choice 0
        //the !! asserts it wont be null
        button(options!!.get(0)).setOnAction {
            replaceWith(ButtonsInOne(0,obj))

        }

        //Considered choice 1
        button(options.get(1)).setOnAction {
            replaceWith(ButtonsInOne(1,obj))
        }

        //Considered choice 2
        button(options.get(2)).setOnAction {
            replaceWith(ButtonsInOne(2,obj))
        }

        //Considered choice 3
        button(options.get(3)).setOnAction {
            replaceWith(ButtonsInOne(3,obj))
        }

    }

    init {
        with (root) {
        }
    }

}

fun ButtonsInOne(choiceNum : Int, obj: Story): View{
    var pathReturn =false
    var death = false




    pathReturn =obj.pathChoice(choiceNum)
    if(pathReturn){
        var messageToPass = "Good Job! "

        if(obj.getPageImOn()!=13) {
            return startScreen(obj, messageToPass)
        }
        else{
            return winScreen()
        }

    }
    else{
        death= obj.didIDie()
        if(death){
            return deathScreen()
        }
        else{
            var messageToPass = "You failed, try again. You know have only "+ obj.getHealth()+" tries left!"
            return startScreen(obj,messageToPass)
        }

    }


}



class winScreen: View("YOU WON") {
    var textHelper="You Won!"

    override val root = vbox {
        label(textHelper)
        button("go to main page").setOnAction {
            replaceWith(MainView())
        }

    }

    init {
        with (root) {
        }
    }

}



class deathScreen: View("deathScreen") {
    var textHelper="You Died, would you like to restart or go to main page"

    override val root = vbox {
        button("go to main page").setOnAction {
            replaceWith(MainView())
        }
        button("Start Again").setOnAction {
            var storyObj = Story(10)
            replaceWith(startScreen(storyObj,""))
        }
    }

    init {
        with (root) {
        }
    }

}







