package son.ysy.useful.dependencies.model

import com.squareup.moshi.JsonClass

import com.squareup.moshi.Json


@JsonClass(generateAdapter = true)
data class DependencyConfig(
    @Json(name = "title")
    val title: String,
    @Json(name = "version")
    val version: String?,
    @Json(name = "link")
    val link: String?,
    @Json(name = "group")
    val group: String?,
    @Json(name = "artifact")
    val name: String?,
    @Json(name = "remark")
    val remark: String?,
    @Json(name = "modules")
    val modules: List<DependencyConfig>?,
    @Json(name = "action")
    val action: String?
) : SortContent {
    override fun getSortContent(): String {
        return title
    }
}