package note.OneDay.advance

/**
  * Scala类和对象：
  * 类是对象的抽象，对象是类的具体实例。
  * 类是抽象的，不占用内存；对象是类的具体实例，占用存储空间。
  *
  */
class TestClass(xc: Int, yc: Int){
  var x: Int = xc
  var y: Int = yc
  def move(dx: Int, dy: Int): Unit ={
    x = x + dx
    y = y + dy
    println("x点的坐标是：" + x)
    println("y点的坐标是：" + y)
  }
}
object Test{
  def main(args: Array[String]): Unit = {
    val pt = new TestClass(10, 20)
    // 移到一个新的位置
    pt.move(10, 10)
  }
}