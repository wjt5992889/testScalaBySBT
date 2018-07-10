package base.grammer

/**
  * Created by Administrator on 2017/5/4.
  */
object TestVariance {
  def main(args: Array[String]): Unit = {
    testInvariant
    testCovariant
    testContravariant
  }

  def testInvariant()={
    class Invariant[T]
    //because of feature of Invariant，this line of code can't be compiled
//    val cv: Invariant[AnyRef] = new Invariant[String]
  }

  def testCovariant()={
    class Covariant[+T]
    //because of covariant Characteristic,child type can be assignment to parent type
    val cv: Covariant[AnyRef] = new Covariant[String]
  }

  def testContravariant()={
    class Contravariant[-T]
    //because of contravariant Characteristic,parent type can be assignment to parent type
    //usually we use this Characteristic in Consumer case
    val cv: Contravariant[String] = new Contravariant[AnyRef]
  }
}
