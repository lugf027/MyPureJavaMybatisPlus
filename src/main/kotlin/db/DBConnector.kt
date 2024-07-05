package db

import com.baomidou.mybatisplus.core.MybatisConfiguration
import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder
import config.MyConfig
import db.entity.ImageV3Mapper
import org.apache.ibatis.datasource.pooled.PooledDataSource
import org.apache.ibatis.logging.stdout.StdOutImpl
import org.apache.ibatis.mapping.Environment
import org.apache.ibatis.session.SqlSessionFactory
import org.apache.ibatis.transaction.TransactionFactory
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory
import utils.LoggerUtils
import javax.sql.DataSource

/**
 * 使用MyBatisPlus连接数据库
 * 参考：https://github.com/baomidou/mybatis-plus-samples/tree/master/mybatis-plus-sample-no-spring
 */
object DBConnector {
    private val logger = LoggerUtils.getLogger(DBConnector::class)
    private val dataSource by lazy { createDataSource() }
    private val selSessionFactory by lazy { createSqlSessionFactory() }
    private val sqlSession by lazy { selSessionFactory.openSession(true) }
    private val mapperList = listOf(
        ImageV3Mapper::class.java,
    )

    fun <T> getMapper(type: Class<T>): T {
        logger.info("getMapper type:$type")
        return sqlSession.getMapper(type)
    }

    private fun createSqlSessionFactory(): SqlSessionFactory {
        val transactionFactory: TransactionFactory = JdbcTransactionFactory()
        val environment = Environment(DBConnector::class.java.name, transactionFactory, dataSource)
        val configuration = MybatisConfiguration(environment)
        mapperList.forEach { configuration.addMapper(it) }
        configuration.logImpl = StdOutImpl::class.java
        return MybatisSqlSessionFactoryBuilder().build(configuration)
    }

    private fun createDataSource(): DataSource {
        val dataSource = PooledDataSource()
        dataSource.driver = net.sf.log4jdbc.DriverSpy::class.java.name
        dataSource.url = MyConfig.getConfig(MyConfig.KEY_SQL_URL)
        dataSource.username = MyConfig.getConfig(MyConfig.KEY_SQL_USER_NAME)
        dataSource.password = MyConfig.getConfig(MyConfig.KEY_SQL_PASSWORD)
        return dataSource
    }
}
