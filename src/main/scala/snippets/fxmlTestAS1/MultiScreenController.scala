package snippets.fxmlTestAS1

import scalafx.event.ActionEvent
import scalafx.scene.layout.{StackPane, Pane}
import scalafxml.core.macros.sfxml

@sfxml
class MultiScreenController(
                             private val pane1: Pane,
                             private val pane2: Pane,
                             private val paneMain: Pane,
                             private val stackPainMain: StackPane,
                             private val myService: MyService) {


  def onBtnShowWindow1(event: ActionEvent) = {
    pane1.setVisible(true)
    paneMain.setVisible(false)
    myService.printSth()

  }

  def onBtnShowWindow2(event: ActionEvent) = {
    pane2.setVisible(true)
    paneMain.setVisible(false)

  }

  def onBtnGoBack1(event: ActionEvent) = {
    paneMain.setVisible(true)
    pane1.setVisible(false)

  }

  def onBtnGoBack2(event: ActionEvent) = {
    paneMain.setVisible(true)
    pane2.setVisible(false)

  }



}
