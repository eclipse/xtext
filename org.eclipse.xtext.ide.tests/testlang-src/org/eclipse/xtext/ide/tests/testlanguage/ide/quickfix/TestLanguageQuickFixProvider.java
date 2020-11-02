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
