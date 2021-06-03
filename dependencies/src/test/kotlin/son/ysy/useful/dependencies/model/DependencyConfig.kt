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
    val action: String?,
    @Json(name = "sort")
    val sort: Int?,
    @Json(name = "ignore")
    val ignore: Boolean?
) : Comparable<DependencyConfig> {


    val realIgnore = ignore ?: false

    val realSort = sort ?: 0

    override fun compareTo(other: DependencyConfig): Int {
        return if (realSort == other.realSort) {
            title.compareTo(other.title)
        } else {
            realSort.compareTo(other.realSort)
        }
    }
}