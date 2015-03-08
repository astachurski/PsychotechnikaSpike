package snippets.fxmlTestAS1

import scalafx.application.JFXApp
import scalafx.Includes._
import scalafx.scene.Scene
import scala.reflect.runtime.universe.typeOf
import scalafx.scene.control.Button
import scalafx.scene.paint.Color
import scalafxml.core.{FXMLView, DependenciesByType}

case class MyService(){

  def printSth() = {
    println("from my service 1!!!")

  }


}

object MultiScreenTest extends JFXApp {

  val res =  getClass.getResource("multiScreenTest.fxml")

  val root = FXMLView(res,
    new DependenciesByType(Map(
      typeOf[MyService] -> new MyService())))

  stage = new JFXApp.PrimaryStage() {
    title = "Hello world"
    scene = new Scene(root){
      //fill = Color.Transparent
    }
  }

  val n = root.lookup("#btnBadania")

  if (n != null){
    n. asInstanceOf[javafx.scene.control.Button].text = "A pupu !"
  }


  //stage.setFullScreen(true)
  //stage.scene.fi fill(Color.Transparent)

}
