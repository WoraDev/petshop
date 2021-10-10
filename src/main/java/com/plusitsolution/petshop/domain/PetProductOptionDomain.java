package com.plusitsolution.petshop.domain;

import java.util.List;

public class PetProductOptionDomain {

	private String optionName;
	private List<String> options;
	
	public String getOptionName() {
		return optionName;
	}
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	public List<String> getOptions() {
		return options;
	}
	public void setOptions(List<String> options) {
		this.options = options;
	}
	
}
