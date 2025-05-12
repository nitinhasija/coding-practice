package com.epam;
import java.util.ArrayList;
import java.util.List;

/**
 * The interface Vehicle.
 */
interface Vehicle {
    /**
     * Gets number.
     *
     * @return the number
     */
    int getNumber();

    /**
     * Gets cost.
     *
     * @return the cost
     */
    int getCost();

    /**
     * Gets colour.
     *
     * @return the colour
     */
    String getColour();

    /**
     * Gets name.
     *
     * @return the name
     */
    String getName();

    /**
     * Gets vehicle type.
     *
     * @return the vehicle type
     */
    VehicleType getVehicleType();
}

/**
 * The type Bike.
 */
class Bike implements Vehicle {

    private final int number;
    private final int cost;
    private final String colour;
    private final String name;
    private final VehicleType vehicleType;

    /**
     * Instantiates a new Bike.
     *
     * @param number the number
     * @param name   the name
     * @param colour the colour
     * @param cost   the cost
     */
    public Bike(int number, String name, String colour, int cost) {
        this.number = number;
        this.cost = cost;
        this.colour = colour;
        this.name = name;
        this.vehicleType = VehicleType.TWO_WHEELER;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public String getColour() {
        return colour;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public VehicleType getVehicleType() {
        return vehicleType;
    }

    @Override
    public int getCost() {
        return cost;
    }
}

/**
 * The type Car.
 */
class Car implements Vehicle {
    private final int number;
    private final int cost;
    private final String colour;
    private final String name;
    private final VehicleType vehicleType;

    /**
     * Instantiates a new Car.
     *
     * @param number the number
     * @param name   the name
     * @param colour the colour
     * @param cost   the cost
     */
    public Car(int number, String name, String colour, int cost) {
        this.number = number;
        this.cost = cost;
        this.colour = colour;
        this.name = name;
        this.vehicleType = VehicleType.TWO_WHEELER;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public String getColour() {
        return colour;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public VehicleType getVehicleType() {
        return vehicleType;
    }
}

/**
 * The type Vehicle not found exception.
 */
class VehicleNotFoundException extends Exception {
    private String message;

    /**
     * Instantiates a new Vehicle not found exception.
     *
     * @param message the message
     */
    public VehicleNotFoundException(String message) {
        super(message);
    }
}

/**
 * The type Capacity exception.
 */
class CapacityException extends Exception {
    private String message;

    /**
     * Instantiates a new Capacity exception.
     *
     * @param message the message
     */
    public CapacityException(String message) {
        super(message);
    }
}

/**
 * The type Vehicle factory.
 */
class VehicleFactory {
    private final int capacity;
    private final List<Vehicle> vehicles;

    /**
     * Instantiates a new Vehicle factory.
     */
    public VehicleFactory() {
        capacity = 100;
        vehicles = new ArrayList<>(capacity);
    }

    /**
     * Gets vehicle.
     *
     * @param number the number
     * @return the vehicle
     * @throws VehicleNotFoundException the vehicle not found exception
     */
    public Vehicle getVehicle(int number) throws VehicleNotFoundException {
        for(Vehicle vehicle : vehicles){
            if(vehicle.getNumber() == number)
                return vehicle;
        }
        throw new VehicleNotFoundException("Vehicle not found");
    }

    /**
     * Gets vehicle.
     *
     * @param number      the number
     * @param vehicleType the vehicle type
     * @return the vehicle
     * @throws VehicleNotFoundException the vehicle not found exception
     */
    public Vehicle getVehicle(int number, VehicleType vehicleType) throws VehicleNotFoundException {
        for(Vehicle vehicle : vehicles){
            if(vehicle.getNumber() == number && vehicle.getVehicleType().equals(vehicleType)){
                return vehicle;
            }
        }
        throw new VehicleNotFoundException("Vehicle not found");
    }

    /**
     * Add vehicle.
     *
     * @param number      the number
     * @param name        the name
     * @param colour      the colour
     * @param rentalCost  the rental cost
     * @param vehicleType the vehicle type
     * @throws CapacityException the capacity exception
     */
    public void addVehicle(int number, String name, String colour, int rentalCost, VehicleType vehicleType) throws CapacityException {
        validate(vehicleType);
        vehicles.add(new Bike(number, name, colour, rentalCost));
    }

    /**
     * Remove vehicle.
     *
     * @param number the number
     * @throws VehicleNotFoundException the vehicle not found exception
     */
    public void removeVehicle(int number) throws VehicleNotFoundException {
        try {
            Vehicle vehicle = getVehicle(number);
            vehicles.remove(vehicle);
        } catch (VehicleNotFoundException e) {
            throw new VehicleNotFoundException(e.getMessage());
        }
    }

    private void validate(VehicleType vehicleType) throws CapacityException {
        if (vehicles.size() >= capacity) {
            throw new CapacityException(String.format("Capacity filled for %s", vehicleType));
        }
    }

    /**
     * Update vehicle.
     *
     * @param number      the number
     * @param name        the name
     * @param colour      the colour
     * @param rentalCost  the rental cost
     * @param vehicleType the vehicle type
     * @throws VehicleNotFoundException the vehicle not found exception
     * @throws CapacityException        the capacity exception
     */
    public void updateVehicle(int number, String name, String colour, int rentalCost, VehicleType vehicleType) throws VehicleNotFoundException, CapacityException {
        removeVehicle(number);
        addVehicle(number, name, colour, rentalCost, vehicleType);
    }
}



/**
 * The enum Vehicle type.
 */ 
enum VehicleType {
    /**
     * Two wheeler vehicle type.
     */
    TWO_WHEELER,
    /**
     * Four wheeler vehicle type.
     */
    FOUR_WHEELER,
    /**
     * Heavy vehicle vehicle type.
     */
    HEAVY_VEHICLE
}


/**
 * The type Vehicle controller.
 */
class VehicleController {
    private final VehicleFactory vehicleFactory;

    /**
     * Instantiates a new Vehicle controller.
     */
    public VehicleController() {
        vehicleFactory = new VehicleFactory();
    }

    /**
     * Gets vehicle.
     *
     * @param number      the number
     * @param vehicleType the vehicle type
     * @return the vehicle
     */
    public Vehicle getVehicle(int number, VehicleType vehicleType) {
        try {
            return vehicleFactory.getVehicle(number, vehicleType);
        } catch (VehicleNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    /**
     * Add vehicle.
     *
     * @param number      the number
     * @param name        the name
     * @param colour      the colour
     * @param rentalCost  the rental cost
     * @param vehicleType the vehicle type
     */
    public void addVehicle(int number, String name, String colour, int rentalCost, VehicleType vehicleType) {
        try {
            vehicleFactory.addVehicle(number, name, colour, rentalCost, vehicleType);
        } catch (CapacityException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Update vehicle.
     *
     * @param number      the number
     * @param name        the name
     * @param colour      the colour
     * @param rentalCost  the rental cost
     * @param vehicleType the vehicle type
     */
    public void updateVehicle(int number, String name, String colour, int rentalCost, VehicleType vehicleType) {
        try {
            vehicleFactory.updateVehicle(number, name, colour, rentalCost, vehicleType);
        } catch (Exception e) {
            System.out.println("Can't update vehicle");
        }
    }

    /**
     * Remove vehicle.
     *
     * @param id the id
     */
    public void removeVehicle(int id) {
        try {
            vehicleFactory.removeVehicle(id);
        } catch (VehicleNotFoundException e) {
            System.out.println("Can't remove vehicle");
        }
    }
}


public class Main {
    public static void main(String[] args) {
        VehicleController controller = new VehicleController();
        controller.addVehicle(101, "Honda city", "white", 500 ,VehicleType.FOUR_WHEELER);
        controller.addVehicle(102, "BMW", "Black", 5000 ,VehicleType.FOUR_WHEELER);
        controller.addVehicle(112, "KTM", "Black", 50 ,VehicleType.TWO_WHEELER);


        Vehicle vehicle = controller.getVehicle(101, VehicleType.TWO_WHEELER);
        System.out.println(vehicle.getName());

        controller.updateVehicle(112, "Pulsar", "black", 100, VehicleType.TWO_WHEELER);

        System.out.println(controller.getVehicle(112, VehicleType.TWO_WHEELER).getName());

        controller.removeVehicle(101);

        System.out.println(controller.getVehicle(101, VehicleType.TWO_WHEELER).getName());
    }
}

