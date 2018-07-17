package contest

import scala.annotation.tailrec

/**
  * Initially, there is a Robot at position (0, 0).
  * Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.
  *
  * The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L(Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.
  *
  * Example 1:
  *
  * Input: "UD"
  * Output: true
  * Example 2:
  *
  * Input: "LL"
  * Output: false
  * object Solution {
  * def judgeCircle(moves: String): Boolean = {
  * }
  * }
  */
object RobotMove {

  def main(args: Array[String]): Unit = {
    println(judgeCircle("RLLU"))
  }

  def judgeCircle(moves: String): Boolean = {

//    @tailrec
//    def move(moves: String,a:Tuple2[Int,Int]): (Int,Int) ={
//      if(moves.length == 0) a
//      else {
//        val point = moves.head match{
//          case 'R' => (a._1 + 1,a._2)
//          case 'L' => (a._1 - 1,a._2)
//          case 'R' => (a._1,a._2 + 1)
//          case 'L' => (a._1,a._2 - 1)
//          case _ => a
//        }
//        move(moves.tail.toString,point)
//      }
//    }
//
//    move(moves,(0,0))==(0,0)

    val point = moves.foldLeft((0,0)){
      (result,a) => a match {
        case 'R' => (result._1 + 1,result._2)
        case 'L' => (result._1 - 1,result._2)
        case 'R' => (result._1,result._2 + 1)
        case 'L' => (result._1,result._2 - 1)
        case _ => result
      }
    }

    point == (0,0)
  }

}
