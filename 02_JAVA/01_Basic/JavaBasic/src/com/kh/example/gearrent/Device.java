package com.kh.example.gearrent;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class Device {
	private String id;
	private String name;
	private String category;
	private int borrowCount;
	private Set<String> tags;
	
	public Device(String id, String name, String category, int borrowCount, Set<String> tags) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.borrowCount = borrowCount;
		this.tags = (tags == null) ? new HashSet<>() : new HashSet<>();
	}
	
	public abstract int getBorrowLimitDays();
	public abstract int calcLateFee(int overdueDays);
	
	public void increaseBorrowCount() {
		this.borrowCount++;
	}
	
	public boolean hasTag(String tag) {
		String t = tag.toLowerCase();
		for(String s : tags) {
			if(s.toLowerCase().equals(t)) {
				return true;
			}
		}
		return false;			
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Device) {
			Device dev = (Device)obj;
			return this.id.equals(dev.getId());
		}
		return false;
	}

	@Override
	public String toString() {
		return "Device [id=" + id + ", name=" + name + ", category=" + category + ", borrowCount=" + borrowCount
				+ ", tags=" + tags + "]";
	}
	
	
	
	
}
