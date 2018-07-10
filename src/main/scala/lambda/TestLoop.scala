package lambda

/**
  * Created by Administrator on 2018/3/17.
  */
object TestLoop {

  def main(args: Array[String]): Unit = {
    implLoop()
  }

  def implLoop(): Unit ={
    var a = 0 to 10;

    var b = a.filter(_ % 2 ==0).map(2*_)

    print(b)
  }
}
