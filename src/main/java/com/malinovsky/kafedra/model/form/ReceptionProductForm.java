package com.malinovsky.kafedra.model.form;

import java.util.List;

public class ReceptionProductForm {
	private List<WarekeeperBean> beans;

	public ReceptionProductForm() {
	}

	public ReceptionProductForm(List<WarekeeperBean> beans) {
		setBeans(beans);
	}

	public List<WarekeeperBean> getBeans() {
		return beans;
	}

	public void setBeans(List<WarekeeperBean> beans) {
		this.beans = beans;
	}

}
