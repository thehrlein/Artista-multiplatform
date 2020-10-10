package model.searchartist

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArtistResult(@SerialName("artistmatches") val artistMatches: ArtistMatches)