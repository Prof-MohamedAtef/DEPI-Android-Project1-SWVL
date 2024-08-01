package mo.ed.nozha.apps.excercise.seight.models

import java.io.Serializable

data class Trip(
    var id: Int, var pickupAddress: String, var destination: String
) : Serializable
