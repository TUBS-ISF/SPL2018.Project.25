package interfaces;

public class Progress implements IProgress {
	private double progress = 0.0;
	
	public double getProgress() {
		return progress;
	}
	public void setProgress(double progress) {
		this.progress = progress;
	}
}
