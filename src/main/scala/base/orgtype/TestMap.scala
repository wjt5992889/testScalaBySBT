package base.orgtype

/**
  * Created by Administrator on 2018/3/17.
  */
object TestMap {

  def main(args: Array[String]): Unit = {
    createMap

  }

  def createMap(): Unit ={
    var map = Map("a"->1,"b"->2,"c"->3)
    map += ("d"->4)
    print(map.toString())


  }

}
