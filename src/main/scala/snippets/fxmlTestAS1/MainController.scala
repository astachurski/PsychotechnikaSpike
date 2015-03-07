package snippets.fxmlTestAS1

import scalafx.event.ActionEvent
import scalafx.scene.control.{Button, Label}
import scalafx.scene.paint.Color
import scalafx.scene.shape.Rectangle
import scalafxml.core.macros.sfxml


@sfxml
class MainController(private val LblDupa: Label, private val RectDupa: Rectangle) {

  def onBtnClicked(event: ActionEvent) {
    LblDupa.setText("I'm fucking clicked !!!")
    //println("bububu")
    RectDupa.fill = Color.Red

  }


}
