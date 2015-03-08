package snippets.fxmlTestAS1

import java.net.URL
import scalafx.application.JFXApp
import scalafx.Includes._
import scalafx.scene.Scene
import scala.reflect.runtime.universe.typeOf
import scalafxml.core.DependenciesByType
import scalafxml.core.FXMLLoader
import javafx.{scene => jfxs}


case class MyService() {
  def printSth() = {
    println("from my service 1!!!")
  }
}

object MultiScreenTest extends JFXApp {

  val res: URL = getClass.getResource("multiScreenTest.fxml")
  val deps: DependenciesByType = new DependenciesByType(Map(typeOf[MyService] -> new MyService()))
  val loader = new FXMLLoader(res, deps)
  loader.load()

  val root = loader.getRoot[jfxs.Parent]

  stage = new JFXApp.PrimaryStage() {
    title = "Hello world"
    scene = new Scene(root) {
      //fill = Color.Transparent
    }
  }

  val n = root.lookup("#btnBadania")

  if (n != null) {
    n.asInstanceOf[javafx.scene.control.Button].text = "A pupu !"
  }

  val ctrl = loader.getController[MultiScreenControllerIntf]()
  ctrl.initialize()


  //stage.setFullScreen(true)
  //stage.scene.fi fill(Color.Transparent)

}
