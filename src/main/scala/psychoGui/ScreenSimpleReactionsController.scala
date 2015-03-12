package psychoGui

import java.net.URL
import java.util.ResourceBundle
import javafx.event.ActionEvent
import javafx.fxml.{FXML, Initializable}

/**
 * Created by adrian on 3/12/2015.
 */
class ScreenSimpleReactionsController extends Initializable with ControlledScreen {

  var myController: ScreensController = null

  override def initialize(location: URL, resources: ResourceBundle): Unit = {

  }

  override def setScreenParent(screenParent: ScreensController): Unit = {
    myController = screenParent

  }

  @FXML
  def goToScreenSimpleReactionsSettings(event: ActionEvent): Unit = {
    myController.setScreen(ScreenNames.SCREEN_SIMPLE_REACTIONS_SETTINGS)

  }

  @FXML
  def startExamination(event: ActionEvent): Unit = {
    println("started examination")
  }


}
