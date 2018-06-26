package features;

public class Task {
	private double progress;
	
	public double getProgress() {
		return progress;
	}
	
	public void setProgress(double progress) {
		this.progress = progress;
	}
	
	public String toString() {
		return original() + "\t\t" + progress;
	}
}
