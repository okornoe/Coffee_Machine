package machine

import java.util.*

fun main() {

    /**
     * If the coffee machine has enough supplies to make the specified amount of coffee,
     * the program should print "Yes, I can make that amount of coffee".
     * If the coffee machine can make more than that,
     * the program should output "Yes, I can make that amount of coffee (and even N more than that)",
     * where N is the number of additional cups of coffee that the coffee machine can make.
     * If the amount of resources is not enough to make the specified amount of coffee,
     * the program should output "No, I can make only N cups of coffee".
     */

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
}

fun calculateAmountOfCoffee(water : Int, milk: Int, coffeeBeans: Int, cupsOfCoffee: Int){
    // if coffee machine has enough supplies, "yes I can make that amount of coffee"

    if (water ==  (200 * cupsOfCoffee) && milk == (50 * cupsOfCoffee) && coffeeBeans == (15 * cupsOfCoffee) ) {
        println("Yes, I can make that amount of coffee")
    }

    // if the amount of resources requires is not enough to make the specified amount
    // "No, I can make only N cups of coffee"

    else if ((water < (200 * cupsOfCoffee)) || (milk < (50 * cupsOfCoffee))
            || (coffeeBeans < (15 * cupsOfCoffee))) {
        val minCoffee = minOf((water/200),
                (milk / 50),
                (coffeeBeans /15) )
        println("No, I can make only $minCoffee cup(s) of coffee")
    }


    // if coffee machine machine can make that amount and more,
    // "yes I can make that amount of coffee and n more"

    if (water >  (200 * cupsOfCoffee) && milk > (50 * cupsOfCoffee) && coffeeBeans > (15 * cupsOfCoffee) ) {
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



