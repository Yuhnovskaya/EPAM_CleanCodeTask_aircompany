import models.SecrecyLevel;
import planesTest.ExperimentalPlaneTest;
import models.MilitaryType;
import planesTest.MilitaryPlane;
import planesTest.PassengerPlane;
import planesTest.Plane;

import java.util.*;

// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019

public
class Airport {
    private final List<? extends Plane> planes;

    public
    List<PassengerPlane> getPassengerPlane() {
        List<PassengerPlane> passengerPlanes = new ArrayList<>();
        for (Plane p : planes) {
            if (p instanceof PassengerPlane) {
                passengerPlanes.add((PassengerPlane) p);
            }
        }
        return passengerPlanes;
    }

    public
    List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof MilitaryPlane) {
                militaryPlanes.add((MilitaryPlane) plane);
            }
        }
        return militaryPlanes;
    }

    public
    PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPassengerPlane();
        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
        for (int i = 0; i < passengerPlanes.size(); i++) {
            if (passengerPlanes.get(i).getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = passengerPlanes.get(i);
            }
        }
        return planeWithMaxCapacity;
    }

    public
    List<MilitaryPlane> getTransportMilitaryPlanes() {
        List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        for (int i = 0; i < militaryPlanes.size(); i++) {
            MilitaryPlane plane = militaryPlanes.get(i);
            if (plane.getType() == MilitaryType.TRANSPORT) {
                transportMilitaryPlanes.add(plane);
            }
        }
        return transportMilitaryPlanes;
    }

    public
    List<MilitaryPlane> getBomberMilitaryPlanes() {
        List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        for (int i = 0; i < militaryPlanes.size(); i++) {
            MilitaryPlane plane = militaryPlanes.get(i);
            if (plane.getType() == MilitaryType.BOMBER) {
                bomberMilitaryPlanes.add(plane);
            }
        }
        return bomberMilitaryPlanes;

    }

    public
    List<ExperimentalPlaneTest> getExperimentalPlanes() {
        List<ExperimentalPlaneTest> experimentalPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof ExperimentalPlaneTest) {
                experimentalPlanes.add((ExperimentalPlaneTest) plane);
            }
        }
        return experimentalPlanes;
    }

    public
    Airport sortByMaxDistance() {
        Collections.sort(planes, new Comparator<Plane>() {
                    public
                    int compare(Plane o1, Plane o2) {
                        return o1.getMaxFlightDistance() - o2.getMaxFlightDistance();
                    }
                });
        return this;
    }

    public
    Airport sortByMaxSpeed() {
        Collections.sort(planes, new Comparator<Plane>() {
            public
            int compare(Plane o1, Plane o2) {
                return o1.getMaxSpeed() - o2.getMaxSpeed();
            }
        });
        return this;
    }

    public
    Airport sortByMaxLoadCapacity() {
        Collections.sort(planes, new Comparator<Plane>() {
            public
            int compare(Plane o1, Plane o2) {
                return o1.getMaxLoadCapacity() - o2.getMaxLoadCapacity();
            }
        });
        return this;
    }

    public
    List<? extends Plane> getPlanes() {
        return planes;
    }

    private
    void printPlanesList(Collection<? extends Plane> collection) {
        Iterator<? extends Plane> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Plane plane = iterator.next();
            System.out.println(plane);
        }
    }

    @Override
    public
    String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }

    public
    Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public
    boolean checkSortingByMaxLoadCapacity(List<? extends Plane> planes) {
        boolean nextPlaneMaxLoadCapacityIsHigherThanCurrent = true;
        for (int i = 0; i < planes.size() - 1; i++) {
            Plane currentPlane = planes.get(i);
            Plane nextPlane = planes.get(i + 1);
            if (currentPlane.getMaxLoadCapacity() > nextPlane.getMaxLoadCapacity()) {
                nextPlaneMaxLoadCapacityIsHigherThanCurrent = false;
                break;
            }
        }
        return nextPlaneMaxLoadCapacityIsHigherThanCurrent;
    }

    public
    boolean checkMilitaryPlaneType(List<MilitaryPlane> militaryPlanes, MilitaryType militaryType) {
        boolean isTypesEqual = false;
        for (MilitaryPlane militaryPlane : militaryPlanes) {
            if ((militaryPlane.getType() == militaryType)) {
                isTypesEqual = true;
                break;
            }
        }
        return isTypesEqual;
    }

    public
    boolean checkMilitaryPlanesHasAtLeastOneInstanceOfType(List<MilitaryPlane> militaryPlanes, MilitaryType militaryType) {
        boolean hasMilitaryPlanesAtLeastOneInstanceOfType = false;
        for (MilitaryPlane militaryPlane : militaryPlanes) {
            if ((militaryPlane.getType() == militaryType)) {
                hasMilitaryPlanesAtLeastOneInstanceOfType = true;
            }
        }
        return hasMilitaryPlanesAtLeastOneInstanceOfType;
    }

    public
    boolean checkExperimentalPlanesHasNoUnclassifiedLevel(List<ExperimentalPlaneTest> experimentalPlanes) {
        boolean hasNoUnclassifiedPlanes = false;
        for (ExperimentalPlaneTest experimentalPlane : experimentalPlanes) {
            if (experimentalPlane.getSecrecyLevel() == SecrecyLevel.UNCLASSIFIED) {
                hasNoUnclassifiedPlanes = true;
                break;
            }
        }
        return hasNoUnclassifiedPlanes;
    }
}
