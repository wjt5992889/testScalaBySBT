package advance.typeProgram

/**
  * 逆变,参数逆变
  * 逆变定义形式如：trait List[-T] {}
  * 当类型S是类型A的子类型，则Queue[A]反过来可以认为是Queue[S}的子类型。
  * 也就是被参数化类型的泛化方向与参数类型的方向是相反的，所以称为逆变（contravariance）
  *
  *
  *
  */
object Contravariant {

}

//下面这行代码能够正确运行
class Person4[+A]{
  def test:A=null.asInstanceOf[A]
}
//下面这行代码会编译出错
//contravariant type A occurs
//in covariant position in type ⇒ A of method test
//class Person5[-A]{
//  def test:A=null.asInstanceOf[A]
//}

class List[-T](val head: T, val tail: List[T]){
  //covariant type T occurs in contravariant position in type T of value newHead
  //编译器提示协变类型T出现在逆变的位置
  //即泛型T定义为协变之后，泛型便不能直接
  //应用于成员方法当中
  //  def prepend(newHead:T):List[T]=new List(newHead,this)

  //因为是协变的，输入的类型必须是T的超类
  //new List(newHead,this)这种写法是调用的构造器,所以认为是List(T,T)而不是List(U,U)
  //def prepend[U<:T](newHead:U):List[U]=new List(newHead,this)
  def prepend[U<:T](newHead:U):List[U]=null.asInstanceOf[List[U]]
}


/**
  * 为什么方法返回值类型可以是协变的
  * 里氏替换原则，所有使用父类型对象的地方都可以换成子类型对象
  * AnyRef                 -------->  String
  * A[AnyRef]              -------->  A[String]
  * fun()=AnyRef            -------->  fun()=String
  * father.fun()=notString  xxxxxxxxx  child.fun()=notString
  *
  */
//class In[+A]{ def fun(): A = null.asInstanceOf[A] }