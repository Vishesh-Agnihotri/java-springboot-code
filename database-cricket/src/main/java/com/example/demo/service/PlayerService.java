package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.model.Player;

public interface PlayerService {

	public List<Player> getAllPlayers();

	public Player getById(Long id);

	public void deleteById(Long id);

	public void createPlayer(Player player);

	public void updatePlayer(Player player, Long id);
	
	public List<Object[]> getCountTeam();
}
