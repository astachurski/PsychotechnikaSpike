package snippets.multiWindowFramework

import java.net.URL
import java.util.ResourceBundle
import javafx.event.ActionEvent
import javafx.fxml.{FXML, Initializable}

/**
 * Created by adrian on 3/9/2015.
 */

class Screen1Controller extends Initializable with ControlledScreen {

  var myController: ScreensController = null

  override def initialize(location: URL, resources: ResourceBundle): Unit = {

  }

  override def setScreenParent(screenParent: ScreensController): Unit = {
    myController = screenParent

  }

  @FXML
  def goToScreen2(event: ActionEvent): Unit = {
    myController.setScreen(ScreenNames.SCREEN2_SCREEN)

  }

  @FXML
  def goToScreen3(event: ActionEvent): Unit = {
    myController.setScreen(ScreenNames.SCREEN3_SCREEN)

  }

}

