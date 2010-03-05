
package org.eclipse.xtext.ui.tests.quickfix.ui.quickfix;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.ui.tests.quickfix.importUriUi.Element;
import org.eclipse.xtext.validation.Issue;

public class QuickfixCrossrefTestLanguageQuickfixProvider extends DefaultQuickfixProvider {

//	@Fix(MyJavaValidator.INVALID_TYPE_NAME)
//	public void capitalizeName(final Issue issue, IssueResolutionAcceptor acceptor) {
//		acceptor.accept(issue, "Capitalize name", "Capizalize name of type", "upcase.png", new IModification() {
//			public void apply(IModificationContext context) throws BadLocationException {
//				IXtextDocument xtextDocument = context.getXtextDocument();
//				String firstLetter = xtextDocument.get(issue.getOffset(), 1);
//				xtextDocument.replace(issue.getOffset(), 1, Strings.toFirstUpper(firstLetter));
//			}
//		});
//	}

	public static final String SEMANTIC_FIX_ID = "Semantic Fix ID";
	
	@Fix(SEMANTIC_FIX_ID)
	public void rename(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, SEMANTIC_FIX_ID, SEMANTIC_FIX_ID, null, new ISemanticModification() {
			public void apply(EObject element, IModificationContext context) {
				((Element)element).setName("Bor");
			}
		});
	}
}
