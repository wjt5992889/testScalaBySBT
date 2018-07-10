package note.OneDay.advance

/**
  * 提取器使用模式匹配：
  * 在我们实例化一个类的时，可以带上0个或者多个的参数，编译器在实例化的时会调用 apply 方法。
  */
object TestExtractorByPatternMatch {
  def main(args: Array[String]) {

    val x = TestExtractorByPatternMatch(5)
    println(x)

    x match
    {
      case TestExtractorByPatternMatch(num) => println(x + " 是 " + num + " 的两倍！")  //2：10是5的两倍！
      //unapply 被调用
      case _ => println("无法计算")
    }

  }
  def apply(x: Int) = x*2 //1：10
  def unapply(z: Int): Option[Int] = if (z%2==0) Some(z/2) else None
}
