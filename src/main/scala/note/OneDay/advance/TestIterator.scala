package note.OneDay.advance

/**
  * Scala迭代器：
  * 迭代器不是一个集合，而是一个用于访问集合的方法。
  *
  */
object TestIterator{
  def main(args: Array[String]): Unit = {
    val it = Iterator("one", "two", "three", "four")
    while(it.hasNext){  // 检测集合中是否还有元素
      println(it.next())  // 返回迭代器的下一个元素，并更新迭代器的状态
    }

    val ita = Iterator(1, 2, 3, 4, 5)
    val itb = Iterator(11, 22, 33, 44, 55)
    //println(ita.max)  // 查找最大元素
    //println(itb.min)  // 查找最小元素

    println(ita.size) // 获取迭代器的长度
    println(itb.length) // 获取迭代器的长度
  }
}