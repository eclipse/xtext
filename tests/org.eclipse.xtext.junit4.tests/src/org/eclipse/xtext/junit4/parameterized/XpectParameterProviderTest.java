package org.eclipse.xtext.junit4.parameterized;

import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.parameterized.IParameterProvider.IExpectation;
import org.eclipse.xtext.junit4.parameterized.IParameterProvider.IParameterAcceptor;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.Exceptions;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(value = XtextInjectorProvider.class)
public class XpectParameterProviderTest
{
	public static class TestTestCase
	{
		public void meth()
		{
		}

		@Parameter(syntax = "'at' myOffset=OFFSET")
		public void offsetMeth()
		{
		}

		@Parameter(syntax = "('text' myText=TEXT)? ('int' myInt=INT)? ('string' myString=STRING)? ('id' myId=ID)?")
		public void optionalMeth()
		{
		}
	}

	@Inject
	private ParseHelper<Grammar> parseHelper;
	@Inject
	private ValidationTestHelper validationHelper;

	@Inject
	private XpectParameterProvider parameterProvider;
	private String model = "grammar foo.Bar import 'http://www.eclipse.org/emf/2002/Ecore' as ecore\n generate bar 'http://bar.com/'\n{0}\n foo:val='bar';";

	private String parse(String text)
	{
		String model = this.model.replace("{0}", text);
		Grammar grammar;
		try
		{
			grammar = parseHelper.parse(model);
			validationHelper.assertNoIssues(grammar);
			final List<String> result = Lists.newArrayList();
			parameterProvider.collectParameters(TestTestCase.class, (XtextResource) grammar.eResource(),
			    new IParameterAcceptor()
			    {

				    public void acceptImportURI(URI uri)
				    {
					    result.add("import " + uri);
				    }

				    public void acceptTest(String title, String method, Object[][] params, IExpectation expectation,
				        boolean ignore)
				    {
					    StringBuilder str = new StringBuilder();
					    if (ignore)
						    str.append("(ignored) ");
					    if (title != null)
						    str.append("'" + title + "' ");
					    List<String> p1 = Lists.newArrayList();
					    for (Object[] o : params)
					    {
						    List<String> p2 = Lists.newArrayList();
						    for (Object x : o)
						    {
							    if (x == null)
								    p2.add("null");
							    else if (x instanceof Resource)
								    p2.add("Res");
							    else if (x instanceof Map<?, ?>)
								    p2.add("Map");
							    else if (x instanceof Integer)
								    p2.add("Int");
							    else
								    p2.add(x.getClass().getSimpleName());
						    }
						    p1.add(Joiner.on(", ").join(p2));
					    }
					    str.append(method + "(" + Joiner.on(" | ").join(p1) + ")");
					    if (expectation != null)
						    str.append(" --> " + expectation.getExpectation().replace("\n", "\\n"));
					    result.add(str.toString());
				    }

			    });
			return Joiner.on("\n").join(result);
		} catch (Exception e)
		{
			Exceptions.throwUncheckedException(e);
			return "";
		}
	}

	private String params(String text)
	{
		String model = this.model.replace("{0}", text);
		Grammar grammar;
		try
		{
			grammar = parseHelper.parse(model);
			validationHelper.assertNoIssues(grammar);
			final List<String> result = Lists.newArrayList();
			parameterProvider.collectParameters(TestTestCase.class, (XtextResource) grammar.eResource(),
			    new IParameterAcceptor()
			    {

				    public void acceptImportURI(URI uri)
				    {
				    }

				    public void acceptTest(String title, String method, Object[][] params, IExpectation expectation,
				        boolean ignore)
				    {
					    XtextResource res = (XtextResource) params[0][0];
					    @SuppressWarnings("unchecked")
					    Map<String, String> map = (Map<String, String>) params[0][1];
					    List<String> p2 = Lists.newArrayList();
					    String text = res.getParseResult().getRootNode().getText();
					    for (Map.Entry<String, String> e : map.entrySet())
					    {
						    if (e.getKey().toLowerCase().contains("offset"))
						    {
							    int offs = Integer.parseInt(e.getValue());
							    String val = "'" + text.substring(offs - 3, offs) + "!" + text.substring(offs, offs + 3) + "'";
							    p2.add(e.getKey() + " at " + val.replace("\n", "\\n"));
						    } else
							    p2.add(e.getKey() + " = " + e.getValue());
					    }
					    result.add(method + "(" + Joiner.on(", ").join(p2) + ")");
				    }
			    });
			return Joiner.on("\n").join(result);
		} catch (Exception e)
		{
			Exceptions.throwUncheckedException(e);
			return "";
		}
	}

