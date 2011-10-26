package org.eclipse.xtext.junit4.parameterized;

import java.util.Collection;
import java.util.List;

import org.eclipse.xtext.junit4.parameterized.ActualCollection;
import org.eclipse.xtext.junit4.parameterized.ActualCollection.ActualItem;
import org.eclipse.xtext.junit4.parameterized.ExpectationCollection;
import org.eclipse.xtext.junit4.parameterized.ExpectationCollection.ExpectationItem;
import org.eclipse.xtext.util.Pair;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

public class UnorderedMapTest
{

	private String format(Collection<ExpectationItem> items)
	{
		List<String> result = Lists.newArrayList();
		for (ExpectationItem item : items)
		{
			if (item.isWildcard())
				result.add("...");
			else if (item.isNegated())
				result.add("!" + item.getNormalized());
			else
				result.add(item.getNormalized());
		}
		String r = Joiner.on(",").join(result);
		return result.size() > 1 ? "(" + r + ")" : r;
	}

	private String format(List<Pair<Collection<ExpectationItem>, ActualItem>> map)
	{
		List<String> result = Lists.newArrayList();
		for (Pair<Collection<ExpectationItem>, ActualItem> item : map)
		{
			if ((item.getFirst() == null || item.getFirst().isEmpty()) && item.getSecond() == null)
				result.add("null<>null");
			else if (item.getFirst() == null || item.getFirst().isEmpty())
				result.add("null<>" + item.getSecond().getNormalized());
			else if (item.getSecond() == null)
				result.add(format(item.getFirst()) + "<>null");
			else
				result.add(format(item.getFirst()) + "<>" + item.getSecond().getNormalized());
		}
		return Joiner.on("; ").join(result);
	}

	@Test
	public void simple()
	{
		ExpectationCollection exp = new ExpectationCollection();
		ActualCollection act = new ActualCollection();
		exp.setOrdered(false);
		act.setOrdered(false);
		exp.init("foo, bar");
		act.init("foo", "bar");
		Assert.assertEquals("bar<>bar; foo<>foo", format(exp.map(act)));
		act.init("bar", "foo");
		Assert.assertEquals("bar<>bar; foo<>foo", format(exp.map(act)));
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
		Assert.assertEquals("foo<>foo; foo<>foo", format(exp.map(act)));
		act.init("foo");
		Assert.assertEquals("foo<>foo; foo<>null", format(exp.map(act)));
		act.init("foo", "foo", "foo");
		Assert.assertEquals("foo<>foo; foo<>foo; null<>foo", format(exp.map(act)));
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
		Assert.assertEquals("foo<>foo; ...<>foo", format(exp.map(act)));
		act.init("foo", "baz", "zonk");
		Assert.assertEquals("...<>baz; foo<>foo; ...<>zonk", format(exp.map(act)));
		act.init("foo");
		Assert.assertEquals("foo<>foo", format(exp.map(act)));
		act.init("foo", "bar");
		Assert.assertEquals("...<>bar; foo<>foo", format(exp.map(act)));
		act.init("bar", "foo");
		Assert.assertEquals("...<>bar; foo<>foo", format(exp.map(act)));
		act.init("bar");
		Assert.assertEquals("...<>bar; foo<>null", format(exp.map(act)));
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
		Assert.assertEquals("!bar<>baz; foo<>foo", format(exp.map(act)));
		act.init("foo", "baz", "zonk");
		Assert.assertEquals("!bar<>baz; foo<>foo; !bar<>zonk", format(exp.map(act)));
		act.init("foo");
		Assert.assertEquals("foo<>foo", format(exp.map(act)));
		act.init("foo", "bar");
		Assert.assertEquals("null<>bar; foo<>foo", format(exp.map(act)));
		act.init("bar", "foo");
		Assert.assertEquals("null<>bar; foo<>foo", format(exp.map(act)));
		act.init("bar");
		Assert.assertEquals("null<>bar; foo<>null", format(exp.map(act)));
	}
}
