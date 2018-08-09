package com.inmoment.robot.model;

public class Status {
	private String status;
	private int timeUsed;
	private int timeRemaining;
	private String currentTerm;
	private String currentTermDefinition;
	private int currentPageIndex;
	private int currentTermIndex;
	private boolean hasNextPage;
	private boolean hasPreviousPage;
	private boolean hasNextTerm;
	private boolean hasPreviousTerm;
	private String error;

	public Status() {
	}

	public Status(String status, int timeUsed, int timeRemaining, String currentTerm, String currentTermDefinition,
			int currentPageIndex, int currentTermIndex, boolean hasNextPage, boolean hasPreviousPage,
			boolean hasNextTerm, boolean hasPreviousTerm, String error) {
		super();
		this.status = status;
		this.timeUsed = timeUsed;
		this.timeRemaining = timeRemaining;
		this.currentTerm = currentTerm;
		this.currentTermDefinition = currentTermDefinition;
		this.currentPageIndex = currentPageIndex;
		this.currentTermIndex = currentTermIndex;
		this.hasNextPage = hasNextPage;
		this.hasPreviousPage = hasPreviousPage;
		this.hasNextTerm = hasNextTerm;
		this.hasPreviousTerm = hasPreviousTerm;
		this.error = error;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTimeUsed() {
		return timeUsed;
	}

	public void setTimeUsed(int timeUsed) {
		this.timeUsed = timeUsed;
	}

	public int getTimeRemaining() {
		return timeRemaining;
	}

	public void setTimeRemaining(int timeRemaining) {
		this.timeRemaining = timeRemaining;
	}

	public String getCurrentTerm() {
		return currentTerm;
	}

	public void setCurrentTerm(String currentTerm) {
		this.currentTerm = currentTerm;
	}

	public String getCurrentTermDefinition() {
		return currentTermDefinition;
	}

	public void setCurrentTermDefinition(String currentTermDefinition) {
		this.currentTermDefinition = currentTermDefinition;
	}

	public int getCurrentPageIndex() {
		return currentPageIndex;
	}

	public void setCurrentPageIndex(int currentPageIndex) {
		this.currentPageIndex = currentPageIndex;
	}

	public int getCurrentTermIndex() {
		return currentTermIndex;
	}

	public void setCurrentTermIndex(int currentTermIndex) {
		this.currentTermIndex = currentTermIndex;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public boolean isHasPreviousPage() {
		return hasPreviousPage;
	}

	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}

	public boolean isHasNextTerm() {
		return hasNextTerm;
	}

	public void setHasNextTerm(boolean hasNextTerm) {
		this.hasNextTerm = hasNextTerm;
	}

	public boolean isHasPreviousTerm() {
		return hasPreviousTerm;
	}

	public void setHasPreviousTerm(boolean hasPreviousTerm) {
		this.hasPreviousTerm = hasPreviousTerm;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
