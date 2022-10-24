package com.chandan.norwegiancruiseline.dependency_injection.KoinModules

import com.chandan.norwegiancruiseline.model.CruiseDetailsRepository
import com.chandan.norwegiancruiseline.model.NCLApi
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    factory { provideOkHttpClient() }
    factory { provideForecastApi(get()) }
    single { provideRetrofit(get()) }
    factory { CruiseDetailsRepository(get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(CruiseDetailsRepository.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient().newBuilder().build()
}

fun provideForecastApi(retrofit: Retrofit): NCLApi = retrofit.create(NCLApi::class.java)
