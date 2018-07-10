package note.OneDay.advance

/**
  * Scala提取器（Extractor）:
  * apply方法：无需new操作就可创建对象。
  * unapply方法：是apply方法的反向操作，接受一个对象，然后从对象中提取值，提取的值通常是用来构造对象的值。
  */
object TestExtractor {
  def main(args: Array[String]) {

    println ("Apply 方法 : " + apply("Zara", "gmail.com")); // 也可直接Test("Zara", "gmail.com")来创建Zara@gmail.com
    println ("Unapply 方法 : " + unapply("Zara@gmail.com"));
    println ("Unapply 方法 : " + unapply("Zara Ali"));

  }
  // 注入方法 (可选)
  def apply(user: String, domain: String) = {
    user +"@"+ domain
  }

  // 提取方法（必选）
  def unapply(str: String): Option[(String, String)] = {
    val parts = str split "@"
    if (parts.length == 2){
      Some(parts(0), parts(1))
    }else{
      None
    }
  }
}
