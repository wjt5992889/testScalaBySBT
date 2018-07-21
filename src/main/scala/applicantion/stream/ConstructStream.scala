package applicantion.stream

object ConstructStream {

  def main(args: Array[String]): Unit = {
    /**
      * cons似乎是Stream对象的一个方法。但是，事实上它是Stream对象的一个内部对象
      * cons(head,tail)
      */
    Stream.cons(3, Stream.cons(4, Stream.empty))

    /**
      * scanleft后的第一个参数是为运算集合再加入一个head
      * 然后相邻进行运算
      */
    Array(1,2,4,3,5).scanLeft(0)((x:Int,y:Int)=>{println(x,y);x+y})
  }
}
