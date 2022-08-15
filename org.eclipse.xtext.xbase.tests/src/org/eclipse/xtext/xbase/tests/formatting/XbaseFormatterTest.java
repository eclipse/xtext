/**
 * Copyright (c) 2012, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.formatting;

import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.formatter.FormatterTestRequest;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.formatting2.XbaseFormatterPreferenceKeys;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(XbaseFormatterTestInjectorProvider.class)
public class XbaseFormatterTest {
	@Inject
	protected XbaseFormatterTester xbaseFormatterTester;

	@Test
	public void formatGenerics() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String toBeFormatted =
					"val x = <Pair<String, String>>newArrayList()\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatBlockExpression() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"val x = newArrayList(\"A\", \"b\");\n" +
					"val y = 'foo';\n" +
					"x.join\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"val x = newArrayList(\"A\", \"b\") ; val y = 'foo' ; x.join\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatBlockExpressionPreserveNewLines() {
		xbaseFormatterTester.assertFormatted((FormatterTestRequest it) -> {
			String string = "{\n" +
					"\n" +
					"	val x = newArrayList(\"A\", \"b\");\n" +
					"\n" +
					"	val y = 'foo'\n" +
					"\n" +
					"	x.join\n" +
					"\n" +
					"}\n";
			String expectation = string.toString().trim();
			it.setExpectation(Strings.toPlatformLineSeparator(expectation));
			String toBeFormatted =
					"  {  \n" +
					"\n" +
					"\n" +
					"val x = newArrayList(\"A\", \"b\") ;\n" +
					"\n" +
					"\n" +
					"val y = 'foo'\n" +
					"\n" +
					"\n" +
					" x.join\n" +
					"\n" +
					"\n" +
					" }\n";
			it.setToBeFormatted(Strings.toPlatformLineSeparator(toBeFormatted));
		});
	}

	@Test
	public void formatClosures() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String toBeFormatted =
					"val x = newArrayList(\"A\", \"b\")\n" +
					"val y = x.filter[toUpperCase == it]\n" +
					"y.join\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatClosuresParenthesis() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String toBeFormatted =
					"val x = newArrayList(\"A\", \"b\")\n" +
					"val y = x.filter(toUpperCase == it)\n" +
					"y.join\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatClosuresParenthesis2() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"val x = newArrayList(\"A\", \"b\")\n" +
					"val y = x.filter(foo|foo.toUpperCase == foo)\n" +
					"y.join\n";
			it.setToBeFormatted(expectation);
		});
	}

	@Test
	public void formatClosuresSemicolon() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"newArrayList(\"A\", \"b\").filter[val b = it; b.toUpperCase == b]\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"newArrayList(\"A\", \"b\").filter[ val b = it  ;   b.toUpperCase == b ]\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatClosuresEmpty() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"val x = newArrayList(\"A\", \"b\")\n" +
					"val y = x.filter[]\n" +
					"y.join\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"val x = newArrayList(\"A\", \"b\") val y = x.filter[   ] y.join\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatClosuresParam() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String toBeFormatted =
					"val x = newArrayList(\"A\", \"b\")\n" +
					"val y = x.filter[z|z.toUpperCase == z]\n" +
					"y.join\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatClosuresEmptyParam() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String toBeFormatted =
					"val Iterable<Object> x = [|#[].iterator]\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatClosuresMultiLine() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"val x = newArrayList(\"A\", \"b\")\n" +
					"val y = x.filter [\n" +
					"	val z = it\n" +
					"	z.toUpperCase == z\n" +
					"]\n" +
					"y.join\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"val x = newArrayList(\"A\", \"b\") val y = x.filter [\n" +
					"	val z = it z.toUpperCase == z \n" +
					"] y.join\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatClosuresMultiLine_02() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"val x = newArrayList(\"A\", \"b\")\n" +
					"val y = x.filter [\n" +
					"	val z = it\n" +
					"	z.toUpperCase == z\n" +
					"]\n" +
					"y.join\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"val x = newArrayList(\"A\", \"b\") val y = x.filter[\n" +
					"	val z = it z.toUpperCase == z \n" +
					"] y.join\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatClosuresMultiLine03() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"new Thread [|\n" +
					"	println(\"foo\")\n" +
					"]\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"new Thread[  | println(\"foo\")\n" +
					"]\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatClosuresMultiLineSemicolon() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"val x = newArrayList(\"A\", \"b\")\n" +
					"val y = x.filter [\n" +
					"	val z = it;\n" +
					"	z.toUpperCase == z;\n" +
					"]\n" +
					"y.join\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"val x = newArrayList(\"A\", \"b\") val y = x.filter [\n" +
					"	val z = it  ;   z.toUpperCase == z  ;   \n" +
					"] y.join\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatClosuresWrapIfNeeded() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"val x = newArrayList(\"A\", \"b\")\n" +
					"val y = x.filter [\n" +
					"	val z = it\n" +
					"	z.toUpperCase == z\n" +
					"	z.toUpperCase == z\n" +
					"	z.toUpperCase == z\n" +
					"]\n" +
					"y.join\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"val x = newArrayList(\"A\", \"b\") val y = x.filter [ val z = it z.toUpperCase == z z.toUpperCase == z z.toUpperCase == z ] y.join\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatClosuresParamMultiLine() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"val x = newArrayList(\"A\", \"b\")\n" +
					"val y = x.filter [ z |\n" +
					"	val w = z\n" +
					"	w.toUpperCase == w\n" +
					"]\n" +
					"y.join\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"val x = newArrayList(\"A\", \"b\") val y = x.filter[ z |\n" +
					"	val w = z w.toUpperCase == w\n" +
					"] y.join\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatClosuresWithOperator() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"val x = new StringBuffer() => [\n" +
					"	append(\"x\")\n" +
					"	append(\"y\")\n" +
					"]\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"val x = new StringBuffer() => [\n" +
					"	append(\"x\")\n" +
					"	append(\"y\")\n" +
					"]\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatMultiLineClosureWithAssignment() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"x += foo.myBuilder [\n" +
					"	foo\n" +
					"	bar\n" +
					"]\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"x += foo.myBuilder [\n" +
					"	foo bar\n" +
					"]\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatSynchronizedBlock_1() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"synchronized (new Object) {\n" +
					"}\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"synchronized(new Object){}\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatSynchronizedBlock_2() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"synchronized (new Object) {\n" +
					"}\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"synchronized         (          new            Object           )        {        }\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatIf1SL1() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			it.preferences((MapBasedPreferenceValues p) -> {
				p.put(XbaseFormatterPreferenceKeys.whitespaceBetweenKeywordAndParenthesisSL, true);
			});
			String toBeFormatted =
					"if (true) println(\"foo\")\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatIf1SL2() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			it.preferences((MapBasedPreferenceValues p) -> {
				p.put(XbaseFormatterPreferenceKeys.whitespaceBetweenKeywordAndParenthesisSL, false);
			});
			String toBeFormatted =
					"if(true) println(\"foo\")\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatIf1ML1() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			it.preferences((MapBasedPreferenceValues p) -> {
				p.put(XbaseFormatterPreferenceKeys.whitespaceBetweenKeywordAndParenthesisML, true);
			});
			String toBeFormatted =
					"if (true)\n" +
					"	println(\"foo\")\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatIf1ML2() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			it.preferences((MapBasedPreferenceValues p) -> {
				p.put(XbaseFormatterPreferenceKeys.whitespaceBetweenKeywordAndParenthesisML, false);
			});
			String toBeFormatted =
					"if(true)\n" +
					"	println(\"foo\")\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatIf1MLVar() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"var x = if (true)\n" +
					"		println(\"foo\")\n" +
					"	else\n" +
					"		println(\"bar\")\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"var x = if(true)\n" +
					"println(\"foo\") else println(\"bar\")\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatIf1MLSemicolon1() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"if (true)\n" +
					"	println(\"foo\");\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"if(true)\n" +
					"println(\"foo\");\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatIf1MLSemicolon2() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"if (true)\n" +
					"	println(\"foo\");\n" +
					"println(\"bar\")\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"if(true)\n" +
					"println(\"foo\");\n" +
					"println(\"bar\")\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatIf2() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String toBeFormatted =
					"if (true) {\n" +
					"	println(\"foo\")\n" +
					"}\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatIfElse1SL() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"if(true) println(\"foo\") else println(\"bar\")\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"if(true)println(\"foo\")else  println(\"bar\")\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatIfElse1ML() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"if (true)\n" +
					"	println(\"foo\")\n" +
					"else\n" +
					"	println(\"bar\")\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"if(true)\n" +
					"println(\"foo\")\n" +
					"else\n" +
					"println(\"bar\")\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatIfElse2() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String toBeFormatted =
					"if (true) {\n" +
					"	println(\"foo\")\n" +
					"} else {\n" +
					"	println(\"bar\")\n" +
					"}\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatIfElse3() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			it.preferences((MapBasedPreferenceValues p) -> {
				p.put(XbaseFormatterPreferenceKeys.bracesInNewLine, true);
			});
			String toBeFormatted =
					"if (true)\n" +
					"{\n" +
					"	println(\"foo\")\n" +
					"}\n" +
					"else\n" +
					"{\n" +
					"	println(\"bar\")\n" +
					"}\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatIfElseIf1() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"if (true)\n" +
					"	println(\"foo\")\n" +
					"else if (false)\n" +
					"	println(\"bar\")\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"if(true)\n" +
					"println(\"foo\")\n" +
					"else if(false)\n" +
					"println(\"bar\")\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatIfElseIf2() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"if (true) {\n" +
					"	println(\"foo\")\n" +
					"} else if (false) {\n" +
					"	println(\"bar\")\n" +
					"}\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"if(true) {\n" +
					"println(\"foo\")\n" +
					"} else if(false) {\n" +
					"println(\"bar\")\n" +
					"}\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatIfElseIf3() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"if (true) {\n" +
					"	println(\"foo\")\n" +
					"} else if (false)\n" +
					"	println(\"bar\")\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"if(true) {\n" +
					"println(\"foo\")\n" +
					"} else if(false)\n" +
					"println(\"bar\")\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatFor1() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"for (i : 1 .. 2)\n" +
					"	println(i)\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"for  (  i  :  1 .. 2  )  println(i)\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatFor2() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			it.preferences((MapBasedPreferenceValues p) -> {
				p.put(XbaseFormatterPreferenceKeys.bracesInNewLine, false);
			});
			String toBeFormatted =
					"for (i : 1 .. 2) {\n" +
					"	println(i)\n" +
					"}\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatFor3() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			it.preferences((MapBasedPreferenceValues p) -> {
				p.put(XbaseFormatterPreferenceKeys.bracesInNewLine, true);
			});
			it.setToBeFormatted("for (i : 1 .. 2)\n" +
					"{\n" +
					"	println(i)\n" +
					"}\n");
		});
	}

	@Test
	public void formatBasicFor() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"for (var i = 1; i < 10; i = i + 1)\n" +
					"	println(i)\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"for  (  var    i  =   1  ;   i   <   10;   i    =  i    +  1  )  println(i)\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatBasicFor2() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"for (;;) {\n" +
					"	return true\n" +
					"}\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"for  (      ;     ;      )  {     return     true }\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatBasicFor3() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"var int x\n" +
					"var int y\n" +
					"for (x = 1, y = 2;;) {\n" +
					"	return x + y\n" +
					"}\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"var   int     x\n" +
					"var   int    y \n" +
					"for  (       x   = 1    ,   y     =   2 ;     ;      )  {     return     x  +  y }\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatBasicFor4() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"val x = 1\n" +
					"for (; x < 10;)\n" +
					"	println(x)\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"val x = 1\n" +
					"for  (       ;     x     <    10      ;      )       println(x)\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatBasicFor5() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"val x = 1\n" +
					"for (;; x = x + 1, x = x + 2)\n" +
					"	println(x)\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"val x = 1\n" +
					"for  (       ;     ;     x     =      x 	+      1  ,  x  =   x   +    2 )          println(x)\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatBasicFor6() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"for (val x = 1;; x = x + 1, x = x + 2)\n" +
					"	println(x)\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"for  (			val 		x 		= 		1		;     ;     x     =      x 	+      1  ,  x  =   x   +    2 )          println(x)\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatWhile11() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			it.preferences((MapBasedPreferenceValues p) -> {
				p.put(XbaseFormatterPreferenceKeys.whitespaceBetweenKeywordAndParenthesisML, true);
			});
			String toBeFormatted =
					"while (true)\n" +
					"	println(\"x\")\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatWhile12() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			it.preferences((MapBasedPreferenceValues p) -> {
				p.put(XbaseFormatterPreferenceKeys.whitespaceBetweenKeywordAndParenthesisML, false);
			});
			String toBeFormatted =
					"while(true)\n" +
					"	println(\"x\")\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatWhile2() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			it.preferences((MapBasedPreferenceValues p) -> {
				p.put(XbaseFormatterPreferenceKeys.bracesInNewLine, false);
			});
			String toBeFormatted =
					"while (true) {\n" +
					"	println(\"x\")\n" +
					"}\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatWhile21() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			it.preferences((MapBasedPreferenceValues p) -> {
				p.put(XbaseFormatterPreferenceKeys.bracesInNewLine, true);
			});
			String toBeFormatted =
					"while (true)\n" +
					"{\n" +
					"	println(\"x\")\n" +
					"}\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatDoWhile11() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			it.preferences((MapBasedPreferenceValues p) -> {
				p.put(XbaseFormatterPreferenceKeys.whitespaceBetweenKeywordAndParenthesisML, true);
			});
			String toBeFormatted =
					"do\n" +
					"	println(\"x\")\n" +
					"while (true)\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatDoWhile12() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			it.preferences((MapBasedPreferenceValues p) -> {
				p.put(XbaseFormatterPreferenceKeys.whitespaceBetweenKeywordAndParenthesisML, false);
			});
			String toBeFormatted =
					"do\n" +
					"	println(\"x\")\n" +
					"while(true)\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatDoWhile2() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			it.preferences((MapBasedPreferenceValues p) -> {
				p.put(XbaseFormatterPreferenceKeys.bracesInNewLine, false);
			});
			String toBeFormatted =
					"do {\n" +
					"	println(\"x\")\n" +
					"} while (true)\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatDoWhile3() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			it.preferences((MapBasedPreferenceValues p) -> {
				p.put(XbaseFormatterPreferenceKeys.bracesInNewLine, true);
			});
			String toBeFormatted =
					"do\n" +
					"{\n" +
					"	println(\"x\")\n" +
					"}\n" +
					"while (true)\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatSwitchSL() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			it.preferences((MapBasedPreferenceValues p) -> {
				p.put(XbaseFormatterPreferenceKeys.bracesInNewLine, false);
			});
			String toBeFormatted =
					"switch 'x' { case 'x': println('x') case 'y': println('y') }\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatSwitchSL1() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			it.preferences((MapBasedPreferenceValues p) -> {
				p.put(XbaseFormatterPreferenceKeys.bracesInNewLine, true);
			});
			String toBeFormatted =
					"switch 'x' { case 'x': println('x') case 'y': println('y') }\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatSwitchDefaultSL() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			it.preferences((MapBasedPreferenceValues p) -> {
				p.put(XbaseFormatterPreferenceKeys.bracesInNewLine, false);
			});
			String toBeFormatted =
					"switch 'x' { case 'y': println('y') default: println('z') }\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatSwitchDefaultSL1() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			it.preferences((MapBasedPreferenceValues p) -> {
				p.put(XbaseFormatterPreferenceKeys.bracesInNewLine, true);
			});
			String toBeFormatted =
					"switch 'x' { case 'y': println('y') default: println('z') }\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatSwitchCaseSL1() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			it.preferences((MapBasedPreferenceValues p) -> {
				p.put(XbaseFormatterPreferenceKeys.bracesInNewLine, true);
			});
			String toBeFormatted =
					"switch 'x'\n" +
					"{\n" +
					"	case 'x': println('x')\n" +
					"	case 'y': println('y')\n" +
					"}\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatSwitchCaseSLParenthesis() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"switch 'x' {\n" +
					"	case 'x': println('x')\n" +
					"	case 'y': println('y')\n" +
					"}\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"switch   'x'  {   \n" +
					"	case 'x':   println('x')   case   'y':    println('y')\n" +
					"}\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatSwitchCaseDefaultSL1() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			it.preferences((MapBasedPreferenceValues p) -> {
				p.put(XbaseFormatterPreferenceKeys.bracesInNewLine, true);
			});
			String toBeFormatted =
					"switch 'x'\n" +
					"{\n" +
					"	case 'x': println('x')\n" +
					"	case 'y': println('y')\n" +
					"	default: println('z')\n" +
					"}\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatSwitchCaseDefaultSLParenthesis() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"switch 'x' {\n" +
					"	case 'x': println('x')\n" +
					"	case 'y': println('y')\n" +
					"	default: println('z')\n" +
					"}\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"switch   'x'  {   \n" +
					"	case 'x':   println('x')   case   'y':    println('y')  default  :    println('z')\n" +
					"}\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatSwitchML() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"switch 'x' {\n" +
					"	case 'x':\n" +
					"		println('x')\n" +
					"	case 'y':\n" +
					"		println('y')\n" +
					"}\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"switch 'x'  {   \n" +
					"	case 'x':   \n" +
					"		println('x')   case   'y':    println('y')\n" +
					"}\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatSwitchDefaultML() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"switch 'x' {\n" +
					"	case 'x':\n" +
					"		println('x')\n" +
					"	case 'y':\n" +
					"		println('y')\n" +
					"	default:\n" +
					"		println('z')\n" +
					"}\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"switch 'x'  {   \n" +
					"	case 'x':   \n" +
					"		println('x')   case   'y':    println('y')     default  :    println('z')\n" +
					"}\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatSwitchDefault2ML() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"switch 'x' {\n" +
					"	case 'x':\n" +
					"		println('x')\n" +
					"	case 'y':\n" +
					"		println('y')\n" +
					"	default:\n" +
					"		println('z')\n" +
					"}\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"switch 'x'  {   \n" +
					"	case 'x': println('x')   case   'y':    println('y')     \n" +
					"	default  :    \n" +
					"		println('z')\n" +
					"}\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatSwitchDefault2MLFallThrough() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"switch 'x' {\n" +
					"	case 'x',\n" +
					"	case 'y':\n" +
					"		println('y')\n" +
					"	default:\n" +
					"		println('z')\n" +
					"}\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"switch 'x'  {   \n" +
					"	case 'x'  ,   case   'y':    println('y')     \n" +
					"	default  :    \n" +
					"		println('z')\n" +
					"}\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatSwitchMLBlock() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			it.preferences((MapBasedPreferenceValues p) -> {
				p.put(XbaseFormatterPreferenceKeys.bracesInNewLine, false);
			});
			String expectation =
					"switch 'x' {\n" +
					"	case 'x': {\n" +
					"		println('x')\n" +
					"	}\n" +
					"	case 'y': {\n" +
					"		println('y')\n" +
					"	}\n" +
					"}\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"switch 'x'  { case 'x': { println('x') }  case   'y':  {  println('y') } }\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatSwitchDefaultMLBlock() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			it.preferences((MapBasedPreferenceValues p) -> {
				p.put(XbaseFormatterPreferenceKeys.bracesInNewLine, false);
			});
			String expectation =
					"switch 'x' {\n" +
					"	case 'x': {\n" +
					"		println('x')\n" +
					"	}\n" +
					"	case 'y': {\n" +
					"		println('y')\n" +
					"	}\n" +
					"	default: {\n" +
					"		println('z')\n" +
					"	}\n" +
					"}\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"switch 'x'  { case 'x': { println('x') }  case   'y':  {  println('y') } default: { println('z') } }\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatSwitchMLBlock1() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			it.preferences((MapBasedPreferenceValues p) -> {
				p.put(XbaseFormatterPreferenceKeys.bracesInNewLine, true);
			});
			String expectation =
					"switch 'x'\n" +
					"{\n" +
					"	case 'x':\n" +
					"	{\n" +
					"		println('x')\n" +
					"	}\n" +
					"	case 'y':\n" +
					"	{\n" +
					"		println('y')\n" +
					"	}\n" +
					"}\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"switch 'x'  { case 'x': { println('x') }  case   'y':  {  println('y') } }\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatFeatureCallNoParenthesis() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String toBeFormatted =
					"val v1 = newArrayList\n" +
					"val v2 = newArrayList\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatFeatureCallNoParams() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String toBeFormatted =
					"val v1 = newArrayList()\n" +
					"val v2 = newArrayList()\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatFeatureCall1() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"val ML2 = newArrayList(newArrayList(1, 2, 3, 4, 5, 6),\n" +
					"	newArrayList(5, 6, 7, 8), newArrayList(9, 10, 11, 12),\n" +
					"	newArrayList(13, 14, 15, 16))\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"val ML2 = newArrayList(newArrayList(1, 2, 3, 4, 5, 6), newArrayList(5, 6, 7, 8), newArrayList(9, 10, 11, 12), newArrayList(13, 14, 15, 16))\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatFeatureCall2() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"val ML2 = newArrayList(newArrayList(1, 2, 3, 4),\n" +
					"	newArrayList(5, 6, 7, 8, 101, 102, 103, 104, 105, 106, 107, 108, 109,\n" +
					"		110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120),\n" +
					"	newArrayList(9, 10, 11, 12), newArrayList(13, 14, 15, 16))\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"val ML2 = newArrayList(newArrayList(1, 2, 3, 4), newArrayList(5, 6, 7, 8, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120), newArrayList(9, 10, 11, 12), newArrayList(13, 14, 15, 16))\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatFeatureCallMultiline() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"val ML2 = newArrayList(\n" +
					"	newArrayList(1, 2, 3, 4),\n" +
					"	newArrayList(5, 6, 7, 8, 101, 102, 103, 104, 105, 106, 107, 108, 109,\n" +
					"		110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120),\n" +
					"	newArrayList(9),\n" +
					"	newArrayList(10)\n" +
					")\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"val ML2 = newArrayList(newArrayList(1, 2, 3, 4), newArrayList(5, 6, 7, 8, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120), newArrayList(9), newArrayList(10)\n" +
					")\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatConstructorCallNoParenthesis() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String toBeFormatted =
					"val v1 = new ArrayList\n" +
					"val v2 = new ArrayList\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatConstructorCallClosure() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String toBeFormatted =
					"new Thread[|println(\"foo\")]\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatConstructorCallNoParams() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String toBeFormatted =
					"val v1 = new ArrayList()\n" +
					"val v2 = new ArrayList()\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatConstructorCall1() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"val ML2 = new ArrayList(new ArrayList(1, 2, 3, 4, 5, 6),\n" +
					"	new ArrayList(5, 6, 7, 8), new ArrayList(9, 10, 11, 12),\n" +
					"	new ArrayList(13, 14, 15, 16))\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"val ML2 = new ArrayList(new ArrayList(1, 2, 3, 4, 5, 6), new ArrayList(5, 6, 7, 8), new ArrayList(9, 10, 11, 12), new ArrayList(13, 14, 15, 16))\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatConstructorCall2() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"val ML2 = new ArrayList(new ArrayList(1, 2, 3, 4),\n" +
					"	new ArrayList(5, 6, 7, 8, 101, 102, 103, 104, 105, 106, 107, 108, 109,\n" +
					"		110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120),\n" +
					"	new ArrayList(9, 10, 11, 12), new ArrayList(13, 14, 15, 16))\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"val ML2 = new ArrayList(new ArrayList(1, 2, 3, 4), new ArrayList(5, 6, 7, 8, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120), new ArrayList(9, 10, 11, 12), new ArrayList(13, 14, 15, 16))\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatConstructorCallMultiline() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"val ML2 = new ArrayList(\n" +
					"	new ArrayList(1, 2, 3, 4),\n" +
					"	new ArrayList(5, 6, 7, 8, 101, 102, 103, 104, 105, 106, 107, 108, 109,\n" +
					"		110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120),\n" +
					"	new ArrayList(9, 10, 11, 12),\n" +
					"	new ArrayList(13, 14, 15, 16)\n" +
					")\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"val ML2 = new ArrayList(new ArrayList(1, 2, 3, 4), new ArrayList(5, 6, 7, 8, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120), new ArrayList(9, 10, 11, 12), new ArrayList(13, 14, 15, 16)\n" +
					")\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatMemberFeatureCallNoParenthesis() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String toBeFormatted =
					"val v1 = \"x\".toString\n" +
					"val v2 = \"x\".toString\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatMemberFeatureCallNoParams() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String toBeFormatted =
					"val v1 = \"x\".toString()\n" +
					"val v2 = \"x\".toString()\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatMemberFeatureCall1() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"val ML1 = \"x\".substring(0).substring(1).substring(2).substring(3).\n" +
					"	substring(4).substring(5).substring(6).substring(7).substring(8).\n" +
					"	substring(9).substring(10).substring(11)\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"val ML1 = \"x\".substring(0).substring(1).substring(2).substring(3).substring(4).substring(5).substring(6).substring(7).substring(8).substring(9).substring(10).substring(11)\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatMemberFeatureCall2() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"val ML1 = \"x\".substring(0).substring(1)\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"val ML1 = \"x\"\n" +
					".\n" +
					"substring(0)\n" +
					".\n" +
					"substring(1)\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatMemberFeatureCall21() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"val ML1 = \"x\".toString.toString\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"val ML1 = \"x\"\n" +
					".\n" +
					"toString\n" +
					".\n" +
					"toString\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatMemberFeatureCall3() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"val ML1 = \"x\".substring(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,\n" +
					"	15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28)\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"val ML1 = \"x\".substring(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28)\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatMemberFeatureCall4() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"val ML1 = \"x\".substring(0, 1, 2)\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"val ML1 = \"x\".substring (\n" +
					"\n" +
					"0, \n" +
					"\n" +
					"1, \n" +
					"\n" +
					"2)\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatMemberFeatureCallMultiline() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"val ML1 = \"x\".substring(\n" +
					"	0,\n" +
					"	1,\n" +
					"	2\n" +
					")\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"val ML1 = \"x\".substring (\n" +
					"\n" +
					"0, \n" +
					"\n" +
					"1, \n" +
					"\n" +
					"2\n" +
					")\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatMemberFeatureCallBuilder1() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"newArrayList(\"x\").map()[]\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"newArrayList(\"x\")  .  map  (  )  [  ]\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatMemberFeatureCallBuilder2() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"newArrayList(\"x\").map()[lenght]\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"newArrayList(\"x\")  .  map  (  )  [  lenght  ]\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatMemberFeatureCallBuilderMultiline1() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"newArrayList(\"x\").map(\n" +
					"	length\n" +
					")[lenght]\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"newArrayList(\"x\")  .  map  (  length  \n" +
					")  [  lenght  ]\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatMemberFeatureCallBuilderMultiline2() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"newArrayList(\"x\").map(length) [\n" +
					"	length\n" +
					"]\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"newArrayList(\"x\")  .  map  (  length   )  [  length  \n" +
					"]\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	/**
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=461033
	 */
	@Test
	public void formatMemberFeatureCallParenthesized() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"val s = (\"a\" + \"b\").substring(1)\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"val  s  =  (\"a\"  +  \"b\") . substring(1)\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatBinaryExpression1() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"val ML1 = 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11 + 12 + 13 + 14 + 15 +\n" +
					"	16 + 17 + 18 + 19 + 20 + 21 + 22 + 23 + 24 + 25 + 26 + 27 + 28 + 29 +\n" +
					"	30 + 31 + 32 + 33 + 34 + 35 + 36\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"val ML1 = 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11 + 12 + 13 + 14 + 15 + 16 + 17 + 18 + 19 + 20 + 21 + 22 + 23 + 24 + 25 + 26 + 27 + 28 + 29 + 30 + 31 + 32 + 33 + 34 + 35 + 36 \n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatBinaryExpression2() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"val ML1 = 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 +\n" +
					"	11 * 12 * 13 * 14 * 15 * 16 * 17 * 18 + 19 + 20 + 21 + 22 + 23 + 24 +\n" +
					"	25 + 26 + 27 + 28 + 29 + 30 + 31 + 32 + 33 + 34 + 35 + 36\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"val ML1 = 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11 * 12 * 13 * 14 * 15 * 16 * 17 * 18 + 19 + 20 + 21 + 22 + 23 + 24 + 25 + 26 + 27 + 28 + 29 + 30 + 31 + 32 + 33 + 34 + 35 + 36 \n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatXTypeLiteral() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			it.setExpectation("typeof(String)\n");
			it.setToBeFormatted("typeof  (  String  )\n");
		});
	}

	@Test
	public void formatXTypeLiteralArray1() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			it.setExpectation("typeof(String[])\n");
			it.setToBeFormatted("typeof  (  String  [  ])\n");
		});
	}

	@Test
	public void formatXTypeLiteralArray2() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			it.setExpectation("typeof(String[][])\n");
			it.setToBeFormatted("typeof  (  String  [  ] [ ] )\n");
		});
	}

	@Test
	public void formatXThrowExpression() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			it.setExpectation("throw new RuntimeException()\n");
			it.setToBeFormatted("throw  new  RuntimeException()\n");
		});
	}

	@Test
	public void formatXReturnExpression1() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			it.setExpectation("return \"foo\"\n");
			it.setToBeFormatted("return   \"foo\"\n");
		});
	}

	@Test
	public void formatXReturnExpression2() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			it.setExpectation("\"foo\"\n" +
					"return\n");
			it.setToBeFormatted("\"foo\"  return\n");
		});
	}

	@Test
	public void formatXReturnExpression3() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			it.setExpectation("return;\n");
			it.setToBeFormatted("return   ;\n");
		});
	}

	@Test
	public void formatTryFinallyExpression1() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"try\n" +
					"	println(\"x\")\n" +
					"finally\n" +
					"	println(\"y\")\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"try   println(\"x\")   finally   println(\"y\")\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatTryFinallyExpression2() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"try {\n" +
					"	println(\"x\")\n" +
					"} finally {\n" +
					"	println(\"y\")\n" +
					"}\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"try  {   println(\"x\")  }  finally  {  println(\"y\")  }\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatTryCatchExpression11() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			it.preferences((MapBasedPreferenceValues p) -> {
				p.put(XbaseFormatterPreferenceKeys.whitespaceBetweenKeywordAndParenthesisML, true);
			});
			String toBeFormatted =
					"try\n" +
					"	println(\"x\")\n" +
					"catch (Exception e)\n" +
					"	println(\"y\")\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatTryCatchExpression12() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			it.preferences((MapBasedPreferenceValues p) -> {
				p.put(XbaseFormatterPreferenceKeys.whitespaceBetweenKeywordAndParenthesisML, false);
			});
			String toBeFormatted =
					"try\n" +
					"	println(\"x\")\n" +
					"catch(Exception e)\n" +
					"	println(\"y\")\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatTryCatchExpression2() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"try {\n" +
					"	println(\"x\")\n" +
					"} catch (Exception e) {\n" +
					"	println(\"y\")\n" +
					"}\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"try  {   println(\"x\")  }  catch (  Exception   e  )  {  println(\"y\")  }\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatTryCatchFinallyExpression1() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"try\n" +
					"	println(\"x\")\n" +
					"catch (Exception e)\n" +
					"	println(\"y\")\n" +
					"finally\n" +
					"	println(\"z\")\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"try   println(\"x\")  catch   (   Exception   e   )   println(\"y\")  finally   println(\"z\")\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatTryCatchFinallyExpressionBug474022() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			it.preferences((MapBasedPreferenceValues p) -> {
				p.put(XbaseFormatterPreferenceKeys.bracesInNewLine, false);
			});
			String expectation =
					"val i = try {\n" +
					"		println(\"x\")\n" +
					"		1\n" +
					"	} catch (Exception e) {\n" +
					"		println(\"y\")\n" +
					"		2\n" +
					"	} finally {\n" +
					"		println(\"z\")\n" +
					"	}\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"val i = try  {   println(\"x\") 1  }   catch   (   Exception   e   )  {  println(\"y\") 2  } finally  {  println(\"z\")  }\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatTryCatchFinallyExpression2() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			it.preferences((MapBasedPreferenceValues p) -> {
				p.put(XbaseFormatterPreferenceKeys.bracesInNewLine, false);
			});
			String expectation =
					"try {\n" +
					"	println(\"x\")\n" +
					"} catch (Exception e) {\n" +
					"	println(\"y\")\n" +
					"} finally {\n" +
					"	println(\"z\")\n" +
					"}\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"try  {   println(\"x\")  }   catch   (   Exception   e   )  {  println(\"y\")  } finally  {  println(\"z\")  }\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatTryCatchFinallyExpression3() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			it.preferences((MapBasedPreferenceValues p) -> {
				p.put(XbaseFormatterPreferenceKeys.bracesInNewLine, true);
			});
			String expectation =
					"try\n" +
					"{\n" +
					"	println(\"x\")\n" +
					"}\n" +
					"catch (Exception e)\n" +
					"{\n" +
					"	println(\"y\")\n" +
					"}\n" +
					"finally\n" +
					"{\n" +
					"	println(\"z\")\n" +
					"}\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"try  {   println(\"x\")  }   catch   (   Exception   e   )  {  println(\"y\")  } finally  {  println(\"z\")  }\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatTryCatchCatchFinallyExpression1() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"try\n" +
					"	println(\"x\")\n" +
					"catch (Exception e)\n" +
					"	println(\"y\")\n" +
					"catch (Exception f)\n" +
					"	println(\"z\")\n" +
					"finally\n" +
					"	println(\"a\")\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"try   println(\"x\")  catch   (   Exception   e   )   println(\"y\")  catch   (   Exception   f  )   println(\"z\")  finally   println(\"a\")\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatTryCatchCatchFinallyExpression2() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"try {\n" +
					"	println(\"x\")\n" +
					"} catch (Exception e) {\n" +
					"	println(\"y\")\n" +
					"} catch (Exception f) {\n" +
					"	println(\"z\")\n" +
					"} finally {\n" +
					"	println(\"a\")\n" +
					"}\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"try  {   println(\"x\")  }   catch   (   Exception   e   )  {  println(\"y\")  } catch   (   Exception   f  )  {  println(\"z\")  } finally  {  println(\"a\")  }\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatListLiteral1() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"#[12, 13, 14]\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"#[12,     13  ,	14		]\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatListLiteral3() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"#[\n" +
					"	12,\n" +
					"	13,\n" +
					"	14\n" +
					"]\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"#[12,     13  ,	14		\n" +
					"]\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatEmptySwitchSL() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"switch null { }\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"switch   null    {      }\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatEmptySwitchSL_2() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"switch null { default: 1 }\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"switch   null    {    default    :  1  }\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatEmptySwitchML() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"switch null {\n" +
					"}\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"switch   null    {      \n" +
					"	\n" +
					"	\n" +
					"	\n" +
					"}\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatEmptySwitchML_2() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"switch null {\n" +
					"	default: 1\n" +
					"}\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"switch   null    {      \n" +
					"	\n" +
					"	\n" +
					"	\n" +
					"	default : 1\n" +
					"	\n" +
					"}\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatInstanceOf() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"\"x\".toString instanceof String\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"\"x\".toString  instanceof  String\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatCast() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"\"x\" as String\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"\"x\"  as  String\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void formatPostfix() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"val i = j++\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"val i = j ++\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void testFeatureCallWithParentheses() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"val it = \"xxxx\"\n" +
					"val j = true && (startsWith(\"x\"))\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"val it = \"xxxx\"\n" +
					"val j = true&&(startsWith(\"x\"))\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void testMemberFeatureCallWithParentheses() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"val j = true && (class.startsWith(\"Hugo\"))\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"val j = true&&(class.startsWith(\"Hugo\"))\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

	@Test
	public void testIssue527() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"var veryveryveryveryveryveryveryveryveryveryveryveryveryveryveryveryveryveryname = #[\n" +
					"	1, 2, 3, 4, 5]\n" +
					"veryveryveryveryveryveryveryveryveryveryveryveryveryveryveryveryveryveryname.\n" +
					"	map [ l |\n" +
					"		veryveryveryveryveryveryveryveryveryveryveryveryveryveryveryveryveryveryname\n" +
					"	]\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"var veryveryveryveryveryveryveryveryveryveryveryveryveryveryveryveryveryveryname = #[1,2,3,4,5]\n" +
					"veryveryveryveryveryveryveryveryveryveryveryveryveryveryveryveryveryveryname.map[l|veryveryveryveryveryveryveryveryveryveryveryveryveryveryveryveryveryveryname]\n" +
					"\n";
			it.setToBeFormatted(toBeFormatted);
		});

	}
}
