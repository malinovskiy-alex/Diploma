package com.malinovsky.kafedra.model;

public enum CalculationType {
	LT("����"), GR("�����"), SHT("�����"),KG("����������");
	private CalculationType(String type) {
		this.type = type;
	}

	private String type;

	public String getType() {
		return type;
	}

	public String toString() {
		return type;
	}
}
