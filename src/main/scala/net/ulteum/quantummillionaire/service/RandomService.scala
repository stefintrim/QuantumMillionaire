package net.ulteum.quantummillionaire.service

import cats.effect.IO
import com.typesafe.scalalogging.LazyLogging
import net.ulteum.quantummillionaire.model.NumberGroup

import scala.annotation.tailrec

class RandomService(randomFunction: Int => IO[Seq[Double]]) extends LazyLogging {

  /**
   * generate a sequence of random numbers for a [[NumberGroup]] using the random generator
   * @param numberGroup representation of size and count of numbers
   */
  def generateNumberSequence(numberGroup: NumberGroup): IO[Seq[Int]] = {
    randomFunction(numberGroup.size).map(rands => {
      val result = shuffle(1 to numberGroup.size, rands)
        .take(numberGroup.count)
      result
    })
  }

  /**
   * perform a fisher-yates shuffle on a sequence of Ints
   * @param values sequence to shuffle
   * @return
   */
  @tailrec
  final def shuffle(values: Seq[Int], randoms: Seq[Double], index: Int = 0): Seq[Int] = {
    val n = values.size
    if (index == n - 1) values
    else shuffle(swap(values, index, index + (randoms(index) * (n - index)).toInt), randoms, index + 1)
  }

  @tailrec
  final def swap(seq: Seq[Int], i: Int, j: Int): Seq[Int] = {
    if (i == j) seq
    else if (j < i) swap(seq, j, i)
    else seq.take(i) ++ Seq(seq(j)) ++ seq.slice(i + 1, j) ++ Seq(seq(i)) ++ seq.drop(j + 1)
  }

}
