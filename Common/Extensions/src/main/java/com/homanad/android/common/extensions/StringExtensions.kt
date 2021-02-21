package com.homanad.android.common.extensions

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun String.toDate(formatPattern: String, locale: Locale): Date? {
    val dateFormatter = SimpleDateFormat(formatPattern, locale)
    return try {
        dateFormatter.parse(this)
    } catch (e: ParseException) {
        null
    }
}