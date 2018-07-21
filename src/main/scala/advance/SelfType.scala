package advance

/**
  * trait T {
  * private[this] val self = this
  * }
  * selftype 是 this 的别名
  * 特质可以要求混入它的类扩展自另一个类型，
  * 但是当使用自身类型（self type）的声明来定义特质时（this: ClassName =>），
  * 这样的特质只能被混入给定类型的子类当中。
  * 如果尝试将该特质混入不符合自身类型所要求的类时，就会报错。
  */
object SelfType {
  def b()='1'
}

class SelfType {
  def a()='1'

  def main(args: Array[String]): Unit = {
    a()
  }
}


object tt{
  def main(args: Array[String]): Unit = {
    import SelfType._
    b()

    val selfType = new SelfType
    selfType.a()
  }
}


trait Fly{
  this:Wing =>
}
trait Wing{}
/**
  * 此处不带上Wing就会报错
  */
class Bird extends Fly with Wing{
}



trait Swim{
  self:Sea with Water=>
}
trait Sea{
}
trait Water{}

/**
  * 使用self和this效果相同
  */
class Fish extends Swim with Sea with Water{
}


