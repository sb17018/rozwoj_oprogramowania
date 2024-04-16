package bar.piotr.chapters;

class Transaction {
	
	private double gain = 0d;
	private double cost = 0d;
	private double commission = 0d;

	public Transaction(double gain, double cost, double commission) {
		this.gain = gain;
		this.cost = cost;
		this.commission = commission;
	}
	
	void setValues(double gain, double cost, double commission) {
		this.gain += gain;
		this.cost += cost;
		this.commission += commission;
	}

	double getGain() {
		return this.gain;
	}

	double getSpent() {
		return this.cost + this.commission;
	}
	
}
