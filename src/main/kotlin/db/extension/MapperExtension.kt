package db.extension

import db.DBConnector
import kotlin.reflect.KClass

inline fun <reified T: Any> KClass<T>.get(): T {
    return DBConnector.getMapper(this.java)
}
