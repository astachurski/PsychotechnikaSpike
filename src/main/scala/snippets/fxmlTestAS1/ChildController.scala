package snippets.fxmlTestAS1

import java.net.URL
import java.util.ResourceBundle
import javafx.fxml
import javafx.scene.control
import javafx.scene.layout.BorderPane
import scalafx.scene.layout.Pane
import scalafxml.core.macros.sfxml
import javafx.scene.{control => jfxsc}
import javafx.scene.{layout => jfxsl}
import javafx.{event => jfxe}
import javafx.{fxml => jfxf}



/*
trait ChildControllerIntf {
  def initialize(): Unit

}
*/


class ChildController extends jfxf.Initializable {

  @jfxf.FXML
  private var btnDupa: jfxsc.Button = _

  @jfxf.FXML
  private var paneContents: jfxsl.BorderPane = _

  override def initialize(location: URL, resources: ResourceBundle): Unit = {
    //paneContents = new BorderPane()

  }
}

