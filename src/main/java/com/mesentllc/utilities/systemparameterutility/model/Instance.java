package com.mesentllc.utilities.systemparameterutility.model;

import com.mesentllc.utilities.systemparameterutility.enums.PFEnvironment;
import com.mesentllc.utilities.systemparameterutility.enums.PFSystem;

public class Instance {
	private PFSystem pfSystem;
	private PFEnvironment pfEnvironment;
	private String username;
	private String password;

	public PFSystem getPfSystem() {
		return pfSystem;
	}

	public void setPfSystem(PFSystem pfSystem) {
		this.pfSystem = pfSystem;
	}

	public PFEnvironment getPfEnvironment() {
		return pfEnvironment;
	}

	public void setPfEnvironment(PFEnvironment pfEnvironment) {
		this.pfEnvironment = pfEnvironment;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
