import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.event.ActionEvent
import scalafx.geometry.{Pos, Insets}
import scalafx.scene.paint.Color
import scalafx.scene.{Scene, Node}
import scalafx.scene.control.{Label, Button}
import scalafx.scene.layout.{VBox, HBox, GridPane}

object TestMain extends JFXApp {

  def getMainSceneContent: Seq[Node] = {

    val bInsets = Insets(10.0)
    val defFontStyle = "-fx-font-size: 16pt"
    val defFontStyleBold = """-fx-font-size: 16pt;-fx-font-weight:bold"""


    val b1 = new Button("Aparat Krzyżowy") {}
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
    bExit.onAction = { e: ActionEvent => ; stage.close();}

    val bMinWidth = 300.0
    val bMinHeight = 80.0


    val buttonList = List[Button](b1, b2, b3, b4, b5, b6)
    buttonList.foreach(x => {
      x.setMinSize(bMinWidth, bMinHeight);
      x.style = defFontStyle;
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


}
