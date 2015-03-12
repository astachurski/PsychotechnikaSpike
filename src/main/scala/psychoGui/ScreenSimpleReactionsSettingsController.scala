package psychoGui

import java.net.URL
import java.util.ResourceBundle
import javafx.event.ActionEvent
import javafx.fxml.{FXML, Initializable}

/**
 * Created by adrian on 3/12/2015.
 */

class ScreenSimpleReactionsSettingsController extends Initializable with ControlledScreen {

  var myController: ScreensController = null

  override def initialize(location: URL, resources: ResourceBundle): Unit = {

  }

  override def setScreenParent(screenParent: ScreensController): Unit = {
    myController = screenParent

  }

  @FXML
  def goToScreenExaminations(event: ActionEvent): Unit = {
    myController.setScreen(ScreenNames.SCREEN_EXAMINATIONS)

  }

  @FXML
  def goToScreenSimpleReactions(event: ActionEvent): Unit = {
    myController.setScreen(ScreenNames.SCREEN_SIMPLE_REACTIONS)

  }




}
