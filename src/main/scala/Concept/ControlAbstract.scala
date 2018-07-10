package Concept

object ControlAbstract {

  def main(args: Array[String]): Unit = {
    println(check(3,9))
    println(sqrt1(5))
  }

  def sqrt0(a:Double,b:Double):Double={
    val next = (a+b/a)/2
    if((b -next*next)*(b-next*next) <=  0.001*0.01) next
    else sqrt0(next,b)
  }



  def sqrt1(b:Double)={
    def calc(guss: Double)={
      (guss+b/guss)/2
    }

    def inSqrt1(guss:Double): Double ={
      val next = calc(guss)
      println("next is "+next.toString+" check "+calcAcc(next))
      if(check1(next)) next
      else inSqrt1(next)
    }

    def checkAcc1(a:Double)(t:Double)(f:Double=>Double)={
      f(a)*f(a) < t*t
    }

    def check1(a:Double)=checkAcc1(a)(0.01)(calcAcc)

    def calcAcc(a:Double)= (b-a*a)*(b-a*a)

    inSqrt1(1)

  }





  def sqrt(x:Double)={
    def isGoodEnough(guess:Double, x:Double)=
      ((guess * guess -x) < 0.0001*x) && ((guess * guess -x ) > -0.0001*x)

    def improve (guess:Double, x:Double)=
      (guess+ x/guess)/2

    def sqrtIter(guess:Double):Double=
      if(isGoodEnough(guess,x)) guess
      else sqrtIter(improve(guess,x))

    sqrtIter(1.0)
  }

  def checkAcc(f:(Double,Double)=>Double)(t:Double):(Double,Double)=>Boolean={

    def inCheckAcc(a:Double,b:Double)={
      f(a,b)*f(a,b) < t*t
    }
    

    inCheckAcc
  }

  def accNumber(a:Double,b:Double) = (b-a*a)*(b-a*a)

  def check(a:Double,b:Double) = checkAcc(accNumber)(0.01)(a,b)










}
