package net.ulteum.quantummillionaire.service

import com.typesafe.scalalogging.LazyLogging
import net.ulteum.quantummillionaire.model.NumberGroup

import scala.annotation.tailrec

class RandomService(randomFunction: Int => Seq[Int]) extends LazyLogging {

  /**
   * generate a sequence of random numbers for a [[NumberGroup]] using the random generator
   * @param numberGroup representation of size and count of numbers
   */
  def generateNumberSequence(numberGroup: NumberGroup): Seq[Int] = {
    val result = shuffle(1 to numberGroup.size, randomFunction(numberGroup.size))
      .take(numberGroup.count)
    if (numberGroup.isFullList) result else result.sorted
  }

  /**
   * perform a fisher-yates shuffle on a sequence of Ints
   * @param values sequence to shuffle
   * @return
   */
  @tailrec
  final def shuffle(values: Seq[Int], randoms: Seq[Int], index: Int = 0): Seq[Int] = {
    val n = values.size
    if (index == n - 1) values
    else shuffle(swap(values, index, index + (randoms(index) % (n - index))), randoms, index + 1)
  }

  @tailrec
  final def swap(seq: Seq[Int], i: Int, j: Int): Seq[Int] = {
    if (i == j) seq
    else if (j < i) swap(seq, j, i)
    else seq.take(i) ++ Seq(seq(j)) ++ seq.slice(i + 1, j) ++ Seq(seq(i)) ++ seq.drop(j + 1)
  }

}
