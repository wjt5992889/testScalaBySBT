package Concept

object PreDefinetion {

  /**
    * 1. Ant的构造器在做自己的构造器之前，调用Creature的构造器。
    *
    * 2. Creature的构造器将它的range字段设为10。
    *
    * 3. Creature的构造器为了初始化env数组， 调用range()。
    *
    * 4. 该方法被重写，但range字段还未被初始化，所以返回0。
    *
    * 5. env被设置为长度0的数组。
    *
    * 6. Ant构造器执行，将range字段设置为2。
    *
    * @param args
    */
  def main(args: Array[String]): Unit = {
    val ant = new Ant
    //print 0
    println(ant.env.length)

    val antNew = new AntNew
    //print 2
    println(antNew.env.length)
  }


  class Creature {

    val range : Int=10

    val env: Array[Int] = new Array[Int] ( range)

  }


  class Ant extends Creature {

    override val range=2

  }


  class AntNew extends  {
    override val range = 2
  } with Creature {}
}
