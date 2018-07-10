package base.classpkg

/**
  * Created by Administrator on 2018/3/18.
  * the constructor of scala class need to use the key word "this"
  * In one class ,there can be mutiple contructors,one is primary contructor,others are anxiliary contructors
  * The definition of primary contructor is different with others,it is mixed into the definiton of class
  */
class TestConstructor(val a:String,val b:Int) {
  //the following line will be executed ,when the main contructor is called
  println("this is primary contructor")

  def this(a:String){
    this(a,0)
  }


}
