package advance.typeProgram

/**
  * 协变,返回值协变
  * 协变定义形式如：trait List[+T] {}
  * 当类型S是类型A的子类型时，则List[S]也可以认为是List[A}的子类型,即List[S]可以泛化为List[A]
  * 被参数化类型的泛化方向与参数类型的方向是一致的，所以称为协变（covariance）
  *
  *
  *     AnyRef        ---------->   String
  *
  *     List[AnyRef]  ---------->   List[String]
  *
  *
  */
object Covariant {
  def main(args: Array[String]): Unit = {
    val list:List[Any]= new List[String]("摇摆少年梦",null)
  }
}

class List[+T](val head: T, val tail: List[T]){
  //covariant type T occurs in contravariant position in type T of value newHead
  //编译器提示协变类型T出现在逆变的位置
  //即泛型T定义为协变之后，泛型便不能直接
  //应用于成员方法当中
//  def prepend(newHead:T):List[T]=new List(newHead,this)

  //因为是协变的，输入的类型必须是T的超类
  def prepend[U>:T](newHead:U):List[U]=new List(newHead,this)
}


/**
  * 为什么参数类是协变的
  * 里氏替换原则，所有使用父类型对象的地方都可以换成子类型对象
  * AnyRef                 -------->  String
  * A[AnyRef]              -------->  A[String]
  * fun(AnyRef)            -------->  fun(String)
  * father.fun(notString)  xxxxxxxxx  child.fun(notString)
  *
  */
//class In[+A]{ def fun(x:A){} }

