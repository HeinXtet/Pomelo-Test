package com.deevvdd.test.utility.mock

import com.deevvdd.domain.model.result.Pickup

/**
 * Created by heinhtet deevvdd@gmail.com on 09,June,2021
 */
object PickupLocationMockData {

    private val pickup = Pickup(1, "test alias", "yangon", "test address", true, 0.0, 0.0)

    val ACTIVE_PICKUP_LIVE = listOf(
        pickup.copy(id = 2, active = true),
        pickup.copy(id = 3, active = true),
        pickup.copy(id = 4, active = true),
        pickup.copy(id = 5, active = true)
    )

    val TO_SORT_PICK_UP_LIST_ACTUAL = listOf(
        pickup.copy(id = 22, latitude = 18.740303, longitude = 98.995566),
        pickup.copy(id = 19, latitude = 15.17352, longitude = 98.359504)
    )

    val TO_SORT_PICK_UP_LIST_EXPECTED = listOf(
        pickup.copy(id = 19, latitude = 15.17352, longitude = 98.359504),
        pickup.copy(id = 22, latitude = 18.740303, longitude = 98.995566)
    )

    val SORTED_PICK_UP_LOCATION_1 = "{\n" +
            "      \"feature\": null,\n" +
            "      \"id_pickup_location\": 19,\n" +
            "      \"id_country\": 206,\n" +
            "      \"id_state\": 328,\n" +
            "      \"id_carrier\": 23,\n" +
            "      \"company\": null,\n" +
            "      \"nps_link\": null,\n" +
            "      \"alias\": \"Baan Dada Children's Home and Co\",\n" +
            "      \"address1\": \"116 Moo 6\",\n" +
            "      \"address2\": \"Tambon Nonglu Huay Ma Lai Sangkhlaburi\",\n" +
            "      \"district\": null,\n" +
            "      \"city\": \"Kanchanaburi\",\n" +
            "      \"postcode\": \"71240\",\n" +
            "      \"latitude\": 15.17352,\n" +
            "      \"longitude\": 98.359504,\n" +
            "      \"phone\": \"084-412-5443\",\n" +
            "      \"nearest_bts\": null,\n" +
            "      \"notable_area\": null,\n" +
            "      \"hours1\": null,\n" +
            "      \"hours2\": null,\n" +
            "      \"hours3\": \"\",\n" +
            "      \"description\": \"\",\n" +
            "      \"is_featured\": false,\n" +
            "      \"subtype\": \"csr\",\n" +
            "      \"active\": true,\n" +
            "      \"status\": \"active\",\n" +
            "      \"id_zone\": 3,\n" +
            "      \"is_new_location\": false,\n" +
            "      \"type\": \"pickup\",\n" +
            "      \"hours\": [],\n" +
            "      \"images\": {\n" +
            "        \"store\": {\n" +
            "          \"primary\": {\n" +
            "          },\n" +
            "          \"secondary\": \"img/retail/stores/default/secondary/default.jpg\",\n" +
            "        },\n" +
            "        \"floormap\": {\n" +
            "        }\n" +
            "      },\n" +
            "      \"is_default_location\": false\n" +
            "    },"

    val SORTED_PICK_UP_LOCATION_2 = "    {\n" +
            "      \"feature\": null,\n" +
            "      \"id_pickup_location\": 22,\n" +
            "      \"id_country\": 206,\n" +
            "      \"id_state\": 322,\n" +
            "      \"id_carrier\": 23,\n" +
            "      \"company\": null,\n" +
            "      \"nps_link\": null,\n" +
            "      \"alias\": \"สำนักงานมูลนิธิตะวันฉาย\",\n" +
            "      \"address1\": \"110/2 Soi 7 Moo 2 Tha Wang Tan\",\n" +
            "      \"address2\": \"Saraphi\",\n" +
            "      \"district\": null,\n" +
            "      \"city\": \"Chiang Mai\",\n" +
            "      \"postcode\": \"50140\",\n" +
            "      \"latitude\": 18.740303,\n" +
            "      \"longitude\": 98.995566,\n" +
            "      \"phone\": \"053-816-285\",\n" +
            "      \"nearest_bts\": null,\n" +
            "      \"notable_area\": null,\n" +
            "      \"hours1\": null,\n" +
            "      \"hours2\": null,\n" +
            "      \"hours3\": \"\",\n" +
            "      \"description\": \"\",\n" +
            "      \"is_featured\": false,\n" +
            "      \"subtype\": \"csr\",\n" +
            "      \"active\": true,\n" +
            "      \"status\": \"active\",\n" +
            "      \"id_zone\": 3,\n" +
            "      \"is_new_location\": false,\n" +
            "      \"type\": \"pickup\",\n" +
            "      \"hours\": [],\n" +
            "      \"images\": {\n" +
            "        \"store\": {\n" +
            "          \"primary\": {\n" +
            "          },\n" +
            "        },\n" +
            "        \"floormap\": {\n" +
            "        }\n" +
            "      },\n" +
            "      \"is_default_location\": false\n" +
            "    },"

