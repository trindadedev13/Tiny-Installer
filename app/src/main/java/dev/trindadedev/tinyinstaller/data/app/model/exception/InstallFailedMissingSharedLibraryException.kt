package dev.trindadedev.tinyinstaller.data.app.model.exception

class InstallFailedMissingSharedLibraryException : Exception {
    constructor() : super()

    constructor(message: String?) : super(message)
}