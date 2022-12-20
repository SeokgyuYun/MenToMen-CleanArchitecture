package kr.hs.dgsw.b1nd.mentomen.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.b1nd.data.datasource.*
import kr.hs.dgsw.b1nd.data.repository.*
import kr.hs.dgsw.b1nd.domain.repository.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideLoginRepository(loginDataSource: LoginDataSource, dAuthLoginDataSource: DAuthLoginDataSource): LoginRepository =
        LoginRepositoryImpl(loginDataSource, dAuthLoginDataSource)

    @Provides
    @Singleton
    fun providePostRepository(postDataSource: PostDataSource): PostRepository =
        PostRepositoryImpl(postDataSource)

    @Provides
    @Singleton
    fun provideUserRepository(userDataSource: UserDataSource): UserRepository =
        UserRepositoryImpl(userDataSource)

    @Provides
    fun provideCommentRepository(commentDataSource: CommentDataSource): CommentRepository =
        CommentRepositoryImpl(commentDataSource)

    @Provides
    fun provideFileRepository(fileDataSource: FileDataSource): FileRepository =
        FileRepositoryImpl(fileDataSource)
}