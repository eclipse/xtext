package org.eclipse.xtext.junit4.parameterized;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import junit.framework.Assert;

import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.resource.XtextResource;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

@InjectWith(XtextInjectorProvider.class)
@RunWith(ParameterizedXtextRunner.class)
@ResourceURIs(files =
{ "src/org/eclipse/xtext/junit4/parameterized/ParameterizedXtextRunner.xtext" })
public class ParameterizedXtextRunnerTest
{

	@InjectParameter
	private XtextResource resource;

	@InjectParameter
	private int from;

	@InjectParameter
	private int to;

	@InjectParameter("from")
	private Offset fromObj;

	@InjectParameter("to")
	private Offset toObj;

	@Inject
	IGrammarAccess injected;
	private static boolean goodOldTesthasRun = false;
	private static int xpectPlain = 0;
	private static int xpectString = 0;
	private static int xpectCsv = 0;
	private static int xpectLines = 0;
	private static int xpectSelect = 0;

	@Test
	public void goodOldTest()
	{
		goodOldTesthasRun = true;
	}

	@Before
	public void before()
	{
		assertNotNull(injected);
	}

	@AfterClass
	public static void after()
	{
		assertTrue(goodOldTesthasRun);
		assertEquals(2, xpectPlain);
		assertEquals(2, xpectString);
		assertEquals(1, xpectCsv);
		assertEquals(1, xpectLines);
		assertEquals(2, xpectSelect);
	}

	@Xpect
	public void plain()
	{
		xpectPlain++;
	}

	@XpectString
	public String string()
	{
		xpectString++;
		return "My long String expectation";
	}

	@XpectCommaSeparatedValues(maxLineWidth = 60)
	public Iterable<String> csv()
	{
		xpectCsv++;
		return Lists.newArrayList("aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg", "hhh", "iii", "jjj", "kkk", "lll",
		    "mmm", "nnn", "ooo", "ppp", "qqq", "rrr");
	}

	@XpectLines
	public Iterable<String> lines()
	{
		xpectLines++;
		return Lists.newArrayList("foo bar baz", "xxx yyy zzz", "aaa bbb ccc");
	}

	@XpectString
	@ParameterSyntax("'from' from=OFFSET 'to' to=OFFSET")
	public String select1()
	{
		xpectSelect++;
		String text = resource.getParseResult().getRootNode().getText();
		return text.substring(from, to);
	}

	@XpectString
	@ParameterSyntax("'from' from=OFFSET 'to' to=OFFSET")
	public String select2()
	{
		xpectSelect++;
		Assert.assertNotNull(fromObj);
		Assert.assertNotNull(toObj);
		String text = resource.getParseResult().getRootNode().getText();
		return text.substring(fromObj.getOffset(), toObj.getOffset());
	}

}
