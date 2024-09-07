package dev.trindadedev.tinyinstaller.data.recycle.repo.recyclable

import dev.trindadedev.tinyinstaller.IPrivilegedService

import java.io.Closeable

interface UserService : Closeable {
    val privileged: IPrivilegedService
}