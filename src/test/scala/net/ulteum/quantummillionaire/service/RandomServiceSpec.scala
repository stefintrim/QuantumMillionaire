package net.ulteum.quantummillionaire.service

import com.typesafe.scalalogging.LazyLogging
import org.scalatest._
import flatspec._
import matchers._

class RandomServiceSpec extends AnyFlatSpec with should.Matchers with LazyLogging {

  val randomServiceNoSwaps = new RandomService(n => (1 to n).reverse)

  behavior of "the swap function"

  it should "swap two values" in {
    val numbers = 1 to 5
    randomServiceNoSwaps.swap(numbers, 0, 1) shouldBe Seq(2, 1, 3, 4, 5)
    randomServiceNoSwaps.swap(numbers, 0, 4) shouldBe Seq(5, 2, 3, 4, 1)
  }

  behavior of "the shuffle function"

  it should "correctly shuffle a seq" in {
    randomServiceNoSwaps.shuffle(1 to 10, Seq(0,0,0,0,0,0,0,0,0,0)) shouldBe (1 to 10)
    randomServiceNoSwaps.shuffle(1 to 10, Seq(1,1,1,1,1,1,1,1,1,1)) shouldBe ((2 to 10) ++ Seq(1))
    randomServiceNoSwaps.shuffle(1 to 10, (1 to 10).reverse) shouldBe (1 to 10)

  }

  behavior of "RandomService with no swaps"

  it should "" in {

  }


}
