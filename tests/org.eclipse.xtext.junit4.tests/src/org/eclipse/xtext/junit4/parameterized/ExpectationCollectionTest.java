package org.eclipse.xtext.junit4.parameterized;

import java.util.List;

import junit.framework.Assert;

import org.eclipse.xtext.junit4.parameterized.ExpectationCollection;
import org.eclipse.xtext.junit4.parameterized.ExpectationCollection.ExpectationItem;
import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

public class ExpectationCollectionTest
{

	private String format(ExpectationCollection ec)
	{
		List<String> result = Lists.newArrayList();
		for (ExpectationItem i : ec)
		{
			if (i.isWildcard())
				result.add("(wildcard)");
			else
				result.add((i.isNegated() ? "(negated) " : "") + i.getNormalized().replace("\n", "\\n").replace("\r", "\\r")
				    + " -> " + i.getEscaped());
		}
		return Joiner.on('\n').join(result);
	}

	@Test(expected = NullPointerException.class)
	public void robust1()
	{
		ExpectationCollection ec = new ExpectationCollection();
		ec.init(null);
	}

	@Test
	public void robust2()
	{
		ExpectationCollection ec = new ExpectationCollection();
		ec.init("");
		Assert.assertFalse(ec.iterator().hasNext());
		Assert.assertEquals("", format(ec));
	}

	@Test
	public void robust3()
	{
		ExpectationCollection ec = new ExpectationCollection();
		ec.init(" ");
		Assert.assertFalse(ec.iterator().hasNext());
		Assert.assertEquals("", format(ec));
	}

	@Test
	public void robust4()
	{
		ExpectationCollection ec = new ExpectationCollection();
		ec.init("\t");
		Assert.assertFalse(ec.iterator().hasNext());
		Assert.assertEquals("", format(ec));
	}

	@Test
	public void robust5()
	{
		ExpectationCollection ec = new ExpectationCollection();
		ec.init("\t,\t");
		Assert.assertEquals("", format(ec));
		Assert.assertFalse(ec.iterator().hasNext());
	}

	@Test
	public void simple()
	{
		ExpectationCollection ec = new ExpectationCollection();
		ec.setQuote('\'');
		ec.init("foo, bar");

		StringBuilder exp = new StringBuilder();
		exp.append("foo -> 'foo'\n");
		exp.append("bar -> 'bar'");
		Assert.assertEquals(exp.toString(), format(ec));
	}

	@Test
	public void simple_wcq()
	{
		ExpectationCollection ec = new ExpectationCollection();
		ec.setQuote('\'');
		ec.setWhitespaceSensitive(false);
		ec.setCaseSensitive(false);
		ec.setQuoted(false);
		ec.init("foo,  white  space  , CasE, !neg, \\!nneg, ..., \\..., es\\,\r\n\\\\caped, 'quoted', qu'ote");
		StringBuilder exp = new StringBuilder();
		exp.append("foo -> foo\n");
		exp.append("whitespace -> white  space\n");
		exp.append("case -> CasE\n");
		exp.append("(negated) neg -> neg\n");
		exp.append("!nneg -> \\!nneg\n");
		exp.append("(wildcard)\n");
		exp.append("... -> \\...\n");
		exp.append("es,\\caped -> es\\,\\r\\n\\\\caped\n");
		exp.append("'quoted' -> 'quoted'\n");
		exp.append("qu'ote -> qu'ote");
		Assert.assertEquals(exp.toString(), format(ec));
	}

	@Test
	public void simple_wcQ()
	{
		ExpectationCollection ec = new ExpectationCollection();
		ec.setQuote('\'');
		ec.setWhitespaceSensitive(false);
		ec.setCaseSensitive(false);
		ec.setQuoted(true);
		ec.init("'foo', '  white  space  ', 'CasE', !'neg', '!nneg', ..., '...', 'es,\r\n\\\\caped', 'quoted', 'qu\\'ote'");
		StringBuilder exp = new StringBuilder();
		exp.append("foo -> 'foo'\n");
		exp.append("whitespace -> '  white  space  '\n");
		exp.append("case -> 'CasE'\n");
		exp.append("(negated) neg -> 'neg'\n");
		exp.append("!nneg -> '!nneg'\n");
		exp.append("(wildcard)\n");
		exp.append("... -> '...'\n");
		exp.append("es,\\caped -> 'es,\\r\\n\\\\caped'\n");
		exp.append("quoted -> 'quoted'\n");
		exp.append("qu'ote -> 'qu\\'ote'");
		Assert.assertEquals(exp.toString(), format(ec));
	}

	@Test
	public void simple_wCq()
	{
		ExpectationCollection ec = new ExpectationCollection();
		ec.setQuote('\'');
		ec.setWhitespaceSensitive(false);
		ec.setCaseSensitive(true);
		ec.setQuoted(false);
		ec.init("foo,  white  space  , CasE, !neg, \\!nneg, ..., \\..., es\\,\r\n\\\\caped, 'quoted', qu'ote");
		StringBuilder exp = new StringBuilder();
		exp.append("foo -> foo\n");
		exp.append("whitespace -> white  space\n");
		exp.append("CasE -> CasE\n");
		exp.append("(negated) neg -> neg\n");
		exp.append("!nneg -> \\!nneg\n");
		exp.append("(wildcard)\n");
		exp.append("... -> \\...\n");
		exp.append("es,\\caped -> es\\,\\r\\n\\\\caped\n");
		exp.append("'quoted' -> 'quoted'\n");
		exp.append("qu'ote -> qu'ote");
		Assert.assertEquals(exp.toString(), format(ec));
	}

