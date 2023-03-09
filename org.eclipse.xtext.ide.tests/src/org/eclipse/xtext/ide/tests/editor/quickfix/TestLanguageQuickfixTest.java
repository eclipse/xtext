/**
* Copyright (c) 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.editor.quickfix;

import org.eclipse.xtext.ide.tests.testlanguage.TestLanguageIdeInjectorProvider;
import org.eclipse.xtext.ide.tests.testlanguage.ide.quickfix.TestLanguageQuickFixProvider;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TestLanguagePackage;
import org.eclipse.xtext.ide.tests.testlanguage.validation.TestLanguageValidator;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Heinrich Weichert
 */
@RunWith(XtextRunner.class)
@InjectWith(TestLanguageIdeInjectorProvider.class)
public class TestLanguageQuickfixTest extends AbstractIdeQuickfixTest {

	@Test
	public void issueProducesEMFChange() {

		String actual = "package testLanguage {"
				+ "\n"
				+ "\n"
				+ "type myType {"
				+ "\n"
				+ "}\n"
				+ "}";

		// quickfix replaces first char to Upper
		// see: org.eclipse.xtext.ide.tests.testlanguage.ide.quickfix.TestLanguageQuickFixProvider.fixLowerCaseName(DiagnosticResolutionAcceptor)
		String expected = actual.toString().replace("myType", "MyType");

		assertQuickFixOn(actual, expected, TestLanguageQuickFixProvider.EMF_QF_LABEL, TestLanguageValidator.INVALID_NAME, TestLanguagePackage.Literals.TYPE_DECLARATION);
	}

	@Test
	public void issueProducesTextualChange() {

		String actual = "package testLanguage {"
				+ "\n"
				+ "\n"
				+ "type myType {"
				+ "\n"
				+ "}\n"
				+ "}";

		// quickfix replaces first char to Upper
		// see: org.eclipse.xtext.ide.tests.testlanguage.ide.quickfix.TestLanguageQuickFixProvider.textFixLowerCaseName(DiagnosticResolutionAcceptor)
		String expected = actual.toString().replace("myType", "MyType");

		assertQuickFixOn(actual, expected, TestLanguageQuickFixProvider.TEXT_QF_LABEL, TestLanguageValidator.INVALID_NAME, TestLanguagePackage.Literals.TYPE_DECLARATION);
	}

}
