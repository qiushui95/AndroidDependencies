package son.ysy.useful.dependencies

/**
 * 编译版本配置
 */
sealed class BuildVersion<T>(var value: T) {

    /**
     * 自定义版本
     */
    fun custom(value: T): T {
        this.value = value
        return value
    }

    /**
     * SDK编译版本
     */
    object CompileSdk : BuildVersion<Int>(30)

    /**
     * 最小支持的SDK版本
     */
    object MinSdk : BuildVersion<Int>(21)

    /**
     * 当前适配SDK版本
     */
    object TargetSdk : BuildVersion<Int>(30)

    /**
     * SDK编译工具版本
     */
    object BuildTools : BuildVersion<String>("30.0.3")

    /**
     * ndk版本
     */
    object Ndk:BuildVersion<String>("22.1.7171670")
}