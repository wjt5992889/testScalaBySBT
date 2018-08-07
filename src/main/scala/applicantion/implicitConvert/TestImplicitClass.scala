package applicantion.implicitConvert

import java.io.File

class TestImplicitClass {

}

object ContextHelper{
  implicit class Operate(one : Int) {//隐式类
  def add(second : Int) = {
    one + second
  }
  }
  implicit class FileRich(file : File) {
    def lala() = file.getName
  }
}

object ImplicitClass {
  def main(args: Array[String]): Unit = {
    import ContextHelper._ //在当前作用域导入隐式类
    //调用隐式类构造器
    println(1.add(2))// 扩展了整数的方法，使得Int具有add方法
    println(new File("d:\\a.txt").lala()) //扩展了文件的方法，使得File的具有lala方法
  }
}
