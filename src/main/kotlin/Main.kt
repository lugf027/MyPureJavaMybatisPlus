import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import config.MyConfig
import db.entity.ImageV3
import db.entity.ImageV3Mapper
import db.extension.get

fun main() {
    val keySQLUserName = MyConfig.getConfig(MyConfig.KEY_SQL_USER_NAME)
    println("keySQLUserName $keySQLUserName")

    val imageMapper = ImageV3Mapper::class.get()
    val list = imageMapper.selectList(
        QueryWrapper<ImageV3>().lambda()
    )
    println("listCnt ${list.size}")
}
