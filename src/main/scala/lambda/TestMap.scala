package lambda

/**
  * Created by Administrator on 2018/3/18.
  */
object TestMap {

  def testMap(): Unit ={
    var p = Map(1 -> "2222",3 -> "sdsdfsdf")

    println(p(1))

    println(p.contains(1))

    println(p.keys)

    println(p.values)

    //增加元素
    p + (8 -> "eswefwe")
    p ++ List( 7 -> "sfwefwe",10 -> "eewfwef")

    //删除元素 - (key)
    p - 1
    p -- List(1,8,3)

  }
}
