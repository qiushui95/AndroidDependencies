package son.ysy.useful.dependencies.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DependencyContainer(
    @Json(name = "single")
    val single: List<DependencyConfig>,
    @Json(name = "group")
    val group: List<DependencyConfig>,
    @Json(name = "view")
    val view: List<DependencyConfig>,
    @Json(name = "test")
    val test: List<DependencyConfig>,
) {

    fun sorted(): DependencyContainer {
        return DependencyContainer(
            single = single.sort(),
            group = group.sort(),
            view = view.sort(),
            test = test.sort(),
        )
    }

    private fun List<DependencyConfig>.sort(): List<DependencyConfig> {
        return map { config ->
            config.copy(modules = config.modules?.sort())
        }.sorted()
    }
}
