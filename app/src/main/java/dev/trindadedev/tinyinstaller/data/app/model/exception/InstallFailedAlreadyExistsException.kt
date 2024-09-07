package dev.trindadedev.tinyinstaller.data.app.model.exception

class InstallFailedAlreadyExistsException : Exception {
    constructor() : super()

    constructor(message: String?) : super(message)
}