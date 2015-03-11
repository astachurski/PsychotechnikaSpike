package psychoGui

/**
 * Created by adrian on 3/9/2015.
 */

trait ControlledScreen {

  //This method will allow the injection of the Parent ScreenPane
  def setScreenParent(screenPage: ScreensController)

}
