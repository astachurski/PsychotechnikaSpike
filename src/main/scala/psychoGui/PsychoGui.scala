package psychoGui

import javafx.scene.{Group, Scene}

import scalafx.application.JFXApp


object PsychoGui extends JFXApp {

  val mainContainer = new ScreensController

  mainContainer.loadScreen(ScreenNames.SCREEN_MAIN, ScreenNames.SCREEN_MAIN_FXML)
  mainContainer.loadScreen(ScreenNames.SCREEN_ENTER_EXAM_DATA_DLG_SCREEN, ScreenNames.SCREEN_ENTER_EXAM_DATA_DLG_SCREEN_FXML)
  mainContainer.loadScreen(ScreenNames.SCREEN_EXAMINATIONS, ScreenNames.SCREEN_EXAMINATIONS_FXML)

  mainContainer.loadScreen(ScreenNames.SCREEN_SIMPLE_REACTIONS_SETTINGS, ScreenNames.SCREEN_SIMPLE_REACTIONS_SETTINGS_FXML)
  mainContainer.loadScreen(ScreenNames.SCREEN_SIMPLE_REACTIONS, ScreenNames.SCREEN_SIMPLE_REACTIONS_FXML)


  mainContainer.setScreen(ScreenNames.SCREEN_MAIN)

  val root = new Group()

  root.getChildren.addAll(mainContainer)

  val scene = new Scene(root)



  stage = new JFXApp.PrimaryStage()

  stage.delegate.setScene(scene)

  scene.getWindow.setWidth(1280)
  scene.getWindow.setHeight(800)

  stage.show()


}
