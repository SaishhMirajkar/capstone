package com.capstone.DashboardCapstone.Repositories;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capstone.DashboardCapstone.Entites.Managers;

public interface ManagerRepository extends JpaRepository<Managers, Long> {
	
	@Query("SELECT m.managerId, m.company, SUM(s.streams),SUM(s.royalty) FROM Streams s JOIN s.song so JOIN so.artist a JOIN a.manager m GROUP BY m.managerId ORDER BY SUM(s.royalty) DESC")
	    List<Object[]> findTop5ManagersByTotalRoyalty(PageRequest pageRequest);
}
