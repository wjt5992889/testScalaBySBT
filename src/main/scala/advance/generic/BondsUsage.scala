package advance.generic


/**
  * 参数的界定是用来限制传入的参数的类型，代表该类型具有这样的一个特性
  */
object BondsUsage extends App{
  val a="3"
  val b = "2"
  val pair = new Pair(a,b);
}

class PairOne[T](val first:T,val second:T){
  //如下写法,编译器报错，因为编译器不能确定T具有compareTo的方法
  //  def smaller = if(first.compareTo(second) < 0) first else second
}


/**
  * 此处T<:Comparable[T]表示传入的T的类型是Comparable的子类型,或者说Comparable是T的超类
  *
  * K>:T<:M //这意味着M是T类型的超类，K也是T类型的超类
  *
  * 必定存在TtoComparable的转换
  *
  * @param first
  * @param second
  * @tparam T
  */
class PairTwo[T<:Comparable[T]](val first:T,val second:T){
  def smaller = if(first.compareTo(second) < 0) first else second
}

class A[T]
class B[T]

object MutilBound extends App{
  implicit val a=new A[String]
  implicit val b=new B[String]
  //多重上下文界定，必须存在两个隐式值，类型为A[T],B[T]类型
  //前面定义的两个隐式值a,b便是
  def test[T:A:B](x:T)=println(x)
  test("摇摆少年梦")

  implicit def t2A[T](x:T)=new A[T]
  implicit def t2B[T](x:T)=new B[T]
  //多重视图界定，必须存在T到A，T到B的隐式转换
  //前面我们定义的两个隐式转换函数就是
  def test2[T <% A[T] <% B[T]](x:T)=println(x)
  test2("摇摆少年梦2")
}


/**
  * T<%M<%K //这意味着在作用域中必须存在T到M、T到K的隐式转换
  * @param first
  * @param second
  * @tparam T
  */
class PairThree[T<%Comparable[T]](val first:T,val second:T){
  def smaller = if(first.compareTo(second) < 0) first else second
}

/**
  * T:M:K //这意味着在作用域中必须存在M[T]、K[T]类型的隐式值
  * 必须存在xxxtoM或者xxtoK的方法
  * @param first
  * @param second
  * @tparam T
  */
class PairFour[T:Ordering](val first:T,val second:T){
  //引入odering到Ordered的隐式转换
  //在查找作用域范围内的Ordering[T]的隐式值
  //本例的话是implicit val p1=new PersonOrdering
  //编译器看到比较方式是<的方式进行的时候，会自动进行
  //隐式转换，转换成Ordered，然后调用其中的<方法进行比较
  import Ordered.orderingToOrdered;
  def smaller={
    if(first<second)
      first
    else
      second
  }
}
