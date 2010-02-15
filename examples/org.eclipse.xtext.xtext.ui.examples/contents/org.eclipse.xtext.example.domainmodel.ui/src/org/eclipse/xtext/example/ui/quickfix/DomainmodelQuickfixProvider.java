
package org.eclipse.xtext.example.ui.quickfix;

import org.eclipse.xtext.example.domainmodel.Type;
import org.eclipse.xtext.example.validation.DomainmodelJavaValidator;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.validation.IssueContext;

public class DomainmodelQuickfixProvider extends DefaultQuickfixProvider {

	@Fix(code = DomainmodelJavaValidator.INVALID_TYPE_NAME, image = "upcase.png", label = "Capitalize name", description = "Capitalize name of type")
	public void fixName(Type type, IssueContext issue) {
		type.setName(Strings.toFirstUpper(type.getName()));
	}

}
