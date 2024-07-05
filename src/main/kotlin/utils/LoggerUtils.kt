package utils

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.reflect.KClass

object LoggerUtils {
    inline fun <reified T> T.getLogger(): Logger {
        return LoggerFactory.getLogger(T::class.java)
    }

    inline fun <reified T : Any> getLogger(clazz: KClass<T>): Logger {
        return LoggerFactory.getLogger(clazz.java)
    }
}
