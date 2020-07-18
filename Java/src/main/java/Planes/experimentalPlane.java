package planes;

import models.SecrecyLevel;
import models.ExperimentalType;

import java.util.Objects;

public class ExperimentalPlane extends Plane{
    private SecrecyLevel secrecyLevel;
    private ExperimentalType experimentalType;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ExperimentalType experimentalType, SecrecyLevel secrecyLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.secrecyLevel = secrecyLevel;
        this.experimentalType=experimentalType;
    }

    public SecrecyLevel getSecrecyLevel(){
        return secrecyLevel;
    }

    public
    ExperimentalType getExperimentalType() {
        return experimentalType;
    }

    @Override
    public
    boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ExperimentalPlane that = (ExperimentalPlane) o;
        return secrecyLevel == that.secrecyLevel &&
                experimentalType == that.experimentalType;
    }

    @Override
    public
    int hashCode() {
        return Objects.hash(super.hashCode(), secrecyLevel, experimentalType);
    }

    @Override
    public
    String toString() {
        return "ExperimentalPlane{" +
                "secrecyLevel=" + secrecyLevel +
                ", experimentalType=" + experimentalType +
                '}';
    }
}
