package snippets

import java.util.Calendar

import akka.actor.{ActorRef, Props, ActorSystem, Actor}

import scala.util.Random
import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.event.ActionEvent
import scalafx.geometry.{Insets, Pos}
import scalafx.scene.control._
import scalafx.scene.layout.{GridPane, HBox, VBox}
import scalafx.scene.paint.Color
import scalafx.scene.{Node, Scene}
import scala.concurrent.duration._
import scalafx.util.converter.DateTimeStringConverter


case class PsychoStimulus(originTime: Long)
case class GeneratorStartCommand(receiver: ActorRef)
case class ResponseEvent(originTime: Long)


class PsychoEventListener extends Actor {

  var lastStimulusTime: Long = 0L
  var lastResponseTime: Long = 0L

  def difCalc: Long = {
    lastResponseTime - lastStimulusTime
  }

  def showResults(): Unit = {
    println(s"And the result is: $difCalc ms")
  }

  def receive = {
    case PsychoStimulus(originTime) => lastStimulusTime = originTime
    case ResponseEvent(originTime) => lastResponseTime = originTime; showResults()
  }

}


class Generator extends Actor {
  def generate(recv: ActorRef) {
    for (i <- 1 to 20) {

      println(s"Test# $i - React NOW !")
      recv ! PsychoStimulus(Calendar.getInstance().getTimeInMillis)

      Thread.sleep(Random.nextInt(3500))
    }
  }

  def receive = {
    case GeneratorStartCommand(r) => generate(r)
  }
}


object PsychoActorsSpike extends JFXApp {


  def getMainSceneContent: Seq[Node] = {

    val bInsets = Insets(10.0)
    val defFontStyle = "-fx-font-size: 16pt"
    val defFontStyleBold = """-fx-font-size: 16pt;-fx-font-weight:bold"""

    val b1 = new Button("Aparat Krzyżowy") {}
    b1.onAction = { e: ActionEvent => psychoEventListener ! ResponseEvent(Calendar.getInstance().getTimeInMillis)}

    val b2 = new Button("Aparat Piórkowskiego") {}
    val b3 = new Button("Wirometr") {}
    val b4 = new Button("Badanie reakcji prostych") {}
    val b5 = new Button("Badanie reakcji złożonych") {}
    val b6 = new Button("Kinestezjometr") {}

    val bResults = new Button("Wyniki badania") {}
    bResults.margin = bInsets
    bResults.style = defFontStyleBold
    //bResults.onAction = {e:ActionEvent => Dialogs.show}

    val bExit = new Button("WYJśCIE") {}
    bExit.margin = bInsets
    bExit.style = defFontStyleBold
    bExit.onAction = { e: ActionEvent => ; stage.close(); system.shutdown()}

    val bMinWidth = 300.0
    val bMinHeight = 80.0


    val buttonList = List[Button](b1, b2, b3, b4, b5, b6)
    buttonList.foreach(x => {
      x.setMinSize(bMinWidth, bMinHeight)
      x.style = defFontStyle
      x.margin = bInsets
    })

    bResults.setMinSize(200, 60)
    bExit.setMinSize(200, 60)

    val mainGridPane = new GridPane() {
      styleClass += "mainGridPane"
    }

    val mainCaptionHBox = new HBox() {
      styleClass += "mainCaption"
      alignment = Pos.CENTER
      padding = Insets(30.0)
    }

    mainCaptionHBox.content = new Label("BADANIA PSYCHOTECHNICZNE") {
      style = "-fx-font-weight:bold;-fx-font-size: 24pt"
    }

    val resultsExitHBox = new HBox() {
      alignment = Pos.CENTER
      styleClass += "exitReportButtons"
      padding = Insets(10.0)
    }

    resultsExitHBox.content = Seq(
      bResults,
      bExit
    )

    mainGridPane.padding = Insets(80.0)
    mainGridPane.add(b1, 1, 1)
    mainGridPane.add(b2, 2, 1)
    mainGridPane.add(b3, 1, 2)
    mainGridPane.add(b4, 2, 2)
    mainGridPane.add(b5, 1, 3)
    mainGridPane.add(b6, 2, 3)
    mainGridPane.add(resultsExitHBox, 1, 4, 2, 1)

    val mainVBox = new VBox() {
      padding = Insets(25.0)
      //alignment = Pos.CENTER
      children ++= Seq(mainCaptionHBox, mainGridPane)
    }

    Seq(

      mainVBox
      //mainCaptionHBox,
      //mainGridPane
    )
  }

  def getMainScene: Scene = {

    new Scene(850, 750) {

      stylesheets += "default.css"

      fill = Color.web("1a3399")

      content = getMainSceneContent


    }


  }

  stage = new PrimaryStage {
    //width = 1024
    //height = 768
    title = "Psychotechnika"
    scene = getMainScene

  }

  val system = ActorSystem("PsycholSystem")
  val psychoEventListener = system.actorOf(Props[PsychoEventListener], name = "psychoeventlistener")
  val generator = system.actorOf(Props[Generator], name = "generator")

  generator ! GeneratorStartCommand(psychoEventListener)

  //system.scheduler.schedule(0.seconds, 2.second, psychoEventListener, PsychoStimulus(Calendar.getInstance().getTimeInMillis))(system.dispatcher, psychoEventListener)
}


