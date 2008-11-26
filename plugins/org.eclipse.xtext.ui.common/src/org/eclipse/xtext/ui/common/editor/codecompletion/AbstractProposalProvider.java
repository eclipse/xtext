package org.eclipse.xtext.ui.common.editor.codecompletion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.LexerRule;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.crossref.impl.SimpleAttributeResolver;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.ParseTreeUtil;
import org.eclipse.xtext.service.Inject;
import org.eclipse.xtext.util.Strings;

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
	protected ILinkingCandidatesService linkingCandidatesService;

	protected SimpleAttributeResolver<String> nameResolver;
	
	protected SimpleAttributeResolver<String> createNameResolver() {
		return SimpleAttributeResolver.newResolver(String.class, "name");
	}
	
	public AbstractProposalProvider() {
		nameResolver = createNameResolver();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xtext.ui.common.editor.codecompletion.IProposalProvider#completeKeyword(org.eclipse.xtext.Keyword,
	 * org.eclipse.emf.ecore.EObject, java.lang.String, org.eclipse.jface.text.IDocument, int)
	 */
	public List<? extends ICompletionProposal> completeKeyword(Keyword keyword, EObject model, String prefix,
			IDocument doc, int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeKeyword '" + keyword.getValue() + "' for model '" + model + "' and prefix '"
					+ prefix.trim() + "'");
		}
		String text = keyword.getValue().length() == 1 ? keyword.getValue() : keyword.getValue() + " ";
		return Collections.singletonList(createCompletionProposal(keyword, model, text, offset));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xtext.ui.common.editor.codecompletion.IProposalProvider#completeRuleCall(org.eclipse.xtext.RuleCall,
	 * org.eclipse.emf.ecore.EObject, java.lang.String, org.eclipse.jface.text.IDocument, int)
	 */
	public List<? extends ICompletionProposal> completeRuleCall(RuleCall ruleCall, EObject model, String prefix,
			IDocument doc, int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeRuleCall '" + ruleCall.getName() + "' cardinality '" + ruleCall.getCardinality()
					+ "' for model '" + model + "' and prefix '" + prefix.trim() + "'");
		}

		AbstractRule calledRule = GrammarUtil.calledRule(ruleCall);

		if (calledRule instanceof LexerRule) {
			return doCompleteLexerRuleRuleCall((LexerRule) calledRule, ruleCall, model, offset);
		}

		return Collections.emptyList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtext.ui.common.editor.codecompletion.IProposalProvider#sortAndFilter(java.util.List,
	 * org.eclipse.emf.ecore.EObject, java.lang.String, org.eclipse.jface.text.IDocument, int,
	 * org.eclipse.xtext.parsetree.AbstractNode, org.eclipse.xtext.parsetree.LeafNode)
	 */
	public List<? extends ICompletionProposal> sortAndFilter(
			List<? extends ICompletionProposal> completionProposalList, EObject model, String prefix,
			IDocument document, int offset) {
		return doSortAndFilter(completionProposalList, model, prefix, document, offset);
	}

	/**
	 * Concrete subclasses can override this to provide a more meaningful and sophisticated behaviour whenever a list of
	 * ICompletionProposal's should be computed for simple <code>LexerRule</code> call's.
	 * 
	 * This implementation returns one <code>ICompletionProposal</code> with a displayString composed of the name of the
	 * containing rule plus the featurename of an optional assignment and at the end the name of the given LexerRule
	 * (e.i. ParserRuleName+AssignmentFeatureName+LexerRuleName) or {@link #getDefaultIntegerValue()} if its <i>INT</i>
	 * based LexerRule.
	 * 
	 * @param lexerRule
	 *            the 'called' LexerRule instance
	 * @param ruleCall
	 *            the ruleCall for the provided lexerRule
	 * @param offset
	 *            an offset within the document for which completions should be computed
	 * @return a computed list of <code>ICompletionProposal</code> for the given <code>LexerRule</code>
	 */
	protected List<? extends ICompletionProposal> doCompleteLexerRuleRuleCall(LexerRule lexerRule, RuleCall ruleCall,
			EObject model, int offset) {
		ParserRule containingParserRule = GrammarUtil.containingParserRule(ruleCall);
		Assignment containingAssignment = GrammarUtil.containingAssignment(ruleCall);

		String defaultDisplayString = containingParserRule.getName()
				+ (null != containingAssignment ? firstLetterCapitalized(containingAssignment.getFeature()) : "")
				+ lexerRule.getName();

		if (LEXER_RULE_INT.equalsIgnoreCase(lexerRule.getName())) {
			defaultDisplayString = String.valueOf(getDefaultIntegerValue());
		}
		else if (LEXER_RULE_STRING.equalsIgnoreCase(lexerRule.getName())) {
			defaultDisplayString = "\"" + defaultDisplayString + "\"";
		}

		return Collections.singletonList(createCompletionProposal(containingAssignment, model, defaultDisplayString,
				offset));
	}

	/**
	 * @return the default integer value for ecore::EInt <code>RuleCall<>
	 */
	protected int getDefaultIntegerValue() {
		return 0;
	}

	/**
	 * 
	 * @return the id of the plug-in containing the image files; <code>null </code> is returned if the plug-in does not
	 *         exist
	 */
	protected abstract String getPluginId();

	/**
	 * Returns the the relative path of the default image file, relative to the root of the containing plug-in; the path
	 * must be legal The image would typically be shown to the left of the <code>ICompletionProposal</code> display
	 * string.
	 * 
	 * @return the image file path of the default image to be shown or <code>null</code> if no image is desired
	 * @see #getPluginId()
	 */
	protected abstract String getDefaultImageFilePath();

	/**
	 * Concrete subclasses can override this to provide custom lookup behaviour for <code>CrossReference</code>. This
	 * implementation delegates to the injected LinkingService
	 * 
	 * @return a list of <code>ICompletionProposal</code> matching the given assignment
	 */
	protected List<? extends ICompletionProposal> lookupCrossReference(CrossReference crossReference, EObject model,
			String prefix, int offset) {

		List<ICompletionProposal> completionProposalList = new ArrayList<ICompletionProposal>();

		if (linkingCandidatesService != null) {
			final EReference ref = GrammarUtil.getReference(crossReference, model.eClass());
			final List<EObject> candidates = linkingCandidatesService.getLinkingCandidates(model, ref);
			for (EObject candidate : candidates) {
				completionProposalList.add(createCompletionProposal(crossReference, model, getLabel(
						candidate, ref, model), offset));
			}
		}

		return completionProposalList;
	}
	
	protected String getLabel(EObject candidate, EReference ref, EObject context) {
		return nameResolver.getValue(candidate);
	}

	/**
	 * @return a new <code>XtextCompletionProposal</code> for the given text and offset.
	 */
	protected final XtextCompletionProposal createCompletionProposal(AbstractElement abstractElement, EObject model,
			String text, int offset) {
		return new XtextCompletionProposal(abstractElement, model, text, new StyledString(text), text,
				getDefaultImageFilePath(), getPluginId(), offset);
	}

	/**
	 * Concrete subclasses can override this for custom sort and filter behavior. Gets called after all completion
	 * proposals have been collected.
	 * 
	 * The default behavior of this implementation is to sort duplicates and to trim matching
	 * <code>ICompletionProposal#displayString</code> with matching prefix values.
	 * 
	 * @see #sortAndFilter(List, EObject, String, IDocument, int, AbstractNode, LeafNode)
	 */
	protected List<? extends ICompletionProposal> doSortAndFilter(
			List<? extends ICompletionProposal> completionProposalList, EObject model, String prefix,
			IDocument document, int offset) {

		Map<String, ICompletionProposal> displayString2ICompletionProposalMap = new HashMap<String, ICompletionProposal>();

		for (Iterator<? extends ICompletionProposal> iterator = completionProposalList.iterator(); iterator.hasNext();) {

			ICompletionProposal completionProposal = iterator.next();

			// filter duplicate displayString
			if (!displayString2ICompletionProposalMap.containsKey(completionProposal.getDisplayString())) {

				displayString2ICompletionProposalMap.put(completionProposal.getDisplayString(), completionProposal);

				if (model != null) {

					CompositeNode parserNode = NodeUtil.getRootNode(model);

					LeafNode currentLeafNode = ParseTreeUtil.getCurrentNodeByOffset(parserNode, offset);

					boolean isCursorAtTheEndOfTheLastElement = offset == (currentLeafNode.getOffset() + currentLeafNode
							.getLength());

					if (isCursorAtTheEndOfTheLastElement && completionProposal instanceof XtextCompletionProposal) {

						XtextCompletionProposal xtextCompletionProposal = (XtextCompletionProposal) completionProposal;

						AbstractElement abstractElement = xtextCompletionProposal.getAbstractElement();

						EObject grammarElement = currentLeafNode.getGrammarElement();
						// at the end of the last element we want to filter only the CompletionProposal for the same grammar element
						if (((isCursorAtTheEndOfTheLastElement && abstractElement.equals(grammarElement)) || !isCursorAtTheEndOfTheLastElement)
								&& !completionProposal.getDisplayString().startsWith(currentLeafNode.getText())) {
							if (logger.isDebugEnabled()) {
								logger.debug("filter completionProposal '" + completionProposal + "'");
							}
							iterator.remove();
						}
					}
				}

			}
			else {
				if (logger.isDebugEnabled()) {
					logger.debug("filter duplicate completionProposal '" + completionProposal + "'");
				}

				iterator.remove();
			}
		}

		return completionProposalList;
	}

	/**
	 * @param text
	 *            to apply
	 * @return the provided string with the first letter capitalized
	 */
	protected final String firstLetterCapitalized(String text) {
		return Strings.toFirstUpper(text);
	}

}
