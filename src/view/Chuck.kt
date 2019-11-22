package view

import tornadofx.*
import tornadofx.*
import app.MyApp
import app.Styles
import tornadofx.*
import java.util.*
import java.util.Scanner.*
import java.util.Arrays

var repeat_check = false


fun main(args: Array<String>){

    //val read = Scanner(System.`in`)
    println("Welcome to Bulls and Cows!")
    println("Please Enter a 5 Letter Word")

    val user_guess = getGuess()
}


fun getGuess(): String? {
    val guess = readLine()

    if (guess != null) {
       repeat_check =  check_for_repeat(guess)
    }

    if (repeat_check != false) {
        if (guess != null) {
            if (guess.length == 5 ) {
                println(guess)
            }
            else {
                println("Please Enter a 5 Letter Word")
                getGuess()
            }
        }

    }
    else{
        println("Please Enter a Word Without Repeating Letters")
        getGuess()
    }

    return guess
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


class chuckMain : View("chuckMain") {


    override val root = hbox {
        label(title) {
            addClass(Styles.heading)
        }
    }
}
