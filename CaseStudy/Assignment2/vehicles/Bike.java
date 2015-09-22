// bike class 

package vehicles;

public class Bike extends Vehicle {

	private boolean selfStart;
	private double helmetPrice;

	public boolean getSelfStart() {
		return selfStart;
	}

	public void setSelfStart(boolean selfStart) {
		this.selfStart = selfStart;
	}

	public double getHelmetPrice() {
		return helmetPrice;
	}

	public void setHelmetPrice(double helmetPrice) {
		this.helmetPrice = helmetPrice;
	}

	// override calculateOnRoadPrice of vehicle
	double calculateOnRoadPrice() {
		return super.calculateOnRoadPrice() + 100;
	}

	@Override
	public String toString() {
		return "Bike [Make=" + getMake() + ", Model=" + getModel()
				+ ", Engine In CC=" + getEngineInCC() + ", Fuel Capacity="
				+ getFuelCapacity() + ", Milage=" + getMilage() + ", Price="
				+ getPrice() + ", Road Tax=" + getRoadTax() + ", Self Start="
				+ selfStart + ", Helmet Price=" + helmetPrice + "]";
	}

}
