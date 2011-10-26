package org.eclipse.xtext.junit4.parameterized;

import java.util.Collection;
import java.util.List;

import org.eclipse.xtext.junit4.parameterized.ActualCollection;
import org.eclipse.xtext.junit4.parameterized.ExpectationCollection;
import org.eclipse.xtext.junit4.parameterized.ActualCollection.ActualItem;
import org.eclipse.xtext.junit4.parameterized.ExpectationCollection.ExpectationItem;
import org.eclipse.xtext.util.Pair;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

public class OrderedMapTest
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
		exp.setOrdered(true);
		act.setOrdered(true);
		exp.init("foo, bar");
		act.init("foo", "bar");
		Assert.assertEquals("foo<>foo; bar<>bar", format(exp.map(act)));
		act.init("bar", "foo");
		Assert.assertEquals("null<>bar; foo<>foo; bar<>null", format(exp.map(act)));
		act.init("bar");
		Assert.assertEquals("foo<>null; bar<>bar", format(exp.map(act)));
		act.init("foo", "bar", "baz");
		Assert.assertEquals("foo<>foo; bar<>bar; null<>baz", format(exp.map(act)));
		act.init("bar", "baz");
		Assert.assertEquals("foo<>null; bar<>bar; null<>baz", format(exp.map(act)));
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
		Assert.assertEquals("foo<>foo; foo<>foo", format(exp.map(act)));
		act.init("foo");
		Assert.assertEquals("foo<>foo; foo<>null", format(exp.map(act)));
		act.init("foo", "foo", "foo");
		Assert.assertEquals("foo<>foo; foo<>foo; null<>foo", format(exp.map(act)));
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
		Assert.assertEquals("foo<>foo; ...<>foo", format(exp.map(act)));
		act.init("foo", "baz", "zonk");
		Assert.assertEquals("foo<>foo; ...<>baz; ...<>zonk", format(exp.map(act)));
		act.init("foo");
		Assert.assertEquals("foo<>foo", format(exp.map(act)));
		act.init("foo", "bar");
		Assert.assertEquals("foo<>foo; ...<>bar", format(exp.map(act)));
		act.init("bar", "foo");
		Assert.assertEquals("null<>bar; foo<>foo", format(exp.map(act)));
		act.init("bar");
		Assert.assertEquals("foo<>null; ...<>bar", format(exp.map(act)));
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
		Assert.assertEquals("foo<>foo; bar<>bar", format(exp.map(act)));
		act.init("foo", "xxx", "bar", "zzz");
		Assert.assertEquals("foo<>foo; ...<>xxx; bar<>bar; ...<>zzz", format(exp.map(act)));
		act.init("foo", "aaa", "xxx", "bar", "bbb", "zzz");
		Assert.assertEquals("foo<>foo; ...<>aaa; ...<>xxx; bar<>bar; ...<>bbb; ...<>zzz", format(exp.map(act)));
		act.init("foo");
		Assert.assertEquals("foo<>foo; bar<>null", format(exp.map(act)));
		act.init("bar");
		Assert.assertEquals("foo<>null; bar<>bar", format(exp.map(act)));
		act.init("bar", "foo");
		Assert.assertEquals("null<>bar; foo<>foo; bar<>null", format(exp.map(act)));
		act.init("bar", "xxx", "foo", "zzz");
		Assert.assertEquals("null<>bar; null<>xxx; foo<>foo; ...<>zzz; bar<>null", format(exp.map(act)));
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
		Assert.assertEquals("foo<>foo; !bar<>foo", format(exp.map(act)));
		act.init("foo", "baz", "zonk");
		Assert.assertEquals("foo<>foo; !bar<>baz; !bar<>zonk", format(exp.map(act)));
		act.init("foo");
		Assert.assertEquals("foo<>foo", format(exp.map(act)));
		act.init("foo", "bar");
		Assert.assertEquals("foo<>foo; null<>bar", format(exp.map(act)));
		act.init("bar", "foo");
		Assert.assertEquals("null<>bar; foo<>foo", format(exp.map(act)));
		act.init("bar");
		Assert.assertEquals("foo<>null; null<>bar", format(exp.map(act)));
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
		Assert.assertEquals("foo<>foo; bar<>bar", format(exp.map(act)));
		act.init("foo", "xxx", "bar", "zzz");
		Assert.assertEquals("foo<>foo; null<>xxx; bar<>bar; null<>zzz", format(exp.map(act)));
		act.init("foo", "xxz", "bar", "zzx");
		Assert.assertEquals("foo<>foo; !xxx<>xxz; bar<>bar; !zzz<>zzx", format(exp.map(act)));
		act.init("foo", "aaa", "xxx", "bar", "bbb", "zzz");
		Assert.assertEquals("foo<>foo; !xxx<>aaa; null<>xxx; bar<>bar; !zzz<>bbb; null<>zzz", format(exp.map(act)));
		act.init("foo", "aaa", "xxz", "bar", "bbb", "zzx");
		Assert.assertEquals("foo<>foo; !xxx<>aaa; !xxx<>xxz; bar<>bar; !zzz<>bbb; !zzz<>zzx", format(exp.map(act)));
		act.init("foo");
		Assert.assertEquals("foo<>foo; bar<>null", format(exp.map(act)));
		act.init("bar");
		Assert.assertEquals("foo<>null; bar<>bar", format(exp.map(act)));
		act.init("bar", "foo");
		Assert.assertEquals("null<>bar; foo<>foo; bar<>null", format(exp.map(act)));
		act.init("bar", "xxz", "foo", "zzx");
		Assert.assertEquals("null<>bar; null<>xxz; foo<>foo; !xxx<>zzx; bar<>null", format(exp.map(act)));
	}

}
