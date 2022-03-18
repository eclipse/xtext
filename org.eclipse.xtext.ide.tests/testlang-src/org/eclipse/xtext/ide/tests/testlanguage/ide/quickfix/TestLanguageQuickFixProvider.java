/*******************************************************************************
 * Copyright (c) 2016, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.testlanguage.ide.quickfix;

import org.eclipse.xtext.ide.editor.quickfix.AbstractDeclarativeIdeQuickfixProvider;
import org.eclipse.xtext.ide.editor.quickfix.DiagnosticResolutionAcceptor;
import org.eclipse.xtext.ide.editor.quickfix.QuickFix;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TypeDeclaration;
import org.eclipse.xtext.ide.tests.testlanguage.validation.TestLanguageValidator;
import org.eclipse.xtext.xbase.lib.StringExtensions;

public class TestLanguageQuickFixProvider extends AbstractDeclarativeIdeQuickfixProvider {

	@QuickFix(TestLanguageValidator.INVALID_NAME)
	public void fixLowerCaseName(DiagnosticResolutionAcceptor acceptor) {
		acceptor.accept("Change element name to first upper", obj -> {
			final TypeDeclaration element = (TypeDeclaration) obj;
			element.setName(StringExtensions.toFirstUpper(element.getName()));
		});
	}

}
