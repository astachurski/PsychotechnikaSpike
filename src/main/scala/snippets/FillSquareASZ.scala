package snippets

import scala.util.Random
import scalafx.Includes._
import scalafx.animation.AnimationTimer
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.paint.Color
import scalafx.scene.shape.Rectangle

object FillSquareASZ extends JFXApp {
  val rectangle = new Rectangle {
    x = 25
    y = 40
    width = 100
    height = 100
    fill = Color.GREEN
  }
  stage = new JFXApp.PrimaryStage {
    title.value = "Hello Stage"
    width = 600
    height = 450
    scene = new Scene {
      fill = Color.LIGHTGREEN
      content = rectangle
    }
  }
  def getDelay(): Long = Random.nextInt(3).toLong + 2
  var timespanS: Long = getDelay()
  //  println(s"Random timespan ${timespanS}s")
  var startTimer = 0L
  var prevTimerS = -1L
  var squareOn = false
  var squareOnTimerMs = 0L
  var clicked = false
  var timerMs = 0L
  val timer = AnimationTimer { currentTimer =>
    if (startTimer == 0)
      startTimer = currentTimer
    timerMs = (currentTimer - startTimer) / 1000000
    val timerS = timerMs / 1000
    if (timerS >= timespanS && !squareOn) {
      rectangle.fill = Color.RED
      //      println(s"Time start at ${timerMs}ms")
      squareOn = true
      squareOnTimerMs = timerMs
    }
    if (clicked) {
      val reactionTimeMs = timerMs - squareOnTimerMs
      println(s"Reaction time ${reactionTimeMs}ms")
      clicked = false
      squareOn = false
      rectangle.fill = Color.GREEN
      startTimer = currentTimer
      timespanS = getDelay()
    }
    //    println(s"ms $timerMs")
    //    if (timerS - prevTimerS > 0) {
    //      print(s"$timerS ")
    //      if (timerS % 10 == 0) println()
    //      prevTimerS = timerS
    //    }
  }

  timer.start()
  rectangle.onMousePressed = handle {
    //    println("Clicked")
    clicked = true
  }

}