	@Test
	public void simple_wCQ()
	{
		ExpectationCollection ec = new ExpectationCollection();
		ec.setQuote('\'');
		ec.setWhitespaceSensitive(false);
		ec.setCaseSensitive(true);
		ec.setQuoted(true);
		ec.init("'foo', '  white  space  ', 'CasE', !'neg', '!nneg', ..., '...', 'es,\r\n\\\\caped', 'quoted', 'qu\\'ote'");
		StringBuilder exp = new StringBuilder();
		exp.append("foo -> 'foo'\n");
		exp.append("whitespace -> '  white  space  '\n");
		exp.append("CasE -> 'CasE'\n");
		exp.append("(negated) neg -> 'neg'\n");
		exp.append("!nneg -> '!nneg'\n");
		exp.append("(wildcard)\n");
		exp.append("... -> '...'\n");
		exp.append("es,\\caped -> 'es,\\r\\n\\\\caped'\n");
		exp.append("quoted -> 'quoted'\n");
		exp.append("qu'ote -> 'qu\\'ote'");
		Assert.assertEquals(exp.toString(), format(ec));
	}

	@Test
	public void simple_Wcq()
	{
		ExpectationCollection ec = new ExpectationCollection();
		ec.setQuote('\'');
		ec.setWhitespaceSensitive(true);
		ec.setCaseSensitive(false);
		ec.setQuoted(false);
		ec.init("foo,  white  space  , CasE, !neg, \\!nneg, ..., \\..., es\\,\r\n\\\\caped, 'quoted', qu'ote");
		StringBuilder exp = new StringBuilder();
		exp.append("foo -> foo\n");
		exp.append("white  space -> white  space\n");
		exp.append("case -> CasE\n");
		exp.append("(negated) neg -> neg\n");
		exp.append("!nneg -> \\!nneg\n");
		exp.append("(wildcard)\n");
		exp.append("... -> \\...\n");
		exp.append("es,\\r\\n\\caped -> es\\,\\r\\n\\\\caped\n");
		exp.append("'quoted' -> 'quoted'\n");
		exp.append("qu'ote -> qu'ote");
		Assert.assertEquals(exp.toString(), format(ec));
	}

	@Test
	public void simple_WcQ()
	{
		ExpectationCollection ec = new ExpectationCollection();
		ec.setQuote('\'');
		ec.setWhitespaceSensitive(true);
		ec.setCaseSensitive(false);
		ec.setQuoted(true);
		ec.init("'foo', '  white  space  ', 'CasE', !'neg', '!nneg', ..., '...', 'es,\r\n\\\\caped', 'quoted', 'qu\\'ote'");
		StringBuilder exp = new StringBuilder();
		exp.append("foo -> 'foo'\n");
		exp.append("  white  space   -> '  white  space  '\n");
		exp.append("case -> 'CasE'\n");
		exp.append("(negated) neg -> 'neg'\n");
		exp.append("!nneg -> '!nneg'\n");
		exp.append("(wildcard)\n");
		exp.append("... -> '...'\n");
		exp.append("es,\\r\\n\\caped -> 'es,\\r\\n\\\\caped'\n");
		exp.append("quoted -> 'quoted'\n");
		exp.append("qu'ote -> 'qu\\'ote'");
		Assert.assertEquals(exp.toString(), format(ec));
	}

	@Test
	public void simple_WCq()
	{
		ExpectationCollection ec = new ExpectationCollection();
		ec.setQuote('\'');
		ec.setWhitespaceSensitive(true);
		ec.setCaseSensitive(true);
		ec.setQuoted(false);
		ec.init("foo,  white  space  , CasE, !neg, \\!nneg, ..., \\..., es\\,\r\n\\\\caped, 'quoted', qu'ote");
		StringBuilder exp = new StringBuilder();
		exp.append("foo -> foo\n");
		exp.append("white  space -> white  space\n");
		exp.append("CasE -> CasE\n");
		exp.append("(negated) neg -> neg\n");
		exp.append("!nneg -> \\!nneg\n");
		exp.append("(wildcard)\n");
		exp.append("... -> \\...\n");
		exp.append("es,\\r\\n\\caped -> es\\,\\r\\n\\\\caped\n");
		exp.append("'quoted' -> 'quoted'\n");
		exp.append("qu'ote -> qu'ote");
		Assert.assertEquals(exp.toString(), format(ec));
	}

	@Test
	public void simple_WCQ()
	{
		ExpectationCollection ec = new ExpectationCollection();
		ec.setQuote('\'');
		ec.setWhitespaceSensitive(true);
		ec.setCaseSensitive(true);
		ec.setQuoted(true);
		ec.init("'foo', '  white  space  ', 'CasE', !'neg', '!nneg', ..., '...', 'es,\r\n\\\\caped', 'quoted', 'qu\\'ote'");
		StringBuilder exp = new StringBuilder();
		exp.append("foo -> 'foo'\n");
		exp.append("  white  space   -> '  white  space  '\n");
		exp.append("CasE -> 'CasE'\n");
		exp.append("(negated) neg -> 'neg'\n");
		exp.append("!nneg -> '!nneg'\n");
		exp.append("(wildcard)\n");
		exp.append("... -> '...'\n");
		exp.append("es,\\r\\n\\caped -> 'es,\\r\\n\\\\caped'\n");
		exp.append("quoted -> 'quoted'\n");
		exp.append("qu'ote -> 'qu\\'ote'");
		Assert.assertEquals(exp.toString(), format(ec));
	}

}
