package psychoGui

import java.net.URL
import java.util.ResourceBundle
import javafx.event.ActionEvent
import javafx.fxml.{FXML, Initializable}

/**
 * Created by adrian on 3/9/2015.
 */

class ScreenMainController extends Initializable with ControlledScreen {

  var myController: ScreensController = null

  override def initialize(location: URL, resources: ResourceBundle): Unit = {

  }

  override def setScreenParent(screenParent: ScreensController): Unit = {
    myController = screenParent

  }


  @FXML
  def goToScreenEnterExamDataDialog(event: ActionEvent): Unit = {
    myController.setScreen(ScreenNames.SCREEN_ENTER_EXAM_DATA_DLG_SCREEN)

  }


}

