package view

import tornadofx.*
import app.MyApp
import app.Styles
import com.sun.org.apache.bcel.internal.Repository.addClass
import javafx.scene.control.TextField
import javafx.scene.layout.Priority
import tornadofx.*
import tornadofx.Stylesheet.Companion.button
import tornadofx.Stylesheet.Companion.label
import view.MainView;


class lilyMain : View("lilyMain") {

//    var inpa: Double = 0.0
//    var inpb: Double = 0.0
//    var inpc: Double = 0.0
//    var inpd: Double = 0.0

    val defaultRead = reading(0,0,0.0)

    fun read(){


    }

    var inpa: TextField by singleAssign()
    var inpb: TextField by singleAssign()
    var inpc: TextField by singleAssign()
    var inpd: TextField by singleAssign()


    override val root = vbox {
        hbox {
            label("Base Input (A)")
            inpa = textfield{
                filterInput { it.controlNewText.isDouble() }
            }
        }
        hbox {
            label("Second Input (B)")
            inpb = textfield{
                filterInput { it.controlNewText.isDouble() }
            }
        }
        hbox {
            label("Third Input (C)")
            inpc = textfield{
                filterInput { it.controlNewText.isDouble() }
            }
        }
        hbox {
            label("Fourth Input (D)")
            inpd = textfield{
                filterInput { it.controlNewText.isDouble() }
            }
        }
        button("Set inputs") {
            useMaxWidth = true
            val test1 = inpa.text
            val ye = test1.toString()
            val yo: String = "23"
            val myNumber: Int = yo.toInt()
            val test2 = inpb.text
            action {
                println("Input A set to ${inpa.text}, input B set to ${inpb.text}, input C set to ${inpc.text}, input D set to ${inpd.text}")
                println(test1)
            }
        }
    }



    fun meme() {

    }

  //  mine
//    override val root = vbox {
//        label(title) {
//            addClass(Styles.heading)
//        }
//        button("Main").setOnAction {
//            replaceWith(MainView())
//        }
//        textfield {
//            gridpaneConstraints {
//                columnRowIndex(3,5)
//                marginTop = 50.0
//                marginLeft = 550.0
//            }
//            style {
//                fontSize = 20.0.px
//            }
    data class reading(val x: Int, val y: Int, val dist: Double){

    }
}