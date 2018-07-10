package note.OneDay.base
/**Scala数组：**/
object TestArray {
  def main(args: Array[String]): Unit = {
    //    1、声明数组
    var a:Array[String] = new Array[String](3)

    var z = new Array[String](3)
    z(0) = "value1"; z(1) = "value2"; z(2) = "value3"

    var b = Array("value1", "value2", "value3")
  }
}



//    2、处理数组
object Test1{
  def main(args: Array[String]){
    var myList = Array(1.1, 2.2, 3.3, 4.4)

    // 输出所有数组元素
    for(x <- myList){
      println(x)
    }

    // 计算数组所有元素的总和
    var total = 0.0
    for(i <- 0 to (myList.length - 1)){
      total += myList(i)
    }
    println("总和：" + total)

    // 查找数组中的最大元素
    var max = myList(0)
    for(i <- 1 to (myList.length - 1)){
      if(myList(i) > max)
        max = myList(i)
    }
    println("最大值：" + max)
  }
}

//    3、多维数组
import Array._
object Test2{
  def main(args: Array[String]){
    // 定义数组
    var myMatrix = ofDim[Int](3,3)
    // 创建矩阵
    for(i <- 0 to 2){
      for(j <- 0 to 2){
        myMatrix(i)(j) = j;
      }
    }
    // 打印矩阵
    for(i <- 0 to 2){
      for(j <- 0 to 2){
        print(" " + myMatrix(i)(j));
      }
      println();
    }
  }
}

//    4、合并数组
import Array._
object Test3{
  def main(args: Array[String]){
    var myList1 = Array(1.1, 2.2, 3.3, 4.4)
    var myList2 = Array(5.5, 6.6, 7.7, 8.8)
    // 使用concat()合并
    var myList3 = concat(myList1, myList2)
    // 输出所有数组元素
    for(x <- myList3){
      println(x)
    }
  }
}

//    5、创建区间数组:使用range(x,y,z)创建区间数组,数值范围大于等于x,小于y。z表示步长，默认为1。
object Test4{
  def main(args: Array[String]){
    var myList1 = range(10, 20, 2)
    var myList2 = range(10, 20)
    for(x <- myList1){
      print(" " + x)  //输出：10 12 14 16 18
    }
    println()
    for(x <- myList2){
      print(" " + x)  // 输出：10 11 12 13 14 15 16 17 18 19
    }
  }
}