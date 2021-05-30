package de.htwg.se.ConnectFour.aUI.states.TUI

import de.htwg.se.ConnectFour.aUI.states.TUI
import de.htwg.se.ConnectFour.controller.Controller
import de.htwg.se.ConnectFour.model.Grid
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class GameStateSpec extends AnyWordSpec with Matchers{
  "An initial state" when {
    val controller = new Controller(new Grid)
    val gameState = GameState(controller)
    controller.addPlayer("Franz")
    controller.addPlayer("Jens")
    "initialised" should {
      "be able to change its state" in {
        gameState.changeState(TUI.WinState(controller))
        gameState.state should be (WinState(controller))
      }

    }
  }
}
