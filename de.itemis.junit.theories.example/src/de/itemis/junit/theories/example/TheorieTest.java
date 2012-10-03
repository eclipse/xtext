package de.itemis.junit.theories.example;

import org.junit.Assert;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class TheorieTest {

	@DataPoint
	public static String a = "a";

	@DataPoint
	public static String b = "bb";

	@DataPoint
	public static String c = "ccc";

	@Theory
	public void stringTest(String x, String y) {
		Assert.assertTrue(x.length() >= 1);
		System.out.println(x + " " + y);
	}
}