package com.example.monappli.teams;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.example.monappli.players.Player;

@RunWith( MockitoJUnitRunner.class)
public class TeamServiceTest {
	
	@InjectMocks
	private TeamService teamservice;
	
	@Mock
	private TeamRepository teamRepository;
	
	@Mock
	private Team t;
	
	@Mock
	private Player p;
	
	@Test
	public void shouldDeleteT() {
		// Given
        t.setId(36L);
        t.setName("TestTeam");

        // When
        teamservice.delete(t.getId());

        // Then
        Mockito.verify( this.teamRepository, Mockito.times( 1 )).delete(t.getId());;
	}
 
	
	@Test
	public void shouldDeleteP_whenAtLeastOnePExistinTeam() {
		// Given
        t.setId(36L);
        t.setName("TestTeam");
        
        p.setId(3L);
        p.setName("Jack");
        p.setId_team(t.getId());
        p.setPosition("Undefined");        
        p.setDiet("Undefined");
        

        // When
        teamservice.delete(t.getId());

        // Then
        Mockito.verify( this.teamRepository, Mockito.times( 1 )).delete(t.getId());;
	}
	
	
 
}
