package thread.actor


import akka.actor.{Actor, ActorSystem, Props}

class  TestActor extends Actor{


  override def receive: Receive = {
    case "hello" => println("您好！")
    case  msg => println(msg)
  }
}


object TestActor extends App {
  val system = ActorSystem("HelloSystem")
  // 缺省的Actor构造函数
  val helloActor = system.actorOf(Props[TestActor], name = "TestActor")
  helloActor ! "hello"
  helloActor ! "喂"

  system.terminate()
}

