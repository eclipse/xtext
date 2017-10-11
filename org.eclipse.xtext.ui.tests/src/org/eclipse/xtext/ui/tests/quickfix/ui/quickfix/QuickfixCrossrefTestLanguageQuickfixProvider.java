
package org.eclipse.xtext.ui.tests.quickfix.ui.quickfix;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.model.edit.IMultiModificationContext;
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.ui.tests.quickfix.quickfixCrossref.Element;
import org.eclipse.xtext.ui.tests.quickfix.validation.QuickfixCrossrefTestLanguageValidator;
import org.eclipse.xtext.validation.Issue;

public class QuickfixCrossrefTestLanguageQuickfixProvider extends DefaultQuickfixProvider {

	public static final String SEMANTIC_FIX_ID = "Semantic Fix ID";

	@Fix(SEMANTIC_FIX_ID)
	public void rename(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, SEMANTIC_FIX_ID, SEMANTIC_FIX_ID, null, new ISemanticModification() {
			@Override
			public void apply(EObject element, IModificationContext context) {
				((Element) element).setName("Bor");
			}
		});
	}

	@Fix(QuickfixCrossrefTestLanguageValidator.MULTIFIXABLE_ISSUE)
	public void addDocumentation(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.acceptMulti(issue, "Multi fix", "Multi fix", null, (EObject element, IMultiModificationContext ctx) -> {
			EObject toModify = ctx.getElement();
			// do other things here
			ctx.setModification(toModify, (obj) -> {
				((Element) obj).setDoc("Better documentation");
			});
		});
	}

	@Fix(QuickfixCrossrefTestLanguageValidator.MULTIFIXABLE_ISSUE_2)
	public void addDocumentation2(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.acceptMulti(issue, "Multi fix 2", "Multi fix 2", null, eObj -> ((Element) eObj).setDoc("Even Better documentation"));
	}
}
