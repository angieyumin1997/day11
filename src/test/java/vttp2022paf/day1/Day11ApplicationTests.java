package vttp2022paf.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import vttp2022paf.day1.models.Comment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import vttp2022paf.day1.models.Game;
import vttp2022paf.day1.repositories.GameRepositary;

@SpringBootTest
class Day11ApplicationTests {

	@Autowired
	private GameRepositary gameRepo;

	@Test
	void shouldReturnAGame() {
		Optional<Game> opt = gameRepo.getGameByGid(10);
		assertTrue(opt.isPresent(),"gid = 10");
	}

	@Test void shouldReturnEmpty(){
		Optional<Game> opt = gameRepo.getGameByGid(10000);
		assertFalse(opt.isPresent(),"gid = 10000");

	}

	@Test
	public void shouldReturn42Comment(){
		List<Comment> results = gameRepo.getCommentsByGid(10);
		assertEquals(42, results.size(),"number of comments for gid=10 is 42");
	}
}
