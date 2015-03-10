package snippets.multiWindowFramework

import java.net.URL
import java.util.ResourceBundle
import javafx.event.ActionEvent
import javafx.fxml
import javafx.fxml.{FXML, Initializable}


class Screen3Controller extends Initializable with ControlledScreen {

  var myController: ScreensController = null

  override def initialize(location: URL, resources: ResourceBundle): Unit = {


  }

  override def setScreenParent(screenParent: ScreensController): Unit = {
    myController = screenParent
  }


  @FXML
  def goToScreen1(event: ActionEvent): Unit = {
    myController.setScreen(ScreenNames.SCREEN1_SCREEN)

  }

  @FXML
  def goToScreen2(event: ActionEvent): Unit = {
    myController.setScreen(ScreenNames.SCREEN2_SCREEN)

  }

}