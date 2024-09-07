package dev.trindadedev.tinyinstaller.data.app.model.exception

class InstallFailedInsufficientStorageException : Exception {
    constructor() : super()

    constructor(message: String?) : super(message)
}