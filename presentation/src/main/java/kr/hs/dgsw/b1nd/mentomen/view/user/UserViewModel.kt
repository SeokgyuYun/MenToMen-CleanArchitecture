package kr.hs.dgsw.b1nd.mentomen.view.user

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import kr.hs.dgsw.b1nd.domain.model.Post
import kr.hs.dgsw.b1nd.domain.model.StdInfo
import kr.hs.dgsw.b1nd.domain.model.User
import kr.hs.dgsw.b1nd.domain.usecase.GetUserInfoUseCase
import kr.hs.dgsw.b1nd.domain.usecase.GetUserPostUseCase
import kr.hs.dgsw.b1nd.mentomen.base.BaseViewModel
import kr.hs.dgsw.b1nd.mentomen.widget.util.MutableEventFlow
import kr.hs.dgsw.b1nd.mentomen.widget.util.asEventFlow
import javax.inject.Inject
import kotlin.math.log

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUserInfoUseCase: GetUserInfoUseCase,
    private val getUserPostUseCase: GetUserPostUseCase
): BaseViewModel() {

    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEventFlow()

    fun getUserInfo() = viewModelScope.launch {
        getUserInfoUseCase()
            .catch { e -> _errorMsg.value = e.message }
            .collect { userInfo ->
                _eventFlow.emit(Event.GetUserEvent(userInfo))
            }
    }

    fun getUserPost() = viewModelScope.launch {
        getUserPostUseCase()
            .catch { e -> _errorMsg.value = e.message }
            .collect { postList ->
                _eventFlow.emit(Event.GetPostEvent(postList))
            }
    }

    sealed class Event {
        data class GetUserEvent(val user: User): Event()
        data class GetPostEvent(val postList: List<Post>): Event()
    }
}