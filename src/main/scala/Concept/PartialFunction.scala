package Concept

import akka.actor.Actor

/**
  * 偏函数是只对函数定义域的一个子集进行定义的函数。
  */
object PartialFunction {
  /**
    * 定义一个偏函数，有两种方式定义偏函数，下面这种更好，
    * 因为有isDefinedAt方法来校验参数是否会得到处理.
    * 或者在调用时使用一个orElse方法，该方法接受另一个偏函数,
    * 用来定义当参数未被偏函数捕获时该怎么做
    */
  def jump: PartialFunction[String, Unit] = {
    case "hello" => println("fine, and you?")
    case "have a good day!" => println("the same to you!")
    //    case 5 => println("why get me a Five?")
    case _ => println("what is this? get away from me!")//注释的话如果匹配不上会报错
  }


  /**
    * 另一种定义一个偏函数的方式，不细说
    */
  def run = (x: Int) => x match {
    case x if x > 1 => 1
  }

}

class HelloActor extends Actor{

  /**
    * 源码中
    *  def receive: Actor.Receive
    * type Receive = PartialFunction[Any, Unit]
    * receive的参数是一个偏函数，输入参数是”actorDemo”,输出参数是Unit.
    * 可以理解case就是一个函数，经常有好多组case,如果一组case语句没有涵盖所有的情况，
    * 那么这组case语句就可以被看做是一个偏函数。
    *
    * @return
    */
  override def receive: Receive = {
    case "actorDemo" => println("receive....ActorDemo")
  }
}
