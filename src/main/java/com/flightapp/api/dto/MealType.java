package com.flightapp.api.dto;

public class MealType {
	
	private int typeId;
	private String typeName;
	
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	public MealType() {}
	
	public MealType(String typeName) {
		this.typeName = typeName;
	}
	
	@Override
	public String toString() {
		return "MealType [typeId=" + typeId + ", typeName=" + typeName + "]";
	}
	
}
