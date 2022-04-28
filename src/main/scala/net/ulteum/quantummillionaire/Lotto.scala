package net.ulteum.quantummillionaire

import cats.effect.IO
import cats.effect.unsafe.implicits.global
import cats.implicits._
import com.typesafe.scalalogging.LazyLogging
import io.circe.syntax.EncoderOps
import io.circe.{Encoder, Json}
import net.ulteum.quantummillionaire.model.NumberGroup
import net.ulteum.quantummillionaire.service.{QRNG, RandomService}

trait Lotto {
  def generate(vals: Seq[NumberGroup]): IO[Lotto.Response]
}

object Lotto extends LazyLogging {
  final case class Response(nums: Seq[(Int, Seq[Int])])
  val randomService = new RandomService(QRNG.f)
  object Response {
    //TODO: build a nicer response
    implicit val lottoEncoder: Encoder[Response] = (resp: Response) =>
      Json.obj(
        ("Your Numbers:",
      Json.fromFields(resp.nums.map(t => (t._1.toString, t._2.asJson)))
        )
      )
  }

  def impl: Lotto = (vals: Seq[NumberGroup]) => {
    val resp = vals.map(randomService.generateNumberSequence).sequence
    resp.map(r => Response(r.zipWithIndex.map(t => (t._2, t._1))))
  }
}
