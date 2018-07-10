package applicantion.implicitConvert

package applicantion.implicitConvert

import java.io.File

import scala.io.Source


/**
  * 隐式转换应用,让File具备RichFile中的read能力
  */
object FileDemo{
  //定义隐式转换方法
  implicit def fileReadToRichFile(file: File)=new RichFile(file)
}
class RichFile(val f:File) {
  def read()=Source.fromFile(f).mkString
}
object RichFile{
  def main(args: Array[String]) {
    val f=new File("E://words.txt")
    //使用import导入隐式转换方法
    import FileDemo._
    //通过隐式转换，让File类具备了RichFile类中的方法
    val context=f.read()
    println(context)
  }
}

