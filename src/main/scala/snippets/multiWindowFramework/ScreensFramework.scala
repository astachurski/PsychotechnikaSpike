package snippets.multiWindowFramework
import javafx.scene.{Scene, Group}
import scalafx.application.JFXApp


object ScreensFramework extends JFXApp {

  val mainContainer = new ScreensController

  mainContainer.loadScreen(ScreenNames.SCREEN1_SCREEN, ScreenNames.SCREEN1_SCREEN_FXML)
  mainContainer.loadScreen(ScreenNames.SCREEN2_SCREEN, ScreenNames.SCREEN2_SCREEN_FXML)
  mainContainer.loadScreen(ScreenNames.SCREEN3_SCREEN, ScreenNames.SCREEN3_SCREEN_FXML)
  
  mainContainer.setScreen(ScreenNames.SCREEN1_SCREEN)
  
  val root = new Group()
  root.getChildren.addAll(mainContainer)
  
  val scene = new Scene(root)

  stage = new JFXApp.PrimaryStage()
  
  stage.delegate.setScene(scene)
  
  stage.show()



  
}
