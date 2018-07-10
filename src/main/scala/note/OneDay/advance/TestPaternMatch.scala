package note.OneDay.advance

/**
  * Scala模式匹配：
  * 选择器 match {备选项}
  */
object TestPaternMatch {
  def main(args: Array[String]): Unit = {
    println(matchTest("two"))
    println(matchTest("test"))
    println(matchTest(1))
    println(matchTest(6))
  }
  def matchTest(x: Any): Any = x match {
    case 1 => "one"
    case "two" => 2
    case y: Int => "scala.Int"  // 对应类型匹配
    case _ => "many"  // 默认全匹配选项
  }
}
