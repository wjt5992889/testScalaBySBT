package Concept

/**
  * 隐式转换的前提：
  * 1.不存在二义性（如例1）
  * 2.隐式操作不能嵌套使用（如 convert1(covert2(x))）+y
  * 3.代码能够在不使用隐式转换的前提下能编译通过，就不会进行隐式转换
  *
  * 隐式转换的发生时机:
  * 1、调用某个函数，但是给函数传入的参数类型，与函数定义的签名不匹配。
  * 2、使用某个类型对象，调用某个方法，而这个方法并不存在于该类型时。
  * 3、使用某个类型对象，调用某个方法，虽然该类型有这个方法，但是给方法传入的参数类型与签名并不一致的时候。
  */
object ImplicitConvert {

  //name为隐式参数
  def person(implicit name : String) = name
  //p被称为隐式值,如果不定义这个编译器说无法为参数name找到一个隐式值
  implicit val p = "mobin"


  def foo(msg : String) = println(msg)
  implicit def intToString(x : Int) = x.toString

  def main(args: Array[String]): Unit = {
    /**隐式值**/
    //因为将p变量标记为implicit，所以编译器会在方法省略隐式参数的情况下去搜索作用域内的隐式值作为缺少参数。
    //但是如果此时你又在REPL中定义一个隐式变量，再次调用方法时就会报错
    println(person)

    /**隐式视图:把一种类型自动转换到另一种类型**/
    //foo需要的参数类型是String,此处传入的类型是Int,正常情况下报错
    //解决办法就是定义一个转换函数给编译器将int自动转换成String
    foo(10)
  }
}


class SwingType{
  def  wantLearned(sw : String) = println("兔子已经学会了"+sw)
}
object swimming{
  implicit def learningType(s : AminalType) = new SwingType
}
class AminalType
object AminalType extends  App{
  import Concept.swimming._
  val rabbit = new AminalType
  //编译器在rabbit对象调用时发现对象上并没有wantLearning方法，
  // 此时编译器就会在作用域范围内查找能使其编译通过的隐式视图，
  // 找到learningType方法后，编译器通过隐式转换将对象转换成具有这个方法的对象，
  // 之后调用wantLearning方法
  rabbit.wantLearned("breaststroke")         //蛙泳
}

/**
  * 在scala2.10后提供了隐式类，可以使用implicit声明类，但是需要注意以下几点：
  * 1.其所带的构造参数有且只能有一个
  * 2.隐式类必须被定义在类，伴生对象和包对象里
  * 3.隐式类不能是case class（case class在定义会自动生成伴生对象与2矛盾）
  * 4.作用域内不能有与之相同名称的标示符
  */
object Stringutils {
  implicit class StringImprovement(val s : String){   //隐式类
    def increment = s.map(x => (x +1).toChar)
  }
}
object  Main extends  App{
  import Concept.Stringutils._
  //编译器在mobin对象调用increment时发现对象上并没有increment方法，
  // 此时编译器就会在作用域范围内搜索隐式实体，
  // 发现有符合的隐式类可以用来转换成带有increment方法的StringImprovement类，
  // 最终调用increment方法
  // 按照我的理解,实际调用了构造器进行类型的转换,所以要求构造器参数唯一
  println("mobin".increment)
}