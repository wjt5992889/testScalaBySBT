package applicantion

object MathFunctionImpletetation {

  def main(args: Array[String]): Unit = {
    //sum a,b (F(n))
    sum(1,10,(x:Int)=>x*2)

    //2rd way to implement sum a,b (F(n))
    val f1 = sum2((x:Int)=>x*3)
    f1(1,10)
  }

  def sum(a:Int,b:Int,f:Int => Int):Int={
    if(a>b) 0
    else f(a) + sum(a-1,b,f)
  }

  def sum2(f:Int=>Int): (Int,Int)=>Int={
    def sum3(a:Int,b:Int)=sum(a,b,f);
    sum3
  }

}
