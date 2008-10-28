package org.eclipse.xtext.ui.common.editor.codecompletion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;

/**
 * Convenient super class for <code>IProposalProvider</code> implementations.
 * 
 * @author Michael Clay - Initial contribution and API
 * 
 * @see IProposalProvider
 */
public abstract class AbstractProposalProvider implements IProposalProvider {

	protected static final String LEXER_RULE_ID = "ID";
	// logger available to subclasses
	protected final Logger logger = Logger.getLogger(getClass());

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.xtext.ui.common.editor.codecompletion.IProposalProvider#
	 * completeKeyword(org.eclipse.xtext.Keyword, org.eclipse.emf.ecore.EObject,
	 * java.lang.String, org.eclipse.jface.text.IDocument, int)
	 */
	public List<? extends ICompletionProposal> completeKeyword(Keyword keyword, EObject model, String prefix,
			IDocument doc, int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeKeyword '" + keyword.getValue() + "' for model '" + model + "' and prefix '"
					+ prefix.trim() + "'");
		}
		String text = keyword.getValue().length() == 1 ? keyword.getValue() : keyword.getValue() + " ";

		return Collections.singletonList(createCompletionProposal(text, offset));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.xtext.ui.common.editor.codecompletion.IProposalProvider#
	 * completeRuleCall(org.eclipse.xtext.RuleCall,
	 * org.eclipse.emf.ecore.EObject, java.lang.String,
	 * org.eclipse.jface.text.IDocument, int)
	 */
	public List<? extends ICompletionProposal> completeRuleCall(RuleCall ruleCall, EObject model, String prefix,
			IDocument doc, int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeRuleCall '" + ruleCall.getName() + "' cardinality '" + ruleCall.getCardinality()
					+ "' for model '" + model + "' and prefix '" + prefix.trim() + "'");
		}
		return Collections.emptyList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.xtext.ui.common.editor.codecompletion.IProposalProvider#
	 * sortAndFilter(java.util.List)
	 */
	public List<? extends ICompletionProposal> sortAndFilter(List<? extends ICompletionProposal> completionProposalList) {
		return doSortAndFilter(completionProposalList);
	}

	/**
	 * Concrete subclasses can override this for custom sort and filter
	 * behavior. Gets called after all completion proposals have been collected.
	 */
	protected List<? extends ICompletionProposal> doSortAndFilter(
			List<? extends ICompletionProposal> completionProposalList) {
		return completionProposalList;
	}

	/**
	 * 
	 * @return the id of the plug-in containing the image file;
	 *         <code>null</code> is returned if the plug-in does not exist
	 */
	protected abstract String getPluginId();

	/**
	 * Returns the the relative path of the default image file, relative to the
	 * root of the containing plug-in; the path must be legal The image would
	 * typically be shown to the left of the display string.
	 * 
	 * @return the image file path of the default image to be shown or
	 *         <code>null</code> if no image is desired
	 * @see #getPluginId()
	 */
	protected abstract String getDefaultImageFilePath();

	/**
	 * Concrete subclasses can override this to provide custom lookup behaviour
	 * for <code>CrossReference</code>. The default behaviour of this method is
	 * to lookup all <code>RuleCall</code> within the current parsetree matching
	 * the type of the given CrossReference.
	 * 
	 * @return a list of <code>ICompletionProposal</code> matching the given
	 *         assignment
	 */
	protected List<? extends ICompletionProposal> lookupCrossReference(CrossReference crossReference, EObject model, int offset) {
		List<ICompletionProposal> completionProposalList = new ArrayList<ICompletionProposal>();
		for (CompositeNode compositeNode : EcoreUtil2.getAllContentsOfType(EcoreUtil2.getRootContainer(model),
				CompositeNode.class)) {
			if (compositeNode.getGrammarElement() instanceof RuleCall
					&& crossReference.getType().getName().equals(
							((RuleCall) compositeNode.getGrammarElement()).getName())) {
				for (LeafNode leafNode : compositeNode.getLeafNodes()) {
					if (leafNode.getGrammarElement() instanceof RuleCall
							&& LEXER_RULE_ID.equalsIgnoreCase(((RuleCall) leafNode.getGrammarElement()).getName())) {
						completionProposalList.add(createCompletionProposal(leafNode.getText(), offset));
					}
				}
			}
		}
		return completionProposalList;
	}

	/**
	 * @return a new <code>XtextCompletionProposal</code> for the given text and
	 *         offset.
	 */
	protected final XtextCompletionProposal createCompletionProposal(String text, int offset) {
		return new XtextCompletionProposal(text, new StyledString(text), text, getDefaultImageFilePath(),
				getPluginId(), offset);
	}

}
