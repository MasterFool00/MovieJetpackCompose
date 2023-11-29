package com.waffle.moviecomposeapp.module

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        proceed(
            request()
                .newBuilder()
                .addHeader("Authorization", "Bearer ${TOKEN}")
                .build()
        )
    }

    companion object {
        const val TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI3N2JkOGM1MGMzOTc4NmI3YjU4ZGExNDc4ZGY5MDMwMSIsInN1YiI6IjY0ZTQ1ZjJhZTBjYTdmMDEwMDZmOGM3MCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.vYwzpPpQPUmCPZjLKqHPTA-r9DCO_NPhhRaPTUn4dgA"
    }
}

