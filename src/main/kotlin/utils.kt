object Utils {
    private val start: Long = System.currentTimeMillis();
    fun timePassed(): String {
        var end = System.currentTimeMillis();
        return " @" + (end - start)+ "ms"
    }
}
