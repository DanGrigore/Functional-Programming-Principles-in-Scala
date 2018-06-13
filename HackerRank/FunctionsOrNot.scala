
object Object extends App {
  val n = io.StdIn.readInt()
  for (i <- 1 to n) yield {
    val count = io.StdIn.readInt()
    val pair = (1 to count).map(x => io.StdIn.readLine.split("\\s")).toList
    if (pair.distinct.size == pair.size) println("YES") else println("NO")
  }
}
