package com.example.airlinereservation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="inventory")
public class Inventory {

	@Id
	@GeneratedValue
	private int inventoryId;
	
	private int count;
	
	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}
	public Inventory() {
		
	}
	public Inventory(int count) {
		super();
		this.count = count;
	}

	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Inventory [inventoryId=" + inventoryId + ", count=" + count + "]";
	}
	
}
