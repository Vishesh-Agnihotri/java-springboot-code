package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Player;
import com.example.demo.service.PlayerService;

@RestController
public class PlayerController {
	private final PlayerService playerService;

	public PlayerController(PlayerService playerService) {
		super();
		this.playerService = playerService;
	}

	@GetMapping("/allPlayers")
	public List<Player> getAllPlayers() {
		return playerService.getAllPlayers();
	}

	@GetMapping("/playerId/{id}")
	public Player getPlayerById(@PathVariable Long id) {
		return playerService.getById(id);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		playerService.deleteById(id);
		return ResponseEntity.ok("Deleted player");
	}

	@PostMapping("/createPlayer")
	public ResponseEntity<String> createPlayer(@RequestBody Player player) {
		playerService.createPlayer(player);
		return ResponseEntity.ok("Player created");
	}

	@PutMapping("/updatePlayerData/{id}")
	public ResponseEntity<String> updatePlayer(@RequestBody Player player, @PathVariable Long id) {
		playerService.updatePlayer(player, id);
		return ResponseEntity.ok("Player data updated");
	}

	@GetMapping("/playerCount")
	public List<Object[]> getCountTeam() {
		return playerService.getCountTeam();
	}
}
