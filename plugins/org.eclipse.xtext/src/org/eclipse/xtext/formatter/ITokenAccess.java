/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatter;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.resource.XtextResource;

/**
 * A TokenAccess provides TextRegions for model elements and values.
 * 
 * Technically, it is a lightweight facade over the node model or the serializer's output.
 * 
 * As an abstraction, the TokenAccess provides a linked list of Tokens an Gaps. Tokens and Gaps occur strictly
 * alternating. A token represents the value of an EAttribute or CrossReference. A Gap represents all whitespace and
 * comments between two tokens. If there is no whitespace/comments between two tokens, there will be a Gap-Object in the
 * linked list nonetheless.
 * 
 * The purpose of this class is:
 * <ul>
 * <li>Allow the formatter to operate on a parse document (node model) and a serialized model.</li>
 * <li>Provide a convenient abstraction for formatting (tokens, gaps).
 * <li>Allow fast access to TextRanges. The node model would be too slow to traverse due to its large expression trees.</li>
 * <li>Shield users from surprises due to the node model's structure.</li>
 * </ul>
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * 
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 * @since 2.7
 */
public interface ITokenAccess {

	public interface IComment extends IHidden {
	}

	public interface IGap extends ITextRegion {

		boolean containsComment();

		IToken getNextToken();

		IToken getPreviousToken();

		List<IHidden> getWhitespaceAndComments();

		boolean isUndefined();
	}

	public interface IHidden extends ITextRegion {
		IGap getGap();

		AbstractRule getGrammarElement();

		// IHidden getNextHidden(); // stays within the same gap!
		// IHidden getPreviousHidden(); // stays within the same gap!
	}

	public interface IToken extends ITextRegion {
		AbstractElement getGrammarElement();

		IGap getLeadingGap();

		IToken getNextToken();

		IToken getPreviousToken();

		EObject getSemanticElement();

		IGap getTrailingGap();
	}

	public interface IWhitespace extends IHidden {
	}

	// ISemanticToken tokenForEObject(EObject owner);

	/**
	 * Returns the {@link RuleCall} or the assigned {@link Action} that led to the construction of this EObject.
	 */
	AbstractElement getInvokingGrammarElement(EObject obj);

	// List<IToken> getAllSemanticTokens();

	XtextResource getResource();

	// List<RuleCall> getInvokingRuleCalls(EObject owner, EStructuralFeature features);

	String getText(int offset, int length);

	IToken immediatelyFollowingKeyword(EObject owner, String keyword);

	IToken immediatelyFollowingKeyword(IToken token, String keyword);

	IToken immediatelyPrecedingKeyword(EObject owner, String keyword);

	IToken immediatelyPrecedingKeyword(IToken token, String keyword);

	IToken immediatelyPrecedingKeyword(EObject owner);

	IToken immediatelyPrecedingKeyword(IToken token);

	boolean isMultiline(EObject object);

	IGap leadingGap(EObject owner);

	IToken tokenForFeature(EObject owner, EStructuralFeature feature);

	IToken tokenForKeyword(EObject owner, String keyword);

	// IToken tokenForKeyword(EObject owner, Keyword keyword);

	IToken tokenForRuleCallTo(EObject owner, AbstractRule rule);

	List<IToken> tokensForRuleCallsTo(EObject owner, AbstractRule... rule);

	List<IToken> tokensForKeywords(EObject owner, String... string);

	// List<IToken> tokensForAllCrossReferences(EObject container, CrossReference... ruleCall);

	// List<Pair<IToken, IToken>> tokensForAllKeywordPairs(EObject container, Keyword keyword1, Keyword keyword2);

	// List<Pair<IToken, IToken>> tokensForAllKeywordPairs(EObject container, String keyword1, Keyword keyword2);

	// List<IToken> tokensForAllKeywords(EObject container, Keyword... keyword);

	// List<IToken> tokensForAllKeywords(EObject container, String... string);

	// List<IToken> tokensForAllRuleCalls(EObject container, RuleCall... ruleCall);

	// List<IToken> tokensForFeature(EObject owner, EStructuralFeature feature);

	// List<Pair<IToken, IToken>> tokensForKeywordPairs(EObject owner, Keyword keyword1, Keyword keyword2);

	// List<Pair<IToken, IToken>> tokensForKeywordPairs(EObject owner, String keyword1, Keyword keyword2);

	// List<IToken> tokensForKeywords(EObject owner, Keyword... keyword);

	IGap trailingGap(EObject owner);

}
