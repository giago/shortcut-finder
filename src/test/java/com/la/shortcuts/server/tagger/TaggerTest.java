package com.la.shortcuts.server.tagger;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class TaggerTest {
	
	@Test
	public void shouldGetMeaningfulWordWithNullSource() {
		String source = null;
		ArrayList<String> result = Tagger.tag(source);
		Assert.assertNotNull(result);
	}
	
	@Test
	public void shouldGetMeaningfulWordWithEmptySource() {
		String source = "";
		ArrayList<String> result = Tagger.tag(source);
		Assert.assertNotNull(result);
	}

	@Test
	public void shouldGetMeaningfulWord1() {
		String source = "unlocking android is and the lock";
		ArrayList<String> result = Tagger.tag(source);
		Assert.assertNotNull(result);
		Assert.assertEquals(3, result.size());
		Assert.assertEquals("unlocking", result.get(0));
		Assert.assertEquals("android", result.get(1));
		Assert.assertEquals("lock", result.get(2));
	}
	
	@Test
	public void shouldGetMeaningfulWord2() {
		String source = "modify it under the terms of the GNU Lesser General Public";
		ArrayList<String> result = Tagger.tag(source);
		Assert.assertNotNull(result);
		Assert.assertEquals(7, result.size());
	}
	
	@Test
	public void shouldGetAllLowerCaseWords() {
		String source = "Modify uNDer GNU";
		ArrayList<String> result = Tagger.tag(source);
		Assert.assertNotNull(result);
		Assert.assertEquals(3, result.size());
		Assert.assertEquals("modify", result.get(0));
		Assert.assertEquals("under", result.get(1));
		Assert.assertEquals("gnu", result.get(2));
	}
	
	@Test
	public void shouldGetOnlyUniqueTag() {
		String source = "modify under modify uNder";
		ArrayList<String> result = Tagger.tag(source);
		Assert.assertNotNull(result);
		Assert.assertEquals(2, result.size());
		Assert.assertEquals("modify", result.get(0));
		Assert.assertEquals("under", result.get(1));
	}

	@Test
	public void shouldGetALimitedNumberOfTag() {
		String source = "one two tre four five";
		checkLimit(source, 1);
		checkLimit(source, 2);
		checkLimit(source, 3);
		checkLimit(source, 4);
		checkLimit(source, 5);
	}

	@Test
	public void shouldGetALimitedExcludingNotConsideredKeys() {
		String source = "one in two";
		checkLimit(source, 2);
	}
	
	private void checkLimit(String textToTag, int limit) {
		ArrayList<String> result = Tagger.tag(textToTag, limit);
		Assert.assertNotNull(result);
		Assert.assertEquals(limit, result.size());
	}
	

}
