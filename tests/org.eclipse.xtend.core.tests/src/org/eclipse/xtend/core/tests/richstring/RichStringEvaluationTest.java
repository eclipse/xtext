/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.richstring;

import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtend.core.richstring.AbstractRichStringPartAcceptor;
import org.eclipse.xtend.core.richstring.DefaultIndentationHandler;
import org.eclipse.xtend.core.richstring.RichStringProcessor;
import org.eclipse.xtend.core.xtend.RichString;
import org.eclipse.xtend.core.xtend.RichStringLiteral;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.junit.Ignore;
import org.junit.Test;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RichStringEvaluationTest extends AbstractRichStringEvaluationTest {

	public static class StringBuilderBasedAcceptor extends AbstractRichStringPartAcceptor {

		private StringBuilder builder;
		private StringBuilder currentLine;
		private Stack<Boolean> printNext;
		private Stack<Boolean> printElse;
		private Stack<Boolean> ignoreStack;
		private Stack<Integer> forLoopStack;
		private boolean firstLine = true;

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
		public void acceptSemanticText(@NonNull CharSequence text, @Nullable RichStringLiteral origin) {
			if (!ignore())
				currentLine.append(text);
		}

		@Override
		public void acceptSemanticLineBreak(int length, @NonNull RichStringLiteral origin, boolean controlStructureSeen) {
			if (!ignore()) {
				firstLine = false;
				String newLine = currentLine.append('\n').toString();
				if (!controlStructureSeen || newLine.trim().length() != 0) {
					builder.append(newLine);	
				}
				currentLine = new StringBuilder();
			}
		}

		@Override
		public void acceptIfCondition(@NonNull XExpression condition) {
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

		@Override
		public void acceptElseIfCondition(@NonNull XExpression condition) {
			if (!internalIgnore()) {
				if (printElse.peek()) {
					XBooleanLiteral literal = (XBooleanLiteral) condition;
					boolean conditionResult = literal.isIsTrue();
					if (conditionResult) {
						printElse.pop();
						printElse.push(Boolean.FALSE);
					}
					printNext.pop();
					printNext.push(conditionResult);
				} else {
					printNext.pop();
					printNext.push(Boolean.FALSE);
				}
			}
		}

		@Override
		public void acceptElse() {
			if (!internalIgnore()) {
				if (printElse.peek()) {
					printNext.pop();
					printNext.push(Boolean.TRUE);
				}
			}
		}

		@Override
		public void acceptEndIf() {
			if (internalIgnore()) {
				ignoreStack.pop();
			} else {
				printNext.pop();
				printElse.pop();
			}
		}

		@Override
		public void acceptForLoop(@NonNull JvmFormalParameter parameter, @NonNull XExpression expression) {
			if (!ignore()) {
				XMemberFeatureCall featureCall = (XMemberFeatureCall) expression;
				XStringLiteral receiver = (XStringLiteral) featureCall.getMemberCallTarget();
				int length = receiver.getValue().length();
				if (length != 0)
					forLoopStack.push(length * -1);
				else
					forLoopStack.push(null);
			}
		}

		@Override
		public void acceptEndFor(@Nullable XExpression after, @NonNull CharSequence indentation) {
			if (!ignore()) {
				if (forLoopStack.pop() != null && after != null) {
					acceptExpression(after, indentation);
				}
			}
		}
		
		public boolean forLoopHasNext(@Nullable XExpression before, @Nullable XExpression separator, @NonNull CharSequence indentation) {
			if (!ignore()) {
				if (forLoopStack.peek() != null) {
					int remaining = forLoopStack.peek();
					boolean first = false;
					if (remaining < 0) {
						first = true;
						remaining = remaining * -1;
					}
					if (remaining > 0) {
						forLoopStack.set(forLoopStack.size() - 1, remaining - 1);
						if (first) {
							if (before != null)
								acceptExpression(before, indentation);
						} else if (separator != null) {
							acceptExpression(separator, indentation, true);
						}
						return true;
					}
				}
			}
			return false;
		}

		@Override
		public void acceptExpression(@NonNull XExpression expression, @NonNull CharSequence indentation) {
			acceptExpression(expression, indentation, false);
		}
		
		protected void acceptExpression(@NonNull XExpression expression, @NonNull CharSequence indentation, boolean immediate) {
			XStringLiteral literal = (XStringLiteral) expression;
			String value = literal.getValue();
			value = value.replaceAll("\\n", "\n" + indentation);
			if (immediate) {
				if (currentLine.toString().matches("^\\s*$")) {
					for(int at = builder.length() - 1; at >= 0; at++) {
						if (builder.charAt(at) == '\n') {
							builder.insert(at, value);
							return;
						}
					}
				}
			}
			for(int i = value.length() - 1; i >= 0; i--) {
				if (value.charAt(i) == '\n') {
					builder.append(currentLine);
					builder.append(value.substring(0, i + 1));
					if (i != value.length() - 1) {
						currentLine = new StringBuilder(value.substring(i + 1));
					} else {
						currentLine = new StringBuilder();
					}
					return;
				}
			}
			currentLine.append(value);
		}
		
		@Override
		public String toString() {
			StringBuilder result = new StringBuilder(builder.toString());
			if (currentLine.length() != 0) {
				String newLine = currentLine.toString();
				if (firstLine || newLine.trim().length() != 0) {
					result.append(newLine);	
				}
			}
			return result.toString();
		}
	}
	
	@Inject
	private Provider<XtextResourceSet> resourceSetProvider;
	
	@Override
	public void assertOutput(String expectedOutput, String richString) throws Exception {
		RichString parsedString = richString(richString);
		StringBuilderBasedAcceptor acceptor = new StringBuilderBasedAcceptor();
		DefaultIndentationHandler handler = new DefaultIndentationHandler();
		RichStringProcessor processor = new RichStringProcessor();
		processor.process(parsedString, acceptor, handler);
		String actualOutput = acceptor.toString();
		assertEquals(richString, expectedOutput, actualOutput);
	}
	
	protected RichString richString(String string) throws Exception {
		XtendClass clazz = clazz("class Foo { def foo() "+string+"}");
		XtendFunction function = (XtendFunction) clazz.getMembers().get(0);
		return (RichString) function.getExpression();
	}
	
	protected XtendClass clazz(String string) throws Exception {
		return (XtendClass) file(string).getXtendTypes().get(0);
	}

	protected XtendFile file(String string) throws Exception {
		return file(string, false);
	}

	protected XtendFile file(String string, boolean validate) throws Exception {
		XtextResourceSet set = resourceSetProvider.get();
		String fileName = getFileName(string);
		Resource resource = set.createResource(URI.createURI(fileName + ".xtend"));
		resource.load(new StringInputStream(string), null);
		assertEquals(resource.getErrors().toString(), 0, resource.getErrors().size());
		if (validate) {
			List<Issue> issues = ((XtextResource) resource).getResourceServiceProvider().getResourceValidator()
					.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
			assertTrue("Resource contained errors : " + issues.toString(), issues.isEmpty());
		}
		XtendFile file = (XtendFile) resource.getContents().get(0);
		return file;
	}

	protected String getFileName(String string) {
		Matcher packMatcher = Pattern.compile("package (\\S+)").matcher(string);
		Matcher classMatcher = Pattern.compile("class (\\w+)").matcher(string);
		String pathName = "";
		if (packMatcher.find()) {
			pathName = packMatcher.group(1).replace('.', '/') + "/";
		}
		classMatcher.find();
		return pathName + classMatcher.group(1);
	}

	@Ignore("Evaluation test assumes that only string literals are used in expression contexts")
	@Override
	@Test
	public void testIf_08() throws Exception {
		super.testIf_08();
	}
}
