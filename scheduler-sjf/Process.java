
public class Process {
	private int cpuBurst; //alfa
	private int outOfCPU; // tempo de espera
	private int lastTimeCPU;
	private Double lastWeight;
	
	public Process(int cpuBurst, int lastTimeCPU,int outOfCPU) {
		this.cpuBurst = cpuBurst;
		this.outOfCPU = outOfCPU;
		this.lastTimeCPU = lastTimeCPU;
	}
	
	public Process(double lastWeight) {
		this.lastWeight = lastWeight;
	}

	public int getBurst() {
		return cpuBurst;
	}

	public int getOutOfCPU() {
		return outOfCPU;
	}

	public int getLastTimeCPU() {
		return lastTimeCPU;
	}

	public Double getLastWeight() {
		return lastWeight;
	}

	public void setLastWeight(Double lastWeight) {
		this.lastWeight = lastWeight;
	}
	
	public double evaluateNextBurst(double lastWeight) {
		return lastWeight*lastTimeCPU + (1 - lastWeight) * cpuBurst;	
	}

}

