package psychoGui

import java.net.URL
import java.util.ResourceBundle
import javafx.event.ActionEvent
import javafx.fxml.{FXML, Initializable}

/**
 * Created by adrian on 3/9/2015.
 */


class ScreenEnterExamDataDialogController extends Initializable with ControlledScreen {

  var myController: ScreensController = null

  override def initialize(location: URL, resources: ResourceBundle): Unit = {


  }

  override def setScreenParent(screenParent: ScreensController): Unit = {
    myController = screenParent

  }



  @FXML
  def goToScreenMain(event: ActionEvent): Unit ={
    myController.setScreen(ScreenNames.SCREEN_MAIN)

  }

  @FXML
  def goToScreenExaminations(event: ActionEvent): Unit = {
    myController.setScreen(ScreenNames.SCREEN_EXAMINATIONS)

  }





}