    val CREATE_PICKUP_RESPONSE = "{\n" +
            "  \"number_of_new_locations\": 5,\n" +
            "  \"pickup\": [\n" +
            "    {\n" +
            "      \"feature\": \"fast_delivery\",\n" +
            "      \"id_pickup_location\": 39,\n" +
            "      \"id_country\": 206,\n" +
            "      \"id_state\": 315,\n" +
            "      \"id_carrier\": 35,\n" +
            "      \"company\": null,\n" +
            "      \"nps_link\": \"https://pomelo3.typeform.com/to/EDFJ5z\",\n" +
            "      \"alias\": \"\",\n" +
            "      \"address1\": \"\",\n" +
            "      \"address2\": \"\",\n" +
            "      \"district\": \"\",\n" +
            "      \"city\": \"\",\n" +
            "      \"postcode\": \"10110\",\n" +
            "      \"latitude\": 13.7314,\n" +
            "      \"longitude\": 100.569212,\n" +
            "      \"phone\": \"02-003-6072\",\n" +
            "      \"nearest_bts\": \"\",\n" +
            "      \"notable_area\": null,\n" +
            "      \"hours1\": \"\",\n" +
            "      \"hours2\": \"\",\n" +
            "      \"hours3\": \"\",\n" +
            "      \"description\": \"\",\n" +
            "      \"is_featured\": false,\n" +
            "      \"subtype\": \"store\",\n" +
            "      \"store_image_path\": \"{\\\"primary\\\":{\\\"landscape\\\":\\\"img/pickup-locations/main-image-landscape/emquartier.jpg\\\",\\\"full_landscape\\\":\\\"https://pomelofashion-staging.imgix.net/img/pickup-locations/main-image-landscape/emquartier.jpg\\\",\\\"portrait\\\":\\\"img/retail/stores/default/primary/default_portrait.jpg\\\",\\\"full_portrait\\\":\\\"https://pomelofashion-staging.imgix.net/img/retail/stores/default/primary/default_portrait.jpg\\\"},\\\"secondary\\\":\\\"img/pickup-locations/secondary-image/emquartier.jpg\\\",\\\"full_secondary\\\":\\\"https://pomelofashion-staging.imgix.net/img/pickup-locations/secondary-image/emquartier.jpg\\\"}\",\n" +
            "      \"floormap_image_path\": \"{\\\"main\\\":\\\"img/pickup-locations/floor-map/emquartier.jpg\\\",\\\"full_main\\\":\\\"https://pomelofashion-staging.imgix.net/img/pickup-locations/floor-map/emquartier.jpg\\\",\\\"zoomed\\\":\\\"img/pickup-locations/floor-map-zoomed/emquartier.jpg\\\",\\\"full_zoomed\\\":\\\"https://pomelofashion-staging.imgix.net/img/pickup-locations/floor-map-zoomed/emquartier.jpg\\\"}\",\n" +
            "      \"active\": true,\n" +
            "      \"floor_number\": \"1\",\n" +
            "      \"status\": \"active\",\n" +
            "      \"id_zone\": 3,\n" +
            "      \"features\": [\n" +
            "        {\n" +
            "          \"type\": \"fast_delivery\",\n" +
            "          \"description\": \"Shop Online & Try Order On Offline\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"shopping\",\n" +
            "          \"description\": \"Shop New Arrivals & Best Sellers\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"try_on\",\n" +
            "          \"description\": \"Bring Home Only What You Love\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"is_new_location\": false,\n" +
            "      \"type\": \"pickup\",\n" +
            "      \"hours\": [],\n" +
            "      \"images\": {\n" +
            "        \"store\": {\n" +
            "          \"primary\": {\n" +
            "            \"landscape\": \"img/pickup_location/images/20200304164134_5e5f77ce3d623_file.jpg\",\n" +
            "            \"full_landscape\": \"img/pickup_location/images/20200304164134_5e5f77ce3d623_file.jpg\",\n" +
            "            \"portrait\": \"img/retail/stores/default/primary/default_portrait.jpg\",\n" +
            "            \"full_portrait\": \"https://pomelofashion-staging.imgix.net/img/retail/stores/default/primary/default_portrait.jpg\"\n" +
            "          },\n" +
            "          \"secondary\": \"img/pickup_location/images/20200304164123_5e5f77c317250_file.jpg\",\n" +
            "          \"full_secondary\": \"img/pickup_location/images/20200304164123_5e5f77c317250_file.jpg\"\n" +
            "        },\n" +
            "        \"floormap\": {\n" +
            "          \"main\": \"img/pickup_location/images/20200304164211_5e5f77f31bb6e_file.jpg\",\n" +
            "          \"full_main\": \"img/pickup_location/images/20200304164211_5e5f77f31bb6e_file.jpg\",\n" +
            "          \"zoomed\": \"img/pickup_location/images/20200304164148_5e5f77dc7f07c_file.jpg\",\n" +
            "          \"full_zoomed\": \"img/pickup_location/images/20200304164148_5e5f77dc7f07c_file.jpg\"\n" +
            "        }\n" +
            "      },\n" +
            "      \"is_default_location\": false\n" +
            "    }\n" +
            "  ]\n" +
            "}"
}