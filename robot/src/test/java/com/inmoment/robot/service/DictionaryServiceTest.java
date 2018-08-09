package com.inmoment.robot.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class DictionaryServiceTest {

	@Test
	public void testGetDefinition() {
		DictionaryService dictionaryService = new DictionaryService();
		String definition = dictionaryService.getDefinition("abstain");
		final String expectedDefinition = "To hold one's self aloof; to forbear or refrain voluntarily,"
				+ "and especially from an indulgence of the passions or appetites; --with from.Not a "
				+ "few abstained from voting. Macaulay.Who abstains from meat that is not gaunt Shak.";
		//assertEquals(expectedDefinition, definition);
	}
}