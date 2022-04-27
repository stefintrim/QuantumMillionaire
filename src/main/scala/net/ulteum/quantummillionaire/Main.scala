package net.ulteum.quantummillionaire

import cats.effect.{IO, IOApp}

object Main extends IOApp.Simple {
  def run:IO[Unit] = QuantumMillionaireServer.run
}
