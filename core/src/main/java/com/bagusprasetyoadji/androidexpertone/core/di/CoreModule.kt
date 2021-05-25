package com.bagusprasetyoadji.androidexpertone.core.di

import androidx.room.Room
import com.bagusprasetyoadji.androidexpertone.core.data.MovieRepository
import com.bagusprasetyoadji.androidexpertone.core.data.source.local.LocalDataSource
import com.bagusprasetyoadji.androidexpertone.core.data.source.local.room.MovieDatabase
import com.bagusprasetyoadji.androidexpertone.core.data.source.remote.RemoteDataSource
import com.bagusprasetyoadji.androidexpertone.core.data.source.remote.network.ApiService
import com.bagusprasetyoadji.androidexpertone.core.domain.repository.IMovieRepository
import com.bagusprasetyoadji.androidexpertone.core.utils.AppExecutors
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory { get<MovieDatabase>().movieDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            MovieDatabase::class.java, "Movieku.db"
        ).fallbackToDestructiveMigration().build()
    }
}

val networkModule = module {
    single {
        val hostname = "api.themoviedb.org"
        val certificatePinner = CertificatePinner.Builder()
            .add(hostname, "sha256/JSMzqOOrtyOT1kmau6zKhgT676hGgczD5VMdRMyJZFA=")
            .build()
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .certificatePinner(certificatePinner)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<IMovieRepository> {
        MovieRepository(
            get(),
            get(),
            get()
        )
    }
}