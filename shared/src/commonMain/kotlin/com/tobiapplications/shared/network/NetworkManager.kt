package network

import io.ktor.client.HttpClient
import io.ktor.client.features.UserAgent
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import io.ktor.client.features.logging.SIMPLE
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.takeFrom
import kotlinx.serialization.json.Json
import model.searchartist.Artist
import model.searchartist.ArtistMatches
import model.searchartist.ArtistResponse
import model.searchartist.ArtistResult
import utils.Constants
import utils.Urls
import kotlin.reflect.typeOf

/**
 * Created by tobias.hehrlein on 2019-07-22.
 */
class NetworkManager  {

    @OptIn(ExperimentalStdlibApi::class)
    var client : HttpClient = createApiClient()

    @ExperimentalStdlibApi
    private fun createApiClient() : HttpClient {
        return HttpClient {
            install(JsonFeature) {
                serializer = KotlinxSerializer(Json {
                    isLenient = true
                    ignoreUnknownKeys = true
                }).apply {
                    typeOf<ArtistResponse>()
                    typeOf<ArtistResult>()
                    typeOf<ArtistMatches>()
                    typeOf<Artist>()
                }
            }
            install(Logging) {
                logger = Logger.SIMPLE
                level = LogLevel.ALL
            }
            install(UserAgent) {
                agent = "kotlinlibs"
            }

        }

    }

    suspend fun searchArtist(artist: String) : ArtistResponse {
        return client.get {
            url {
                takeFrom(Urls.BASE_LAST_FM_URL)
                parameter(Urls.METHOD, Urls.SEARCH_ARTIST_METHOD)
                parameter(Urls.SEARCH_ARTIST_QUERY, artist)
                parameter("api_key", Constants.LAST_FM_API_KEY)
                parameter("format", "json")
            }
        }
    }

}
