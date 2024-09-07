package dev.trindadedev.tinyinstaller;

import dev.trindadedev.tinyinstaller.IPrivilegedService;

interface IShizukuUserService {
    void destroy() = 16777114;

    IPrivilegedService getPrivilegedService() = 1;
}
