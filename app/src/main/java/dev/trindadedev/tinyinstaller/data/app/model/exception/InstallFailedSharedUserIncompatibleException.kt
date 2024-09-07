package dev.trindadedev.tinyinstaller.data.app.model.exception

class InstallFailedSharedUserIncompatibleException : Exception {
    constructor() : super()

    constructor(message: String?) : super(message)
}