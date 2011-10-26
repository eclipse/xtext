package org.eclipse.xtext.junit4.parameterized;

import org.eclipse.xtext.junit4.parameterized.ActualCollection;
import org.eclipse.xtext.junit4.parameterized.ExpectationCollection;
import org.junit.Assert;
import org.junit.Test;

public class UnorderedMatchTest
{

	@Test
	public void simple()
	{
		ExpectationCollection exp = new ExpectationCollection();
		ActualCollection act = new ActualCollection();
		exp.setOrdered(false);
		act.setOrdered(false);
		exp.init("foo, bar");
		act.init("foo", "bar");
		Assert.assertTrue(exp.matches(act));
		act.init("bar", "foo");
		Assert.assertTrue(exp.matches(act));
	}

	@Test
	public void multi()
	{
		ExpectationCollection exp = new ExpectationCollection();
		ActualCollection act = new ActualCollection();
		exp.setOrdered(false);
		act.setOrdered(false);
		exp.init("foo, foo");
		act.init("foo", "foo");
		Assert.assertTrue(exp.matches(act));
		act.init("foo");
		Assert.assertFalse(exp.matches(act));
		act.init("foo", "foo", "foo");
		Assert.assertFalse(exp.matches(act));
	}

	@Test
	public void wildcard()
	{
		ExpectationCollection exp = new ExpectationCollection();
		ActualCollection act = new ActualCollection();
		exp.setOrdered(false);
		act.setOrdered(false);
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
		Assert.assertTrue(exp.matches(act));
		act.init("bar");
		Assert.assertFalse(exp.matches(act));
	}

	@Test
	public void negated()
	{
		ExpectationCollection exp = new ExpectationCollection();
		ActualCollection act = new ActualCollection();
		exp.setOrdered(false);
		act.setOrdered(false);
		exp.init("foo, !bar");
		act.init("foo", "baz");
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
}
