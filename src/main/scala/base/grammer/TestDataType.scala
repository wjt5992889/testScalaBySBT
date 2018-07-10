package base.grammer

import scala.util.control.Breaks

/**
  * Created by Administrator on 2017/4/18.
  */
object TestDataType {
  def main(args: Array[String]): Unit = {
//    Byte	8位有符号补码整数。数值区间为 -128 到 127
//    Short	16位有符号补码整数。数值区间为 -32768 到 32767
//    Int	32位有符号补码整数。数值区间为 -2147483648 到 2147483647
//    Long	64位有符号补码整数。数值区间为 -9223372036854775808 到 9223372036854775807
//    Float	32位IEEE754单精度浮点数
//    Double	64位IEEE754单精度浮点数
//    Char	16位无符号Unicode字符, 区间值为 U+0000 到 U+FFFF
//    String	字符序列
//    Boolean	true或false
//    Unit	表示无值，和其他语言中void等同。用作不返回任何结果的方法的结果类型。Unit只有一个实例值，写成()。
//    Null	null 或空引用
//    Nothing	Nothing类型在Scala的类层级的最低端；它是任何其他类型的子类型。
//    Any	Any是所有其他类的超类
//    AnyRef	AnyRef类是Scala里所有引用类(reference classpkg)的基类

    var int1  = 0
    var int2  = 0xFFFFFFFF
    var long1 = 777L
    var double1= 0.0
    var float1  = 1e30f
    var float2  = 3.14159f

//    多行字符串用三个双引号来表示分隔符，格式为：""" ... """。
    val foo = """aaa
vvv
       ddd
        333
        555"""
    print(foo)

//    b		退格(BS) ，将当前位置移到前一列
//    \t		水平制表(HT) （跳到下一个TAB位置）
//    \n		换行(LF) ，将当前位置移到下一行开头
//    \f		换页(FF)，将当前位置移到下页开头
//    \r		回车(CR) ，将当前位置移到本行开头
//    \"		代表一个双引号(")字符
//    \'		代表一个单引号（'）字符
//    \\		代表一个反斜线字符 '\'

    println("Hello\tWorld\n\n" );

  }
}
