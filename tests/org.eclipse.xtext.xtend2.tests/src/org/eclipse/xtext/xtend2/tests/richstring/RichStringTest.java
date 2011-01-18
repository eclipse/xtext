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
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xtend2.richstring.DefaultIndentationHandler;
import org.eclipse.xtext.xtend2.richstring.IRichStringPartAcceptor;
import org.eclipse.xtext.xtend2.richstring.RichStringProcessor;
import org.eclipse.xtext.xtend2.xtend2.RichString;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RichStringTest extends AbstractRichStringTest {

	public static class StringBuilderBasedAcceptor implements IRichStringPartAcceptor {

		private StringBuilder builder;
		private Stack<Boolean> printNext;
		private Stack<Boolean> printElse;
		private Stack<Boolean> ignoreStack;

		public StringBuilderBasedAcceptor() {
			builder = new StringBuilder();
			printNext = new Stack<Boolean>();
			printElse = new Stack<Boolean>();
			ignoreStack = new Stack<Boolean>();
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
		
		public void acceptSemanticText(String text) {
			if (!ignore())
				builder.append(text);
		}

		public void acceptTemplateText(String text) {
		}

		public void acceptSemanticLineBreak() {
			if (!ignore())
				builder.append('\n');
		}

		public void acceptTemplateLineBreak() {
		}

		public void acceptIfCondition(XExpression condition) {
			if (ignore()) {
				ignoreStack.push(Boolean.TRUE);
			} else {
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
			}
		}

		public void acceptElse() {
			if (!internalIgnore()) {
				if (printElse.peek()) {
					printNext.pop();
					printNext.push(Boolean.TRUE);
				}
			}
		}

		public void acceptEndIf() {
			if (internalIgnore()) {
				ignoreStack.pop();
			} else {
				printNext.pop();
				printElse.pop();				
			}
		}

		public void acceptForLoop(JvmFormalParameter parameter, XExpression expression) {
		}

		public void acceptEndFor() {
		}

		public void acceptExpression(XExpression expression, String indentation) {
			XStringLiteral literal = (XStringLiteral) expression;
			String value = literal.getValue();
			value = value.replaceAll("\\n", "\n" + indentation);
			builder.append(value);
		}
		
		@Override
		public String toString() {
			return builder.toString();
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
				"  «IF true»\n" +
				"		«IF true»\n" +
				"				foobar\n" +
				"		«ENDIF»\n" +
				"  «ENDIF»\n" +
				"'''");
	}
	
	public void testNestedIf_02() throws Exception {
		assertOutput(
				"foobar", 
				"'''\n" +
				"  «IF true»\n" +
				"		«IF true»foobar«ENDIF»\n" +
				"  «ENDIF»\n" +
				"'''");
	}
}
