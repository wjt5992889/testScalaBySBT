package base.grammer

/**
  * Created by Administrator on 2017/4/18.
  */
object TestVariable {
  def main(args: Array[String]): Unit = {

    println("Hello, world!")

    var myVar : String = "Foo"
     myVar = "Too"
    println(myVar)
    val myVal : String = "Foo"
    println(myVal)


//    如果在没有指明数据类型的情况下声明变量或常量必须要给出其初始值，否则将会报错。
    var myVar2 = 10;
    val myVal2 = "Hello, Scala!";
//    Scala 支持多个变量的声明：
    val xmax, ymax = 100  // xmax, ymax都声明为100
  }
}
