/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.richstring;

import java.util.Stack;

import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XIntLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xtend2.richstring.AbstractRichStringPartAcceptor;
import org.eclipse.xtext.xtend2.richstring.DefaultIndentationHandler;
import org.eclipse.xtext.xtend2.richstring.RichStringProcessor;
import org.eclipse.xtext.xtend2.xtend2.RichString;
import org.eclipse.xtext.xtend2.xtend2.RichStringLiteral;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RichStringTest extends AbstractRichStringTest {

	public static class StringBuilderBasedAcceptor extends AbstractRichStringPartAcceptor {

		private StringBuilder builder;
		private StringBuilder currentLine;
		private boolean controlStructureSeen;
		private Stack<Boolean> printNext;
		private Stack<Boolean> printElse;
		private Stack<Boolean> ignoreStack;
		private Stack<Integer> forLoopStack;

		public StringBuilderBasedAcceptor() {
			builder = new StringBuilder();
			currentLine = new StringBuilder();
			printNext = new Stack<Boolean>();
			printElse = new Stack<Boolean>();
			ignoreStack = new Stack<Boolean>();
			forLoopStack = new Stack<Integer>();
		}
		
		public boolean internalIgnore() {
			if (ignoreStack.isEmpty())
				return false;
			return ignoreStack.peek().booleanValue();
		}
		
		public boolean ignore() {
			if (ignoreStack.isEmpty()) {
				if (printNext.isEmpty())
					return false;
				return !printNext.peek().booleanValue();
			}
			return ignoreStack.peek().booleanValue();
		}
		
		@Override
		public void acceptSemanticText(CharSequence text, RichStringLiteral origin) {
			if (!ignore())
				currentLine.append(text);
		}

		@Override
		public void acceptSemanticLineBreak(int length, RichStringLiteral origin) {
			if (!ignore()) {
				String newLine = currentLine.append('\n').toString();
				if (!controlStructureSeen || newLine.trim().length() != 0) {
					builder.append(newLine);	
				}
				currentLine = new StringBuilder();
			}
			controlStructureSeen = false;
		}

		@Override
		public void acceptTemplateLineBreak(int length, RichStringLiteral origin) {
			controlStructureSeen = false;
		}

		@Override
		public void acceptIfCondition(XExpression condition) {
			if (ignore()) {
				ignoreStack.push(Boolean.TRUE);
			} else {
				controlStructureSeen = true;
				printElse.push(Boolean.TRUE);
				XBooleanLiteral literal = (XBooleanLiteral) condition;
				boolean conditionResult = literal.isIsTrue();
				if (conditionResult) {
					printElse.pop();
					printElse.push(Boolean.FALSE);
				}
				printNext.push(conditionResult);
			}
		}

		@Override
		public void acceptElseIfCondition(XExpression condition) {
			if (!internalIgnore()) {
				XBooleanLiteral literal = (XBooleanLiteral) condition;
				boolean conditionResult = literal.isIsTrue();
				if (conditionResult) {
					printElse.pop();
					printElse.push(Boolean.FALSE);
				}
				printNext.pop();
				printNext.push(conditionResult);
				controlStructureSeen = true;
			}
		}

		@Override
		public void acceptElse() {
			if (!internalIgnore()) {
				if (printElse.peek()) {
					printNext.pop();
					printNext.push(Boolean.TRUE);
				}
				controlStructureSeen = true;
			}
		}

		@Override
		public void acceptEndIf() {
			if (internalIgnore()) {
				ignoreStack.pop();
			} else {
				printNext.pop();
				printElse.pop();
				controlStructureSeen = true;
			}
		}

		@Override
		public void acceptForLoop(JvmFormalParameter parameter, XExpression expression) {
			if (!ignore()) {
				controlStructureSeen = true;
				if (expression.eClass() != XbasePackage.Literals.XNULL_LITERAL) {
					forLoopStack.push(((XIntLiteral)expression).getValue());
				} else
					forLoopStack.push(0);
			}
		}

		@Override
		public void acceptEndFor() {
			if (!ignore()) {
				controlStructureSeen = true;
				forLoopStack.pop();
			}
		}
		
		@Override
		public boolean forLoopHasNext() {
			if (!ignore()) {
				int remaining = forLoopStack.peek();
				controlStructureSeen = true;
				if (remaining > 0) {
					forLoopStack.set(forLoopStack.size() - 1, remaining - 1);
					return true;
				}
			}
			return false;
		}

		@Override
		public void acceptExpression(XExpression expression, CharSequence indentation) {
			XStringLiteral literal = (XStringLiteral) expression;
			String value = literal.getValue();
			value = value.replaceAll("\\n", "\n" + indentation);
			currentLine.append(value);
			controlStructureSeen = true;
		}
		
		@Override
		public String toString() {
			StringBuilder result = new StringBuilder(builder.toString());
			if (currentLine.length() != 0) {
				String newLine = currentLine.toString();
				if (!controlStructureSeen || newLine.trim().length() != 0) {
					result.append(newLine);	
				}
			}
			return result.toString();
		}
	}
	
	public void assertOutput(String expectedOutput, String richString) throws Exception {
		RichString parsedString = richString(richString);
		StringBuilderBasedAcceptor acceptor = new StringBuilderBasedAcceptor();
		DefaultIndentationHandler handler = new DefaultIndentationHandler();
		RichStringProcessor processor = new RichStringProcessor();
		processor.process(parsedString, acceptor, handler);
		String actualOutput = acceptor.toString();
		assertEquals(richString, expectedOutput, actualOutput);
	}
	
	public void testSimpleTemplate() throws Exception {
		assertOutput("foobar", "'''foobar'''");
	}
	
	public void testSimpleTemplateWithLeadingSpace() throws Exception {
		assertOutput("  foobar", "'''  foobar'''");
	}
	
	public void testSimpleTemplateWithTrailingSpace() throws Exception {
		assertOutput("foobar   ", "'''foobar   '''");
	}
	
	public void testExpressionTemplate() throws Exception {
		assertOutput("foobar", "'''«'foobar'»'''");
	}
	
	public void testExpressionTemplateWithLeadingSpace() throws Exception {
		assertOutput("  foobar", "'''  «'foobar'»'''");
	}
	
	public void testExpressionTemplateWithTrailingSpace() throws Exception {
		assertOutput("foobar   ", "'''«'foobar'»   '''");
	}
	
	public void testMLExpressionTemplate() throws Exception {
		assertOutput("foo\nbar", "'''«'foo\nbar'»'''");
	}
	
	public void testMLExpressionTemplateWithLeadingSpace() throws Exception {
		assertOutput("  foo\n  bar", "'''  «'foo\nbar'»'''");
	}
	
	public void testMLExpressionTemplateWithTrailingSpace() throws Exception {
		assertOutput("foo\nbar   ", "'''«'foo\nbar'»   '''");
	}
	
	public void testMultiLineTemplate() throws Exception {
		assertOutput(
				"foobar\n", 
				"'''\n" +
				"  foobar\n" +
				"'''");
	}
	
	public void testMultiLineTemplate_01() throws Exception {
		assertOutput(
				" foobar\n" +
				"   foobar\n" +
				"foobar\n",
				"'''\n" +
				"  foobar\n" +
				"    foobar\n" +
				" foobar\n" +
				"'''");
	}
	
	public void testMultiLineTemplate_02() throws Exception {
		assertOutput(
				"  foobar\n" +
				"    foobar\n" +
				" foobar\n",
				"'''  foobar\n" +
				"    foobar\n" +
				" foobar\n" +
				"'''");
	}
	
	public void testMultiLineTemplate_03() throws Exception {
		assertOutput(
				"  foobar\n" +
				"    foobar\n" +
				" foobar  ",
				"'''  foobar\n" +
				"    foobar\n" +
				" foobar  '''");
	}
	
	public void testIf_01() throws Exception {
		assertOutput("foobar", "'''«IF true»foobar«ENDIF»'''");
	}
	
	public void testIf_02() throws Exception {
		assertOutput("", "'''«IF false»foobar«ENDIF»'''");
	}
	
	public void testIf_03() throws Exception {
		assertOutput("zonk", "'''«IF false»foobar«ELSE»zonk«ENDIF»'''");
	}
	
	public void testIf_04() throws Exception {
		assertOutput("zonk", "'''«IF false»foobar«ELSEIF true»zonk«ENDIF»'''");
	}
	
	public void testIf_05() throws Exception {
		assertOutput("zonk", "'''«IF false»foobar«ELSEIF false»foobar«ELSE»zonk«ENDIF»'''");
	}
	
	public void testIf_06() throws Exception {
		assertOutput("foobar\n", 
				"'''\n"+
				"«IF true»\n"+
				"	foobar«ENDIF»\n"+
				"'''");
	}
	
	public void testIf_07() throws Exception {
		assertOutput("foobar\n", 
				"'''\n"+
				"  «IF true»\n"+
				"	  foobar«ENDIF»\n"+
				"'''");
	}
	
	public void testMultilineIf_01() throws Exception {
		assertOutput(
				"foobar\n", 
				"'''\n" +
				"  «IF true»\n" +
				"    foobar\n" +
				"  «ENDIF»\n" +
				"'''");
	}
	
	public void testMultilineIf_02() throws Exception {
		assertOutput(
				"", 
				"'''\n" +
				"	«IF false»\n" +
				"		foobar\n" +
				"	«ENDIF»\n" +
				"'''");
	}
	
	public void testMultilineIf_03() throws Exception {
		assertOutput(
				"zonk\n", 
				"'''\n" +
				"«IF false»\n" +
				"  foobar\n" +
				"«ELSE»\n" +
				"  zonk\n" +
				"«ENDIF»\n" +
				"'''");
	}
	
	public void testMultilineIf_04() throws Exception {
		assertOutput(
				"zonk\n", 
				"'''\n" +
				"«IF false»\n" +
				"	foobar\n" +
				"«ELSEIF true»\n" +
				"	zonk\n" +
				"«ENDIF»\n" +
				"'''");
	}
	
	public void testMultilineIf_05() throws Exception {
		assertOutput(
				"zonk\n", 
				"'''\n" +
				"		«IF false»\n" +
				"				foobar\n" +
				"		«ELSEIF false»\n" +
				"				foobar\n" +
				"		«ELSE»\n" +
				"				zonk\n" +
				"		«ENDIF»\n" +
				"'''");
	}
	
	public void testNestedIf_01() throws Exception {
		assertOutput(
				"foobar\n", 
				"'''\n" +
				"	«IF true»\n" +
				"		«IF true»\n" +
				"				foobar\n" +
				"		«ENDIF»\n" +
				"	«ENDIF»\n" +
				"'''");
	}
	
	public void testNestedIf_02() throws Exception {
		assertOutput(
				"foobar\n", 
				"'''\n" +
				"	«IF true»\n" +
				"		«IF true»foobar«ENDIF»\n" +
				"	«ENDIF»\n" +
				"'''");
	}
	
	public void testNestedIf_03() throws Exception {
		assertOutput(
				"", 
				"'''\n" +
				"	«IF true»\n" +
				"		«IF false»foobar«ENDIF»\n" +
				"	«ENDIF»\n" +
				"'''");
	}
	
	public void testNestedIf_04() throws Exception {
		assertOutput(
				"", 
				"'''\n" +
				"	«IF true»\n" +
				"		«IF false»\n" +
				"				foobar\n" +
				"		«ENDIF»\n" +
				"	«ENDIF»\n" +
				"'''");
	}
	
	public void testNestedIf_05() throws Exception {
		assertOutput(
				"", 
				"'''\n" +
				"	«IF false»\n" +
				"		«IF true»foobar«ENDIF»\n" +
				"	«ENDIF»\n" +
				"'''");
	}
	
	public void testNestedIf_06() throws Exception {
		assertOutput(
				"", 
				"'''\n" +
				"	«IF false»\n" +
				"		«IF true»\n" +
				"				foobar\n" +
				"		«ENDIF»\n" +
				"	«ENDIF»\n" +
				"'''");
	}
	
	public void testInconsistentWhitespace_01() throws Exception {
		assertOutput(
				"foobar\n", 
				"'''\n" +
				"  «IF true»\n" +
				"		«IF true»\n" +
				"				foobar\n" +
				"		«ENDIF»\n" +
				"  «ENDIF»\n" +
				"'''");
	}
	
	public void testTrailingEmptyLine_01() throws Exception {
		assertOutput(
				"\n", 
				"'''\n" +
				"		«IF false»\n" +
				"				foobar\n" +
				"		«ENDIF»\n" +
				"\n" +
				"'''");
	}
	
	public void testTrailingEmptyLine_02() throws Exception {
		assertOutput(
				"foobar\n"+
				"\n", 
				"'''\n" +
				"		«IF true»\n" +
				"				foobar\n" +
				"		«ENDIF»\n" +
				"\n" +
				"'''");
	}
	
	public void testTrailingEmptyLine_03() throws Exception {
		assertOutput(
				"foobar\n"+
				"\n", 
				"'''\n" +
				"		«IF true»\n" +
				"				foobar\n" +
				"		«ENDIF»\n" +
				"		\n" +
				"'''");
	}
	
	public void testTrailingEmptyLine_04() throws Exception {
		assertOutput(
				"foobar\n"+
				"\n", 
				"'''\n" +
				"		«IF true»\n" +
				"				foobar\n" +
				"		«ENDIF»\n" +
				"		\n" +
				"'''");
	}
	
	public void testTrailingEmptyLine_05() throws Exception {
		assertOutput(
				"foobar\n"+
				"  \n", 
				"'''    \n" +
				"		«IF true»\n" +
				"				foobar\n" +
				"		«ENDIF»\n" +
				"		  \n" +
				"'''");
	}
	
	public void testTrailingEmptyLine_06() throws Exception {
		assertOutput(
				"foobar\n"+
				"  \n", 
				"'''\n" +
				"		foobar\n" +
				"		  \n" +
				"'''");
	}
	
	public void testTrailingEmptyLine_07() throws Exception {
		assertOutput(
				"foobar\n"+
				"  \n", 
				"'''\n" +
				"		«IF true»foobar«ENDIF»\n" +
				"		  \n" +
				"'''");
	}
	
	public void testForLoop_01() throws Exception {
		assertOutput(
				"",
				"'''«FOR a:null»foobar«ENDFOR»'''");
	}
	
	public void testForLoop_02() throws Exception {
		assertOutput(
				"",
				"'''\n" +
				"  «FOR a:null»\n" +
				"    foobar\n" +
				"  «ENDFOR»\n" +
				"'''");
	}
	
	public void testForLoop_03() throws Exception {
		assertOutput(
				"",
				"'''«FOR a:1»«FOR a:null»foobar«ENDFOR»«ENDFOR»'''");
	}
	
	public void testForLoop_04() throws Exception {
		assertOutput(
				"",
				"'''\n" +
				"  «FOR a:1»\n" +
				"    «FOR a:null»\n" +
				"      foobar\n" +
				"    «ENDFOR»\n" +
				"  «ENDFOR»\n" +
				"'''");
	}
	
	public void testForLoop_05() throws Exception {
		assertOutput(
				"foobar",
				"'''«FOR a:1»foobar«ENDFOR»'''");
	}
	
	public void testForLoop_06() throws Exception {
		assertOutput(
				"foobar\n",
				"'''\n" +
				"  «FOR a:1»\n" +
				"    foobar\n" +
				"  «ENDFOR»\n" +
				"'''");
	}
	
	public void testForLoop_07() throws Exception {
		assertOutput(
				"  foobar",
				"'''  «FOR a:1»«FOR a:1»foobar«ENDFOR»«ENDFOR»'''");
	}
	
	public void testForLoop_08() throws Exception {
		assertOutput(
				"foobar\n",
				"'''\n" +
				"  «FOR a:1»\n" +
				"    «FOR a:1»\n" +
				"      foobar\n" +
				"    «ENDFOR»\n" +
				"  «ENDFOR»\n" +
				"'''");
	}
	
	public void testForLoop_10() throws Exception {
		assertOutput(
				"foobar\n",
				"'''\n" +
				"  «FOR a:1»\n" +
				"    «FOR a:1»foobar«ENDFOR»\n" +
				"  «ENDFOR»\n" +
				"'''");
	}
	
	public void testForLoop_11() throws Exception {
		assertOutput(
				"foobarfoobar\n",
				"'''\n" +
				"  «FOR a:1»\n" +
				"    «FOR a:2»foobar«ENDFOR»\n" +
				"  «ENDFOR»\n" +
				"'''");
	}
	
	public void testForLoop_12() throws Exception {
		assertOutput(
				"foobar\n" +
				"foobar\n",
				"'''\n" +
				"  «FOR a:2»\n" +
				"    «FOR a:1»foobar«ENDFOR»\n" +
				"  «ENDFOR»\n" +
				"'''");
	}
	
	public void testForLoop_13() throws Exception {
		assertOutput(
				"foobar\n" +
				"foobar\n" +
				"foobar\n" +
				"foobar\n",
				"'''\n" +
				"  «FOR a:2»\n" +
				"    «FOR a:2»\n" +
				"      foobar\n" +
				"    «ENDFOR»\n" +
				"  «ENDFOR»\n" +
				"'''");
	}
	
	public void testForLoop_14() throws Exception {
		assertOutput(
				"foobar\n" +
				"foobar\n" +
				"foobar\n" +
				"foobar\n",
				"'''\n" +
				"  «FOR a:1»\n" +
				"    «FOR a:2»\n" +
				"      «'foobar\nfoobar'»\n" +
				"    «ENDFOR»\n" +
				"  «ENDFOR»\n" +
				"'''");
	}
	
	public void testForLoop_15() throws Exception {
		assertOutput(
				"  foobar\n" +
				"foobar\n" +
				"  foobar\n" +
				"foobar\n",
				"'''\n" +
				"  «FOR a:2»\n" +
				"    «FOR a:1»\n" +
				"      «'  foobar\nfoobar'»\n" +
				"    «ENDFOR»\n" +
				"  «ENDFOR»\n" +
				"'''");
	}
	
	public void testForLoop_16() throws Exception {
		assertOutput(
				"foobar\n" +
				"  foobar\n" +
				"foobar\n" +
				"  foobar\n" +
				"foobar\n" +
				"  foobar\n" +
				"foobar\n" +
				"  foobar\n",
				"'''\n" +
				"  «FOR a:2»\n" +
				"    «FOR a:2»\n" +
				"      «'foobar\n  foobar'»\n" +
				"    «ENDFOR»\n" +
				"  «ENDFOR»\n" +
				"'''");
	}
	
}
