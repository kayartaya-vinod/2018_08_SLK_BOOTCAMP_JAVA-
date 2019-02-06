package com.slk.training.tests;

import org.junit.Assert;
import org.junit.Test;

import com.slk.training.programs.P02_LoopExample;

public class UTC_01_LoopExampleTests {

	
	@Test
	public void testBin2Dec_01() {
		long expected = 32;
		long actual = P02_LoopExample.bin2dec(100000);

		Assert.assertEquals(expected, actual);

	}
	
	@Test
	public void testDec2Bin_01() {
		long expected = 1111;
		long actual = P02_LoopExample.dec2bin(15);

		Assert.assertEquals(expected, actual);

	}

	@Test
	public void testDec2Bin_02() {
		long expected = 100000;
		long actual = P02_LoopExample.dec2bin(32);

		Assert.assertEquals(expected, actual);

	}
}
