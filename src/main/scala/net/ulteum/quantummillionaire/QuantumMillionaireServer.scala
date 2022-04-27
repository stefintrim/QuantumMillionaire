package net.ulteum.quantummillionaire

import cats.effect.IO
import com.comcast.ip4s._
import org.http4s.ember.server.EmberServerBuilder
import org.http4s.implicits._
import org.http4s.server.middleware.Logger

object QuantumMillionaireServer {

  def run: IO[Nothing] = {
    val lottoAlg = Lotto.impl
    val httpApp = QuantumMillionaireRoutes.helloWorldRoutes(lottoAlg).orNotFound
    val finalHttpApp = Logger.httpApp(logHeaders = true, logBody = true)(httpApp)
    EmberServerBuilder.default[IO]
        .withHost(ipv4"0.0.0.0")
        .withPort(port"8080")
        .withHttpApp(finalHttpApp)
        .build
  }.useForever
}
