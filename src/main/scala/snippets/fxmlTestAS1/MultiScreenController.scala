package snippets.fxmlTestAS1

import scalafx.event.ActionEvent
import scalafx.scene.input.MouseEvent
import scalafx.scene.layout.{StackPane, Pane}
import scalafxml.core.macros.sfxml

trait MultiScreenControllerIntf {

  def initialize()
}

@sfxml
class MultiScreenController(
                             private val paneExaminations: Pane,
                             private val pane2: Pane,
                             private val paneMain: Pane,
                             private val stackPainMain: StackPane,
                             private val myService: MyService,
                             private val paneEnterExaminationData: Pane) extends MultiScreenControllerIntf {


  def btnShowEnterExaminationData(event: ActionEvent) = {

    paneEnterExaminationData.setVisible(true)
    paneMain.setVisible(false)
    paneExaminations.setVisible(false)

  }

  def onBtnExitToPaneMainClicked(event: MouseEvent) = {

    initialize()

  }


  def onBtnBypassExamDataClicked(event: MouseEvent) = {
    paneExaminations.setVisible(true)
    paneEnterExaminationData.setVisible(false)
    paneMain.setVisible(false)
  }


  def onBtnShowWindow1(event: ActionEvent) = {
    paneExaminations.setVisible(true)
    paneMain.setVisible(false)
    myService.printSth()

  }

  def onBtnShowWindow2(event: ActionEvent) = {
    pane2.setVisible(true)
    paneMain.setVisible(false)

  }

  def onBtnGoBack1(event: ActionEvent) = {
    paneMain.setVisible(true)
    paneExaminations.setVisible(false)

  }

  def onBtnGoBack2(event: ActionEvent) = {
    paneMain.setVisible(true)
    pane2.setVisible(false)

  }

  override def initialize(): Unit = {

    paneExaminations.setVisible(false)
    pane2.setVisible(false)
    paneEnterExaminationData.setVisible(false)
    paneMain.setVisible(true)
    println("initialized")


  }
}
