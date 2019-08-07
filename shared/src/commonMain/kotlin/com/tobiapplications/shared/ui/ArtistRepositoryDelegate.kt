package ui

import model.searchartist.ArtistResponse

/**
 * Created by tobias.hehrlein on 2019-07-23.
 */
interface ArtistRepositoryDelegate {

    suspend fun getArtists(artist: String) : ArtistResponse
}