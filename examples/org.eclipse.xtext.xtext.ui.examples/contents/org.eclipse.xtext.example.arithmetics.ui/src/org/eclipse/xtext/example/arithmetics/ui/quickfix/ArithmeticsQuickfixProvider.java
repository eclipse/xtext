
package org.eclipse.xtext.example.arithmetics.ui.quickfix;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.xtext.example.arithmetics.validation.ArithmeticsJavaValidator;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.validation.Issue;

public class ArithmeticsQuickfixProvider extends DefaultQuickfixProvider {

	@Fix(ArithmeticsJavaValidator.NORMALIZABLE)
	public void normalize(final Issue issue, IssueResolutionAcceptor acceptor) {
		final String string = issue.getData()[0];
		acceptor.accept(issue, "Replace with "+string, "Replace expression with '"+string+"'", "upcase.png", new IModification() {
			public void apply(IModificationContext context) throws BadLocationException {
				IXtextDocument xtextDocument = context.getXtextDocument();
				xtextDocument.replace(issue.getOffset(), issue.getLength(), string);
			}
		});
	}

}
