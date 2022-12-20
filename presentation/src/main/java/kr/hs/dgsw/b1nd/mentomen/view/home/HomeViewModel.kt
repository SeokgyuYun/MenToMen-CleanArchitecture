package kr.hs.dgsw.b1nd.mentomen.view.home

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kr.hs.dgsw.b1nd.domain.model.Post
import kr.hs.dgsw.b1nd.domain.usecase.GetPostByTagUseCase
import kr.hs.dgsw.b1nd.domain.usecase.GetPostUseCase
import kr.hs.dgsw.b1nd.mentomen.base.BaseViewModel
import kr.hs.dgsw.b1nd.mentomen.widget.util.MutableEventFlow
import kr.hs.dgsw.b1nd.mentomen.widget.util.TagState
import kr.hs.dgsw.b1nd.mentomen.widget.util.asEventFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val postUseCase: GetPostUseCase,
    private val postByTagUseCase: GetPostByTagUseCase
) : BaseViewModel() {

    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEventFlow()

    fun getPost() = viewModelScope.launch {
        postUseCase(
        ).catch { e -> _errorMsg.value = e.message }
            .collect { postList -> _eventFlow.emit(Event.GetPostEvent(postList)) }
    }

    private fun getPostByTag(tag: String) =
        viewModelScope.launch {
            postByTagUseCase(tag)
                .catch { e -> _errorMsg.value = e.message }
                .collect { postList -> _eventFlow.emit(Event.GetPostEvent(postList)) }
        }

    fun onClickBtn(isTagChecked: Boolean, tag: String, isChecked: Boolean) =
        viewModelScope.launch(Dispatchers.Main) {
            if (isTagChecked && isChecked) {
                getPost()
                _eventFlow.emit(
                    Event.TagStateEvent(
                        TagState(
                            isDesignChecked = true,
                            isWebChecked = true,
                            isAndroidChecked = true,
                            isServerChecked = true,
                            isiOSChecked = true,
                            isChecked = false
                        )
                    )
                )
            } else if ((isTagChecked.not() && isChecked) || (isTagChecked)) {
                getPostByTag(tag)
                _eventFlow.emit(
                    Event.TagStateEvent(
                        TagState(
                            isDesignChecked = tag == "DESIGN",
                            isWebChecked = tag == "WEB",
                            isAndroidChecked = tag == "ANDROID",
                            isServerChecked = tag == "SERVER",
                            isiOSChecked = tag == "IOS",
                            isChecked = true
                        )
                    )
                )
            }
        }

    sealed class Event {
        data class GetPostEvent(val postList: List<Post>) : Event()
        data class TagStateEvent(
            val tagState: TagState = TagState(
                isDesignChecked = true,
                isWebChecked = true,
                isAndroidChecked = true,
                isServerChecked = true,
                isiOSChecked = true,
                isChecked = false
            )
        ) : Event()
    }

}