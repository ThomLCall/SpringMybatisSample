package com.example.monappli.children;

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
public class ChildServiceTest {

	@InjectMocks
	private ChildService childservice;

	@Mock
	private ChildRepository childRepository;

	@Mock
	private Child c;

	/////////////////////////////////////////////////////////
	//                Test on SAVE() Method                //
	/////////////////////////////////////////////////////////

	@Test
	public void shouldSaveC_whenChildExist() {
		// Given
		c.setId(5L);
		c.setName("Oedipe");

		when(childRepository.save(c)).thenReturn(2);

		// When
		int result = childservice.save(c);

		// Then
		Mockito.verify(this.childRepository, Mockito.times(1)).save(c);
		Assert.assertEquals("2 ligne doivent être insérées", 2, result);
	}

	/////////////////////////////////////////////////////////
	//               Test on UPDATE() Method               //
	/////////////////////////////////////////////////////////

	@Test
	public void shouldUpdateC_whenChildExist() {
		// Given
		c.setId(8L);
		c.setName("Ahmed");

		when(childRepository.update(c)).thenReturn(1);

		// When
		int result = childservice.update(c);

		// Then
		Mockito.verify(this.childRepository, Mockito.times(1)).update(c);
		Assert.assertEquals("1 ligne doit être mise à jour", 1, result);
	}

	/////////////////////////////////////////////////////////
	//               Test on DELETE() Method               //
	/////////////////////////////////////////////////////////

	@Test // Nominal Case : all is good
	public void shouldDeleteC_whenChildExist() {
		// Given		
		c.setId(5L);
		c.setName("Oedipe");
		
		when(childRepository.delete(c.getId())).thenReturn(1);

		// When
		int result;
		try {
			result = childservice.delete(c.getId());
		} catch (NullIDException e) {
			result = -1;
			e.printStackTrace();
		}

		// Then
		Mockito.verify(this.childRepository, Mockito.times(1)).delete(c.getId());
		Assert.assertEquals("1 ligne doit être supprimé", 1, result);
	}
	
	
	@Test 
	public void shouldDoNothing_whenChildNotExist() {
		// Given

		when(childRepository.delete(c.getId())).thenReturn(0);

        // When
        int result;
		try {
			result = childservice.delete(c.getId());
		} catch (NullIDException e) {			
			e.printStackTrace();
			result = -1;
		}        

        // Then
        Mockito.verify(this.childRepository, Mockito.times(1)).delete(c.getId());
        Assert.assertEquals( "La team n'existe pas", 0, result ); 
	}

}