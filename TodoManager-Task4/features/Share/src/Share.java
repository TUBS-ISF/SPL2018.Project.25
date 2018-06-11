package interfaces;

public class Share implements IShare {
	// Feature Share
	public boolean isShareAvailable() {
		return true;
	}
	public void shareToMail(String email) {
		System.out.println("Sharing Task with " + email + "!");
	}
}
