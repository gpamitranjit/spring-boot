package com.amit.limitsservice.app.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
*
* @author Amit Patil
*
**/
@Component
@ConfigurationProperties("limits-service")
public class LimitsConfiguration {

	private int minimum;
	private int maximum;
	
	public LimitsConfiguration() {
		super();
	}

	public LimitsConfiguration(int minimum, int maximum) {
		super();
		this.minimum = minimum;
		this.maximum = maximum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maximum;
		result = prime * result + minimum;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LimitsConfiguration other = (LimitsConfiguration) obj;
		if (maximum != other.maximum)
			return false;
		if (minimum != other.minimum)
			return false;
		return true;
	}

	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

	public int getMaximum() {
		return maximum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

	@Override
	public String toString() {
		return "LimittsConfiguration [minimum=" + minimum + ", maximum=" + maximum + "]";
	}
	
}
