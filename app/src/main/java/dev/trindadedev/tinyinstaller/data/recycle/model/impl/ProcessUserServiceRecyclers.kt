package dev.trindadedev.tinyinstaller.data.recycle.model.impl

object ProcessUserServiceRecyclers {
    private val map =
        mutableMapOf<String, ProcessUserServiceRecycler>()

    fun get(shell: String): ProcessUserServiceRecycler {
        return map.getOrPut(shell) {
            ProcessUserServiceRecycler(shell)
        }
    }
}