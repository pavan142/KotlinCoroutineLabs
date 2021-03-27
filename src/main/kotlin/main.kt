import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
 println("Just started"+Utils.timePassed())
 runBlocking {
//     launch_vs_async()
//     channelTest()
//      singletonTest()
     ScopeTests().demo()
 }
    Thread.sleep(4000)
}
