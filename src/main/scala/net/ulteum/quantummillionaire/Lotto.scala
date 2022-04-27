package net.ulteum.quantummillionaire

import cats.effect.IO
import cats.implicits._
import com.typesafe.scalalogging.LazyLogging
import io.circe.syntax.EncoderOps
import io.circe.{Encoder, Json}
import net.ulteum.quantummillionaire.model.NumberGroup
import net.ulteum.quantummillionaire.service.{QRNG, RandomService}
import org.http4s.EntityEncoder
import org.http4s.circe._

trait Lotto {
  def generate(vals: Seq[NumberGroup]): IO[Lotto.Response]
}

object Lotto extends LazyLogging {
  final case class Name(name: String) extends AnyVal
  final case class Response(nums: Seq[Int]) extends AnyVal
  val randomService = new RandomService(QRNG.f)
  object Response {
    implicit val lottoEncoder: Encoder[Response] = (resp: Response) => Json.obj(
      ("Your Numbers", resp.nums.asJson),
    )
    implicit val greetingEntityEncoder: EntityEncoder[IO, Response] =
      jsonEncoderOf[IO, Response]
  }

  def impl: Lotto = (vals: Seq[NumberGroup]) => {
    val resp = vals.flatMap(randomService.generateNumberSequence)
    Response(resp).pure[IO]
  }
}
