package com.search.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.search.entity.Search;

@Component
public class SearchRepositoryCustomImpl implements SearchRepositoryCustom {
	
	@Autowired
	private EntityManager Manager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Search> search(String userId, String userName, Integer deptCd, Date startDate, Date endDate) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT g From Search g WHERE ");
		boolean andFlg = false;
		boolean userIdFlg = false;
		if (!"".equals(userId) && userId != null) {
			sql.append(" g.userId LIKE :userId ");
			userIdFlg = true;
			andFlg = true;
		}
		boolean userNameFlg = false;
		if (!"".equals(userName) && userName != null) {
			if (andFlg) sql.append(" AND ");
			sql.append("g.userName LIKE :userName ");
			userNameFlg = true;
			andFlg = true;
		}
		boolean deptCdFlg = false;
		if (deptCd != 0) {
			if (andFlg) sql.append(" AND ");
			sql.append("g.deptCd = :deptCd ");
			deptCdFlg = true;
			andFlg = true;
		}
		boolean startDateFlg = false;
		if (startDate != null) {
			if (andFlg) sql.append(" AND ");
			sql.append("g.entry_date >= :startDate ");
			startDateFlg = true;
			andFlg = true;
		}
		boolean endDateFlg = false;
		if (endDate != null) {
			if (andFlg) sql.append(" AND ");
			sql.append("g.entry_date <= :endDate ");
			endDateFlg = true;
			andFlg = true;
		}
		Query query = Manager.createQuery(sql.toString());
		if (userIdFlg) query.setParameter("userId", "%" + userId + "%");
		if (userNameFlg) query.setParameter("userName", "%" + userName + "%");
		if (deptCdFlg) query.setParameter("deptCd", deptCd);
		if (startDateFlg) query.setParameter("startDate", startDate);
		if (endDateFlg) query.setParameter("endDate", endDate);
		return query.getResultList();
	}
}
