package dev.trindadedev.tinyinstaller.data.app.model.exception

class InstallFailedUpdateIncompatibleException : Exception {
    constructor() : super()

    constructor(message: String?) : super(message)
}