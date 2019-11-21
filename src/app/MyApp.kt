package app

import javafx.*
import view.MainView
import tornadofx.*


fun main(args: Array<String>){

    launch<MyApp>(args)
}

class MyApp: App(MainView::class)

