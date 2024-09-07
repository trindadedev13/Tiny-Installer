package dev.trindadedev.tinyinstaller.data.app.model.exception

class InstallFailedReplaceCouldntDeleteException : Exception {
    constructor() : super()

    constructor(message: String?) : super(message)
}