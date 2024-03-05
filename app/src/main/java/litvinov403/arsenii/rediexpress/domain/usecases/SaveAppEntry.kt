package litvinov403.arsenii.rediexpress.domain.usecases

import litvinov403.arsenii.rediexpress.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke() {
        localUserManager.saveAppEntry()
    }
}