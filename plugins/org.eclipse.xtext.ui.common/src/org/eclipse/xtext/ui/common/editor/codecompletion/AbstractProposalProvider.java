package org.eclipse.xtext.ui.common.editor.codecompletion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.LexerRule;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.crossref.ILinkingService;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.service.Inject;
import org.eclipse.xtext.util.Pair;

/**
 * Convenient super class for <code>IProposalProvider</code> implementations.
 * 
 * @author Michael Clay - Initial contribution and API
 * @author Heiko Behrens
 * 
 * @see IProposalProvider
 */
public abstract class AbstractProposalProvider implements IProposalProvider {
	// constants
	protected static final String LEXER_RULE_ID = "ID";
	protected static final String LEXER_RULE_INT = "INT";
	protected static final String LEXER_RULE_STRING = "STRING";
	// logger available to subclasses
	protected final Logger logger = Logger.getLogger(getClass());

	@Inject
	protected ILinkingService linkingService;

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.xtext.ui.common.editor.codecompletion.IProposalProvider#completeKeyword(org.eclipse.xtext.Keyword, org.eclipse.emf.ecore.EObject, java.lang.String, org.eclipse.jface.text.IDocument, int)
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
	 * @see org.eclipse.xtext.ui.common.editor.codecompletion.IProposalProvider#completeRuleCall(org.eclipse.xtext.RuleCall, org.eclipse.emf.ecore.EObject, java.lang.String, org.eclipse.jface.text.IDocument, int)
	 */
	public List<? extends ICompletionProposal> completeRuleCall(RuleCall ruleCall, EObject model, String prefix,
			IDocument doc, int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeRuleCall '" + ruleCall.getName() + "' cardinality '" + ruleCall.getCardinality()
					+ "' for model '" + model + "' and prefix '" + prefix.trim() + "'");
		}
		
		AbstractRule calledRule = GrammarUtil.calledRule(ruleCall);
		
		if (calledRule instanceof LexerRule) {
			return doCompleteLexerRuleRuleCall((LexerRule) calledRule, ruleCall, offset);
		} 
		
		return Collections.emptyList();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.xtext.ui.common.editor.codecompletion.IProposalProvider#sortAndFilter(java.util.List)
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
	 * Concrete subclasses can override this to provide a more meaningful and sophisticated behaviour
	 * whenever a list of ICompletionProposal's should be computed for simple <code>LexerRule</code> call's.
	 * 
	 * This implementation returns one <code>ICompletionProposal</code> with a displayString composed
	 * of the name of the containing rule plus the featurename of an optional assignment and at the end the name 
	 * of the given LexerRule (e.i. ParserRuleName+AssignmentFeatureName+LexerRuleName) or {@link #getDefaultIntegerValue()} 
	 * if its <i>INT</i> based LexerRule.
	 * 
	 * @param lexerRule the 'called' LexerRule instance
	 * @param ruleCall the ruleCall for the provided lexerRule
	 * @param offset an offset within the document for which completions should be computed
	 * @return a computed list of <code>ICompletionProposal</code> for the given <code>LexerRule</code>
	 */
	protected List<? extends ICompletionProposal> doCompleteLexerRuleRuleCall(LexerRule lexerRule,RuleCall ruleCall, int offset) {
		ParserRule containingParserRule = GrammarUtil.containingParserRule(ruleCall);
		Assignment containingAssignment = GrammarUtil.containingAssignment(ruleCall);
		
		String defaultDisplayString = containingParserRule.getName() + 
			(null != containingAssignment ? firstLetterCapitalized(containingAssignment.getFeature()) : "") + lexerRule.getName();
		
		if (LEXER_RULE_INT.equalsIgnoreCase(lexerRule.getName())) {
			defaultDisplayString=String.valueOf(getDefaultIntegerValue());
		} else if (LEXER_RULE_STRING.equalsIgnoreCase(lexerRule.getName())) {
			defaultDisplayString="\""+defaultDisplayString+"\"";
		} 
		
		return Collections.singletonList(createCompletionProposal(defaultDisplayString, offset));
	}
	
	/**
	 * @return the default integer value for ecore::EInt <code>RuleCall<>
	 */
	protected int getDefaultIntegerValue() {
		return 0;
	}
	
	/**
	 * 
	 * @return the id of the plug-in containing the image files;
	 *         <code>null</code> is returned if the plug-in does not exist
	 */
	protected abstract String getPluginId();

	/**
	 * Returns the the relative path of the default image file, relative to the
	 * root of the containing plug-in; the path must be legal The image would
	 * typically be shown to the left of the <code>ICompletionProposal</code>
	 * display string.
	 * 
	 * @return the image file path of the default image to be shown or
	 *         <code>null</code> if no image is desired
	 * @see #getPluginId()
	 */
	protected abstract String getDefaultImageFilePath();

	/**
	 * Concrete subclasses can override this to provide custom lookup behaviour
	 * for <code>CrossReference</code>. This implementation delegates to the
	 * injected LinkingService
	 * 
	 * @return a list of <code>ICompletionProposal</code> matching the given
	 *         assignment
	 */
	protected List<? extends ICompletionProposal> lookupCrossReference(CrossReference crossReference, EObject model,
			int offset) {
		
		List<ICompletionProposal> completionProposalList = new ArrayList<ICompletionProposal>();

		if (linkingService != null) {
			EObject semanticModel = model instanceof AbstractNode ? NodeUtil.getNearestSemanticObject((AbstractNode) model) : model;
			List<Pair<String, URI>> candidates = linkingService.getLinkCandidates(semanticModel, crossReference, "");
			for (Pair<String, URI> candidate : candidates) {
				completionProposalList.add(createCompletionProposal(candidate.getFirstElement(), offset));
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

	/**
	 * @param text to apply
	 * @return the provided string with the first letter capitalized
	 */
	protected final String firstLetterCapitalized(String text) {
		if (text == null || text.length() == 0) {
			return text;
		}
		return text.substring(0, 1).toUpperCase() + text.substring(1, text.length());
	}

}
