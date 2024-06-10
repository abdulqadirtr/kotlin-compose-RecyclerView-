package app.compose.recyclerviewcompose

import retrofit2.http.GET

interface NetworkService {


    @GET("objects")
    suspend fun getObjects() : List<Objects>

}