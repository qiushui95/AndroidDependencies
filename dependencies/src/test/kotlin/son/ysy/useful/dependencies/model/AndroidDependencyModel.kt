package son.ysy.useful.dependencies.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import son.ysy.useful.dependencies.model.group.GroupDependency
import son.ysy.useful.dependencies.model.single.SingleDependency


@JsonClass(generateAdapter = true)
data class AndroidDependencyModel(
    @Json(name = "version")
    val version: String,
    @Json(name = "single")
    val single: List<SingleDependency>,
    @Json(name = "group")
    val group: List<GroupDependency>,
    @Json(name = "view")
    val view: List<SingleDependency>,
    @Json(name = "test")
    val test: List<SingleDependency>
) {
    fun sorted() = copy(
        single = single.sortedBy { it.getSortContent() },
        group = group.sortedBy { it.getSortContent() },
        view = view.sortedBy { it.getSortContent() },
        test = test.sortedBy { it.getSortContent() },
    )
}