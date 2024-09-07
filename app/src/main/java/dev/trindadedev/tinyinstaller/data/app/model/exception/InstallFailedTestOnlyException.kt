package dev.trindadedev.tinyinstaller.data.app.model.exception

class InstallFailedTestOnlyException : Exception {
    constructor() : super()

    constructor(message: String?) : super(message)
}