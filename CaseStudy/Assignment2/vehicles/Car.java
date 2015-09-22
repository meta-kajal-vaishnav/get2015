// car class

package vehicles;

public class Car extends Vehicle {

	private boolean AC;
	private boolean powerSteering;
	private boolean accessoryKit;

	public boolean getAC() {
		return AC;
	}

	public void setAC(boolean aC) {
		AC = aC;
	}

	public boolean getPowerSteering() {
		return powerSteering;
	}

	public void setPowerSteering(boolean powerSteering) {
		this.powerSteering = powerSteering;
	}

	public boolean getAccessoryKit() {
		return accessoryKit;
	}

	public void setAccessoryKit(boolean accessoryKit) {
		this.accessoryKit = accessoryKit;
	}

	// override calculateOnRoadPrice of vehicle
	double calculateOnRoadPrice() {
		return super.calculateOnRoadPrice() + 200;
	}

	@Override
	public String toString() {
		return "Car [Make=" + getMake() + ", Model=" + getModel()
				+ ", Engine In CC=" + getEngineInCC() + ", Fuel Capacity"
				+ getFuelCapacity() + ", Milage=" + getMilage() + ", Price="
				+ getPrice() + ", Road Tax=" + getRoadTax() + ", AC=" + AC
				+ ", Power Steering=" + powerSteering + ", Accessory Kit="
				+ accessoryKit + "]";
	}

}
