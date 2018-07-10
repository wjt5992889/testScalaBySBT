package base.grammer

/**
  * Created by Administrator on 2018/3/14.
  * 递归算法实现,
  * 1.args.head表示第一个元素
  * 2.args.tail表示其余元素
  * 3._*表示作为参数序列输入
  */
object TestHeadTail {

  def main(args: Array[String]): Unit = {
    print(test(1,1,1,1,11))
  }

  def test(args:Int*):Int  ={
    if(args.length == 0) 0
    else args.head + test(args.tail:_*)
  }

}
