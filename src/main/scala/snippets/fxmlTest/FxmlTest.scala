package snippets.fxmlTest


import java.net.URL

import scalafx.application.JFXApp
import scalafx.Includes._
import scalafx.scene.Scene
import scala.reflect.runtime.universe.typeOf
import scalafxml.core.{FXMLView, DependenciesByType}


/**
 * Created by adrian on 3/7/2015.
 */


object FxmlTest extends JFXApp {

  val res =  getClass.getResource("startscreen.fxml")

  val root = FXMLView(res,
    new DependenciesByType(Map(
      typeOf[TestDependency] -> new TestDependency("hello world"))))

  stage = new JFXApp.PrimaryStage() {
    title = "Hello world"
    scene = new Scene(root)

  }

}
