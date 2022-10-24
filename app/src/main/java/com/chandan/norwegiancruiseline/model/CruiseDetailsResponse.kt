package com.chandan.norwegiancruiseline.model

data class CruiseDetailsResponse(
    val accessCode: String,
    val allowedGuestCount: Int,
    val answersHeadlineHtml: Any,
    val bgeImagePath: String,
    val code: String,
    val features: String,
    val highlights: List<String>,
    val imagePath: List<String>,
    val legends: List<Legend>,
    val name: String,
    val onboard_phones: List<OnboardPhone>,
    val recategorizationDate: String,
    val recategorizationDefaultView: String,
    val shipDescription: String,
    val shipDescriptionHtml: String,
    val shipFacts: ShipFacts,
    val shipName: String,
    val stateroomMetas: List<StateroomMeta>,
    val storiesHeadlineHtml: Any,
    val videoList: List<Any>,
    val wesbCode: String,
    val whatsIncluded: List<String>
)

data class Legend(
    val description: String,
    val legendImageLink: String,
    val legendWeight: String,
    val name: String
)

data class OnboardPhone(
    val locationSharingEnabled: Boolean,
    val mobileName: String,
    val name: String,
    val phone: String,
    val token: String,
    val venueCode: String
)

data class ShipFacts(
    val crew: String,
    val cruiseSpeed: String,
    val draft: String,
    val engines: String,
    val grossRegisterTonnage: String,
    val inauguralDate: String,
    val maxBeam: String,
    val overallLength: String,
    val passengerCapacity: String,
    val remodeledDate: String
)

data class StateroomMeta(
    val accessCode: String,
    val categorizationVersion: String,
    val code: String,
    val description: String,
    val featureHighlights: String,
    val features_highlights: String,
    val floorPlanLink: Any,
    val genericCode: String,
    val imagePath: List<String>,
    val includedFeatures: List<String>,
    val name: String,
    val overview_image: OverviewImage,
    val shortDescription: String,
    val stateroomSubMetas: List<StateroomSubMeta>,
    val thumbnailImage: String,
    val videoList: List<Any>,
    val view360Link: Any,
    val weight: String
)

data class OverviewImage(
    val alt: String,
    val imagePath: String,
    val title: String
)

data class StateroomSubMeta(
    val accessCode: String,
    val approximateSize: String,
    val balconySize: String,
    val body: String,
    val code: String,
    val description: String,
    val featuredTag: Any,
    val featuredTagDescription: Any,
    val featuresAndHighlights: String,
    val floorPlanLink: String,
    val guaranteeMessage: String,
    val imageLinks: List<ImageLink>,
    val marketingTagLine: String,
    val name: String,
    val occupancy: String,
    val stateroomCategories: List<StateroomCategory>,
    val thumbnailImage: String,
    val videoList: List<Any>,
    val view360Link: Any
) {
    data class ImageLink(
        val imageHeadLine: String,
        val imageLink: String,
        val legendWeight: String
    )

    data class StateroomCategory(
        val categoryID: String,
        val code: String,
        val colorSwatch: String,
        val comment: String,
        val decks: String,
        val description: String,
        val mandatoryCabin: Boolean,
        val name: String,
        val positionInShip: String,
        val upsellStateroomCategory: String
    )
}
