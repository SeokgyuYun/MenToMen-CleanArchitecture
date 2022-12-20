package kr.hs.dgsw.b1nd.mentomen.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.b1nd.domain.repository.*
import kr.hs.dgsw.b1nd.domain.usecase.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideDAuthLoginUseCase(loginRepository: LoginRepository): DAuthLoginUseCase =
        DAuthLoginUseCase(loginRepository)

    @Provides
    @Singleton
    fun provideLoginUseCase(loginRepository: LoginRepository): LoginUseCase =
        LoginUseCase(loginRepository)

    @Provides
    @Singleton
    fun provideGetPostUseCase(postRepository: PostRepository): GetPostUseCase =
        GetPostUseCase(postRepository)

    @Provides
    @Singleton
    fun provideGetUserInfoUseCase(userRepository: UserRepository): GetUserInfoUseCase =
        GetUserInfoUseCase(userRepository)

    @Provides
    @Singleton
    fun provideGetUserPostUseCase(userRepository: UserRepository): GetUserPostUseCase =
        GetUserPostUseCase(userRepository)

    @Provides
    @Singleton
    fun provideGetCommentUseCase(commentRepository: CommentRepository): GetCommentUseCase =
        GetCommentUseCase(commentRepository)

    @Provides
    @Singleton
    fun provideSubmitCommentUseCase(commentRepository: CommentRepository): SubmitCommentUseCase =
        SubmitCommentUseCase(commentRepository)

    @Provides
    @Singleton
    fun provideDeleteCommentUseCase(commentRepository: CommentRepository): DeleteCommentUseCase =
        DeleteCommentUseCase(commentRepository)

    @Provides
    @Singleton
    fun provideGetImageUrlUseCase(fileRepository: FileRepository): GetImageUrlUseCase =
        GetImageUrlUseCase(fileRepository)
}