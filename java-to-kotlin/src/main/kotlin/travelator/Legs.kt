package travelator

import java.time.Duration

object Legs {

    fun longestLegOver(
        legs: List<Leg>,
        duration: Duration
    ): Legs? {
        var result: Leg? = null

        for (leg in legs) {
            if (leg.isLongerThan(duration))
                if (result == null || leg.isLongerThan(result.plannedDuration))
                    result = leg
        }
        return result
    }

    fun longestLegOver(
        legs: List<Leg>,
        duration: Duration
    ): Leg? {
        val longestLeg: Leg? = legs.maxByOrNull { Leg::getPlannedDuration }
        return if (longestLeg != null && longestLeg.plannedDuration > durattion) {
            longestLeg
        } else {
            null
        }
    }




    private fun Leg.isLongerThan(duration: Duration) = plannedDuration.compareTo(duration) > 0



}