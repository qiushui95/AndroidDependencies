package son.ysy.useful.dependencies.model.group

import com.squareup.moshi.JsonClass

import com.squareup.moshi.Json
import son.ysy.useful.dependencies.model.SortContent


@JsonClass(generateAdapter = true)
data class GroupChildModule(
    @Json(name = "name")
    val name: String,
    @Json(name = "version")
    val version: String?,
    @Json(name = "link")
    val link: String?,
    @Json(name = "group")
    val group: String?,
    @Json(name = "remark")
    val remark: String?,
    @Json(name = "module")
    val module: String
) : SortContent {
    override fun getSortContent(): String = name

    val isCustomGroup = group?.isNotBlank() == true

    val isCustomVersion = group.isNullOrBlank() && version?.isNotBlank() == true
}