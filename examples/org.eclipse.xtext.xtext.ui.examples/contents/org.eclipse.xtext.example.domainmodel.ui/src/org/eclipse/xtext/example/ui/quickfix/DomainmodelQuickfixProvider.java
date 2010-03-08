package org.eclipse.xtext.example.ui.quickfix;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.xtext.example.domainmodel.Feature;
import org.eclipse.xtext.example.validation.DomainmodelJavaValidator;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.validation.Issue;

public class DomainmodelQuickfixProvider extends DefaultQuickfixProvider {

	@Fix(DomainmodelJavaValidator.INVALID_TYPE_NAME)
	public void fixTypeName(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Capitalize name", "Capitalize name  of '" + issue.getData()[0] + "'", "upcase.png",
				// exemplary textual modification 
				new IModification() {
					public void apply(IModificationContext context) throws BadLocationException {
						IXtextDocument xtextDocument = context.getXtextDocument();
						String firstLetter = xtextDocument.get(issue.getOffset(), 1);
						xtextDocument.replace(issue.getOffset(), 1, Strings.toFirstUpper(firstLetter));
					}
				});
	}

	@Fix(DomainmodelJavaValidator.INVALID_FEATURE_NAME)
	public void fixFeatureName(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Uncapitalize name", "Uncapitalize name of '" + issue.getData()[0] + "'", "upcase.png",
				// exemplary semantic modification 
				new ISemanticModification() {
					public void apply(EObject element, IModificationContext context) {
						((Feature) element).setName(Strings.toFirstLower(issue.getData()[0]));
					}
				});
	}

}
