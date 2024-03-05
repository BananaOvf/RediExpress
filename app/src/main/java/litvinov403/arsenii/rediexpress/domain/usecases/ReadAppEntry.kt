package litvinov403.arsenii.rediexpress.domain.usecases

import kotlinx.coroutines.flow.Flow
import litvinov403.arsenii.rediexpress.domain.manager.LocalUserManager

class ReadAppEntry(
    private val localUserManager: LocalUserManager
) {
    operator fun invoke(): Flow<Boolean> {
        return localUserManager.readAppEntry()
    }
}