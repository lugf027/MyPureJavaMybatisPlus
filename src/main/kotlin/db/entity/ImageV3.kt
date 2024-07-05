package db.entity

import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import com.baomidou.mybatisplus.core.mapper.BaseMapper
import lombok.Data
import lombok.experimental.Accessors
import utils.MyDateTimeUtils
import java.util.UUID

@Data
@Accessors(chain = true)
@TableName(value = "image_v4")
/**
CREATE TABLE image_v3 (
id VARCHAR(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci PRIMARY KEY,
app_name VARCHAR(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
page_name VARCHAR(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
image_url VARCHAR(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
view_tree_ui_origin_url VARCHAR(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
view_tree_ui_json_url VARCHAR(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
view_tree_dumpsys_origin_url VARCHAR(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
view_tree_dumpsys_json_url VARCHAR(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
view_tree_merged_json_url VARCHAR(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
final_json_url VARCHAR(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
label_url VARCHAR(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
create_time VARCHAR(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
 */
data class ImageV3(
    @TableId
    var id: String = UUID.randomUUID().toString(),

    var appName: String = "",
    var pageName: String = "",

    var imageUrl: String = "",
    var viewTreeUiOriginUrl: String = "",
    var viewTreeUiJsonUrl: String = "",
    var viewTreeDumpsysOriginUrl: String = "",
    var viewTreeDumpsysJsonUrl: String = "",
    var viewTreeMergedJsonUrl: String = "",

    var layoutLabelUrl: String = "",
    var elementLabelUrl: String = "",

    var pageComment: String = "",
    var specialView: String = "",

    var createTime: String = MyDateTimeUtils.currentDateTime(),
) {
    data class SpecialViewData(
        val data: MutableMap<String, Int> = mutableMapOf()
    )
}

interface ImageV3Mapper : BaseMapper<ImageV3>

