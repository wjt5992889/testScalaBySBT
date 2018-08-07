package applicantion.implicitConvert

object TestImplicitObject {

}

abstract class Template[T] {
  def add (x : T, y:T): T
}

abstract class SubTemplate[T] extends Template[T] {
  def unit : T
}


object Implicits_Object {

  /**
    * 定义隐式对象
    */
  implicit object StringAdd extends SubTemplate[String] {
    def add (x:String, y: String):String = x concat y
    def unit: String = ""
  }

  /**
    * 定义隐式对象
    */
  implicit object IntAdd extends SubTemplate[Int] {
    def add (x:Int, y: Int) : Int = x + y
    def unit: Int = 0
  }

  /**
    * 在执行sum的时候，首先推断出Ｌｉｓｔ的类型为Int.
    * 然后因为有隐式参数implicit m : SubTemplate[T]
    * 会检查当前作用域是否有SubTemplate[T])类型的　implicit object.
    * 如果有并且类型相同，那么就回去执行该隐式对象里的方法.
    */
  def sum[T] (xs : List[T])(implicit m : SubTemplate[T]) : T =
    if (xs.isEmpty) m.unit
    else m.add(xs.head, sum(xs.tail))

  println(sum(List(1,2,3,4,5)))
  println(sum(List("Spark","Scala","Kafka")))

}