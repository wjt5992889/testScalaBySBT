package base.orgtype

/**
  * Created by Administrator on 2018/3/18.
  */
object TestTuple {

  def main(args: Array[String]): Unit = {
    createTuple
    testZip()
    toMap
    println(getTuple)
  }

  def createTuple(): Unit ={
    val t = (1,2,"111")
    val second = t._2

    var (a,b,c) = t
    var (d,e,_) = t
    print(a,b,c,d,e)

    //元祖用于返回不止一个值的情况,类似数组
    println("New York".partition(_.isUpper))
  }

  def testZip(): Unit ={
    val a = Array(1,2,3)
    val b = Array("q","w","e")
    val c = a.zip(b)
    println(c.mkString("<",",",">"))
  }

  def toMap(): Unit ={
    val a = Array(1,2,3)
    val b = Array("q","w","e")
    val map: Map[Int, String] = a.zip(b).toMap
    print(map)
  }

  def getTuple(): Tuple3[String, String, String] ={
    ("q","w","e")
  }

}
