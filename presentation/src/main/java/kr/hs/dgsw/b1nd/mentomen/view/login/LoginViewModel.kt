package kr.hs.dgsw.b1nd.mentomen.view.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kr.hs.dgsw.b1nd.data.util.PreferenceManager.Companion.CLIENT_ID
import kr.hs.dgsw.b1nd.data.util.PreferenceManager.Companion.REDIRECT_URL
import kr.hs.dgsw.b1nd.domain.request.DAuthLoginRequest
import kr.hs.dgsw.b1nd.domain.request.LoginRequest
import kr.hs.dgsw.b1nd.domain.usecase.DAuthLoginUseCase
import kr.hs.dgsw.b1nd.domain.usecase.LoginUseCase
import kr.hs.dgsw.b1nd.mentomen.base.BaseViewModel
import kr.hs.dgsw.b1nd.mentomen.widget.extension.MenToMenApplication
import kr.hs.dgsw.b1nd.mentomen.widget.util.EventFlow
import kr.hs.dgsw.b1nd.mentomen.widget.util.MutableEventFlow
import kr.hs.dgsw.b1nd.mentomen.widget.util.SingleLiveEvent
import kr.hs.dgsw.b1nd.mentomen.widget.util.asEventFlow
import java.security.MessageDigest
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val dAuthLoginUseCase: DAuthLoginUseCase,
    private val loginUseCase: LoginUseCase,
) : BaseViewModel() {

    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEventFlow()

    fun dAuthLogin(id: String, pw: String) = viewModelScope.launch {
        dAuthLoginUseCase(
            DAuthLoginRequest(
                id,
                encryptSHA512(pw),
                CLIENT_ID,
                REDIRECT_URL
            )
        ).catch { e -> _errorMsg.value = e.message }
            .collect { dAuthLogin ->
                _eventFlow.emit(Event.Location(dAuthLogin.location.split("=", "&")[1]))
            }
    }


    fun login(location: String) = viewModelScope.launch {
        loginUseCase(
            LoginRequest(
                location
            )
        ).catch { e -> _errorMsg.value = e.message }
            .collect { login ->
                MenToMenApplication.prefs.accessToken = login.accessToken
                MenToMenApplication.prefs.refreshToken = login.refreshToken
                _eventFlow.emit(Event.LoginSuccessEvent(Unit))
            }
    }

    private fun encryptSHA512(target: String): String {
        val messageDigest =
            MessageDigest.getInstance("SHA-512")
        val encryptedPassword = StringBuilder()
        messageDigest.update(target.toByteArray())
        val buffer = messageDigest.digest()
        for (temp in buffer) {
            var sb =
                StringBuilder(Integer.toHexString(temp.toInt()))
            while (sb.length < 2) {
                sb.insert(0, "0")
            }
            sb = StringBuilder(sb.substring(sb.length - 2))
            encryptedPassword.append(sb)
        }
        return encryptedPassword.toString()
    }

    sealed class Event {
        data class Location(val location: String) : Event()
        data class LoginSuccessEvent(val event: Unit): Event()
    }
}