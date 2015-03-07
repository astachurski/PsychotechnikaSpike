package snippets.fxmlTestAS1

import scalafx.application.JFXApp
import scalafx.Includes._
import scalafx.scene.Scene
import scala.reflect.runtime.universe.typeOf
import scalafxml.core.{FXMLView, DependenciesByType}

case class TestDependency1()

object FxmlTestAS1 extends JFXApp {

  val res =  getClass.getResource("astest1.fxml")

  val root = FXMLView(res,
    new DependenciesByType(Map(
      typeOf[TestDependency1] -> new TestDependency1())))

  stage = new JFXApp.PrimaryStage() {
    title = "Hello world"
    scene = new Scene(root)

  }

}
