package view

import tornadofx.*
import tornadofx.*
import app.MyApp
import app.Styles
import tornadofx.*
import java.awt.TextField
import java.util.*
import java.util.Scanner.*
import java.util.Arrays
import java.util.Random.*


var repeat_check = false

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


    fun getGuess(guess: String): String {

        repeat_check =  check_for_repeat(guess)

        if (repeat_check != false) {
            if (guess.length == 5 ) {
            }
            else {
                return "Please Enter a 5 Letter Word"
            }

        }
        else{
            if (guess.equals("")){
                return "Please Enter a Word"
            }
            return "Please Enter a Word Without Repeating Letters"
        }

        return guess
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
            guess_value++
        }
        else{
            end_game++
        }
    }

}


class chuckMain : View("chuckMain") {


    var asciiArt1: String = "\n\nWelcome to Bulls and Cows\n"



    override val root = hbox {

        gridpane {
            label(asciiArt1) {
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
            }.setOnAction {
                val game = BullsAndCows()
                var cows = game.cows.toString()
                var bulls = game.bulls.toString()
                var word_to_guess = game.get_word_to_guess()
                replaceWith(launchGame(game, cows, bulls, word_to_guess, ""))
            }
        }
    }
}

class launchGame(game: BullsAndCows, var bulls: String, var cows: String,
                 word_to_guess: String, var error_message: String) : View("Bulls And Cows") {


    var asciiArt1: String = "\n\nPlease Enter a 5 Letter Word\n"

    var guess: String = ""


    override val root = hbox {

        gridpane {
            label(asciiArt1) {
                gridpaneConstraints {
                    columnRowIndex(3, 1)
                    //marginTop = 110.0
                    marginLeft = 550.0
                }
                style {
                    fontSize = 40.0.px
                }
            }
            label("Bulls: $bulls") {
                gridpaneConstraints {
                    columnRowIndex(3, 2)
                    marginTop = 100.0
                    marginLeft = 550.0
                }
                style {
                    fontSize = 20.0.px
                }
            }
            label("Cows: $cows") {
                gridpaneConstraints {
                    columnRowIndex(3, 3)
                    marginTop = 100.0
                    marginLeft = 550.0
                }
                style {
                    fontSize = 20.0.px
                }
            }
            label(error_message) {
                gridpaneConstraints {
                    columnRowIndex(3, 4)
                    marginTop = 140.0
                    marginLeft = 550.0
                }
                style {
                    fontSize = 20.0.px
                }
            }
            label("${game.guess_value} / 5") {
                gridpaneConstraints {
                    columnRowIndex(3, 4)
                    marginTop = 100.0
                    marginLeft = 550.0
                }
                style {
                    fontSize = 20.0.px
                }
            }

            textfield {
                gridpaneConstraints {
                    columnRowIndex(3,5)
                    marginTop = 50.0
                    marginLeft = 550.0
                }
                style {
                    fontSize = 20.0.px
                }
                textProperty().addListener{ obs, old, new ->
                    guess = new
                }
            }.setOnAction {
                if (game.guess_value <= 3 ) {
                    error_message = game.getGuess(guess)
                    if (error_message.length != 5){
                        replaceWith(launchGame(game, bulls, cows, word_to_guess, error_message))
                    }
                    else {
                        game.checkAnswer(guess, word_to_guess)
                        cows = game.cows.toString()
                        bulls = game.bulls.toString()
                        if (bulls == "5") {
                            replaceWith(GameOver(1))
                        }
                    }
                    error_message = ""
                    replaceWith(launchGame(game, bulls, cows, word_to_guess, error_message))
                }
                else{
                    replaceWith(GameOver(0))
                }
            }

            button("Back") {
                useMaxWidth = true
                gridpaneConstraints {
                    columnRowIndex(3, 6)
                    marginTop = 100.0
                    marginLeft = 400.0
                    //columnSpan = 2
                    setMaxSize(120.0, 40.0)
                    setMinSize(120.0, 40.0)
                    setPrefSize(120.0, 40.0)
                }
                style {
                    fontSize = 15.0.px
                }
            }.setOnAction { replaceWith(chuckMain()) }

            button("Play") {
                useMaxWidth = true
                gridpaneConstraints {
                    columnRowIndex(4, 6)
                    marginTop = 100.0
                    marginLeft = 10.0
                    //columnSpan = 2
                    setMaxSize(120.0, 40.0)
                    setMinSize(120.0, 40.0)
                    setPrefSize(120.0, 40.0)
                }
                style {
                    fontSize = 15.0.px
                }
            }.setOnAction {
                if (game.guess_value <= 3 ) {
                    error_message = game.getGuess(guess)
                    if (error_message.length != 5){
                        replaceWith(launchGame(game, bulls, cows, word_to_guess, error_message))
                    }
                    else {
                        game.checkAnswer(guess, word_to_guess)
                        cows = game.cows.toString()
                        bulls = game.bulls.toString()
                        if (bulls == "5") {
                            replaceWith(GameOver(1))
                        }
                    }
                    error_message = ""
                    replaceWith(launchGame(game, bulls, cows, word_to_guess, error_message))
                }
                else{
                    replaceWith(GameOver(0))
                }
            }
        }
    }
}

class GameOver(gameover: Int) : View("Game Over") {


    var asciiArt1: String = "\n\nGame Over\n"

    var gameover_text: String = ""


    override val root = hbox {

        if (gameover == 0){
            gameover_text = "You Lose"
        }
        else{
            gameover_text = "You Win"
        }

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
            label(gameover_text) {
                gridpaneConstraints {
                    columnRowIndex(1, 2)
                    marginTop = 100.0
                    marginLeft = 550.0
                }
                style {
                    fontSize = 20.0.px
                }
            }
            button("Quit") {
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

            button("Play Again ") {
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
            }.setOnAction {
                val game = BullsAndCows()
                var cows = game.cows.toString()
                var bulls = game.bulls.toString()
                var word_to_guess = game.get_word_to_guess()
                replaceWith(launchGame(game, cows, bulls, word_to_guess, ""))
            }

        }
    }
}

