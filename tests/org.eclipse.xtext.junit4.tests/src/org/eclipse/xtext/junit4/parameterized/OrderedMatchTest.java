package org.eclipse.xtext.junit4.parameterized;

import org.eclipse.xtext.junit4.parameterized.ActualCollection;
import org.eclipse.xtext.junit4.parameterized.ExpectationCollection;
import org.junit.Assert;
import org.junit.Test;

public class OrderedMatchTest
{

	@Test
	public void simple()
	{
		ExpectationCollection exp = new ExpectationCollection();
		ActualCollection act = new ActualCollection();
		exp.setOrdered(true);
		act.setOrdered(true);
		exp.init("foo, bar");
		act.init("foo", "bar");
		Assert.assertTrue(exp.matches(act));
		act.init("bar", "foo");
		Assert.assertFalse(exp.matches(act));
		act.init("bar");
		Assert.assertFalse(exp.matches(act));
		act.init("foo", "bar", "baz");
		Assert.assertFalse(exp.matches(act));
		act.init("bar", "baz");
		Assert.assertFalse(exp.matches(act));
	}

	@Test
	public void multi()
	{
		ExpectationCollection exp = new ExpectationCollection();
		ActualCollection act = new ActualCollection();
		exp.setOrdered(true);
		act.setOrdered(true);
		exp.init("foo, foo");
		act.init("foo", "foo");
		Assert.assertTrue(exp.matches(act));
		act.init("foo");
		Assert.assertFalse(exp.matches(act));
		act.init("foo", "foo", "foo");
		Assert.assertFalse(exp.matches(act));
	}

	@Test
	public void wildcard1()
	{
		ExpectationCollection exp = new ExpectationCollection();
		ActualCollection act = new ActualCollection();
		exp.setOrdered(true);
		act.setOrdered(true);
		exp.init("foo, ...");
		act.init("foo", "foo");
		Assert.assertTrue(exp.matches(act));
		act.init("foo", "baz", "zonk");
		Assert.assertTrue(exp.matches(act));
		act.init("foo");
		Assert.assertTrue(exp.matches(act));
		act.init("foo", "bar");
		Assert.assertTrue(exp.matches(act));
		act.init("bar", "foo");
		Assert.assertFalse(exp.matches(act));
		act.init("bar");
		Assert.assertFalse(exp.matches(act));
	}

	@Test
	public void wildcard2()
	{
		ExpectationCollection exp = new ExpectationCollection();
		ActualCollection act = new ActualCollection();
		exp.setOrdered(true);
		act.setOrdered(true);
		exp.init("foo, ..., bar, ...");
		act.init("foo", "bar");
		Assert.assertTrue(exp.matches(act));
		act.init("foo", "xxx", "bar", "zzz");
		Assert.assertTrue(exp.matches(act));
		act.init("foo", "aaa", "xxx", "bar", "bbb", "zzz");
		Assert.assertTrue(exp.matches(act));
		act.init("foo");
		Assert.assertFalse(exp.matches(act));
		act.init("bar");
		Assert.assertFalse(exp.matches(act));
		act.init("bar", "foo");
		Assert.assertFalse(exp.matches(act));
		act.init("bar", "xxx", "foo", "zzz");
		Assert.assertFalse(exp.matches(act));
	}

	@Test
	public void negated1()
	{
		ExpectationCollection exp = new ExpectationCollection();
		ActualCollection act = new ActualCollection();
		exp.setOrdered(true);
		act.setOrdered(true);
		exp.init("foo, !bar");
		act.init("foo", "foo");
		Assert.assertTrue(exp.matches(act));
		act.init("foo", "baz", "zonk");
		Assert.assertTrue(exp.matches(act));
		act.init("foo");
		Assert.assertTrue(exp.matches(act));
		act.init("foo", "bar");
		Assert.assertFalse(exp.matches(act));
		act.init("bar", "foo");
		Assert.assertFalse(exp.matches(act));
		act.init("bar");
		Assert.assertFalse(exp.matches(act));
	}

	@Test
	public void negated2()
	{
		ExpectationCollection exp = new ExpectationCollection();
		ActualCollection act = new ActualCollection();
		exp.setOrdered(true);
		act.setOrdered(true);
		exp.init("foo, !xxx, bar, !zzz");
		act.init("foo", "bar");
		Assert.assertTrue(exp.matches(act));
		act.init("foo", "xxx", "bar", "zzz");
		Assert.assertFalse(exp.matches(act));
		act.init("foo", "xxz", "bar", "zzx");
		Assert.assertTrue(exp.matches(act));
		act.init("foo", "aaa", "xxx", "bar", "bbb", "zzz");
		Assert.assertFalse(exp.matches(act));
		act.init("foo", "aaa", "xxz", "bar", "bbb", "zzx");
		Assert.assertTrue(exp.matches(act));
		act.init("foo");
		Assert.assertFalse(exp.matches(act));
		act.init("bar");
		Assert.assertFalse(exp.matches(act));
		act.init("bar", "foo");
		Assert.assertFalse(exp.matches(act));
		act.init("bar", "xxz", "foo", "zzx");
		Assert.assertFalse(exp.matches(act));
	}

}