	private String expectation(String text)
	{
		String model = this.model.replace("{0}", text);
		int before = this.model.indexOf("{0}");
		int after = this.model.length() - before - 3;
		Grammar grammar;
		try
		{
			grammar = parseHelper.parse(model);
			validationHelper.assertNoIssues(grammar);
			XtextResource resource = (XtextResource) grammar.eResource();
			final StringBuffer result = new StringBuffer(resource.getParseResult().getRootNode().getText());
			parameterProvider.collectParameters(TestTestCase.class, resource, new IParameterAcceptor()
			{

				public void acceptImportURI(URI uri)
				{
				}

				public void acceptTest(String title, String method, Object[][] params, IExpectation expectation, boolean ignore)
				{
					String replace;
					if (expectation.getIndentation() != null)
						replace = expectation.getIndentation() + "xxx";
					else
						replace = "xxx";
					result.replace(expectation.getOffset(), expectation.getOffset() + expectation.getLength(), replace);
				}
			});
			return result.substring(before, result.length() - after);
		} catch (Exception e)
		{
			Exceptions.throwUncheckedException(e);
			return "";
		}
	}

	@Test
	public void xpectSL()
	{
		String model = "// XPECT meth";
		Assert.assertEquals("meth(Res, Map | Res)", parse(model));
	}

	@Test
	public void xpectML()
	{
		String model = "/* XPECT meth */";
		Assert.assertEquals("meth(Res, Map | Res)", parse(model));
	}

	@Test
	public void xpectSLExpectation0()
	{
		String model = "// XPECT meth -->\n";
		String actual = parse(model);
		Assert.assertEquals("meth(Res, Map | Res) --> ", actual);
		Assert.assertEquals("// XPECT meth -->xxx\n", expectation(model));
	}

	@Test
	public void xpectSLExpectation01()
	{
		String model = "// XPECT meth --> \n";
		String actual = parse(model);
		Assert.assertEquals("meth(Res, Map | Res) --> ", actual);
		Assert.assertEquals("// XPECT meth --> xxx\n", expectation(model));
	}

	@Test
	public void xpectSLExpectation02()
	{
		String model = "// XPECT meth -->  \n";
		String actual = parse(model);
		Assert.assertEquals("meth(Res, Map | Res) -->  ", actual);
		Assert.assertEquals("// XPECT meth --> xxx\n", expectation(model));
	}

	@Test
	public void xpectSLExpectation1()
	{
		String model = "// XPECT meth -->exp\n";
		Assert.assertEquals("meth(Res, Map | Res) --> exp", parse(model));
		Assert.assertEquals("// XPECT meth -->xxx\n", expectation(model));
	}

	@Test
	public void xpectSLExpectation2()
	{
		String model = "// XPECT meth --> exp\n";
		Assert.assertEquals("meth(Res, Map | Res) --> exp", parse(model));
		Assert.assertEquals("// XPECT meth --> xxx\n", expectation(model));
	}

	@Test
	public void xpectSLExpectation3()
	{
		String model = "// XPECT meth -->  exp \n";
		Assert.assertEquals("meth(Res, Map | Res) -->  exp ", parse(model));
		Assert.assertEquals("// XPECT meth --> xxx\n", expectation(model));
	}

	@Test
	public void xpectMLExpectation0()
	{
		String model = "/* XPECT meth -->\n*/";
		Assert.assertEquals("meth(Res, Map | Res) --> ", parse(model));
		Assert.assertEquals("/* XPECT meth -->xxx\n*/", expectation(model));
	}

