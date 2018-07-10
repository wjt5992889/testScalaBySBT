package note.OneDay.advance

/**
  * 使用样例类：
  * 使用case关键字的类定义就是样例类，样例类是种特殊的类，经过优化以用于模式匹配。
  */
object TestCaseClass {
  def main(args: Array[String]): Unit = {
    val alice = new Person("Alice", 25)
    val bob = new Person("Bob", 32)
    val charlie = new Person("Charlie", 27)
    for(person <- List(alice, bob, charlie)){
      person match{
        case Person("Alice", 25) => println("Hi Alice!")
        case Person("Bob", 32) => println("Hi Bob!")
        case Person(name, age) => println("Age: " + age + " year,name: " + name +"?")
      }
    }
  }
  // 样例类
  case class Person(name: String, age: Int)
}
