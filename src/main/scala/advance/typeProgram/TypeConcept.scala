package advance.typeProgram

import scala.reflect.runtime.universe._

object TypeConcept {

  class A {
    class B
  }

  def main(args: Array[String]): Unit = {

    val a = new A()
    println(typeOf[A])
    println(classOf[A])

//内部类型依赖外部实例(路径依赖类型)
    val a1 = new A
    val a2 = new A
    val b1 = new a1.B
    val b2 = new a2.B
    println("a1.B.class == a2.B.class:"+ b1.getClass == b2.getClass)
    println("a1.B.type == a2.B.type:"+ typeOf[a1.B] == typeOf[a2.B])


    println("class 一致:"+classOf[List[Int]] == classOf[List[String]])
    println("type 不一致:"+typeOf[List[Int]] == typeOf[List[String]])
  }
}
