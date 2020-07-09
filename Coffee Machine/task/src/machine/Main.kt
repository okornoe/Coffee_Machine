package machine

import java.util.*

/**
 * If the coffee machine has enough supplies to make the specified amount of coffee,
 * the program should print "Yes, I can make that amount of coffee".
 * If the coffee machine can make more than that,
 * the program should output "Yes, I can make that amount of coffee (and even N more than that)",
 * where N is the number of additional cups of coffee that the coffee machine can make.
 * If the amount of resources is not enough to make the specified amount of coffee,
 * the program should output "No, I can make only N cups of coffee".
 */

fun main() {
    actions()
}

fun calculateAmountOfCoffee(water: Int, milk: Int, coffeeBeans: Int, cupsOfCoffee: Int) {

    if (water == (200 * cupsOfCoffee) && milk == (50 * cupsOfCoffee) && coffeeBeans == (15 * cupsOfCoffee)) {
        println("Yes, I can make that amount of coffee")
    } else if ((water < (200 * cupsOfCoffee)) || (milk < (50 * cupsOfCoffee))
            || (coffeeBeans < (15 * cupsOfCoffee))) {
        val minCoffee = minOf((water / 200),
                (milk / 50),
                (coffeeBeans / 15))
        println("No, I can make only $minCoffee cup(s) of coffee")
    }

    if (water > (200 * cupsOfCoffee) && milk > (50 * cupsOfCoffee) && coffeeBeans > (15 * cupsOfCoffee)) {
        if (cupsOfCoffee > 0) {
            val result = minOf((water - (cupsOfCoffee * 200)) / (200 * cupsOfCoffee),
                    (milk - (cupsOfCoffee * 50)) / (50 * cupsOfCoffee),
                    (coffeeBeans - (cupsOfCoffee * 15)) / (15 * cupsOfCoffee))
            println("Yes, I can make that amount of coffee (and even " +
                    "$result more than that)")
        } else {
            println("Yes, I can make that amount of coffee (and even 1 more than that)")
        }
    }
}

fun miniAmountOfCoffeeToMake() {
    val sc = Scanner(System.`in`)

    println("Write how many ml of water the coffee machine has: ")
    val litersOfWater = sc.nextInt()

    println("Write how many ml of milk the coffee machine has: ")
    val litersOfMilk = sc.nextInt()

    println("Write how many grams of coffee beans the coffee machine has: ")
    val gramsOfCoffee = sc.nextInt()

    println("Write how many cups of coffee you will need: ")
    val cupsOfCoffee = sc.nextInt()

    calculateAmountOfCoffee(litersOfWater, litersOfMilk, gramsOfCoffee, cupsOfCoffee)
}

fun calculateResourcesAvailable(water: Int, milk: Int, coffeeBeans: Int) = (water < 200 || milk < 75 || coffeeBeans < 12)

fun actions(nextInput: Boolean = true) {
    val scanner = Scanner(System.`in`)
    loop@ while (nextInput) {
        print("Write action (buy, fill, take, remaining, exit): ")
        when (scanner.next()) {
            "buy" -> buy()
            "fill" -> fill()
            "take" -> take()
            "remaining" -> printStateOfCoffeeMachine()
            "exit" -> break@loop
        }
    }
}

fun fill() {
    val scanner = Scanner(System.`in`)
    println("Write how many ml of water do you want to add: ")
    val addWater = scanner.nextInt()
    println("Write how many ml of milk do you want to add: ")
    val addMilk = scanner.nextInt()
    println("Write how many grams of coffee beans do you want to add: ")
    val addCoffeeBeans = scanner.nextInt()
    println("Write how many disposable cups of coffee do you want to add: ")
    val addDisposableCups = scanner.nextInt()

    GeneralVariables.quantityOfWater = GeneralVariables.quantityOfWater + addWater
    GeneralVariables.quantityOfMilk = GeneralVariables.quantityOfMilk + addMilk
    GeneralVariables.quantityOfCoffeeBeans = GeneralVariables.quantityOfCoffeeBeans + addCoffeeBeans
    GeneralVariables.quantityOfDisposableCups = GeneralVariables.quantityOfDisposableCups + addDisposableCups
}

fun take() {
    println("I gave you $${GeneralVariables.quantityOfMoney}")
    GeneralVariables.quantityOfMoney = 0
}

