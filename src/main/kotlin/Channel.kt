import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun channelTest() {
    runBlocking {
        val channel = Channel<Int>()
        launch {
            for (i in 1..5) {
                delay(1000L)
                channel.send(i*i)
            }
        }
        repeat(5, {println(channel.receive())})
    }
}
