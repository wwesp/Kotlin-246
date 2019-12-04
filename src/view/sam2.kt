package view

import kotlin.math.round
import tornadofx.*
import java.math.RoundingMode
import java.math.BigDecimal

class samMain2(readingA: samMain.reading, readingB: samMain.reading, readingC: samMain.reading, readingD: samMain.reading) : View("samMain2") {
    override val root = vbox {
        setPrefSize(1600.0, 900.0)

        //rounds the degrees needed to spin the knobs to a more readable number
        val knobB = BigDecimal(wheelTurn(readingA.dist, readingB.dist)).setScale(2, RoundingMode.HALF_EVEN)
        val knobC = BigDecimal(wheelTurn(readingA.dist, readingC.dist)).setScale(2, RoundingMode.HALF_EVEN)
        val knobD = BigDecimal(wheelTurn(readingA.dist, readingD.dist)).setScale(2, RoundingMode.HALF_EVEN)

        //prints out degrees to spin
        label("Turn knob B ${knobB} degrees")
        label("Turn knob C ${knobC} degrees")
        label("Turn knob D ${knobD} degrees")


        //the "go-back" buttons
        button("Back").setOnAction {
            replaceWith(samMain())
        }
        button("Home").setOnAction {
            replaceWith(MainView())
        }
    }

    //This method finds the degrees needed to turn a knob in order to level the print bed with the base input
    fun wheelTurn(base: Double, other: Double): Double {

        //Finds how many millimeters to raise or lower
        var len: Double = base - other

        //because one full rotation is 0.6 mm, len is devided by it than multiplied by 360 to find the degrees
        //for instance, if the bed needed moved 0.6 mm, it would be 1 rotation which is 360 degrees
        val degreesToTurn = (len/0.6)*360

        return degreesToTurn
    }

}





