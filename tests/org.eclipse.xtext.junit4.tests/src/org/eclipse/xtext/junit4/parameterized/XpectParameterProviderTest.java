package org.eclipse.xtext.junit4.parameterized;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.eclipse.emf.common.util.URI;
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
import com.google.common.collect.Multimap;
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

		@ParameterSyntax("'at' myOffset=OFFSET")
		public void offsetMeth()
		{
		}

		@ParameterSyntax("('text' myText=TEXT)? ('int' myInt=INT)? ('string' myString=STRING)? ('id' myId=ID)?")
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

				    public void acceptTest(String title, String method, Multimap<String, Object> params,
				        IExpectation expectation, boolean ignore)
				    {
					    StringBuilder str = new StringBuilder();
					    if (ignore)
						    str.append("(ignored) ");
					    if (title != null)
						    str.append("'" + title + "' ");
					    // List<String> p1 = Lists.newArrayList();
					    // for (String key : params.keySet())
					    // {
					    // List<String> p2 = Lists.newArrayList();
					    // for (Object x : params.get(key))
					    // {
					    // if (x == null)
					    // p2.add("null");
					    // else if (x instanceof Resource)
					    // p2.add("Res");
					    // else if (x instanceof Map<?, ?>)
					    // p2.add("Map");
					    // else if (x instanceof Integer)
					    // p2.add("Int");
					    // else
					    // p2.add(x.getClass().getSimpleName());
					    // }
					    // p1.add(key + "=" + Joiner.on("|").join(p2));
					    // }
					    str.append(method /* + "(" + Joiner.on(", ").join(p1) + ")" */);
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

				    public void acceptTest(String title, String method, Multimap<String, Object> params,
				        IExpectation expectation, boolean ignore)
				    {
					    // XtextResource res = (XtextResource)
					    // params.get(XpectParameterProvider.PARAM_RESOURCE).iterator().next();
					    List<String> p2 = Lists.newArrayList();
					    // String text = res.getParseResult().getRootNode().getText();
					    for (Map.Entry<String, Object> e : params.entries())
					    {
						    /*
								 * if (e.getKey().toLowerCase().contains("offset") &&
								 * e.getValue() instanceof Integer) { int offs = (Integer)
								 * e.getValue(); String val = "'" + text.substring(offs - 3,
								 * offs) + "!" + text.substring(offs, offs + 3) + "'";
								 * p2.add(e.getKey() + " at " + val.replace("\n", "\\n")); }
								 * else
								 */if (e.getKey().equals(XpectParameterProvider.PARAM_RESOURCE))
							    p2.add(e.getKey());
						    else
						    {
							    String val = e.getValue().toString().replace("\n", "\\n");
							    if (val.contains(" ") || val.contains("\t"))
								    val = "'" + val + "'";
							    p2.add(e.getKey() + "=" + val);
						    }
					    }
					    Collections.sort(p2);
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

				public void acceptTest(String title, String method, Multimap<String, Object> params, IExpectation expectation,
				    boolean ignore)
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
		Assert.assertEquals("meth", parse(model));
	}

	@Test
	public void xpectML()
	{
		String model = "/* XPECT meth */";
		Assert.assertEquals("meth", parse(model));
	}

	@Test
	public void xpectSLExpectation0()
	{
		String model = "// XPECT meth -->\n";
		String actual = parse(model);
		Assert.assertEquals("meth --> ", actual);
		Assert.assertEquals("// XPECT meth -->xxx\n", expectation(model));
	}

	@Test
	public void xpectSLExpectation01()
	{
		String model = "// XPECT meth --> \n";
		String actual = parse(model);
		Assert.assertEquals("meth --> ", actual);
		Assert.assertEquals("// XPECT meth --> xxx\n", expectation(model));
	}

	@Test
	public void xpectSLExpectation02()
	{
		String model = "// XPECT meth -->  \n";
		String actual = parse(model);
		Assert.assertEquals("meth -->  ", actual);
		Assert.assertEquals("// XPECT meth --> xxx\n", expectation(model));
	}

	@Test
	public void xpectSLExpectation1()
	{
		String model = "// XPECT meth -->exp\n";
		Assert.assertEquals("meth --> exp", parse(model));
		Assert.assertEquals("// XPECT meth -->xxx\n", expectation(model));
	}

	@Test
	public void xpectSLExpectation2()
	{
		String model = "// XPECT meth --> exp\n";
		Assert.assertEquals("meth --> exp", parse(model));
		Assert.assertEquals("// XPECT meth --> xxx\n", expectation(model));
	}

	@Test
	public void xpectSLExpectation3()
	{
		String model = "// XPECT meth -->  exp \n";
		Assert.assertEquals("meth -->  exp ", parse(model));
		Assert.assertEquals("// XPECT meth --> xxx\n", expectation(model));
	}

	@Test
	public void xpectMLExpectation0()
	{
		String model = "/* XPECT meth -->\n*/";
		Assert.assertEquals("meth --> ", parse(model));
		Assert.assertEquals("/* XPECT meth -->xxx\n*/", expectation(model));
	}

	@Test
	public void xpectMLExpectation01()
	{
		String model = "/* XPECT meth --> \n*/";
		Assert.assertEquals("meth --> ", parse(model));
		Assert.assertEquals("/* XPECT meth --> xxx\n*/", expectation(model));
	}

	@Test
	public void xpectMLExpectation02()
	{
		String model = "/* XPECT meth -->  \n*/";
		Assert.assertEquals("meth -->  ", parse(model));
		Assert.assertEquals("/* XPECT meth --> xxx\n*/", expectation(model));
	}

	@Test
	public void xpectMLExpectation1()
	{
		String model = "/* XPECT meth -->exp\n*/";
		Assert.assertEquals("meth --> exp", parse(model));
		Assert.assertEquals("/* XPECT meth -->xxx\n*/", expectation(model));
	}

	@Test
	public void xpectMLExpectation2()
	{
		String model = "/* XPECT meth --> exp\n*/";
		Assert.assertEquals("meth --> exp", parse(model));
		Assert.assertEquals("/* XPECT meth --> xxx\n*/", expectation(model));
	}

	@Test
	public void xpectMLExpectation3()
	{
		String model = "/* XPECT meth -->  exp \n*/";
		Assert.assertEquals("meth -->  exp ", parse(model));
		Assert.assertEquals("/* XPECT meth --> xxx\n*/", expectation(model));
	}

	@Test
	public void xpectMLExpectation4()
	{
		String model = "\n/* XPECT meth ---\nexp\n---*/\n";
		Assert.assertEquals("meth --> exp", parse(model));
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
		parsed.append("meth -->     exp");

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
		parsed.append("meth -->     exp");

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
		parsed.append("meth -->     exp");

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
		parsed.append("meth -->     tree {\\n        node\\n    }");

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
		Assert.assertEquals("offsetMeth(myOffset=154, myOffset=val='!foo';, offset=' \\n*/ !Bar: ', offset=144, resource)",
		    params(model));
	}

	@Test
	public void xpectMLOffsetParameter2()
	{
		String model = "/* XPECT offsetMeth at fo|o -->  exp \n*/ Bar: val='foo';";
		Assert.assertEquals(
		    "offsetMeth(myOffset='l='fo!o';\\n ', myOffset=157, offset=' \\n*/ !Bar: ', offset=145, resource)",
		    params(model));
	}

	@Test
	public void xpectSLParameterText()
	{
		String model = "// XPECT optionalMeth text foo";
		Assert.assertEquals("optionalMeth(myText=foo, offset='foo\\n !foo:v', offset=136, resource)", params(model));
	}

	@Test
	public void xpectSLParameterString()
	{
		String model = "// XPECT optionalMeth string 'foo'";
		Assert.assertEquals("optionalMeth(myString=foo, offset='oo'\\n !foo:v', offset=140, resource)", params(model));
	}

	@Test
	public void xpectSLParameterInt()
	{
		String model = "// XPECT optionalMeth int 123";
		Assert.assertEquals("optionalMeth(myInt=123, myInt=123, myInt=123, offset='123\\n !foo:v', offset=135, resource)",
		    params(model));
	}

	@Test
	public void xpectSLParameterId()
	{
		String model = "// XPECT optionalMeth id foo";
		Assert.assertEquals("optionalMeth(myId=foo, offset='foo\\n !foo:v', offset=134, resource)", params(model));
	}

	@Test
	public void xpectSLParameterAll()
	{
		String model = "// XPECT optionalMeth text abc int 123 string 'str' id foo";
		Assert
		    .assertEquals(
		        "optionalMeth(myId=foo, myInt=123, myInt=123, myInt=123, myString=str, myText=abc, offset='foo\\n !foo:v', offset=164, resource)",
		        params(model));
	}

	@Test
	public void xpectSLParameterDefault()
	{
		String model = "// XPECT meth";
		Assert.assertEquals("meth(offset='eth\\n !foo:v', offset=119, resource)", params(model));
	}

	@Test
	public void xpectSLParameterWithExp()
	{
		String model = "// XPECT optionalMeth text abc --> exp\n";
		Assert.assertEquals("optionalMeth --> exp", parse(model));
		Assert.assertEquals("optionalMeth(myText=abc, offset='xp\\n\\n !foo:v', offset=145, resource)", params(model));
	}

	@Test
	public void xpectMLParameterWithExp()
	{
		String model = "/* XPECT optionalMeth text abc ---\n exp\n--- */";
		Assert.assertEquals("optionalMeth -->  exp", parse(model));
		Assert.assertEquals("optionalMeth(myText=abc, offset=' */\\n !foo:v', offset=152, resource)", params(model));
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
		parsed.append("meth\n");
		parsed.append("meth\n");
		parsed.append("optionalMeth -->  exp");

		Assert.assertEquals(parsed.toString(), parse(model.toString()));
	}

}
