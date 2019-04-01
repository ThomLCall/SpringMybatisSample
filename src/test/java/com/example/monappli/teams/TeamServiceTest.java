package com.example.monappli.teams;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.example.monappli.players.PlayersRepository;

@RunWith( MockitoJUnitRunner.class)
public class TeamServiceTest {
	
	@InjectMocks
	private TeamService teamservice;
	
	@Mock
	private TeamRepository teamRepository;
	
	@Mock
	private PlayersRepository playersRepository;
	
	@Mock
	private Team t;
	

	/////////////////////////////////////////////////////////
	//                Test on SAVE() Method                //
	/////////////////////////////////////////////////////////
	
	@Test
	public void shouldSaveT_whenTeamExist() {
		// Given
        t.setId(36L);
        t.setName("TestTeam");

        when(teamRepository.save(t)).thenReturn(1);

        // When
        int result = teamservice.save(t);        

        // Then
        Mockito.verify(this.teamRepository, Mockito.times(1)).save(t);
        Assert.assertEquals( "1 ligne doit être insérée", 1, result ); 
	} 
	
	
	/////////////////////////////////////////////////////////
	//              Test on UPDATE() Method                //
	/////////////////////////////////////////////////////////
	
	@Test
	public void shouldUpdateT_whenTeamExist() {
		// Given
        t.setId(36L);
        t.setName("TestTeam");

        when(teamRepository.update(t)).thenReturn(1);

        // When
        int result = teamservice.update(t);        

        // Then
        Mockito.verify(this.teamRepository, Mockito.times(1)).update(t);
        Assert.assertEquals( "1 ligne doit être mise à jour", 1, result ); 
	} 
	
	
	/////////////////////////////////////////////////////////
	//              Test on DELETE() Method                //
	/////////////////////////////////////////////////////////
	
	@Test //Nominal Case : all is good
	public void shouldDeleteT_whenTeamExist() {
		//// Given
		/**Reproduction of the implementations that we need for the delete()
		 * 
		 */
        t.setId(36L);
        t.setName("TestTeam");
        
        /**Simulation of the delete method
         * "Mocker" the behavior with when()
         * And predict the expected result with thenReturn()
         */
        when(teamRepository.delete(t.getId())).thenReturn(1);

        //// When
        int result;
		try {
			result = teamservice.delete(t.getId());
		} catch (NullIDException e) {
			result = -1;// send an absurd result to give the test error message
			e.printStackTrace();
		}
		
        //// Then
        // Verify teamRepository used 1 time
        Mockito.verify(this.teamRepository, Mockito.times(1)).delete(t.getId());
        // result verification
        Assert.assertEquals( "1 ligne doit être supprimé", 1, result ); 
        } 
	
	@Test //(expected = NullIDException.class)
	public void shouldDoNothing_whenTeamNotExist() {
		// Given
		       
		//doThrow(new NullIDException("Error occurred")).when(teamRepository).delete(t.getId());
		when(teamRepository.delete(t.getId())).thenReturn(0);

        // When
        int result;
		try {
			result = teamservice.delete(t.getId());
			//Assertions.fail("Il n'y avait pas de team");
		} catch (NullIDException e) {			
			e.printStackTrace();
			result = -1;
		}        

        // Then
        Mockito.verify(this.teamRepository, Mockito.times(1)).delete(t.getId());
        Assert.assertEquals( "La team n'existe pas", 0, result ); 
	}
	
	
	
 
}
