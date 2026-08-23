package com.example.demo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.model.Player;
import com.example.demo.repository.PlayerRepository;
import com.example.demo.service.PlayerService;
import com.example.demo.service.PlayerServiceImpl;

@ExtendWith(MockitoExtension.class)
class PlayerServiceTest {

	@Mock
	private PlayerRepository playerRepository;

	@InjectMocks
	private PlayerServiceImpl playerService;

	@Test
	void shouldReturnAllPlayers() {

		// Arrange
		Player p1 = new Player();
		p1.setId(1L);
		p1.setName("Virat");
		p1.setTeam("India");
		p1.setRole("Batsman");
		p1.setRuns(100000);

		Player p2 = new Player();
		p2.setId(2L);
		p2.setName("Smith");
		p2.setTeam("Australia");
		p1.setRole("Batsman");
		p1.setRuns(100000);

		List<Player> players = Arrays.asList(p1, p2);

		when(playerRepository.findAll()).thenReturn(players);

		// Act
		List<Player> result = playerService.getAllPlayers();

		// Assert
		assertEquals(2, result.size());
		assertEquals("Virat", result.get(0).getName());
		assertEquals("Smith", result.get(1).getName());

		// Verify repository was called
		verify(playerRepository, times(1)).findAll();
	}

	@Test
	void shouldThrowExceptionWhenPlayerNotFound() {

		// Arrange
		when(playerRepository.findById(100L)).thenReturn(Optional.empty());

		// Act + Assert
		RuntimeException exception = assertThrows(RuntimeException.class, () -> playerService.getById(100L));

		assertEquals("Player not found", exception.getMessage());

		verify(playerRepository).findById(100L);
	}

	@Test
	void shouldReturnTeamPlayerCount() {

		// Arrange
		List<Object[]> teamCounts = Arrays.asList(new Object[] { "India", 3L }, new Object[] { "Australia", 2L },
				new Object[] { "England", 4L });

		when(playerRepository.getCountTeam()).thenReturn(teamCounts);

		// Act
		List<Object[]> result = playerService.getCountTeam();

		// Assert
		assertEquals(3, result.size());

		verify(playerRepository, times(1)).getCountTeam();
	}
}