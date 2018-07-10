package note.OneDay.advance

object TestReadConsole {
  def main(args: Array[String]) {
    print("请输入菜鸟教程官网 : " )
    val line = Console.readLine // 在控制台手动输入

    println("谢谢，你输入的是: " + line)
  }
}
