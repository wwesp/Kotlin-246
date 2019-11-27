package view

import tornadofx.*
import app.MyApp
import app.Styles
import tornadofx.*
import javax.xml.soap.Node


class willMain : View("willMain") {
    var textHelper="Welcome to find the Pattern!"
    var storyObj = Story(10)

    override val root = vbox {
        prefWidth = 800.0
        prefHeight = 600.0

        label(textHelper) {
            addClass(Styles.heading)
        }

        button("Press me to start").setOnAction {
            replaceWith(startScreen(storyObj,""))
        }


    }

    init {
        with (root) {

            label(storyObj.getHealth().toString())
        }
    }

}













open class Story(h: Int) {
    private var health: Int
    private var pageImOn: Int
    //the hash maps match each other. these are what the buttons will display

    //its a gaming code converted to hex
    val pagePaths = mapOf(
            1 to listOf("52","55","42","4C"),
            2 to listOf("41","42","52","44"),
            3 to listOf("4C","41","55","42"),
            4 to listOf("55","52","4C","42"),
            5 to listOf("44","41","42","55"),
            6 to listOf("44","55","52","42"),
            7 to listOf("52","55","4C","42"),
            8 to listOf("41","52","44","42"),
            9 to listOf("44","4C","41","55"),
            10 to listOf("52","55","4C","42"),
            11 to listOf("42","4C","41","52"),
            12 to listOf("42","55","52","44")
    )
    //maps the winning choice for pagepaths
    val winningPath = mapOf(
            1 to 3,
            2 to 2,
            3 to 0,
            4 to 1,
            5 to 3,
            6 to 0,
            7 to 1,
            8 to 2,
            9 to 2,
            10 to 3,
            11 to 2,
            12 to 0
    )

    val lambdaEx: Map<Int,List<String>>.(Map<Int,Int>, Int) -> Pair<Int,List<String>> =
            { second,third -> Pair(second[third], this[third]) as Pair<Int, List<String>> }

    var accList = ArrayList<String>()

    init{
        health=h
        pageImOn=1;
        accList= ArrayList();
    }



    //fist to call
    fun pathChoice(choice: Int): Boolean {

        return if(winningPath.get(pageImOn)==choice){
            pageImOn++
            true
        }
        else{
            health= health-1
            false
        }



    }
    //a lambda version of the funciton above
    var pathChoice2 = { x:Int ->
        if(winningPath.get(pageImOn)==x){
            pageImOn++
            true
        }
        else{
            health= health-1
            false
        }
    }







    //second to call
    fun didIDie() = health<=0



    // if you take : out of the thing, it removes explicit type inference
    fun returnOptions() = pagePaths.get(pageImOn)

    fun getPageImOn()= pageImOn
    fun getHealth()= health
    fun getpagePaths()= pagePaths;
    fun getwinningPath()= winningPath;


}











