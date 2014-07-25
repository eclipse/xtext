/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.formatting2.ITextSegment;
import org.eclipse.xtext.resource.XtextResource;

/**
 * A TokenAccess provides TextRegions for model elements and values.
 * 
 * Technically, it is a lightweight facade over the node model or the serializer's output.
 * 
 * As an abstraction, the TokenAccess provides a linked list of Tokens an HiddenRegions. Tokens and HiddenRegions occur
 * strictly alternating. A token represents the value of an EAttribute or CrossReference. A HiddenRegion represents all
 * whitespace and comments between two tokens. If there is no whitespace/comments between two tokens, there will be a
 * HiddenRegion-Object in the linked list nonetheless.
 * 
 * The purpose of this class is:
 * <ul>
 * <li>Allow the formatter to operate on a parse document (node model) and a serialized model.</li>
 * <li>Provide a convenient abstraction for formatting (tokens, HiddenRegions).
 * <li>Allow fast access to TextRanges. The node model would be too slow to traverse due to its large expression trees.</li>
 * <li>Shield users from surprises due to the node model's structure.</li>
 * </ul>
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * 
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 * @since 2.7
 * 
 * 
 */
// TODO: allgemein: rename token* to region*
public interface ITextRegionAccess { // ITextRegionAccess

	// ISemanticToken tokenForEObject(EObject owner);

	ITextSegment expandRegionsByLines(int leadingLines, int trailingLines, ITextSegment... regions);

	// List<IToken> getAllSemanticTokens();

	/**
	 * Returns the {@link RuleCall} or the assigned {@link Action} that led to the construction of this EObject.
	 */
	AbstractElement getInvokingGrammarElement(EObject obj);

	IHiddenRegion getFirstRegionInFile();

	// List<RuleCall> getInvokingRuleCalls(EObject owner, EStructuralFeature features);

	XtextResource getResource();

	String getText(int offset, int length);

	boolean hasSyntaxError(EObject object);

	boolean hasSyntaxError();

	ISemanticRegion immediatelyFollowingKeyword(EObject owner, String keyword);

	ISemanticRegion immediatelyFollowingKeyword(ISequentialRegion region, String keyword);

	ISemanticRegion immediatelyPrecedingKeyword(EObject owner);

	ISemanticRegion immediatelyPrecedingKeyword(EObject owner, String keyword);

	ISemanticRegion immediatelyPrecedingKeyword(ISequentialRegion region);

	ISemanticRegion immediatelyPrecedingKeyword(ISequentialRegion region, String keyword);

	ITextSegment indentationRegion(int offset);

	ITextSegment regionForEObject(EObject object); // TODO: should be semantic region?

	boolean isMultiline(EObject object);

	// IToken tokenForKeyword(EObject owner, Keyword keyword);

	IHiddenRegion leadingHiddenRegion(EObject owner);

	ISemanticRegion regionForFeature(EObject owner, EStructuralFeature feature);

	ISemanticRegion regionForKeyword(EObject owner, String keyword);

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

	ISemanticRegion regionForRuleCallTo(EObject owner, AbstractRule rule);

	List<ISemanticRegion> regionsForKeywords(EObject owner, String... string);

	List<ISemanticRegion> regionsForRuleCallsTo(EObject owner, AbstractRule... rule);

	IHiddenRegion trailingHiddenRegion(EObject owner);
}
