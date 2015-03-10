package snippets.multiWindowFramework

import javafx.scene.{Scene, Group}
import snippets.fxmlTestAS1.FxmlTestAS1._
import scalafx.application.JFXApp


object ScreensFramework extends JFXApp {

  val mainContainer = new ScreensController

  mainContainer.loadScreen(ScreenNames.MAIN_SCREEN, ScreenNames.MAIN_SCREEN_FXML)
  mainContainer.loadScreen(ScreenNames.POKER_SCREEN, ScreenNames.POKER_SCREEN_FXML)
  mainContainer.loadScreen(ScreenNames.ROULETTE_SCREEN, ScreenNames.ROULETTE_SCREEN_FXML)
  
  mainContainer.setScreen(ScreenNames.MAIN_SCREEN)
  
  val root = new Group()
  root.getChildren.addAll(mainContainer)
  
  val scene = new Scene(root)

  stage = new JFXApp.PrimaryStage()
  
  stage.delegate.setScene(scene)
  
  stage.show()



  
}
