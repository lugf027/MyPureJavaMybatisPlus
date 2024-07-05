package config

import io.github.cdimascio.dotenv.Dotenv

object MyConfig {
    const val KEY_SQL_URL = "SQL_URL"
    const val KEY_SQL_USER_NAME = "SQL_USER_NAME"
    const val KEY_SQL_PASSWORD = "SQL_PASSWORD"
    private val mDotenv by lazy { Dotenv.load() }

    fun getConfig(key: String): String = mDotenv.get(key, "")
}