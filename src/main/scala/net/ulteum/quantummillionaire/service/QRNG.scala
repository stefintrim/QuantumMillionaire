package net.ulteum.quantummillionaire.service
import cats.effect._
import org.http4s._
import org.http4s.client._
import org.http4s.circe._
import io.circe.generic.auto._
import cats.effect.unsafe.IORuntime

final case class QrngResponse(data: Seq[Int])

object QRNG {
  implicit val qrngResponseEntityDecoder: EntityDecoder[IO, QrngResponse] = jsonOf[IO, QrngResponse]
  implicit val runtime: IORuntime = cats.effect.unsafe.IORuntime.global

  private val httpClient: Client[IO] = JavaNetClientBuilder[IO].create
  private def request(n: Int) = httpClient.expect[QrngResponse](s"https://qrng.anu.edu.au/API/jsonI.php?length=$n&type=uint8&size=1")

  def f: Int => Seq[Int] = n => request(n).unsafeRunSync().data.take(n)

}
