package org.eclipse.xtext.ui.common.editor.codecompletion;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ContextInformationValidator;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.ParseTreeUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.Inject;
import org.eclipse.xtext.ui.core.editor.model.UnitOfWork;
import org.eclipse.xtext.ui.core.editor.model.XtextDocument;

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
	 * computes the possible grammar elements following the one at the given
	 * offset and calls the respective methods on the proposal provider.
	 */
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, final int offset) {
		
		ICompletionProposal[] completionProposals = null;
		
		if (proposalProvider != null) {

			IDocument document = viewer.getDocument();
			
			if (document instanceof XtextDocument) {
				
				List<ICompletionProposal> completionProposalList = new ArrayList<ICompletionProposal>();
				
				XtextDocument xtextDocument = (XtextDocument) document;

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

				String prefix = null==currentLeafNode ? "" : currentLeafNode.getText();
				
				Set<AbstractElement> nextValidElementSet = new LinkedHashSet<AbstractElement>();
				/**
				 * in the case of a non linked crossreference we delegate to proposalProvider (again) 
				 */
				if (lastCompleteNode.getGrammarElement() instanceof CrossReference && !isLinked(lastCompleteNode)) {
					
					nextValidElementSet.add((AbstractElement) lastCompleteNode.getGrammarElement());
				} 
				/**
				 * in the case we are at the end of the completed previous element add for 'right-to-left' backtracking cases
				 */
				else if (currentLeafNode==lastCompleteNode) {
					nextValidElementSet.add((AbstractElement) lastCompleteNode.getGrammarElement());
				}
				
				nextValidElementSet.addAll(ParseTreeUtil.getElementSetValidFromOffset(rootNode,lastCompleteNode, offset));
				
				ProposalProviderInvokerSwitch proposalProviderInvokerSwitch = new ProposalProviderInvokerSwitch(
						lastCompleteNode, document, offset, prefix, proposalProvider);
				
				for (List<EObject> resolvedElementOrRuleList : new ProposalCandidateResolverSwitch(nextValidElementSet)) {

					List<ICompletionProposal> collectedCompletionProposalList = 
						proposalProviderInvokerSwitch.collectCompletionProposalList(resolvedElementOrRuleList);
					
					completionProposalList.addAll(collectedCompletionProposalList);
				}

				if (completionProposalList != null) {
					List<? extends ICompletionProposal> sortAndFilter = proposalProvider.sortAndFilter(completionProposalList,currentLeafNode,prefix,document,offset);
					completionProposals =  sortAndFilter.toArray(new ICompletionProposal[] {});
				}
			}
		}
		
		return completionProposals;
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

	
	@SuppressWarnings("unchecked")
	private boolean isLinked(AbstractNode lastCompleteNode) {

		EObject semanticModel = NodeUtil.getNearestSemanticObject(lastCompleteNode);

		EReference eReference = getReference((CrossReference) lastCompleteNode.getGrammarElement(), semanticModel
				.eClass());

		if (eReference.getUpperBound() == 1) {

			if (null != semanticModel.eGet(eReference)) {
				return true;
			}
		}
		else {

			EcoreEList<EObject> ecoreEList = (EcoreEList<EObject>) semanticModel.eGet(eReference);

			for (EObject object : ecoreEList) {

				if (EcoreUtil2.getURIFragment(object).equalsIgnoreCase(((LeafNode) lastCompleteNode).getText())) {
					return true;
				}
			}
		}

		return false;
	}

	private EReference getReference(CrossReference ref, EClass class1) {

		EList<EReference> references = class1.getEAllReferences();

		String feature = GrammarUtil.containingAssignment(ref).getFeature();

		for (EReference reference : references) {
			if (!reference.isContainment() && reference.getName().equals(feature))
				return reference;
		}
		return null;
	}


}