	@Test
	public void xpectMLExpectation01()
	{
		String model = "/* XPECT meth --> \n*/";
		Assert.assertEquals("meth(Res, Map | Res) --> ", parse(model));
		Assert.assertEquals("/* XPECT meth --> xxx\n*/", expectation(model));
	}

	@Test
	public void xpectMLExpectation02()
	{
		String model = "/* XPECT meth -->  \n*/";
		Assert.assertEquals("meth(Res, Map | Res) -->  ", parse(model));
		Assert.assertEquals("/* XPECT meth --> xxx\n*/", expectation(model));
	}

	@Test
	public void xpectMLExpectation1()
	{
		String model = "/* XPECT meth -->exp\n*/";
		Assert.assertEquals("meth(Res, Map | Res) --> exp", parse(model));
		Assert.assertEquals("/* XPECT meth -->xxx\n*/", expectation(model));
	}

	@Test
	public void xpectMLExpectation2()
	{
		String model = "/* XPECT meth --> exp\n*/";
		Assert.assertEquals("meth(Res, Map | Res) --> exp", parse(model));
		Assert.assertEquals("/* XPECT meth --> xxx\n*/", expectation(model));
	}

	@Test
	public void xpectMLExpectation3()
	{
		String model = "/* XPECT meth -->  exp \n*/";
		Assert.assertEquals("meth(Res, Map | Res) -->  exp ", parse(model));
		Assert.assertEquals("/* XPECT meth --> xxx\n*/", expectation(model));
	}

	@Test
	public void xpectMLExpectation4()
	{
		String model = "\n/* XPECT meth ---\nexp\n---*/\n";
		Assert.assertEquals("meth(Res, Map | Res) --> exp", parse(model));
		Assert.assertEquals("\n/* XPECT meth ---\nxxx\n---*/\n", expectation(model));
	}

	@Test
	public void xpectMLIndentation1()
	{
		StringBuilder model = new StringBuilder();
		model.append("/* XPECT meth ---\n");
		model.append("    exp\n");
		model.append("--- */\n");

		StringBuilder parsed = new StringBuilder();
		parsed.append("meth(Res, Map | Res) -->     exp");

		StringBuilder replaced = new StringBuilder();
		replaced.append("/* XPECT meth ---\n");
		replaced.append("xxx\n");
		replaced.append("--- */\n");

		Assert.assertEquals(parsed.toString(), parse(model.toString()));
		Assert.assertEquals(replaced.toString(), expectation(model.toString()));
	}

	@Test
	public void xpectMLIndentation2()
	{
		StringBuilder model = new StringBuilder();
		model.append("  /* XPECT meth ---\n");
		model.append("      exp\n");
		model.append("  --- */\n");

		StringBuilder parsed = new StringBuilder();
		parsed.append("meth(Res, Map | Res) -->     exp");

		StringBuilder replaced = new StringBuilder();
		replaced.append("  /* XPECT meth ---\n");
		replaced.append("  xxx\n");
		replaced.append("  --- */\n");

		Assert.assertEquals(parsed.toString(), parse(model.toString()));
		Assert.assertEquals(replaced.toString(), expectation(model.toString()));
	}

	@Test
	public void xpectMLIndentation3()
	{
		StringBuilder model = new StringBuilder();
		model.append("\t/* XPECT meth ---\n");
		model.append("\t    exp\n");
		model.append("\t--- */\n");

		StringBuilder parsed = new StringBuilder();
		parsed.append("meth(Res, Map | Res) -->     exp");

		StringBuilder replaced = new StringBuilder();
		replaced.append("\t/* XPECT meth ---\n");
		replaced.append("\txxx\n");
		replaced.append("\t--- */\n");

		Assert.assertEquals(parsed.toString(), parse(model.toString()));
		Assert.assertEquals(replaced.toString(), expectation(model.toString()));
	}

