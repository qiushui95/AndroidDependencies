package son.ysy.useful.dependencies.model.group

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import son.ysy.useful.dependencies.model.SortContent


@JsonClass(generateAdapter = true)
data class GroupDependency(
    @Json(name = "name")
    val name: String,
    @Json(name = "version")
    val version: String,
    @Json(name = "link")
    val link: String?,
    @Json(name = "group")
    val group: String,
    @Json(name = "remark")
    val remark: String?,
    @Json(name = "modules")
    val modules: List<GroupChildModule>
) : SortContent {
    override fun getSortContent(): String = name
}