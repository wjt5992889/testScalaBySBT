package base.orgtype

import scala.collection.mutable.ArrayBuffer


/**
  * Created by Administrator on 2018/3/15.
  */
object TestArrayBuffer {

  def main(args: Array[String]): Unit = {
    test
    testMkString
    test2DimArray
  }


  def test: Any = {
    val b =  ArrayBuffer[Int]();
    val a =  Array[Int](1);
    //add element at the end of this array
    b+=1
    //add mutiple elements
    b += (1,2,3,4)
    //add collection into this array
    b ++= Array(1,2,3)
    //remove last 1 elements
    b.trimEnd(1)


    //下面的方法会造成元素平移,所以效率不高,不推荐使用
    //remove first 1 elements
    b.trimStart(1)

    //arraybuffer to array
    b.toArray
    //array to arraybuffer
    a.toBuffer
  }

  def testMkString(): Unit ={
    var a = 0 to 11
    val aa: String = a.mkString("|",",","|")
    print(aa)
  }

  def test2DimArray(): Unit ={

    //3*4的二维数组
    var b = Array.ofDim[Int](3,4)

    b(1)(2)=4
    print(b(1)(2))


    val a = new Array[Array[Int]](10)

    //创建不规则二维数组
    for(i <- 0 until a.length)
      a(i)  = new Array[Int](i+1)


  }
}
