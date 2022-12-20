package kr.hs.dgsw.b1nd.mentomen.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.b1nd.data.datasource.*
import kr.hs.dgsw.b1nd.data.repository.*
import kr.hs.dgsw.b1nd.data.service.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideDAuthDataSource(loginService: DAuthLoginService): DAuthLoginDataSource =
        DAuthLoginDataSourceImpl(loginService)

    @Provides
    @Singleton
    fun provideLoginDataSource(loginService: LoginService): LoginDataSource =
        LoginDataSourceImpl(loginService)

    @Provides
    @Singleton
    fun providePostDataSource(postService: PostService): PostDataSource =
        PostDataSourceImpl(postService)

    @Provides
    @Singleton
    fun provideUserDataSource(userService: UserService): UserDataSource =
        UserDataSourceImpl(userService)

    @Provides
    @Singleton
    fun provideCommentDataSource(commentService: CommentService): CommentDataSource =
        CommentDataSourceImpl(commentService)

    @Provides
    @Singleton
    fun provideFileDataSource(fileService: FileService): FileDataSource =
        FileDataSourceImpl(fileService)
}