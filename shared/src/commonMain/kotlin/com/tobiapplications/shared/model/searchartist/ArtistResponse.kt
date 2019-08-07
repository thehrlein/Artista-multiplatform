package model.searchartist

import kotlinx.serialization.Serializable

@Serializable
data class ArtistResponse(val results: ArtistResult)