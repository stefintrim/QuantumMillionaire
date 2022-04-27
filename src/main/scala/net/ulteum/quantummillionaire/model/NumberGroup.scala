package net.ulteum.quantummillionaire.model

/**
 * a NumberGroup models a series of numbers in a lottery system
 * consider EuroMillions where you must pick 5 numbers from 1 to 50 and 2 numbers from 1 to 12
 * this is modeled as 2 number groups - NumberGroup(5, 50) and NumberGroup(2, 12)
 * @param count the count of numbers in the group
 * @param size the size of the group given as 1 to size inclusive [1, size]
 */
final case class NumberGroup(count: Int, size: Int)

