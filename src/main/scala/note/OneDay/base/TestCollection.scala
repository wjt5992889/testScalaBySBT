package note.OneDay.base

object TestCollection {
  def main(args: Array[String]): Unit = {
    /**
      * Scala集合：分为可变集合和不可变集合。
      * 可变集合：  可以在适当的地方被更新或扩展，也就是可以修改、添加、移除一个集合的元素。
      * 不可变集合：永远不会改变。但可以模拟添加、移除、更新操作，
      *           但是这些操作将在每一种情况下都返回一个新的集合，
      *            同时使原来的集合不发生改变。
      */
       // 定义整形List
      val x = List(1,2,3,4)
      // 定义Set
      var x1 = Set(1,3,5,7)
      // 定义Map
      val x2 = Map("one" -> 1, "two" -> 2, "three" -> 3)
      // 创建两个不同类型的元组
      val x3 = (10, "Runoob")
      // 定义Option
      val x4:Option[Int] = Some(5)


//    Option 有两个子类别，一个是 Some，一个是 None，
//    当他回传 Some 的时候，代表这个函式成功地给了你一个 String，
//    而你可以透过 get() 这个函式拿到那个 String，
//    如果他返回的是 None，则代表没有字符串可以给你。
    val sites = Map("runoob" -> "www.runoob.com", "google" -> "www.google.com")

    println("sites.get( \"runoob\" ) : " +  sites.get( "runoob" )) // Some(www.runoob.com)
    println("sites.get( \"baidu\" ) : " +  sites.get( "baidu" ))  //  None

  }
}