	@Test
	public void xpectMLIndentation4()
	{
		StringBuilder model = new StringBuilder();
		model.append("\t    /* XPECT meth ---\n");
		model.append("\t        tree {\n");
		model.append("\t            node\n");
		model.append("\t        }\n");
		model.append("\t    --- */\n");

		StringBuilder parsed = new StringBuilder();
		parsed.append("meth(Res, Map | Res) -->     tree {\\n        node\\n    }");

		StringBuilder replaced = new StringBuilder();
		replaced.append("\t    /* XPECT meth ---\n");
		replaced.append("\t    xxx\n");
		replaced.append("\t    --- */\n");

		Assert.assertEquals(parsed.toString(), parse(model.toString()));
		Assert.assertEquals(replaced.toString(), expectation(model.toString()));
	}

	@Test
	public void xpectMLOffsetParameter1()
	{
		String model = "/* XPECT offsetMeth at foo -->  exp \n*/ Bar: val='foo';";
		Assert.assertEquals("offsetMeth(offset at '*/ !Bar', myOffset at 'l='!foo')", params(model));
	}

	@Test
	public void xpectMLOffsetParameter2()
	{
		String model = "/* XPECT offsetMeth at fo!o -->  exp \n*/ Bar: val='foo';";
		Assert.assertEquals("offsetMeth(offset at '*/ !Bar', myOffset at ''fo!o';')", params(model));
	}

	@Test
	public void xpectSLParameterText()
	{
		String model = "// XPECT optionalMeth text foo";
		Assert.assertEquals("optionalMeth(offset at 'o\\n !foo', myText = foo)", params(model));
	}

	@Test
	public void xpectSLParameterString()
	{
		String model = "// XPECT optionalMeth string 'foo'";
		Assert.assertEquals("optionalMeth(offset at ''\\n !foo', myString = foo)", params(model));
	}

	@Test
	public void xpectSLParameterInt()
	{
		String model = "// XPECT optionalMeth int 123";
		Assert.assertEquals("optionalMeth(offset at '3\\n !foo', myInt = 123)", params(model));
	}

	@Test
	public void xpectSLParameterId()
	{
		String model = "// XPECT optionalMeth id foo";
		Assert.assertEquals("optionalMeth(offset at 'o\\n !foo', myId = foo)", params(model));
	}

	@Test
	public void xpectSLParameterAll()
	{
		String model = "// XPECT optionalMeth text abc int 123 string 'str' id foo";
		Assert.assertEquals("optionalMeth(offset at 'o\\n !foo', myText = abc, myInt = 123, myString = str, myId = foo)",
		    params(model));
	}

	@Test
	public void xpectSLParameterWithExp()
	{
		String model = "// XPECT optionalMeth text abc --> exp\n";
		Assert.assertEquals("optionalMeth(Res, Map | Res) --> exp", parse(model));
		Assert.assertEquals("optionalMeth(offset at '\\n\\n !foo', myText = abc)", params(model));
	}

	@Test
	public void xpectMLParameterWithExp()
	{
		String model = "/* XPECT optionalMeth text abc ---\n exp\n--- */";
		Assert.assertEquals("optionalMeth(Res, Map | Res) -->  exp", parse(model));
		Assert.assertEquals("optionalMeth(offset at '/\\n !foo', myText = abc)", params(model));
	}

	@Test
	public void xpectImport()
	{
		String model = "// XPECT_IMPORT foo/bar_baz-file.ext\n";
		Assert.assertEquals("import foo/bar_baz-file.ext", parse(model));
	}

	@Test
	public void xpectMulti()
	{
		StringBuilder model = new StringBuilder();
		model.append("// XPECT_IMPORT foo.ext\n");
		model.append("// XPECT meth ---\n");
		model.append("// XPECT meth ---\n");
		model.append("/* XPECT optionalMeth text abc ---\n exp\n--- */\n");

		StringBuilder parsed = new StringBuilder();
		parsed.append("import foo.ext\n");
		parsed.append("meth(Res, Map | Res)\n");
		parsed.append("meth(Res, Map | Res)\n");
		parsed.append("optionalMeth(Res, Map | Res) -->  exp");

		Assert.assertEquals(parsed.toString(), parse(model.toString()));
	}

}
