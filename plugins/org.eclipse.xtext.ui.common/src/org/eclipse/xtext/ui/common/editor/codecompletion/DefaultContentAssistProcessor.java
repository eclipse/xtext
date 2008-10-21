package org.eclipse.xtext.ui.common.editor.codecompletion;

import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ContextInformationValidator;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.ParseTreeUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.Inject;
import org.eclipse.xtext.ui.core.editor.model.UnitOfWork;
import org.eclipse.xtext.ui.core.editor.model.XtextDocument;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class DefaultContentAssistProcessor implements IContentAssistProcessor {

	@Inject
	private IProposalProvider proposalProvider;

	/**
	 * computes the possible grammar elements following the one at the given
	 * offset and calls the respective methods on the proposal provider.
	 */
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, final int offset) {
		if (proposalProvider != null) {
			IDocument document = viewer.getDocument();
			if (document instanceof XtextDocument) {
				XtextDocument xtextDocument = (XtextDocument) document;

				CompositeNode rootNode = xtextDocument.readOnly(new UnitOfWork<CompositeNode>() {
					public CompositeNode exec(XtextResource resource) throws Exception {
						IParseResult parseResult = resource.getParseResult();
						Assert.isNotNull(parseResult);
						return parseResult.getRootNode();
					}
				});
				Assert.isNotNull(rootNode);
				LeafNode currentNode = ParseTreeUtil.getCurrentNodeByOffset(rootNode, offset);
				// AbstractNode lastNode =
				// ParseTreeUtil.getLastCompleteNodeByOffset(rootNode, offset);
				String prefix = viewer.getTextWidget().getText(currentNode.getOffset(), offset);
				List<ICompletionProposal> allProposals = null;
				EObject grammarElement = currentNode.getGrammarElement();
				if (grammarElement instanceof Keyword) {
					allProposals = proposalProvider.completeKeyword((Keyword) grammarElement,
							rootNode, prefix, xtextDocument);
				}
				else if (grammarElement instanceof RuleCall) {
					// FIXME allProposals =
					// proposalProvider.completeRuleCall((RuleCall) currentNode,
					// rootNode, prefix);
				}
				if (allProposals != null) {
					return (ICompletionProposal[]) proposalProvider.sortAndFilter(allProposals).toArray();
				}
			}
		}
		return null;
	}

	public char[] getCompletionProposalAutoActivationCharacters() {
		return null;
	}

	public String getErrorMessage() {
		return null;
	}

	public IContextInformation[] computeContextInformation(ITextViewer viewer, int offset) {
		return null;
	}

	public char[] getContextInformationAutoActivationCharacters() {
		return null;
	}

	public IContextInformationValidator getContextInformationValidator() {
		return new ContextInformationValidator(this);
	}

}
