package dev.trindadedev.tinyinstaller.data.app.model.exception

class InstallFailedContainerErrorException : Exception {
    constructor() : super()

    constructor(message: String?) : super(message)
}