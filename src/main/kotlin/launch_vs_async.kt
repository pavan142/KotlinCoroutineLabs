import javafx.application.Application.launch
import kotlinx.coroutines.*

suspend fun A () {
    println("A-Task1:: " + Thread.currentThread().toString())
    delay(1000L) // This is non blocking call, which means the current thread is ready to accept other tasks
    println("A-Task2:: " + Thread.currentThread().toString())
}

suspend fun B() {
    println("B-Task1:: " + Thread.currentThread().toString())
    delay(1000L) // This has no impact if B is called using async
}

suspend fun AB() {
    A()
    B()
}

suspend fun AB_async() {
    var job1 = GlobalScope.async{A()}
    var job2 = GlobalScope.async{B()}
    job1.await()
    job2.await()
}

suspend fun launch_vs_async() {
    AB()
    println("----------------DONE WITH AB-------------")
    AB_async()
    println("----------------DONE WITH AB ASYNC-------------")
}
