
package org.eclipse.xtext.ui.tests.editor.contentassist;

import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.contentassist.AbstractTwoContextsTestLanguageProposalProvider;

import com.google.common.base.Predicate;


public class TwoContextsTestLanguageProposalProvider extends AbstractTwoContextsTestLanguageProposalProvider {

	@Override
	public void completeKeyword(Keyword keyword, final ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		super.completeKeyword(keyword, context, filter(acceptor, new Predicate<ICompletionProposal>() {
			public boolean apply(ICompletionProposal input) {
				if (!input.getDisplayString().startsWith(context.getPrefix()))
					throw new IllegalStateException("proposed element '"+input.getDisplayString()+"' does not start with '"+ context.getPrefix()+"'");
				return true;
			}
		}));
	}
}
