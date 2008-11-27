package org.eclipse.xtext.ui.common.editor.codecompletion;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ContextInformationValidator;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.crossref.ILinkingService;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.ParseTreeUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.Inject;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.core.editor.model.UnitOfWork;

/**
 * @author Michael Clay - Initial contribution and API
 * @author Dennis Hübner - Initial contribution and API
 * @author Heiko Behrens
 */
public class DefaultContentAssistProcessor implements IContentAssistProcessor {

	// logger available to subclasses
	protected final Logger logger = Logger.getLogger(getClass());

	@Inject
	private IProposalProvider proposalProvider;

	/**
	 * @param proposalProvider
	 *            the proposalProvider to set
	 */
	public void setProposalProvider(IProposalProvider proposalProvider) {
		this.proposalProvider = proposalProvider;
	}

	/**
	 * computes the possible grammar elements following the one at the given offset and calls the respective methods on
	 * the proposal provider.
	 */
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, final int offset) {

		ICompletionProposal[] completionProposals = null;

		if (proposalProvider != null) {

			IDocument document = viewer.getDocument();

			if (document instanceof IXtextDocument) {

				List<ICompletionProposal> completionProposalList = new ArrayList<ICompletionProposal>();

				IXtextDocument xtextDocument = (IXtextDocument) document;

				CompositeNode rootNode = xtextDocument.readOnly(new UnitOfWork<CompositeNode>() {
					public CompositeNode exec(XtextResource resource) throws Exception {
						IParseResult parseResult = resource.getParseResult();
						Assert.isNotNull(parseResult);
						return parseResult.getRootNode();
					}
				});

				Assert.isNotNull(rootNode);

				AbstractNode lastCompleteNode = ParseTreeUtil.getLastCompleteNodeByOffset(rootNode, offset);

				LeafNode currentLeafNode = ParseTreeUtil.getCurrentNodeByOffset(rootNode, offset);

				String prefix = calculatePrefix(viewer, offset, currentLeafNode);

				EObject model = lastCompleteNode instanceof AbstractNode ? NodeUtil
						.getNearestSemanticObject((AbstractNode) lastCompleteNode) : lastCompleteNode;

				Set<AbstractElement> nextValidElementSet = new LinkedHashSet<AbstractElement>();
				/**
				 * in case of a crossreference which isnt linked already we evaluate it again and delegate to
				 * proposalProvider (again)
				 */
				if (lastCompleteNode.getGrammarElement() instanceof CrossReference && !isLinked(lastCompleteNode)) {
					nextValidElementSet.add((AbstractElement) lastCompleteNode.getGrammarElement());
					nextValidElementSet.addAll(ParseTreeUtil.getElementSetValidFromOffset(rootNode, lastCompleteNode,
							offset));
				}
				/**
				 * in case of 'at-the-end' of the previous,completed element we evaluate it again for
				 * 'right-to-left-backtracking' cases (e.g. for keyword 'kind' kind>|< |=cursorpos)
				 */
				else if (currentLeafNode == lastCompleteNode) {
					Assignment containingAssignment = GrammarUtil.containingAssignment(lastCompleteNode.getGrammarElement());
					
					if (lastCompleteNode.getGrammarElement() instanceof RuleCall && containingAssignment!=null) {
						nextValidElementSet.add(containingAssignment);
						nextValidElementSet.addAll(ParseTreeUtil.getElementSetValidFromOffset(rootNode, lastCompleteNode, offset));
					} else {
						nextValidElementSet = ParseTreeUtil.getElementSetValidFromOffset(rootNode, lastCompleteNode, offset);
						nextValidElementSet.add((AbstractElement) lastCompleteNode.getGrammarElement());
					}
				}
				else {
					nextValidElementSet = ParseTreeUtil
							.getElementSetValidFromOffset(rootNode, lastCompleteNode, offset);
				}

				ProposalProviderInvokerSwitch proposalProviderInvokerSwitch = new ProposalProviderInvokerSwitch(model,
						document, offset, prefix, proposalProvider);

				for (List<EObject> resolvedElementOrRuleList : new ProposalCandidateResolverSwitch(nextValidElementSet)) {

					List<ICompletionProposal> collectedCompletionProposalList = proposalProviderInvokerSwitch
							.collectCompletionProposalList(resolvedElementOrRuleList);

					completionProposalList.addAll(collectedCompletionProposalList);
				}
				if (completionProposalList != null) {
					List<? extends ICompletionProposal> processedCompletionProposalList = proposalProvider
							.sortAndFilter(completionProposalList, model, prefix, document, offset);
					completionProposals = processedCompletionProposalList.toArray(new ICompletionProposal[] {});
				}
			}
		}

		return completionProposals;
	}

	protected String calculatePrefix(ITextViewer viewer, final int offset, LeafNode currentLeafNode) {

		if (currentLeafNode == null)
			return "";

		String prefix = "";
		StyledText textWidget = viewer.getTextWidget();
		if (textWidget.getCharCount() > 0) {
			int boundedOffset = Math.min(offset, textWidget.getCharCount()) - 1;
			if (currentLeafNode.getTotalOffset() <= boundedOffset)
				prefix = textWidget.getText(currentLeafNode.getTotalOffset(), boundedOffset);
		}

		// if cursor is behind a complete keyword, accept any input => empty
		// prefix
		// TODO: Find a way to distinguish between keywords like "+" or "-" and
		// "extends" or "class"
		// in the latter case, the prefix "" would not always be sufficient
		if (currentLeafNode.getGrammarElement() instanceof Keyword && currentLeafNode.getText().equals(prefix)) {
			prefix = "";
		}

		return prefix;
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

	@Inject
	private ILinkingService linkingService;

	private boolean isLinked(AbstractNode lastCompleteNode) {
		EObject semanticModel = NodeUtil.getNearestSemanticObject(lastCompleteNode);
		CrossReference crossReference = (CrossReference) lastCompleteNode.getGrammarElement();
		EReference eReference = GrammarUtil.getReference(crossReference, semanticModel.eClass());

		List<EObject> referencedObjects = EcoreUtil2.getAllReferencedObjects(semanticModel, eReference);

		if (referencedObjects.isEmpty())
			return false;
		else {
			List<EObject> linkCandidates = linkingService.getLinkedObjects(semanticModel, eReference,
					(LeafNode) lastCompleteNode);
			return !linkCandidates.isEmpty() && referencedObjects.containsAll(linkCandidates);
		}
	}

}
