package view

import app.Styles
import javafx.scene.control.TextArea
import tornadofx.*
import java.io.File
import kotlin.system.exitProcess

class MalikMain : View("") {

    lateinit var ta: TextArea
    override val root = hbox {


        label(title) {
            addClass(Styles.heading)
        }
        pane{

            ta = textarea()
            ta.isWrapText = true

            ta.translateX = 0.0
            ta.translateY = 50.0
            ta.maxWidth = 400.0
            ta.maxHeight = 800.0
            ta.text = readFromFile("src/resources/twoNumbers.txt")

        }
    }




    fun gcd2(a:Int, b:Int):Int{
        if (b==0)
            return a else return gcd2(b, a%b)
    }

    fun readFromFile(fileName: String): String {

        //Kotlin
        val file = fileName
        try {
           var lines: String = File(file).readLines().toString()
            var a = lines.split(" ")
            var b = a[1].substring(0, 3).toInt()
            println(b)
            return "gcd for "+a[0].substring(1)+ " and " + b+ " is " + gcd2(a[0].substring(1).toInt(), b)


            return a.toString()
        }catch(e: Exception){
            e.printStackTrace()
            exitProcess(-1)
        }
    }

}

