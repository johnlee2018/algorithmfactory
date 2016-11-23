package com.ljc.pojo;

public class PagePojo {
	private int page = 1;
	private int pageCount = 2;
	private int start = 0;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
		if (page == 0) {
			start = -1;
		} else {
			this.start = (page - 1) * pageCount;
		}
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

}
