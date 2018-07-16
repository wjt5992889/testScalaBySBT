import scala.reflect.runtime.universe._
class AA
val aa = new AA
aa.getClass
val bb = new AA

//一下类型各不相同
typeOf[aa.type] == typeOf[AA]
typeOf[bb.type] == typeOf[AA]
typeOf[aa.type] == typeOf[bb.type]


/**
  * 有些人很喜欢用 x.foo.bar
  * 这样的方式连续的去操作，
  * 这种风格也成为”链式调用”风格，
  * 它要求方法返回的必须是当前对象类型，
  * 以便连贯的调用方法。
  * 不过上面，因为父类中声明的method1方法返回类型限制死了
  * 就是A类型(不写返回值类型，用类型推导也一样)，
  * 导致子类对象调用完method1之后，
  * 类型已经变成了父类型，
  * 无法再调用子类型中的方法了。
  */
class A {def method1: A = this }
class B extends A {def method2: B = this}
val b = new B
b.method2.method1  // 可以工作
//b.method1.method2  // 不行，提示：error: value method2 is not a member of A

/**
  * 返回类型都改为了 this.type
  * 单例类型，就灵了。
  * 它利用了this关键字的动态特性来实现的，
  * 在执行b.method1 的时候，
  * method1返回值类型this.type
  * 被翻译成了B.this.type
  */
//如下修改即可工作
class C { def method1: this.type = this }
class D extends C { def method2 : this.type = this }

val d = new D
d.method1.method2  // ok