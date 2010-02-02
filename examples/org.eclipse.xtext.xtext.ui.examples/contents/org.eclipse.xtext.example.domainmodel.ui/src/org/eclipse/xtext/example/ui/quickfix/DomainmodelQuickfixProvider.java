
package org.eclipse.xtext.example.ui.quickfix;

import org.eclipse.xtext.example.domainmodel.Type;
import org.eclipse.xtext.example.validation.DomainmodelJavaValidator;
import org.eclipse.xtext.ui.core.editor.quickfix.AbstractDeclarativeQuickfixProvider;
import org.eclipse.xtext.ui.core.editor.quickfix.Fix;
import org.eclipse.xtext.validation.IssueContext;

public class DomainmodelQuickfixProvider extends AbstractDeclarativeQuickfixProvider {

	@Fix(code = DomainmodelJavaValidator.INVALID_TYPE_NAME, image = "upcase.png", label = "Capitalize name", description = "Capitalize name of type")
	public void fixName(Type type, IssueContext issue) {
		type.setName(type.getName().toUpperCase());
	}

}
