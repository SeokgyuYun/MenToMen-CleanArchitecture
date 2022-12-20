package kr.hs.dgsw.b1nd.domain.usecase

import kotlinx.coroutines.flow.Flow
import kr.hs.dgsw.b1nd.domain.repository.FileRepository
import kr.hs.dgsw.b1nd.domain.request.ImgUrl
import okhttp3.MultipartBody
import javax.inject.Inject

class GetImageUrlUseCase @Inject constructor(
    private val fileRepository: FileRepository
) {
    operator fun invoke(imageFile: List<MultipartBody.Part?>): Flow<List<ImgUrl?>> =
        fileRepository.getImageUrl(imageFile)
}