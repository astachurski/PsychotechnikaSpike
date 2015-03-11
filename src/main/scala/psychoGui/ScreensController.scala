package psychoGui

import javafx.fxml.FXMLLoader
import javafx.scene.layout.StackPane
import javafx.scene.{Node, Parent}

import scala.collection.mutable

class ScreensController extends StackPane {

  private val screens = new mutable.HashMap[String, Node]()

  def addScreen(name: String, screen: Node): Unit = {
    screens.put(name, screen)
  }

  def loadScreen(name: String, resource: String): Unit = {

    /*todo: add error handling (throw an exception)*/

    val myLoader = new FXMLLoader(getClass.getResource(resource))
    val loadScreen: Parent = myLoader.load()
    val myScreenController = myLoader.getController.asInstanceOf[ControlledScreen]
    myScreenController.setScreenParent(this)
    addScreen(name, loadScreen)

  }

  def setScreen(name: String): Boolean = {

    if (screens.get(name) != null) {

      if (!getChildren.isEmpty) {
        getChildren.remove(0)
        getChildren.add(0, screens.get(name).get)
      }
      else
        getChildren.add(screens.get(name).get)

      println(s"screen $name loaded successfuly!")
      true
    }
    else {
      println("could not load screen!")
      false
    }

  }

  def unloadScreen(name: String): Boolean = {
    if (screens.remove(name) == null) {
      println("could not remove screen")
      false
    }
    else
      true

  }

}