fun shortage(water: Int, milk: Int, coffeeBeans: Int): String {
    return when (calculateResourcesAvailable(water, milk, coffeeBeans)) {
        water < 200 -> "water"
        milk < 75 -> "milk"
        coffeeBeans < 16 -> "coffee beans"
        else -> ""
    }
}

fun buy() {
    print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
    when (Scanner(System.`in`).next()) {
        "1" -> espresso()
        "2" -> latte()
        "3" -> cappuccino()
        "back" -> actions(false)
    }
}

fun latte() {
    // latte coffee needs water(350), beans(20), milk(75), cost(7)
    if (calculateResourcesAvailable(GeneralVariables.quantityOfWater,
                    GeneralVariables.quantityOfMilk, GeneralVariables.quantityOfCoffeeBeans)) {
        println("sorry, not enough ${shortage(GeneralVariables.quantityOfWater,
                GeneralVariables.quantityOfMilk, GeneralVariables.quantityOfCoffeeBeans)}!")
    } else {

        printLatte()
    }
}

fun printLatte() {
    println("I have enough resources, making you a coffee!")
    GeneralVariables.quantityOfWater = GeneralVariables.quantityOfWater - 350
    GeneralVariables.quantityOfCoffeeBeans = GeneralVariables.quantityOfCoffeeBeans - 20
    GeneralVariables.quantityOfMoney = GeneralVariables.quantityOfMoney + 7
    GeneralVariables.quantityOfMilk = GeneralVariables.quantityOfMilk - 75
    GeneralVariables.quantityOfDisposableCups = GeneralVariables.quantityOfDisposableCups - 1
}

fun cappuccino() {
    // cappuccino coffee needs water(200), milk(100), beans(12), cost(6)
    if (calculateResourcesAvailable(GeneralVariables.quantityOfWater,
                    GeneralVariables.quantityOfMilk, GeneralVariables.quantityOfCoffeeBeans)) {
        println("sorry, not enough ${shortage(GeneralVariables.quantityOfWater,
                GeneralVariables.quantityOfMilk, GeneralVariables.quantityOfCoffeeBeans)}!")
    } else {
        printCappuccino()
    }
}

fun printCappuccino() {
    println("I have enough resources, making you a coffee!")
    GeneralVariables.quantityOfWater = GeneralVariables.quantityOfWater - 200
    GeneralVariables.quantityOfCoffeeBeans = GeneralVariables.quantityOfCoffeeBeans - 12
    GeneralVariables.quantityOfMoney = GeneralVariables.quantityOfMoney + 6
    GeneralVariables.quantityOfMilk = GeneralVariables.quantityOfMilk - 100
    GeneralVariables.quantityOfDisposableCups = GeneralVariables.quantityOfDisposableCups - 1
}

fun espresso() {
    // espresso coffee needs water(250), beans(16), cost(4)
    if (calculateResourcesAvailable(GeneralVariables.quantityOfWater,
                    GeneralVariables.quantityOfMilk, GeneralVariables.quantityOfCoffeeBeans)) {
        println("sorry, not enough ${shortage(GeneralVariables.quantityOfWater,
                GeneralVariables.quantityOfMilk, GeneralVariables.quantityOfCoffeeBeans)}!")
    } else {
        printEspresso()
    }
}

fun printEspresso() {
    println("I have enough resources, making you a coffee!")
    GeneralVariables.quantityOfWater = GeneralVariables.quantityOfWater - 250
    GeneralVariables.quantityOfCoffeeBeans = GeneralVariables.quantityOfCoffeeBeans - 16
    GeneralVariables.quantityOfMoney = GeneralVariables.quantityOfMoney + 4
    GeneralVariables.quantityOfDisposableCups = GeneralVariables.quantityOfDisposableCups - 1
}

/**
 * prints the state of the coffee machine
 */

fun printStateOfCoffeeMachine() {
    println("The coffee machine has: ")
    println("${GeneralVariables.quantityOfWater} of water")
    println("${GeneralVariables.quantityOfMilk} of milk")
    println("${GeneralVariables.quantityOfCoffeeBeans} of coffee beans")
    println("${GeneralVariables.quantityOfDisposableCups} of cups")
    println("${GeneralVariables.quantityOfMoney} of money")
}

/**
 * stores the various quantities of the coffee machine
 */

object GeneralVariables {
    var quantityOfWater = 400
    var quantityOfMilk = 540
    var quantityOfCoffeeBeans = 120
    var quantityOfDisposableCups = 9
    var quantityOfMoney = 550
}