package hello.corekotlin.singleton

class StatefulService {

//    var price: Int? = null

    fun order(name: String, price: Int): Int {
        println("name = $name, price = $price")
//        this.price = price
        return price
    }
}

