package note.OneDay.advance

/**
  * 特征构造顺序：
  * 构造器的执行顺序：
  * 1、调用超类的构造器
  * 2、特征构造器在超类构造器之后、类构造器之前执行
  * 3、特征由左到右被构造
  * 4、每个特征当中，父特征先被构造
  * 5、如果多个特征共有一个父特征，父特征不会被重复构造
  * 6、所有特征被构造完毕，子类被构造
  */
class TestTrait{

}
object TestTrait{
  def main(args: Array[String]): Unit = {
    val p1 = new Point(2, 3)
    val p2 = new Point(2, 4)
    val p3 = new Point(3, 3)
    println(p1.isNotEqual(p2))
    println(p1.isNotEqual(p3))
    println(p1.isNotEqual(2))
  }
}


/**
  * Scala Trait（特征）：
  * 相当于Java的接口，但比接口功能强大，它还可以定义属性和方法的实现。
  * 一般情况下Scala的类只能单继承，但特征可以实现多重继承。
  */
// 定义特征
trait Equal{
  def isEqual(x: Any): Boolean  // 未实现的方法
  def isNotEqual(x: Any): Boolean = !isEqual(x) // 实现了的方法
}

class Point(xc: Int, yc: Int) extends Equal{
  var x: Int = xc
  var y: Int = yc

  override def isEqual(obj: Any): Boolean =
    obj.isInstanceOf[Point] &&
    obj.asInstanceOf[Point].x == x
}

