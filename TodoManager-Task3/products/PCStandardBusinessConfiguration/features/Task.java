package features;

import java.util.LinkedList;
import java.util.List;

public class Task {
	private String title;
	private String notes;
	private String category;
	private long creationTime;
	//#if Severity
	private String severity;
	//#endif
	//#if Deadline
	private long deadline;
	//#endif
	//#if Checklist
//@	private LinkedList<String> checklist;
	//#endif

	public Task(String title, String notes, String category) {
		this.title = title;
		this.notes = notes;
		this.category = category;
		//#if Severity
		this.severity = "MEDIUM";
		System.out.println("Severity on!");
		//#endif
		//#if Deadline
		this.deadline = 0;
		System.out.println("Deadline on!");
		//#endif
		//#if Checklist
//@		this.checklist = new LinkedList<String>();
//@		System.out.println("Checklist on!");
		//#endif
		//#if Share
//@		System.out.println("Share on!");
		//#endif
		this.creationTime = System.currentTimeMillis();
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getNotes() {
		return notes;
	}
	
	public String getCategory() {
		return category;
	}
	
	public long getCreationTime() {
		return creationTime;
	}
	
	//#if Severity
	public String getSeverity() {
		return severity;
	}
	
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	//#endif
	
	//#if Deadline
	public long getDeadline() {
		return deadline;
	}
	
	public void setDeadline(long deadline) {
		this.deadline = deadline;
	}
	//#endif
	
	public boolean isShareAvailable() {
		//#if Share
//@		return true;
		//#else
		return false;
		//#endif
	}
	//#if Share
//@	public void shareToMail(String email) {
//@		System.out.println("Shared " + title + " with " + email);
//@	}
	//#endif
	
	//#if Checklist
//@	public List<String> getChecklist(){
//@		return checklist;
//@	}
//@	
//@	public void addToChecklist(String note) {
//@		this.checklist.add(note);
//@	}
//@	
//@	public void removeObjectFromChecklist(String note) {
//@		if (checklist.contains(note))
//@			checklist.remove(note);
//@	}
	//#endif
}
