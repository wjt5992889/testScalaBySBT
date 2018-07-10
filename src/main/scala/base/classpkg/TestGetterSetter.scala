package base.classpkg

/**
  * Created by Administrator on 2018/3/18.
  */
class TestGetterSetter {
    /*声明属性，严格讲非public,属于私有，是private级别,但同时会默认生成public setter和getter方法，
    (val只有getter,没setter),当调用的时候，会通过age的函数来取得age的值，
    就是getter方法 setter 调用的是age_的方法 */
    var age=19
    //var 默认产生getter和setter
    private var tt = 0
    //val 只有getter没setter
    private val t = 0
    //private[this] 两者都没有,对象私有字段，private[this]类型不看作是类的成员,（实例化后同样无法访问）
    private[this] var a = 0
    //只有getter没有setter,并可以修改值,此处current在被外层调用类似getter,但是没有setter
    private[this] var value = 0
    //def是重新订i,重新定义只有getter,等同于val
    def current = value
    def increment(): Unit ={
      value += 1
    }

}
object TestGetterSetter{
def main(args: Array[String]): Unit = {

  val tt: TestGetterSetter = new TestGetterSetter
  tt.tt=1111
  println(tt.current)

}
}


