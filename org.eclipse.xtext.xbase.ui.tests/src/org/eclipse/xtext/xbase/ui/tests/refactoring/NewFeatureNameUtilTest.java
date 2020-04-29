/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.ui.tests.refactoring;

import org.eclipse.jface.text.TextSelection;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.ui.refactoring.ExpressionUtil;
import org.eclipse.xtext.xbase.ui.refactoring.NewFeatureNameUtil;
import org.eclipse.xtext.xbase.ui.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.ui.tests.XbaseInjectorProviderWithScopeTracking;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Jan Koehnlein
 */
@InjectWith(XbaseInjectorProviderWithScopeTracking.class)
@RunWith(XtextRunner.class)
public class NewFeatureNameUtilTest extends AbstractXbaseTestCase {
	@Inject
	private ExpressionUtil util;

	@Inject
	private Provider<NewFeatureNameUtil> nameUtilProvider;

	@Inject
	private ParseHelper<XExpression> parseHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void testDefaultNamePrimitive() throws Exception {
		assertDefaultName("{2+$3}", "i");
		assertDefaultName("{2+$3f}", "f");
		assertDefaultName("{2+$3l}", "l");
		assertDefaultName("{2+$3.0}", "d");
		assertDefaultName("{$true}", "b");
	}

	@Test
	public void testDefaultNameFeatureCall() throws Exception {
		assertDefaultName("{\"\".$getBytes}", "bytes");
		assertDefaultName("{\"\".$length}", "length");
	}

	@Test
	public void testDefaultNameType() throws Exception {
		assertDefaultName("{$2+3$}", "i");
		assertDefaultName("{\"$\"}", "string");
	}

	@Test
	public void testDefaultNameAlternate() throws Exception {
		assertDefaultName("{val i=1 2+$3}", "j");
		assertDefaultName("{val j=2+$3 val i=1}", "k");
		assertDefaultName("{val i=1 {val j=2+$3}}", "k");
		assertDefaultName("{val j=1 {val i=2+$3}}", "k");
		assertDefaultName("{{val j=2+$3} val i=1 }", "i");
	}

	@Test
	public void testDefaultNameClosure() throws Exception {
		assertDefaultName("{newArrayList(\"\").map[toFirstUpper]$$}", "function");
	}

	@Test
	public void testInvalidNameNull() throws Exception {
		assertInvalidName(null, RefactoringStatus.FATAL, "Choose a name");
		assertInvalidName("", RefactoringStatus.FATAL, "Choose a name");
	}

	@Test
	public void testInvalidNameSyntax() throws Exception {
		assertInvalidName("%", RefactoringStatus.FATAL, "character");
		assertInvalidName("gürkenbröd", RefactoringStatus.FATAL, "character");
		assertInvalidName("&", RefactoringStatus.FATAL, "character");
	}

	@Test
	public void testInvalidNameKeyword() throws Exception {
		assertInvalidName("if", RefactoringStatus.FATAL, "keyword");
		assertInvalidName("else", RefactoringStatus.FATAL, "keyword");
		assertInvalidName("while", RefactoringStatus.FATAL, "keyword");
		assertInvalidName("do", RefactoringStatus.FATAL, "keyword");
		assertInvalidName("switch", RefactoringStatus.FATAL, "keyword");
		assertInvalidName("case", RefactoringStatus.FATAL, "keyword");
	}

	@Test
	public void testInvalidNamePrimitive() throws Exception {
		assertInvalidName("boolean", RefactoringStatus.FATAL, "reserved");
		assertInvalidName("short", RefactoringStatus.FATAL, "reserved");
		assertInvalidName("char", RefactoringStatus.FATAL, "reserved");
		assertInvalidName("int", RefactoringStatus.FATAL, "reserved");
		assertInvalidName("long", RefactoringStatus.FATAL, "reserved");
		assertInvalidName("float", RefactoringStatus.FATAL, "reserved");
		assertInvalidName("double", RefactoringStatus.FATAL, "reserved");
	}

	@Test
	public void testInvalidNameUpperCase() throws Exception {
		assertInvalidName("CamelCase", RefactoringStatus.ERROR, "lowercase");
	}

	protected void assertDefaultName(String modelWithSelectionMarkup, String expectedName) throws Exception {
		String cleanedModel = modelWithSelectionMarkup.replaceAll("\\$", "");
		XExpression expression = parse(cleanedModel);
		int selectionOffset = modelWithSelectionMarkup.indexOf("$");
		int selectionLength = modelWithSelectionMarkup.lastIndexOf("$") - selectionOffset - 1;
		XExpression selectedExpression = util.findSelectedExpression((XtextResource) expression.eResource(),
				new TextSelection(selectionOffset, selectionLength));
		XExpression successor = util.findSuccessorExpressionForVariableDeclaration(selectedExpression);
		NewFeatureNameUtil nameUtil = nameUtilProvider.get();
		nameUtil.setFeatureScopeContext(successor);
		String defaultName = nameUtil.getDefaultName(selectedExpression);
		assertEquals(expectedName, defaultName);
	}

	protected void assertInvalidName(String name, int severity, String messageFragment) throws Exception {
		RefactoringStatus status = new RefactoringStatus();
		NewFeatureNameUtil nameUtil = nameUtilProvider.get();
		nameUtil.checkNewFeatureName(name, false, status);
		assertEquals(severity, status.getSeverity());
		String message = status.getEntryWithHighestSeverity().getMessage();
		assertTrue(message, message.contains(messageFragment));
	}

	protected XExpression parse(CharSequence string) throws Exception {
		XExpression expression = parseHelper.parse(string);
		validationHelper.assertNoErrors(expression);
		return expression;
	}
}
