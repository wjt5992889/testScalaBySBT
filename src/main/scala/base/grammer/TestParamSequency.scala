package base.grammer

/**
  * Created by Administrator on 2018/3/13.
  */
object TestParamSequency {

  def sum(x:Int*): Unit ={
    var result = 0
    for(i<-x) result+=i
    result
  }
}
