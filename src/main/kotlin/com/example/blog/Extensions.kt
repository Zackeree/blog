package com.example.blog

import java.time.LocalDateTime
import java.time.format.DateTimeFormatterBuilder
import java.time.temporal.ChronoField
import java.util.*

fun LocalDateTime.format() = this.format(englishDateFormatter)

/*
    Return the day of the month and add ordinal ending to the number
 */
private val daysLookup = (1..31).associate { it.toLong() to getOrdinal(it) }

/*
    Format our dates Year/Month/Day format
 */
private val englishDateFormatter = DateTimeFormatterBuilder()
        .appendPattern("yyyy-MM-dd")
        .appendLiteral(" ")
        .appendText(ChronoField.DAY_OF_MONTH, daysLookup)
        .appendLiteral(" ")
        .appendPattern("yyyy")
        .toFormatter(Locale.ENGLISH)

/*
    Append the end of ordinal numbering to our passed int
    In general, a number's last digits have patterns:
    1 ends in 'st', except in the case of 11
    2 ends in 'nd', except in the case of 12
    3 ends in 'rd', except in the case of 13
    otherwise, every other number [1..31] ends in 'th'
 */
private fun getOrdinal(n: Int) = when {
    n in 11..13 -> "${n}th"
    n % 10 == 1 -> "${n}st"
    n % 10 == 2 -> "${n}nd"
    n % 10 == 3 -> "${n}rd"
    else -> "${n}th"
}

fun String.toSlug() = toLowerCase()
        .replace("\n", " ")
        .replace("[^a-z\\d\\s]".toRegex(), " ")
        .split(" ")
        .joinToString("-")
        .replace("-+".toRegex(), "-")