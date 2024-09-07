package dev.trindadedev.tinyinstaller.data.app.model.exception

class InstallFailedVersionDowngradeException : Exception {
    constructor() : super()

    constructor(message: String?) : super(message)
}