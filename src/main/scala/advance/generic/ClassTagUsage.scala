package advance.generic

import scala.reflect.ClassTag

/**
  * 源码中的解释，在泛型中，type T是被擦除的。
  * 这个是非常有用的，在我们构建数组的时候，但是数组的类型我们也不知道，
  * 编译的时候不知道，但是运行的时候要知道，ClassTag只包含实际运行时的类的类型。
  */
object ClassTagUsage {

}

class ClassTagDemo[T] {

  /**
    * 在Scala中数组必须是有类型的，如果直接是泛型的话将会报错,如下
    * def makeTArray(): Array[T] = new Array[T](10)
    * Error: cannot find class tag for element type T
    *
    * 编译器会自动翻译成如下,类似mkArray2的写法,所以也可以直接写成mkArray2方式
    *  mkArray: [T](elems: T*)(implicit evidence$1: scala.reflect.ClassTag[T])Array[T]
    * @param elems
    * @tparam T
    * @return
    */
  def mkArray[T: ClassTag](elems: T*) = Array[T](elems: _*)

  def mkArray2(elems: T*)(implicit x: ClassTag[T]) = Array[T](elems: _*)



  //  scala> mkArray(42, 13)
  //  res0: Array[Int] = Array(42, 13)
  //
  //  scala> mkArray("Japan","Brazil","Germany")
  //  res1: Array[String] = Array(Japan, Brazil, Germany)
}

object ClassTagDemo extends App {

  val c = new ClassTagDemo[Int]
  c.mkArray(42, 13)
  c.mkArray2(42, 13)

}

class ScalaArrayDemo[T] {

  //Error: cannot find class tag for element type T
  //在Scala中数组必须是有类型的，如果直接是泛型的话将会报错
//  def makeTArray(): Array[T] = new Array[T](10)

}


