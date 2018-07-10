package base.function

/**
  * 普通字符串定义方法存在一个缺陷问题就在与每一行可能与我们输入的内容，
  * 带有空格之类，导致每一行的开始位置不能整洁对齐。而在实际应用场景下，
  * 有时候我们就是确实需要在scala创建多少字符串，但是每一行需要固定对齐。
  * 解决该问题的方法就是应用scala的stripMargin方法，
  * 在scala中stripMargin默认是“|”作为出来连接符，
  * 在多行换行的行头前面加一个“|”符号即可。
  */
object TestStripMargin {

  def main(args: Array[String]): Unit = {
    val foo = """This is
      a scala multiline
      String"""
    println(foo)

    val foo2 = """This is
      |a scala multiline
      |String""".stripMargin
    println(foo2)

  }
}
