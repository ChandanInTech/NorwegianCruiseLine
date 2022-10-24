package com.chandan.norwegiancruiseline.utils

import android.view.View
import android.widget.TextView
import com.chandan.norwegiancruiseline.model.CruiseData
import com.chandan.norwegiancruiseline.model.CruiseDetailsResponse

fun CruiseDetailsResponse.toCruiseData(): CruiseData {
    return CruiseData(
        name = name,
        passengerCapacity = shipFacts.passengerCapacity,
        crew = shipFacts.crew,
        inauguralDate = shipFacts.inauguralDate
    )
}

fun TextView.setTextOrHideIfNullOrEmpty(text: String?) {
    if (text.isNullOrEmpty()) {
        visibility = View.GONE
    } else {
        this.text = text
    }
}
