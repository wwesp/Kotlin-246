package view

import kotlin.math.round
import tornadofx.*
import java.math.RoundingMode
import java.math.BigDecimal

class samMain2(readingA: samMain.reading, readingB: samMain.reading, readingC: samMain.reading, readingD: samMain.reading) : View("samMain2") {
    override val root = vbox {
        setPrefSize(1600.0, 900.0)

        val knobB = BigDecimal(wheelTurn(readingA.dist, readingB.dist)).setScale(2, RoundingMode.HALF_EVEN)
        val knobC = BigDecimal(wheelTurn(readingA.dist, readingC.dist)).setScale(2, RoundingMode.HALF_EVEN)
        val knobD = BigDecimal(wheelTurn(readingA.dist, readingD.dist)).setScale(2, RoundingMode.HALF_EVEN)

        label("Turn knob B ${knobB} degrees")
        label("Turn knob C ${knobC} degrees")
        label("Turn knob D ${knobD} degrees")


        button("Back").setOnAction {
            replaceWith(samMain())
        }
        button("Home").setOnAction {
            replaceWith(MainView())
        }
    }


    fun wheelTurn(base: Double, other: Double): Double {
        var len: Double = base - other
        val degreesToTurn = (len/0.6)*360
        return degreesToTurn
    }

}





