package dev.trindadedev.tinyinstaller.data.app.model.exception

class InstallFailedDexoptException : Exception {
    constructor() : super()

    constructor(message: String?) : super(message)
}