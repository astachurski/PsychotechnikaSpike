package snippets.fxmlTestAS1

import java.net.URL
import java.util
import javafx.event.ActionEvent
import javafx.scene.{control => jfxsc}
import javafx.scene.{layout => jfxsl}
import javafx.{fxml => jfxf, event}
import scalafx.Includes._


class MultiScreenController extends jfxf.Initializable {


  @jfxf.FXML
  private var paneExaminations: jfxsl.Pane = _
  @jfxf.FXML
  private var paneMain: jfxsl.Pane = _
  @jfxf.FXML
  private var stackPainMain: jfxsl.StackPane = _
  //private val myService: MyService
  @jfxf.FXML
  private var paneEnterExaminationData: jfxsl.Pane = _

  @jfxf.FXML
  private var childWindowController: ChildWindowController = _


  //Intermediate window that can be bypassed...
  @jfxf.FXML
  def btnShowEnterExaminationData(event: ActionEvent) = {
    paneEnterExaminationData.setVisible(true)
    paneMain.setVisible(false)
    paneExaminations.setVisible(false)

  }


  @jfxf.FXML
  def onBtnExitToPaneMainClicked(event: ActionEvent) = {
    resetToDefault()
  }


  //Enter the main examination picker screen. Now choose the test...
  @jfxf.FXML
  def onBtnBypassExamDataClicked(event: ActionEvent) = {

    paneExaminations.setVisible(false)
    paneEnterExaminationData.setVisible(false)
    paneMain.setVisible(false)
    childWindowController.showAll()


  }


  @jfxf.FXML
  def onBtnShowWindow1(event: ActionEvent) = {
    paneExaminations.setVisible(true)
    paneMain.setVisible(false)
    //myService.printSth()

  }

  @jfxf.FXML
  def onBtnShowWindow2(event: ActionEvent) = {
    paneMain.setVisible(false)

  }

  @jfxf.FXML
  def onBtnGoBack1(event: ActionEvent) = {
    paneMain.setVisible(true)
    paneExaminations.setVisible(false)

  }

  @jfxf.FXML
  def onBtnGoBack2(event: ActionEvent) = {
    paneMain.setVisible(true)


  }

  def resetToDefault(): Unit = {
    paneExaminations.setVisible(false)

    paneEnterExaminationData.setVisible(false)
    paneMain.setVisible(true)
  }


  def initialize(url: URL, rb: util.ResourceBundle) {
    resetToDefault()
    childWindowController.hideAll()
  }

  def test(): Unit = {
    println("test")

  }

  def showChild(): Unit = {
    childWindowController.showAll()
  }


  @jfxf.FXML
  def onBtnShowExaminationAction(event: ActionEvent) = {
    //childWindowController.showAll()

  }


}
