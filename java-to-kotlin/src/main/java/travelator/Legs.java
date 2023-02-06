package travelator;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

public class Legs {

    public static Optional<Leg> findLongestLegOver(
            List<Leg> legs,
            Duration duration
    ) {
        Leg result = null;
        for (Leg leg: legs) {
            if (isLonerThan(leg, duration)) {
                if (result == null || isLonerThan(leg, result.getPlannedDuration())) {
                    result = leg;
                }
            }
        }
        return Optional.ofNullable(result);

    }

    private static boolean isLonerThan(Leg leg, Duration duration) {
        return leg.getPlannedDuration().compareTo(duration) > 0;
    }

}
