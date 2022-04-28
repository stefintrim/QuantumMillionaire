package net.ulteum.quantummillionaire

import net.ulteum.quantummillionaire.model.NumberGroup
import org.http4s._
import cats.effect._
import org.http4s.circe.CirceEntityCodec.circeEntityEncoder
import org.http4s.dsl.io._

object QuantumMillionaireRoutes {

  //TODO: tidy this up into a function and include error handling
  implicit val numberGroupQueryParamDecoder: QueryParamDecoder[Seq[NumberGroup]] = QueryParamDecoder[String].map(_.split(",").map(_.toInt)).map(_.sliding(2, 2)).map(_.toList).map(l => l.map(m => NumberGroup(m(0), m(1))))
  object numberGroupQueryParamMatcher extends QueryParamDecoderMatcher[Seq[NumberGroup]]("input")


  def lottoRoutes(H: Lotto): HttpRoutes[IO] = {
    HttpRoutes.of[IO] {
      case GET -> Root / "lotto" :? numberGroupQueryParamMatcher(input) =>
        for {
          vals <- H.generate(input)
          resp <- Ok(vals)
        } yield resp
    }
  }


}
