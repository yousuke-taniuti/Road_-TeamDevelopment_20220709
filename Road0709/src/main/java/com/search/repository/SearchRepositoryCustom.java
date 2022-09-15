package com.search.repository;

import java.util.Date;
import java.util.List;

import com.search.entity.Search;

public interface SearchRepositoryCustom {
	public List<Search> search(String userId, String userName, Integer deptCd, Date startDate, Date endDate);

}
