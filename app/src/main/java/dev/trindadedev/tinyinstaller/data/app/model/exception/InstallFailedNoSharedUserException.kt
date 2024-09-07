package dev.trindadedev.tinyinstaller.data.app.model.exception

class InstallFailedNoSharedUserException : Exception {
    constructor() : super()

    constructor(message: String?) : super(message)
}