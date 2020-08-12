package com.lionsclub.springboot.thymeleaf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lionsclub.springboot.thymeleaf.entity.ServiceCategory;

public interface ServiceCategoryRepository extends JpaRepository<ServiceCategory, Integer> {

	@Query("SELECT m FROM ServiceCategory m WHERE m.ClubID = ?1")
	public List<ServiceCategory> getServiceUsingClubID(String ClubID);

	@Query("Select m.ClubID FROM ServiceCategory m WHERE m.ClubCatogery= :filterData")
	public List<String> getClubIDListUsingCateg(@Param("filterData") String filterData);
	
}
