package kr.hs.dgsw.b1nd.mentomen.view.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import kr.hs.dgsw.b1nd.domain.model.Comment
import kr.hs.dgsw.b1nd.domain.model.Post
import kr.hs.dgsw.b1nd.domain.model.User
import kr.hs.dgsw.b1nd.domain.request.CommentSubmitRequest
import kr.hs.dgsw.b1nd.domain.usecase.*
import kr.hs.dgsw.b1nd.mentomen.base.BaseViewModel
import kr.hs.dgsw.b1nd.mentomen.widget.util.MutableEventFlow
import kr.hs.dgsw.b1nd.mentomen.widget.util.SingleLiveEvent
import kr.hs.dgsw.b1nd.mentomen.widget.util.asEventFlow
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getPostByPostIdUseCase: GetPostByPostIdUseCase,
    private val getUserInfoUseCase: GetUserInfoUseCase,
    private val deletePostUseCase: DeletePostUseCase,
    private val getCommentUseCase: GetCommentUseCase,
    private val submitCommentUseCase: SubmitCommentUseCase,
    private val deleteCommentUseCase: DeleteCommentUseCase,
) : BaseViewModel() {

    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEventFlow()

    fun getPostByPostId(postId: Int) = viewModelScope.launch {
        getPostByPostIdUseCase(postId)
            .catch { e -> _errorMsg.value = e.message }
            .collect { post ->
                _eventFlow.emit(Event.GetPostEvent(post))
            }
    }

    fun getUserInfo() = viewModelScope.launch {
        getUserInfoUseCase()
            .catch { e -> _errorMsg.value = e.message }
            .collect { userInfo ->
                _eventFlow.emit(Event.GetUserEvent(userInfo))
            }
    }

    fun deletePost(postId: Int) = viewModelScope.launch {
        deletePostUseCase(postId)
            .catch { e -> _errorMsg.value = e.message }
            .collect {
                _eventFlow.emit(Event.DeletePostEvent(Unit))
            }
    }

    fun getComment(postId: Int) = viewModelScope.launch {
        getCommentUseCase(postId)
            .catch { e -> _errorMsg.value = e.message }
            .collect { comment ->
                _eventFlow.emit(Event.GetCommentEvent(comment))
            }
    }

    fun submitComment(content: String, postId: Int) = viewModelScope.launch {
        submitCommentUseCase(
            CommentSubmitRequest(
                content,
                postId
            )
        ).catch { e -> _errorMsg.value = e.message }
            .collect {
                _eventFlow.emit(Event.SubmitCommentEvent(Unit))
            }
    }

    fun deleteComment(id: Int) = viewModelScope.launch {
        deleteCommentUseCase(id)
            .catch { e -> _errorMsg.value = e.message }
            .collect {
                _eventFlow.emit(Event.DeleteCommentEvent(Unit))
            }
    }

    sealed class Event {
        data class GetPostEvent(val post: Post): Event()
        data class GetCommentEvent(val commentList: List<Comment>): Event()
        data class GetUserEvent(val userInfo: User): Event()
        data class SubmitCommentEvent(val event: Unit): Event()
        data class DeletePostEvent(val event: Unit): Event()
        data class DeleteCommentEvent(val event: Unit): Event()
    }
}