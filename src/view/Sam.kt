package view

import tornadofx.*
import javafx.scene.control.TextField
import java.io.File


class samMain : View("samMain") {

    //creats the objects of data class reading with coordinates
    val readA = reading(0,0,0.0)
    val readB = reading(1,0,0.0)
    val readC = reading(0,1,0.0)
    val readD = reading(1,1,0.0)

    //creates the mock laser measure values
    var laserA: Double = 0.0
    var laserB: Double = 0.0
    var laserC: Double = 0.0
    var laserD: Double = 0.0

    //creates text fields for input
    var inpa: TextField by singleAssign()
    var inpb: TextField by singleAssign()
    var inpc: TextField by singleAssign()
    var inpd: TextField by singleAssign()

    //these fields are for inputing the mock distances
    override val root = vbox {
        hbox{
            label("Please enter the distance values with base input at correct extruder height in millimeters")
        }
        hbox {
            label("Base mm Input (A)")
            inpa = textfield {
                textProperty().addListener { obs, old, newA ->
                    println("You typed: " + newA)
                    laserA= newA.toDouble()
                }
                filterInput { it.controlNewText.isDouble() }
            }
        }
        hbox {
            label("Second mm Input (B)")
            inpb = textfield {
                textProperty().addListener { obs, old, newB ->
                    println("You typed: " + newB)
                    laserB = newB.toDouble()
                }
                filterInput { it.controlNewText.isDouble() }
            }
        }
        hbox {
            label("Third mm Input (C)")
            inpc = textfield {
                textProperty().addListener { obs, old, newC ->
                    println("You typed: " + newC)
                    laserC = newC.toDouble()
                }
                filterInput { it.controlNewText.isDouble() }
            }
        }
        hbox {
            label("Fourth mm Input (D)")
            inpd = textfield {
                textProperty().addListener { obs, old, newD ->
                    println("You typed: " + newD)
                    laserD = newD.toDouble()
                }
                filterInput { it.controlNewText.isDouble() }
            }
        }
        button("Set inputs") {
            useMaxWidth = true
            action {
                println("Input A set to ${inpa.text}, input B set to ${inpb.text}, input C set to ${inpc.text}, input D set to ${inpd.text} \n")

                //sets the distances in the data classes to the according laser measurement
                readA.dist = laserA
                readB.dist = laserB
                readC.dist = laserC
                readD.dist = laserD

                //writes the data class objects to a text file for storage
                File("data.txt").writeText("${readA.toString()}, ${readB.toString()}, ${readC.toString()}, ${readD.toString()}")

                //sends user to page containing data with the data classes as parameters
                replaceWith(samMain2(readA, readB, readC, readD))

            }
        }
        //sends user to home page
        button("Home").setOnAction {
            replaceWith(MainView())
        }
    }

    //creates the data class used throughout
    data class reading(val x: Int, val y: Int, var dist: Double){}
}

