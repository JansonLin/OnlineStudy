package entity;

public class Video {
	private int VID;
	private int VCourseID;
	private int VDirectoryListsID;
	private String VName;
	private String VAddress;
	public int getVID() {
		return VID;
	}
	public void setVID(int vID) {
		VID = vID;
	}
	public int getVCourseID() {
		return VCourseID;
	}
	public void setVCourseID(int vCourseID) {
		VCourseID = vCourseID;
	}
	public int getVDirectoryListsID() {
		return VDirectoryListsID;
	}
	public void setVDirectoryListsID(int vDirectoryListsID) {
		VDirectoryListsID = vDirectoryListsID;
	}
	public String getVName() {
		return VName;
	}
	public void setVName(String vName) {
		VName = vName;
	}
	public String getVAddress() {
		return VAddress;
	}
	public void setVAddress(String vAddress) {
		VAddress = vAddress;
	}
}
