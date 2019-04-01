package com.example.monappli.players;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.example.monappli.teams.NullIDException;

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
	public void shouldSaveT_whenTeamExist() {
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
	public void shouldUpdateT_whenTeamExist() {
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
		Mockito.verify(this.playersRepository, Mockito.times(1)).update(t);
		Assert.assertEquals("1 ligne doit être mise à jour", 1, result);
	}

	/////////////////////////////////////////////////////////
	//              Test on DELETE() Method                //
	/////////////////////////////////////////////////////////

	@Test // Nominal Case : all is good
	public void shouldDeleteT_whenTeamExist() {
		// Given
		p.setId(1L);
		p.setName("Pierre");
		p.setId_team(36L);
		p.setPosition("Unknown");
		p.setDiet("Omnivorous");

		when(playersRepository.delete(p.getId())).thenReturn(1);

		// When
		int result;
		try {
			result = playerservice.delete(p.getId());
		} catch (NullIDException e) {
			result = -1;// send an absurd result to give the test error message
			e.printStackTrace();
		}

		// Then
		Mockito.verify(this.playersRepository, Mockito.times(1)).delete(p.getId());
		Assert.assertEquals("1 ligne doit être supprimé", 1, result);
	}

	@Test // (expected = NullIDException.class)
	public void shouldDoNothing_whenTeamNotExist() {
		// Given
		when(playersRepository.delete(p.getId())).thenReturn(0);

		// When
		int result;
		try {
			result = playerservice.delete(p.getId());
		} catch (NullIDException e) {
			e.printStackTrace();
			result = -1;
		}

		// Then
		Mockito.verify(this.playersRepository, Mockito.times(1)).delete(p.getId());
		Assert.assertEquals("La team n'existe pas", 0, result);
	}
}
