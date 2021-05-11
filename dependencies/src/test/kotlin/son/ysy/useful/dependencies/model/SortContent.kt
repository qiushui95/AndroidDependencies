package son.ysy.useful.dependencies.model

interface SortContent : Comparable<SortContent> {
    fun getSortContent(): String

    override fun compareTo(other: SortContent): Int {
        return getSortContent().compareTo(other.getSortContent())
    }
}