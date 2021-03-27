/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
import kotlinx.coroutines.*
val start = System.currentTimeMillis()
fun timePassed(): String {
    return " @" + (System.currentTimeMillis() - start) + "ms"
}
class ScopeTests: CoroutineScope {
    var job = Job()
    override val coroutineContext
        get() = Dispatchers.Default + job

    fun demo() {
        launch {
            println("In type1 launch, line1" + timePassed());
            launch {
                delay(1000)
            }
            println("In type1 launch, line2" + timePassed())
        }

        launch {
            println("In type2 launch, line1" + timePassed());
            delay(1000)
            println("In type2 launch, line2" + timePassed())
        }
    }

    fun foo() {
        launch {
            println("foo: before calling bar" + timePassed()+ "{$coroutineContext")
            bar_as_child()
            println("foo: after calling bar" + timePassed()+ "$coroutineContext")
        }
    }

    suspend fun bar_as_sibling() {
        // This coroutine will have no impact on parent coroutine, it does not suspend it
        // This coroutine shall be a sibling of parent coroutine
        launch {
            delay(1000)
            println("hi from bar with own launch" + timePassed() + "$coroutineContext")
        }
    }

    suspend fun bar_as_child() {
        // This coroutine will make the parent coroutine suspend when this is suspended
        // This coroutine shall be a child of parent coroutine
        delay(1000)
        println("hi from bar without own launch" + timePassed()+ "$coroutineContext")
    }
}
