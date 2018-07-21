package applicantion.stream

object CreateSeq {

  def main(args: Array[String]): Unit = {
    //长度为5的递增数组
    //res0: List[Int] = List(1,2,3,4,5)
    inc(1).take(5).toList
    //List(1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765)
    fabonacciStream(0,1).take(20).toList
    //List( 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765,x)
    fabonacciStream(1,1).take(20).toList

    println(fib3.scanLeft(1)(_ + _).take(5).toList)
  }

  //给定一个整数值，创建一个连续递增的整数集合
  def inc(i:Int):Stream[Int] = Stream.cons(i,inc(i+1))
  //fabonacci数组流
  def fabonacciStream(last:Int,now:Int):Stream[Int] = Stream.cons(now,fabonacciStream(now,last+now))

  //zip: zip[B](that: GenIterable[B]): List[(A, B)]
  // 与另外一个列表进行拉链操作，将对应位置的元素组成一个pair，
  // 返回的列表长度为两个列表中短的那个
  /**
    * 代码分析:
    * Stream.cons(1, Stream.cons(1, (fib zip fib.tail).map(p => p._1 + p._2)))
    * 1.fib:Stream.cons(1,X)  第一个元素是1 head=1
    * 2.X:Stream.cons(1, Y)
    *     tail的第一个元素也是1,而且同样是一个stream
    * 3.Y:(fib zip fib.tail).map(p => p._1 + p._2)
    *     a.用fib和X做一个zip操作,得到(,)结构的一个stream
    *     b.map操作,讲(,)中的2个元素相加
    *
    */
  lazy val fib: Stream[BigInt] = Stream.cons(1, Stream.cons(1, (fib zip fib.tail).map(p => p._1 + p._2)))

  /**
    * 使用#::代替cons来构造stream
    */
  val fib2:Stream[Int] = 0 #:: 1 #:: (fib2 zip fib2.tail).map{ t => t._1 + t._2 }


  /**
    *从左扫描，每步的结果都保存起来，执行完成后生成数组
    * 1.    0,x
    * 1.1.  x:cons(1,scanLeft(op(1,head))(op))
    *
    */
  val fib3: Stream[Int] = 0 #:: fib3.scanLeft(1)(_ + _)

  /**
    *Stream.iterate((0,1))(f) = cons((0,1),iterate(f((0,1),f))
    */
  val fib4 = Stream.iterate( (0,1) ) { case (a,b)=>(b,a+b)  }.map(_._1)
}
