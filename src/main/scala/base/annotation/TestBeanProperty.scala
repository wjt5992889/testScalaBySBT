package base.annotation

import scala.beans.BeanProperty

/**
  * Created by Administrator on 2018/3/18.
  */
object TestBeanProperty {

  /**
    * if we mark one field as @BeanProperty,scala will generate 4 methods for this field,2 in scala way,2 in java way
    * a:String
    * a_=(newVal:String)= Unit
    * getA():String
    * setA(newVal:String)=Unit
    *
    */
  @BeanProperty  var a: String = "1"
}
