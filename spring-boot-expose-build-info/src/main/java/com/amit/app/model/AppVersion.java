package com.amit.app.model;

/**
*
* @author Amit Patil
*
**/
public class AppVersion {

	private String version;

	public AppVersion() {
		super();
	}

	public AppVersion(String version) {
		super();
		this.version = version;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "AppVersion [version=" + version + "]";
	}
}
