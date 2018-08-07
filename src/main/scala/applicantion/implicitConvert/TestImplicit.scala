package applicantion.implicitConvert

/**
  * 1.不存在二义性（如例1）
  * 2.隐式操作不能嵌套使用（如 convert1(covert2(x))）+y
  * 3.代码能够在不使用隐式转换的前提下能编译通过，就不会进行隐式黑铁
  *
  * 隐式解析的搜索范围
  * 这一部分的规则有些复杂，根据《Scala In Depth》所描述的，顶层的搜索逻辑是：
  *
  * 在当前作用域下查找。这种情形又分两种情况，
  * 一个是在当前作用域显示声明的implicit元素，
  * 另一个通过import导入的implicit元素。
  * 如果第一种方式没有找到，则编译器会继续在隐式参数类型的隐式作用域里查找。
  * 真正复杂的地方是什么叫一个类型的隐式作用域？
  * 一个类型的隐式作用域指的是“与该类型相关联的类型”的所有的伴生对象。
  *
  * OK，那什么叫作“与一个类型相关联的类型”？ 定义如下：
  *
  * 假如T是这样定义的：T with A with B with C，那么A, B, C的伴生对象都是T的搜索区域。
  * 如果T是类型参数，那么参数类型和基础类型都是T的搜索部分。
  * 比如对于类型List[Foo]，List和Foo都是搜索区域如果T是一个单例类型p.T，那么p和T都是搜索区域如果T是类型注入p#T，那么p和T都是搜索区域。
  */
class TestImplicit {

//  def main(args: Array[String]): Unit = {
//    // implicit ordered:T 隐式参数函数，函数后面带：号，将T转换为Ordered[T],可以进行比较
//    def bigger[T](a:T,b:T)(implicit ordered:T =>Ordered[T]) =
//    // 比较大小，返回较大的值
//      if(ordered(a) > b) a else b
//  }
}


// 泛型Ordering，隐式类型T。主构造器，val first: T, val second: T
class PairImplicits[T: Ordering](val first: T, val second: T) {
  // ordered隐式值。 比较大小，返回结果,
  //不给函数指定参数，此时会查找一个隐式值，该隐式值类型为Ordering[Person],根据上下文界定的要求，该类型正好满足要求
  //因此它会作为smaller的隐式参数传入，从而调用ord.compare(first, second)方法进行比较
  def bigger(implicit ordered: Ordering[T]) =
    if (ordered.compare(first, second) > 0) first else second
}

class PairImplicitly[T: Ordering](val first: T, val second: T) {
  // implicitly关键字：提取运行时上下文件界定时的实例值。
  def bigger = if (implicitly[Ordering[T]].compare(first, second) > 0) first else second
}

class PairImplicitlyOdereded[T: Ordering](val first: T, val second: T) {
  def bigger = {
    // 引用Ordered下所有的累
    import Ordered._
    // >函数，使用隐式转换成Ordered类型，进行比较
    if(first >  second) first else second
  }
}

// 代码调用实现
object ContextBoundsIntemals {
  def main(args: Array[String]): Unit = {
    // implicit object Int extends IntOrdering
    //scala-library\srcs\scala-library-2.11.11-sources.jar!\scala\math\Ordering.scala 256
    // 执行结果：9由于传入是Int,所以会在Int的作用域中寻找
    println(new PairImplicits(7, 9).bigger);
    // 执行结果：9
    println(new PairImplicitly(7, 9).bigger);
    // 执行结果：9
    println(new PairImplicitlyOdereded(7, 9).bigger);
  }
}
