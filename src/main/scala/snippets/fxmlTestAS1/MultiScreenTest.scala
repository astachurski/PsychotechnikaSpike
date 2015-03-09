package snippets.fxmlTestAS1

import java.net.URL
import scalafx.application.JFXApp
import scalafx.Includes._
import scalafx.scene.Scene
import scala.reflect.runtime.universe.typeOf
import scalafxml.core.DependenciesByType
import scalafxml.core.FXMLLoader
import javafx.{scene => jfxs}
import javafx.{fxml => jfxf}


case class MyService() {
  def printSth() = {
    println("from my service 1!!!")
  }
}

object MultiScreenTest extends JFXApp {

  val res: URL = getClass.getResource("multiScreenTest.fxml")
  val deps: DependenciesByType = new DependenciesByType(Map(typeOf[MyService] -> new MyService()))
  //val loader = new FXMLLoader(res, deps)
  //val loader = jfxf.FXMLLoader.load(res)
  //loader.load()

  //val root = loader.getRoot[jfxs.Parent]
  val loader = new jfxf.FXMLLoader(res)
  val root: jfxs.Parent = loader.load()

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


  val ctrl = loader.getController[MultiScreenController]()
  ctrl.test()

  //val k = ctrl.getClass

  //println("rstrs")


//-------------------------------------------

  //val loader2 = new FXMLLoader(getClass.getResource("multiScreenTestChild1.fxml"), null)
  //loader2.load()

  ///val ctrlC = loader2.getController[ChildControllerIntf]()
  //ctrlC.initialize()

  //val scene2 = loader2.getRoot[jfxs.Parent]

 // wait(1000)

  //println("dupa")


  //stage.setFullScreen(true)
  //stage.scene.fi fill(Color.Transparent)

}
