package com.example.monappli.players;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.example.monappli.exceptions.NullIDException;

@RunWith(MockitoJUnitRunner.class)
public class PlayerServiceTest {
	
	@InjectMocks
	private PlayerService playerservice;
	
	@Mock
	private PlayersRepository playersRepository;
	
	@Mock
	private Player p;
	
	
	/////////////////////////////////////////////////////////
	//                Test on SAVE() Method                //
	/////////////////////////////////////////////////////////

	@Test
	public void shouldSaveP_whenPlayerExist() {
		// Given
		p.setId(1L);
		p.setName("Pierre");
		p.setId_team(36L);
		p.setPosition("Unknown");
		p.setDiet("Omnivorous");

		when(playersRepository.save(p)).thenReturn(1);

		// When
		int result = playerservice.save(p);

		// Then
		Mockito.verify(this.playersRepository, Mockito.times(1)).save(p);
		Assert.assertEquals("1 ligne doit être insérée", 1, result);
	}

	/////////////////////////////////////////////////////////
	//              Test on UPDATE() Method                //
	/////////////////////////////////////////////////////////

	@Test
	public void shouldUpdateP_whenPlayerExist() {
		// Given
		p.setId(1L);
		p.setName("Pierre");
		p.setId_team(36L);
		p.setPosition("Unknown");
		p.setDiet("Omnivorous");

		when(playersRepository.update(p)).thenReturn(1);

		// When
		int result = playerservice.update(p);

		// Then
		Mockito.verify(this.playersRepository, Mockito.times(1)).update(p);
		Assert.assertEquals("1 ligne doit être mise à jour", 1, result);
	}

	/////////////////////////////////////////////////////////
	//              Test on DELETE() Method                //
	/////////////////////////////////////////////////////////

	@Test // Nominal Case : all is good
	public void shouldDeleteP_whenPlayerExist() throws NullIDException {
		// Given
		p.setId(1L);
		p.setName("Pierre");
		p.setId_team(36L);
		p.setPosition("Unknown");
		p.setDiet("Omnivorous");

		when(playersRepository.delete(p.getId())).thenReturn(1);

		// When
        final int result = playerservice.delete(p.getId());

		// Then
		Mockito.verify(this.playersRepository, Mockito.times(1)).delete(p.getId());
		Assert.assertEquals("1 ligne doit être supprimé", 1, result);
	}

	@Test (expected = NullIDException.class)
	public void shouldDoNothing_whenPlayerNotExist() throws NullIDException {
		// Given
		when(playersRepository.delete(null)).thenReturn(0);

		// When
		playerservice.delete(null);		

		// Then
		Mockito.verify(this.playersRepository, Mockito.times(1)).delete(p.getId());
	}
}
