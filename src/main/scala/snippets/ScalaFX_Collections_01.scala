package snippets

//             ________                                __                   ________   __    __
//           /   _____/\                             /  /\                /   _____/\/__/\ /  /\
//          /  /\_____\/  ________     _______      /  / /   ________    /  /\_____\/\  \ /  / /
//         /  /_/___    /   _____/\  /_____   /\   /  / /  /_____   /\  /  /_/__      \  /  / /
//        /______  /\  /  /\_____\/  \____/  / /  /  / /   \____/  / / /   ____/\      \/  / /
//        \_____/ / / /  / /       /  ___   / /  /  / /  /  ___   / / /  /\____\/      /  / /\
//       ______/ / / /  /_/___    /  /__/  / /  /  / /  /  /__/  / / /  / /           /  / /\ \
//     /________/ / /________/\  /________/ /  /__/ /  /________/ / /__/ /           /__/ /  \ \
//     \________\/  \________\/  \________\/   \__\/   \________\/  \__\/            \__\/ \__\/
//
//                                  ScalaFX Programming Library Examples
//

import scalafx.collections.ObservableBuffer
import scalafx.collections.ObservableBuffer.{Add, Remove, Reorder}

/**
 * @author Luc Duponcheel <luc.duponcheel@gmail.com>
 *
 *         based upon: Example 4 Using an ObservableList & Example 7 Querying a ListChangeListener.Change Object
 *
 *         http://docs.oracle.com/javafx/2.0/collections/jfxpub-collections.htm
 *
 */

object ScalaFX_Collections_01 {
  private def changes01(observableStringBuffer: ObservableBuffer[String]) {
    println("observable string buffer before changes01 " + observableStringBuffer)
    observableStringBuffer += "a"
    observableStringBuffer += "b"
    println("observable string buffer after  changes01 " + observableStringBuffer)
  }

  private def changes02(observableStringBuffer: ObservableBuffer[String]) {
    println("observable string buffer before changes02 " + observableStringBuffer)
    observableStringBuffer ++= List("c", "d")
    println("observable string buffer after  changes02 " + observableStringBuffer)
  }

  private def changes03(observableStringBuffer: ObservableBuffer[String]) {
    println("observable string buffer before changes03 " + observableStringBuffer)
    List("x", "y", "z") ++=: observableStringBuffer
    println("observable string buffer after  changes03 " + observableStringBuffer)
  }

  private def changes04(observableStringBuffer: ObservableBuffer[String]) {
    println("observable string buffer before changes04 " + observableStringBuffer)
    observableStringBuffer.remove(1, 4)
    println("observable string buffer after  changes04 " + observableStringBuffer)
  }

  private def changes05(observableStringBuffer: ObservableBuffer[String]) {
    println("observable string buffer before changes05 " + observableStringBuffer)
    observableStringBuffer.setAll("X", "C", "D")
    println("observable string buffer after  changes05 " + observableStringBuffer)
  }

  private def changes06(observableStringBuffer: ObservableBuffer[String]) {
    println("observable string buffer before changes06 " + observableStringBuffer)
    observableStringBuffer.sort()
    println("observable string buffer after  changes06 " + observableStringBuffer)
  }

  def main(args: Array[String]) {
    val observableStringBuffer = ObservableBuffer[String]()
    observableStringBuffer onInvalidate {
      println("observable string buffer invalidated")
    }


    observableStringBuffer onChange {
      (_, changes) =>
        for (change <- changes) change match {
          case Add(position, elements) =>
            println("added " + elements + " at position " + position)
          case Remove(position, elements) =>
            println("removed " + elements + " at position " + position)
          case Reorder(start, end, _) =>
            println("reordered from " + start + " to " + end)
          case _ =>
            println("unclassified change")
        }
    }
    println("======================================================================")
    changes01(observableStringBuffer)
    println("======================================================================")
    changes02(observableStringBuffer)
    println("======================================================================")
    changes03(observableStringBuffer)
    println("======================================================================")
    changes04(observableStringBuffer)
    println("======================================================================")
    changes05(observableStringBuffer)
    println("======================================================================")
    changes06(observableStringBuffer)
    println("======================================================================")
  }
}



