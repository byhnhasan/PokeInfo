package com.hsnbyhn.pokeinfo.di.module

/**
 * Created by hasanbayhan on 28.10.2020
 **/

/*@Module(includes = [OkHttpClientModule::class, ContextModule::class])
class PicassoModule {

    @Provides
    @ApplicationScope
    fun picasso(
        context: Application,
        okHttp3Downloader: OkHttp3Downloader
    ) = Picasso.Builder(context).downloader(okHttp3Downloader).build()

    @Provides
    fun okHttp3Downloader(okHttpClient: OkHttpClient) = OkHttp3Downloader(okHttpClient)
}*/