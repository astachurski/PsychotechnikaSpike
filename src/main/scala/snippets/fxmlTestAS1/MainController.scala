package snippets.fxmlTestAS1

import scalafx.beans.binding.StringBinding
import scalafx.event.ActionEvent
import scalafx.scene.control.{ListView, TextField, Button, Label}
import scalafx.scene.layout.Pane
import scalafx.scene.paint.Color
import scalafx.scene.shape.Rectangle
import scalafxml.core.macros.sfxml


@sfxml
class MainController(private val LblDupa: Label,
                     private val RectDupa: Rectangle,
                     private val textDest: TextField,
                     private val textSrc: TextField,
                     private val paneToggleable: Pane,
                     private val paneToggleable1: Pane) {

  def onBtnClicked(event: ActionEvent) {
    LblDupa.setText("I'm fucking clicked !!!")
    RectDupa.fill = Color.Red
    textDest.text <== textSrc.text
  }

  def createNewWindow(event: ActionEvent): Unit = {


  }

  def onCbxDupa1Toggled(event: ActionEvent): Unit = {

    paneToggleable.visible = !paneToggleable.isVisible
  }

  def onCbxDupa2Toggled(event: ActionEvent): Unit = {

    paneToggleable1.visible = !paneToggleable1.isVisible
  }


}
