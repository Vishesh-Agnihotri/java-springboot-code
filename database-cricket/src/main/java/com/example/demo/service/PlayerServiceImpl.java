package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.PlayerNotFound;
import com.example.demo.model.Player;
import com.example.demo.repository.PlayerRepository;

@Service
public class PlayerServiceImpl implements PlayerService {
	private final PlayerRepository playerRepository;

	public PlayerServiceImpl(PlayerRepository playerRepository) {
		super();
		this.playerRepository = playerRepository;
	}

	@Override
	public List<Player> getAllPlayers() {
		return playerRepository.findAll();
	}

	@Override
	public Player getById(Long id) {
		return playerRepository.findById(id).orElseThrow(() -> new PlayerNotFound("Player is not present."));
	}

	@Override
	public void deleteById(Long id) {
		if (playerRepository.existsById(id)) {
			playerRepository.deleteById(id);
		}
	}

	@Override
	public void createPlayer(Player player) {
		playerRepository.save(player);
	}

	@Override
	public void updatePlayer(Player player, Long id) {
		Player existingPlayer = playerRepository.findById(id)
				.orElseThrow(() -> new PlayerNotFound("Player is not present."));

		if (existingPlayer != null) {
			existingPlayer.setId(player.getId());
			existingPlayer.setName(player.getName());
			existingPlayer.setRole(player.getRole());
			existingPlayer.setRuns(player.getRuns());
			existingPlayer.setTeam(player.getTeam());
		}
	}

	@Override
	public List<Object[]> getCountTeam() {
		return playerRepository.getCountTeam();
	}
}
