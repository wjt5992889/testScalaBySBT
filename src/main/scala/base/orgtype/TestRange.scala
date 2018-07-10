package base.orgtype

/**
  * Created by Administrator on 2017/4/18.
  */
object TestRange {

  def testMapRange(): Unit = {
    println((1 to 3).map(_ * 2.0).toList)
    println((1 to 5).map(e => (e, e*2)))

  }

  def main(args: Array[String]): Unit = {

    testBaseRange()
    testBaseRangeUsage()
    testAssociatedRange()
    testMapRange()

  }

  def testBaseRange(  ) :Unit = {
    //    使用to包括区间上限
    var range1 =1 to 5
    println(range1)
    println(range1(0))
    //    使用until不包括区间上限
    var range2 = 1 until 5
    println(range2)
    //    使用by设置步长
    var range3 = 1 to 10 by 3
    println(range3)
    //    NumericRange
    var range4 = 'a' to 'g'
    println(range4)
    var range5 =BigInt(1) to BigInt(5) by 2
    println(range5)
    var range6 =  0.1f to 5.3f by 1.0f
    println(range6)
  }

  def testBaseRangeUsage(  ) :Unit = {
    var r1 = 1 to 10;//赋值1到10的整数
    var r2 = 1.to(10);
    for(i <- 0 to 10){
      print(i)
    };
    for(i <- 0 until 10){
      print(i)
    };
    var r3 = Range(1,10);
    var r4 = Range(1,10,2);//1到10的整数，步长为2，步长不能为0，默认步长为1
  }

  def testAssociatedRange(): Unit ={
    println(Array.range(1, 10))
    println(List.range(1, 10))
    println(Vector.range(0, 10, 2))
    println((1 to 10).toArray)
    println((1 to 10) by 2 toList)
    println((1 to 10).by(2).toList)
//    range 可以转化为下面集合
//    def toArray: Array[A]
//    def toBuffer[A1 >: Int]: Buffer[A1]
//    def toIndexedSeq: IndexedSeq[Int]
//    def toIterator: Iterator[Int]
//    def toList: scala.List[Int]
//    def toMap[T, U]: collection.Map[T, U]
//    def toParArray: ParArray[Int]
//    def toSet[B >: Int]: Set[B]
//    def toStream: Stream[Int]
//    def toTraversable: collection.Traversable[Int]
//    def toVector: scala.Vector[Int]
//    使用这种方案我们可以把Range转为Set等，不支持range方法的集合类：
    println(Range(0, 5).toSet)
  }
}
