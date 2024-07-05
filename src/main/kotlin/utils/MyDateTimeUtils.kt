package utils

import java.text.SimpleDateFormat
import java.util.*

object MyDateTimeUtils {
    private const val FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss"
    private val sDateTimeFormatter = SimpleDateFormat(FORMAT_DATETIME)
    fun currentDateTime(): String = sDateTimeFormatter.format(Date())
    private const val FORMAT_DATE = "yyyy-MM-dd"
    private val sDateFormatter = SimpleDateFormat(FORMAT_DATE)
    fun currentDate(): String = sDateFormatter.format(Date())
}