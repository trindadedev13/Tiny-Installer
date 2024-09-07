package dev.trindadedev.tinyinstaller.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

import dev.trindadedev.tinyinstaller.R
import dev.trindadedev.tinyinstaller.data.app.model.exception.InstallFailedAlreadyExistsException
import dev.trindadedev.tinyinstaller.data.app.model.exception.InstallFailedConflictingProviderException
import dev.trindadedev.tinyinstaller.data.app.model.exception.InstallFailedContainerErrorException
import dev.trindadedev.tinyinstaller.data.app.model.exception.InstallFailedCpuAbiIncompatibleException
import dev.trindadedev.tinyinstaller.data.app.model.exception.InstallFailedDexoptException
import dev.trindadedev.tinyinstaller.data.app.model.exception.InstallFailedDuplicatePackageException
import dev.trindadedev.tinyinstaller.data.app.model.exception.InstallFailedInsufficientStorageException
import dev.trindadedev.tinyinstaller.data.app.model.exception.InstallFailedInvalidAPKException
import dev.trindadedev.tinyinstaller.data.app.model.exception.InstallFailedInvalidInstallLocationException
import dev.trindadedev.tinyinstaller.data.app.model.exception.InstallFailedInvalidURIException
import dev.trindadedev.tinyinstaller.data.app.model.exception.InstallFailedMediaUnavailableException
import dev.trindadedev.tinyinstaller.data.app.model.exception.InstallFailedMissingFeatureException
import dev.trindadedev.tinyinstaller.data.app.model.exception.InstallFailedMissingSharedLibraryException
import dev.trindadedev.tinyinstaller.data.app.model.exception.InstallFailedNewerSDKException
import dev.trindadedev.tinyinstaller.data.app.model.exception.InstallFailedNoSharedUserException
import dev.trindadedev.tinyinstaller.data.app.model.exception.InstallFailedOlderSdkException
import dev.trindadedev.tinyinstaller.data.app.model.exception.InstallFailedPackageChangedException
import dev.trindadedev.tinyinstaller.data.app.model.exception.InstallFailedReplaceCouldntDeleteException
import dev.trindadedev.tinyinstaller.data.app.model.exception.InstallFailedSharedUserIncompatibleException
import dev.trindadedev.tinyinstaller.data.app.model.exception.InstallFailedTestOnlyException
import dev.trindadedev.tinyinstaller.data.app.model.exception.InstallFailedUidChangedException
import dev.trindadedev.tinyinstaller.data.app.model.exception.InstallFailedUpdateIncompatibleException
import dev.trindadedev.tinyinstaller.data.app.model.exception.InstallFailedVerificationFailureException
import dev.trindadedev.tinyinstaller.data.app.model.exception.InstallFailedVerificationTimeoutException
import dev.trindadedev.tinyinstaller.data.app.model.exception.InstallFailedVersionDowngradeException
import dev.trindadedev.tinyinstaller.data.recycle.model.exception.AppProcessNotWorkException
import dev.trindadedev.tinyinstaller.data.recycle.model.exception.DhizukuNotWorkException
import dev.trindadedev.tinyinstaller.data.recycle.model.exception.RootNotWorkException
import dev.trindadedev.tinyinstaller.data.recycle.model.exception.ShizukuNotWorkException

@Composable
fun Throwable.help(): String {
    return when (this) {
        is InstallFailedAlreadyExistsException -> stringResource(R.string.exception_install_failed_already_exists)
        is InstallFailedInvalidAPKException -> stringResource(R.string.exception_install_failed_invalid_apk)
        is InstallFailedInvalidURIException -> stringResource(R.string.exception_install_failed_invalid_uri)
        is InstallFailedInsufficientStorageException -> stringResource(R.string.exception_install_failed_insufficient_storage)
        is InstallFailedDuplicatePackageException -> stringResource(R.string.exception_install_failed_duplicate_package)
        is InstallFailedNoSharedUserException -> stringResource(R.string.exception_install_failed_no_shared_user)
        is InstallFailedUpdateIncompatibleException -> stringResource(R.string.exception_install_failed_update_incompatible)
        is InstallFailedSharedUserIncompatibleException -> stringResource(R.string.exception_install_failed_shared_user_incompatible)
        is InstallFailedMissingSharedLibraryException -> stringResource(R.string.exception_install_failed_missing_shared_library)
        is InstallFailedReplaceCouldntDeleteException -> stringResource(R.string.exception_install_failed_replace_couldnt_delete)
        is InstallFailedDexoptException -> stringResource(R.string.exception_install_failed_dexopt)
        is InstallFailedOlderSdkException -> stringResource(R.string.exception_install_failed_older_sdk)
        is InstallFailedConflictingProviderException -> stringResource(R.string.exception_install_failed_conflicting_provider)
        is InstallFailedNewerSDKException -> stringResource(R.string.exception_install_failed_newer_sdk)
        is InstallFailedTestOnlyException -> stringResource(R.string.exception_install_failed_test_only)
        is InstallFailedCpuAbiIncompatibleException -> stringResource(R.string.exception_install_failed_cpu_abi_incompatible)
        is InstallFailedMissingFeatureException -> stringResource(R.string.exception_install_failed_missing_feature)
        is InstallFailedContainerErrorException -> stringResource(R.string.exception_install_failed_container_error)
        is InstallFailedInvalidInstallLocationException -> stringResource(R.string.exception_install_failed_invalid_install_location)
        is InstallFailedMediaUnavailableException -> stringResource(R.string.exception_install_failed_media_unavailable)
        is InstallFailedVerificationTimeoutException -> stringResource(R.string.exception_install_failed_verification_timeout)
        is InstallFailedVerificationFailureException -> stringResource(R.string.exception_install_failed_verification_failure)
        is InstallFailedPackageChangedException -> stringResource(R.string.exception_install_failed_package_changed)
        is InstallFailedUidChangedException -> stringResource(R.string.exception_install_failed_uid_changed)
        is InstallFailedVersionDowngradeException -> stringResource(R.string.exception_install_failed_version_downgrade)

        is ShizukuNotWorkException -> stringResource(R.string.exception_shizuku_not_work)
        is DhizukuNotWorkException -> stringResource(R.string.exception_dhizuku_not_work)
        is RootNotWorkException -> stringResource(R.string.exception_root_not_work)
        is AppProcessNotWorkException -> stringResource(R.string.exception_app_process_not_work)
        else -> stringResource(R.string.exception_install_failed_unknown)
    }
}