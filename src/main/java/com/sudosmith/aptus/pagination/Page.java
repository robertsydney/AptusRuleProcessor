/**
 * 
 */
package com.sudosmith.aptus.pagination;

/**

 *
 */
public class Page {

	public Page() {
		// TODO Auto-generated constructor stub
	}

	public Page(int currentPageNo, int recordPerPage, int startIndex,
			int totalNoOfRecord, int startIndexPerPage, int endIndexPerPage) {
		super();
		this.currentPageNo = currentPageNo;
		this.recordPerPage = recordPerPage;
		this.startIndex = startIndex;
		this.totalNoOfRecord = totalNoOfRecord;
		this.startIndexPerPage = startIndexPerPage;
		this.endIndexPerPage = endIndexPerPage;
	}

	private int currentPageNo = 1;

	private int recordPerPage = 4;

	private int startIndex = 0;

	private int totalNoOfRecord;

	private int startIndexPerPage;

	private int endIndexPerPage;

	/**
	 * @return the currentPageNo
	 */
	public int getCurrentPageNo() {
		return currentPageNo;
	}

	/**
	 * @param currentPageNo
	 *            the currentPageNo to set
	 */
	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	/**
	 * @return the recordPerPage
	 */
	public int getRecordPerPage() {
		return recordPerPage;
	}

	/**
	 * @param recordPerPage
	 *            the recordPerPage to set
	 */
	public void setRecordPerPage(int recordPerPage) {
		this.recordPerPage = recordPerPage;
	}

	/**
	 * @return the startIndex
	 */
	public int getStartIndex() {
		return startIndex;
	}

	/**
	 * @param startIndex
	 *            the startIndex to set
	 */
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	/**
	 * @return the totalNoOfRecord
	 */
	public int getTotalNoOfRecord() {
		return totalNoOfRecord;
	}

	/**
	 * @param totalNoOfRecord
	 *            the totalNoOfRecord to set
	 */
	public void setTotalNoOfRecord(int totalNoOfRecord) {
		this.totalNoOfRecord = totalNoOfRecord;
	}

	/**
	 * @return the startIndexPerPage
	 */
	public int getStartIndexPerPage() {
		return startIndexPerPage;
	}

	/**
	 * @param startIndexPerPage
	 *            the startIndexPerPage to set
	 */
	public void setStartIndexPerPage(int startIndexPerPage) {
		this.startIndexPerPage = startIndexPerPage;
	}

	/**
	 * @return the endIndexPerPage
	 */
	public int getEndIndexPerPage() {
		return endIndexPerPage;
	}

	/**
	 * @param endIndexPerPage
	 *            the endIndexPerPage to set
	 */
	public void setEndIndexPerPage(int endIndexPerPage) {
		this.endIndexPerPage = endIndexPerPage;
	}

}
