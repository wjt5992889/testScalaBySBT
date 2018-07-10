package note.OneDay.advance

/**
  * Scala单例对象：
  * Scala中没有static，要使用object关键字实现单例模式。
  * Scala中使用单例模式时，除了定义类，还要定义一个同名的object对象，它和类的区别是，object对象不能带参数。
  * 当单例对象与某个类共享一个名称时，他被称作这个类的伴生对象。
  * 必须在同一个源文件里定义类和它的伴生对象。
  * 类和它的伴生对象可以互相访问其私有成员。
  */
// 私有构造方法
class TestSingltonObject private(val color:String) {
  println("创建" + this)
  override def toString(): String = "颜色标记："+ color  //4：颜色标记：red
}

// 伴生对象，与类共享名字，可以访问类的私有属性和方法
object TestSingltonObject{
  private val markers: Map[String, TestSingltonObject] = Map(
    "red" -> new TestSingltonObject("red"), //1：创建颜色标记：red
    "blue" -> new TestSingltonObject("blue"), //2：创建颜色标记：blue
    "green" -> new TestSingltonObject("green")  //3：创建颜色标记：green
  )

  def apply(color:String) = {
    if(markers.contains(color)) markers(color) else null
  }

  def getMarker(color:String) = {
    if(markers.contains(color)) markers(color) else null  //5：颜色标记：blue
  }

  def main(args: Array[String]) {
    println(TestSingltonObject("red"))
    // 单例函数调用，省略了.(点)符号
    println(TestSingltonObject getMarker "blue")
  }
}
