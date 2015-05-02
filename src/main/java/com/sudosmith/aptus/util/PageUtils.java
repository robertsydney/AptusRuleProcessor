/**
 * 
 */
package com.sudosmith.aptus.util;

import com.sudosmith.aptus.pagination.Page;

/**
 *
 */
public class PageUtils {

	public static Page getPageIndexes(int currentPageNo, int recordPerPage,
			int totalNoOfRecord) {

		Page page = new Page();
		page.setCurrentPageNo(currentPageNo);
		int startIndex = calculateStartIndex(currentPageNo, recordPerPage);
		int startIndexPerPage = startIndex + 1;
		int endIndexPerPage = ((currentPageNo - 1) * recordPerPage)
				+ recordPerPage;
		if (totalNoOfRecord < endIndexPerPage) {
			endIndexPerPage = totalNoOfRecord;

		}

		page.setStartIndex(startIndex);
		page.setStartIndexPerPage(startIndexPerPage);
		page.setEndIndexPerPage(endIndexPerPage);
		page.setTotalNoOfRecord(totalNoOfRecord);
		page.setRecordPerPage(recordPerPage);

		return page;

	}

	public static int calculateStartIndex(int currentPageNo, int recordPerPage) {
		return (currentPageNo - 1) * recordPerPage;
	}

}
