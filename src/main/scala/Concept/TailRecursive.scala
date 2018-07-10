package Concept

import scala.annotation.tailrec

object TailRecursive {

  def main(args: Array[String]): Unit = {
      fibonacciTailRecursive(100)
      factorialTailRecursive(10)
  }

  def fibonacci(n: Int): Int =
    if (n <= 2)
      1
    else
      fibonacci(n-1) + fibonacci(n-2)

  def factorial(n: BigInt): BigInt = {
    if (n <= 1)
      1
    else
      n * factorial(n-1)
  }

  def fibonacciTailRecursive(n: Int): Int = {
    @tailrec
    def _loop(n: Int, acc1: Int, acc2: Int): Int =
      if(n <= 2)
        acc2
      else
        _loop(n-1, acc2, acc1+acc2)

    _loop(n, 1, 1)
  }

  def factorialTailRecursive(a:Int): Unit ={

    @tailrec
    def _loop(a:Int,b:Int): Int ={
      if(a == 1) b
      else _loop(a-1,b*(a-1))
    }

    _loop(a,1)
  }


}
