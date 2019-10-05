package lambdas

fun main(args: Array<String>) {
//    val greetingLambda: (String)->Unit = {name -> println("Hello, $name")}
    val greetingLambda = { name: String -> println("Hello, $name") }
    greetingLambda("Ollie")

    val accounts = mutableListOf<BankAccount>()
    (0..10).forEach {
        accounts.add((BankAccount("Jon Doe", (1..1_000_000).shuffled().last())))
    }

    //    accounts.forEach {
//        println(it)
//    }

    accounts.forEach { account ->
        println(account)
    }

    println("---")
    accounts.sortBy { it.balance }
    val balances = accounts.filter { it.balance > 500_000 }

    balances.forEach {
        println(it)
    }


    println("---")
    accounts.sortBy { it.balance }
    val balances1 = accounts.filter(::filter)

    balances1.forEach {
        println(it)
    }

}

fun  filter(account: BankAccount):Boolean{
    return account.balance > 500_000
}

data class BankAccount(val name: String, val balance: Int)