package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

	@Query("SELECT p.team, COUNT(p) FROM Player p GROUP BY p.team")
	public List<Object[]> getCountTeam();
}
