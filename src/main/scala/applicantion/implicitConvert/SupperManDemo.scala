package applicantion.implicitConvert

object SupperManDemo {
}

class Man(val name:String)
class SuperMan(val name: String) {
  def heat=print("超人打怪兽")
}
object SuperMan{
  //隐式转换方法
  implicit def man2SuperMan(man:Man)=new SuperMan(man.name)
  def main(args: Array[String]) {
    val hero=new Man("hero")
    //Man具备了SuperMan的方法
    hero.heat
  }
}