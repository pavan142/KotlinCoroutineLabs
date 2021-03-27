import kotlinx.coroutines.delay
import kotlin.coroutines.coroutineContext

object FooSingleton {
    fun doSomething() {
        println("I am doing something" + Utils.timePassed())
    }
    init {
        println("I am getting initialized" + Utils.timePassed())
    }
}

suspend fun singletonTest() {
    delay(1000L)
    FooSingleton.doSomething()
}