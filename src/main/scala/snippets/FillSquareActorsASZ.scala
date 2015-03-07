package snippets

import java.util.Calendar

import akka.actor.{Props, ActorSystem, Actor, ActorRef}

import scala.concurrent.Future
import scala.util.Random
import scalafx.Includes._
import scalafx.animation.AnimationTimer
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.paint.Color
import scalafx.scene.shape.Rectangle

case class PsychoStimulus2(originTime: Long)
case class GeneratorStartCommand2(receiver: ActorRef)
case class ResponseEvent2(originTime: Long)


object FillSquareActorsASZ extends JFXApp {
  val rectangle = new Rectangle {
    x = 25
    y = 40
    width = 100
    height = 100
    fill = Color.GREEN
  }

  class PsychoEventListener extends Actor {

    var lastStimulusTime: Long = 0L
    var lastResponseTime: Long = 0L

    def difCalc: Long = {
      lastResponseTime - lastStimulusTime
    }

    def showResults(): Unit = {
      println(s"Reaction time: $difCalc ms")
    }

    def receive = {
      case PsychoStimulus2(originTime) =>
        print("Test - React NOW! ")
        squareOn = true
        lastStimulusTime = originTime
      case ResponseEvent2(originTime) =>
        squareOn = false
        lastResponseTime = originTime
        showResults()
    }
  }

  import scala.concurrent.ExecutionContext.Implicits.global

  class Generator extends Actor {
    def generate(recv: ActorRef) = Future {
      for (i <- 1 to 20) {
        Thread.sleep(Random.nextInt(2000) + 3000)
        recv ! PsychoStimulus2(Calendar.getInstance().getTimeInMillis)
      }
    }

    def receive = {
      case GeneratorStartCommand2(r) => generate(r)
    }
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
  var squareOn = false
  val timer = AnimationTimer { _ =>
    rectangle.fill = if (squareOn) Color.RED else Color.GREEN
  }

  timer.start()
  rectangle.onMousePressed = handle {
    psychoEventListener ! ResponseEvent2(Calendar.getInstance().getTimeInMillis)
  }

  val system = ActorSystem("PsycholSystem")
  val psychoEventListener = system.actorOf(Props[PsychoEventListener], name = "psychoeventlistener")
  val generator = system.actorOf(Props[Generator], name = "generator")

  generator ! GeneratorStartCommand2(psychoEventListener)
}