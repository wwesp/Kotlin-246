package view

import tornadofx.*
import tornadofx.*
import app.MyApp
import app.Styles
import tornadofx.*
import java.util.*
import java.util.Scanner.*
import java.util.Arrays
import java.util.Random.*

var repeat_check = false


fun main(args: Array<String>){

    //val read = Scanner(System.`in`)
    println("Welcome to Bulls and Cows!")
    println("Please Enter a 5 Letter Word")

    var game = BullsAndCows();

    var word_to_guess = game.get_word_to_guess()

    while (game.guess_value != 5 && game.end_game == 0) {
        var guess = game.getGuess()
        if (guess.length == 5){
            game.checkAnswer(guess, word_to_guess)
        }
    }

}


class BullsAndCows {// Constructor Declaration of Class

    var bulls: Int = 0
    var cows: Int = 0
    var guess_value: Int = 0
    var end_game: Int = 0

    fun getBullCount(): Int {
        return bulls
    }

    fun getCowCount(): Int {
        return cows
    }

    fun get_word_to_guess(): String{

        var word_to_guess = ""

        val random = Random()

        val number_for_pick = random.nextInt(9)

        val list_of_words = listOf("quick", "quack", "plans", "gnarl", "asked", "honey", "macho", "minus", "pearl", "scarf")[number_for_pick]

        word_to_guess = list_of_words

        return word_to_guess
    }

    fun check_for_repeat(guess: String): Boolean {

        var new_guess = guess.toLowerCase()
        val len = new_guess.length

        val arr = new_guess.toCharArray()

        Arrays.sort(arr)
        for (i in 0 until len - 1) {
            if (arr[i] == arr[i + 1])
                return false
        }
        return true

    }


    fun getGuess(): String {
        val guess = readLine()

        if (guess != null) {
            repeat_check =  check_for_repeat(guess)
        }

        if (repeat_check != false) {
            if (guess != null) {
                if (guess.length == 5 ) {
                }
                else {
                    println("Please Enter a 5 Letter Word")
                    //getGuess()
                    return null.toString()
                }
            }

        }
        else{
            println("Please Enter a Word Without Repeating Letters")
            //getGuess()
            return null.toString()
        }

        return guess.toString()
    }

    fun checkAnswer(guess: String, correctWord: String) {

        bulls = 0
        cows = 0

        for (i in 0 until guess.length) {
            val c = guess[i]

            if (c == correctWord.get(i)) {
                bulls++
            } else if (correctWord.contains(c.toString())) {
                cows++
            }
        }
        if (bulls != 5) {
            println("You have guessed the word " + guess)
            println("Bulls: " + bulls)
            println("Cows: " + cows)
            guess_value++
            println("Guess " + guess_value + "/5")
        }
        else{
            end_game++
            println("You Win!")
        }
    }

}


class chuckMain : View("chuckMain") {


    var asciiArt1: String = "\n\nWelcome to Bulls and Cows\n"



    override val root = hbox {

        gridpane {
            label(asciiArt1) {

                //constraintsForColumn(1)
                gridpaneConstraints {
                    columnRowIndex(1, 1)
                    marginTop = 110.0
                    marginLeft = 550.0
                }
                style {
                    fontSize = 40.0.px
                }
            }

            button("Back") {
                useMaxWidth = true
                gridpaneConstraints {
                    columnRowIndex(1, 10)
                    marginTop = 350.0
                    marginLeft = 400.0
                    columnSpan = 2
                    setMaxSize(120.0, 40.0)
                    setMinSize(120.0, 40.0)
                    setPrefSize(120.0, 40.0)
                }
                style {
                    fontSize = 15.0.px
                }
            }.setOnAction { replaceWith(MainView()) }

            button("Play") {
                useMaxWidth = true
                gridpaneConstraints {
                    columnRowIndex(2, 10)
                    marginTop = 350.0
                    marginLeft = 10.0
                    columnSpan = 2
                    setMaxSize(120.0, 40.0)
                    setMinSize(120.0, 40.0)
                    setPrefSize(120.0, 40.0)
                }
                style {
                    fontSize = 15.0.px
                }
            }.setOnAction { replaceWith(launchGame()) }
        }
    }
}

class launchGame : View("Bulls And Cows") {


    var asciiArt1: String = "\n\nPlease Enter a 5 Letter Word\n"



    override val root = hbox {

        gridpane {
            label(asciiArt1) {

                //constraintsForColumn(1)
                gridpaneConstraints {
                    columnRowIndex(1, 1)
                    marginTop = 110.0
                    marginLeft = 550.0
                }
                style {
                    fontSize = 40.0.px
                }
            }

            button("Back") {
                useMaxWidth = true
                gridpaneConstraints {
                    columnRowIndex(1, 10)
                    marginTop = 350.0
                    marginLeft = 400.0
                    columnSpan = 2
                    setMaxSize(120.0, 40.0)
                    setMinSize(120.0, 40.0)
                    setPrefSize(120.0, 40.0)
                }
                style {
                    fontSize = 15.0.px
                }
            }.setOnAction { replaceWith(MainView()) }

            button("Play") {
                useMaxWidth = true
                gridpaneConstraints {
                    columnRowIndex(2, 10)
                    marginTop = 350.0
                    marginLeft = 10.0
                    columnSpan = 2
                    setMaxSize(120.0, 40.0)
                    setMinSize(120.0, 40.0)
                    setPrefSize(120.0, 40.0)
                }
                style {
                    fontSize = 15.0.px
                }
            }
        }
    }
}

