package com.chandan.norwegiancruiseline.model

enum class CruiseType {
    SKY,
    BLISS,
    ESCAPE;

    companion object {
        fun getType(type: String): CruiseType? {
            return when (type) {
                SKY.name -> SKY
                BLISS.name -> BLISS
                ESCAPE.name -> ESCAPE
                else -> null
            }
        }
    }
}
