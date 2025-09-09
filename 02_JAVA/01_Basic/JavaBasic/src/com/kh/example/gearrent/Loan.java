package com.kh.example.gearrent;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Loan {
	private String itemId;
	private String memberId;
	private LocalDate loanDate;
	private LocalDate dueDate;
	private LocalDate returnedDate;
	
	public Loan(String itemId, String memberId, LocalDate loanDate, LocalDate dueDate) {
		super();
		this.itemId = itemId;
		this.memberId = memberId;
		this.loanDate = loanDate;
		this.dueDate = dueDate;
	}
	
	
	public String getItemId() {
		return itemId;
	}


	public void setItemId(String itemId) {
		this.itemId = itemId;
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public LocalDate getLoanDate() {
		return loanDate;
	}


	public void setLoanDate(LocalDate loanDate) {
		this.loanDate = loanDate;
	}


	public LocalDate getDueDate() {
		return dueDate;
	}


	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}


	public LocalDate getReturnedDate() {
		return returnedDate;
	}


	public void setReturnedDate(LocalDate returnedDate) {
		this.returnedDate = returnedDate;
	}


	public boolean isOverdue(LocalDate today) {
		//계산 기준일 (반납날짜 또는 오늘)
		LocalDate day = (returnedDate != null) ? returnedDate : today;
		
		//기준일이 마감일(dueDate)보다 늦은면 연체 발생
		return day.isAfter(dueDate);
	}
	
	public int isOverdueDays(LocalDate today) {
		//계산 기준일 (반납날짜 또는 오늘)
		LocalDate day = (returnedDate != null) ? returnedDate : today;
		
		if(day.isAfter(dueDate)) {
			long days = ChronoUnit.DAYS.between(dueDate, day);
			return (int)Math.abs(days);
		}
		
		return 0;
	}
	
			
}
