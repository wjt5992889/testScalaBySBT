package Concept.tailrecursive

import scala.annotation.tailrec

object TailRecursive {

  def main(args: Array[String]): Unit = {
      println(fibonacciTailRecursive(15000))
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

  /**
    * public int fibonacciTailRecursive(final int n) {
    *  return this._loop$1(n, 1, 1);
    *  }
    *
    * private final int _loop$1(int n, int acc1, int acc2) {
    *  while (n > 2) {
    *  final int loc_0 = n - 1;
    *  final int loc_1 = acc2;
    *  acc2 += acc1;
    *  acc1 = loc_1;
    *  n = loc_0;
    *  }
    *  return acc2;
    *  }
    *
    * 以上代码是经过尾递归优化之后的代码
    * @param n
    * @return
    */
  def fibonacciTailRecursive(n: Int): Long = {
    @tailrec
    def _loop(n: Int, acc1: Long, acc2: Long): Long =
      if(n <= 2)
        acc2
      else
        _loop(n-1, acc2, acc1+acc2)

    _loop(n, 1, 1)
  }

  /**
    *
    *
    * public void factorialTailRecursive(final int a) {
    *         this._loop$2(a, 1);
    * }
    *
    *
    *
    * private final int _loop$2(int a, int b) {
    * while (a != 1) {
    * final int loc_0 = a - 1;
    * b *= a - 1;
    * a = loc_0;
    * }
    * return b;
    * }
    *
    * @param a
    */
  def factorialTailRecursive(a:Int): Int ={

    @tailrec
    def _loop(a:Int,b:Int): Int ={
      if(a == 1) b
      else _loop(a-1,b*(a-1))
    }

    _loop(a,1)
  }






}
