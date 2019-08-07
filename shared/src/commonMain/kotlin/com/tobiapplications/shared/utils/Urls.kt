package utils

import io.ktor.http.URLBuilder

/**
 * Created by tobias.hehrlein on 2019-07-22.
 */
object Urls {

    const val BASE_LAST_FM_URL = "https://ws.audioscrobbler.com/2.0/"

    // Services
    const val METHOD = "method"
    const val SEARCH_ARTIST_METHOD = "artist.search"
    const val SEARCH_ARTIST_QUERY = "artist"
    const val TOP_ALBUMS_URL = "?method=name.gettopalbums&name=%s&page=%s&limit=%s"
    const val ALBUM_TRACKS = "?method=album.getinfo&name=%s&album=%s"


//    fun getTopAlbumsUrl(name: String, albumPage: Int, resultsPerPage: Int) : String {
//        return String.format(TOP_ALBUMS_URL, name, albumPage, resultsPerPage)
//    }
//
//    fun getAlbumTracksUrl(name: String, album: String) : String {
//        return String.format(ALBUM_TRACKS, name, album)
//    }
}