package Concept

/**
  * pattern match will call unapply method
  */
class ExtracterInPM {
}
object ExtracterInPM {

  def test(a:UserTwo) ={
    a.country
  }


  def main(args: Array[String]): Unit = {
    //单个成员变量匹配
    val user:User = new PremiumUser("ddd")
    var msg = user match{
      case FreeUser(name) => "hello " + name
      case PremiumUser(name) => "welcome "+name
    }
    println(msg)

    //多成员变量匹配
    val person:User = new UserTwo("aa","nantong","china")
    msg = person match{
      case UserOne(name,_) => s"$name welcome to nantong"
      case UserTwo(name,city,country) =>
        if(city.equals("nantong")) s"$name welcome to $country"
        else "===="
    }
    println(msg)

    //boolean 提取及变量绑定
    val person2:User = new UserTwo("aa","nantong","china")
    msg = person2 match{
      case testUser @ CountryChecker() => test(testUser)
      case _ => "---------------"
    }
    println(msg)

    //流提取,使用中缀的方式来提取而不是func()的提取方式
    //a#::b和#::(a,b)是一样的,此次不用重新实现unapply的方法,因为源码中已有如下实现
//    object #:: {
//      def unapply[A](xs: Stream[A]): Option[(A, Stream[A])] =
//        if (xs.isEmpty) None
//        else Some((xs.head, xs.tail))
//    }
    val xs=1 #:: 22 #:: 44 #:: Stream.empty
    var num = xs match{
      case first #:: second #:: tail => second - first
      case _ => -1
    }
    println(num)

    val arr = 3::6::12::24::Nil
    num = arr match{
        //匹配只有一个元素
      case List(a) => a
      case List(a,b)  => a+b
      case List(a,b,c)  => a+b+c
        //匹配一个以上元素,由于超过3个元素所以被此处匹配到
      case List(a,_*) => 111111
    }
    println(num)
  }
}


trait User{
  def name:String
}

class FreeUser(val name:String) extends User
class PremiumUser(val name:String) extends User

object FreeUser{
  def unapply(arg: FreeUser): Option[String] = Some(arg.name)
}

object PremiumUser{
  def unapply(arg: PremiumUser): Option[String] = Some(arg.name)
}

class UserOne(val name:String,val school:String) extends User
class UserTwo(val name:String,val home:String,val country:String) extends User

object UserOne{
  def unapply(arg: UserOne): Option[(String, String)] = Some(arg.name,arg.school)
}

object UserTwo{
  def unapply(arg: UserTwo): Option[(String, String, String)] = Some(arg.name,arg.home,arg.country)
}

object CountryChecker{
  def unapply(arg: UserTwo): Boolean = arg.country.equals("china")
}