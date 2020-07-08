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
    //miniAmountOfCoffeeToMake()
    printStateOfCoffeeMachine()
    actions()
}

/*fun calculateAmountOfCoffee(water: Int, milk: Int, coffeeBeans: Int, cupsOfCoffee: Int) {

    if (water == (200 * cupsOfCoffee) && milk == (50 * cupsOfCoffee) && coffeeBeans == (15 * cupsOfCoffee)) {
        println("Yes, I can make that amount of coffee")
    }

    else if ((water < (200 * cupsOfCoffee)) || (milk < (50 * cupsOfCoffee))
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
}*/

/*fun miniAmountOfCoffeeToMake() {
    val  sc = Scanner(System.`in`)

    println("Write how many ml of water the coffee machine has: ")
    val litersOfWater = sc.nextInt()

    println("Write how many ml of milk the coffee machine has: ")
    val litersOfMilk = sc.nextInt()

    println("Write how many grams of coffee beans the coffee machine has: ")
    val gramsOfCoffee = sc.nextInt()

    println("Write how many cups of coffee you will need: ")
    val cupsOfCoffee = sc.nextInt()

    calculateAmountOfCoffee(litersOfWater,  litersOfMilk, gramsOfCoffee, cupsOfCoffee)
}*/


fun actions() {
    val scanner = Scanner(System.`in`)
    print("Write action (buy, fill, take): ")

    when (scanner.next()) {
        "buy" -> {
            buy()
        }

        "fill" -> {
            fill()
        }

        "take" -> {
            take()
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

    println("The coffee machine has: ")
    println("${GeneralVariables.quantityOfWater + addWater} of water")
    println("${GeneralVariables.quantityOfMilk + addMilk} of milk")
    println("${GeneralVariables.quantityOfCoffeeBeans + addCoffeeBeans} of coffee beans")
    println("${GeneralVariables.quantityOfDisposableCups + addDisposableCups} of disposable cups")
    println("${GeneralVariables.quantityOfMoney} of money")

}

fun take() {
    println("I gave you $${GeneralVariables.quantityOfMoney}")
    GeneralVariables.quantityOfMoney = 0

    printStateOfCoffeeMachine()
}

fun buy() {

    print("1 - espresso, 2 - latte, 3 - cappuccino ")

    when(Scanner(System.`in`).nextInt()) {
        1 -> {
            // espresso coffee needs water(250), beans(16), cost(4)
            GeneralVariables.quantityOfWater = GeneralVariables.quantityOfWater - 250
            GeneralVariables.quantityOfCoffeeBeans = GeneralVariables.quantityOfCoffeeBeans - 16
            GeneralVariables.quantityOfMoney = GeneralVariables.quantityOfMoney + 4
            GeneralVariables.quantityOfDisposableCups = GeneralVariables.quantityOfDisposableCups - 1
            printStateOfCoffeeMachine()
        }

        2 -> {
            // latte coffee needs water(350), beans(20), milk(75), cost(7)
            GeneralVariables.quantityOfWater = GeneralVariables.quantityOfWater - 350
            GeneralVariables.quantityOfCoffeeBeans = GeneralVariables.quantityOfCoffeeBeans - 20
            GeneralVariables.quantityOfMoney = GeneralVariables.quantityOfMoney + 7
            GeneralVariables.quantityOfMilk = GeneralVariables.quantityOfMilk - 75
            GeneralVariables.quantityOfDisposableCups = GeneralVariables.quantityOfDisposableCups - 1
            printStateOfCoffeeMachine()
        }

        3 -> {
            // cappuccino coffee needs water(200), milk(100), beans(12), cost(6)
            //printStateOfCoffeeMachine()
            GeneralVariables.quantityOfWater = GeneralVariables.quantityOfWater - 200
            GeneralVariables.quantityOfCoffeeBeans = GeneralVariables.quantityOfCoffeeBeans - 12
            GeneralVariables.quantityOfMoney = GeneralVariables.quantityOfMoney + 6
            GeneralVariables.quantityOfMilk = GeneralVariables.quantityOfMilk - 100
            GeneralVariables.quantityOfDisposableCups = GeneralVariables.quantityOfDisposableCups - 1
            printStateOfCoffeeMachine()
        }
    }
}

fun printStateOfCoffeeMachine() {
    println("The coffee machine has: ")
    println("${GeneralVariables.quantityOfWater} of water")
    println("${GeneralVariables.quantityOfMilk} of milk")
    println("${GeneralVariables.quantityOfCoffeeBeans} of coffee beans")
    println("${GeneralVariables.quantityOfDisposableCups} of cups")
    println("${GeneralVariables.quantityOfMoney} of money")
}


object GeneralVariables{
    var quantityOfWater = 400
    var quantityOfMilk = 540
    var quantityOfCoffeeBeans = 120
    var quantityOfDisposableCups = 9
    var quantityOfMoney = 550
}