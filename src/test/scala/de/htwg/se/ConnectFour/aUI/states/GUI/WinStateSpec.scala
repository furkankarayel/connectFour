package de.htwg.se.ConnectFour.aUI.states.GUI

import de.htwg.se.ConnectFour.aUI.states.TUI.{GameState, WinState}
import de.htwg.se.ConnectFour.controller.impl.ControllerImpl
import de.htwg.se.ConnectFour.model.player.impl.PlayerBuilderImpl
import de.htwg.se.ConnectFour.model.grid.impl.GridImpl
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class WinStateSpec extends AnyWordSpec with Matchers {
  "A Winstate" when {
    val controller = new ControllerImpl(new GridImpl,new PlayerBuilderImpl())
    val gameState = GameState(controller)
    gameState.changeState(WinState(controller))
    controller.addPlayer("Franz")
    controller.addPlayer("Jens")
    controller.currentPlayer = controller.players(0)
    "initialised" should {
      "be in drop state" in {
        gameState.state should be (WinState(controller))
      }
      "process input won" in {
        controller.currentPlayer = controller.players(0)
        gameState.handle("won")
        controller.currentPlayer = controller.players(1)
        gameState.handle("won")
      }
      "process invalid input" in {
        gameState.handle("asdasd")
        println("Nobody has won, try playing smarter next time.")
      }
      }

    }

}
