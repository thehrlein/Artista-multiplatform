package ui

import model.searchartist.ArtistResponse
import network.NetworkManager

/**
 * Created by tobias.hehrlein on 2019-07-23.
 */
class ArtistRepository(private val networkManager: NetworkManager) : ArtistRepositoryDelegate{

    override suspend fun getArtists(artist: String): ArtistResponse {
        return networkManager.searchArtist(artist)
    }
}