package base.grammer

object TestPlaceHolder {

  def main(args: Array[String]): Unit = {
    //x=>g(x)  都可以写为g(_)  或 g _

  }

  def g(a:String) = {
    println(a)
  }


}
