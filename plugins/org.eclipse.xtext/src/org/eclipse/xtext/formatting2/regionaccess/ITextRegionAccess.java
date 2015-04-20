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
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.resource.XtextResource;

/**
 * <p>
 * This class provides access to {@link ITextSegment text regions } based on the semantic model. A text region describes
 * the offset and length in characters of a semantic elements within a text document.
 * </p>
 * 
 * <p>
 * Technically, it is a lightweight facade over the node model or the serializer's output.
 * </p>
 * 
 * <p>
 * The text regions are arranged as a linked list of strictly alternating {@link ISemanticRegion semantic regions} and
 * {@link IHiddenRegion hidden region}. HiddenRegions group all hidden tokens (typically whitespace, newlines, tabs and
 * comments) between two semantic tokens. HiddenRegions are empty, but do exist, if there are no hidden tokens between
 * two semantic elements.
 * </p>
 * 
 * <p>
 * Tokens are considered to be hidden, when they have been parsed via terminal rule referenced in "hidden(...)" in the
 * Xtext grammar. In the node model, hidden tokens are usually marked as {@link ILeafNode#isHidden() hidden == true}.
 * </p>
 * 
 * <p>
 * A semantic token can be the value of an EAttribute, a CrossReference or a keyword.
 * </p>
 * 
 * <p>
 * A {@link IHiddenRegion} contains a list of {@link IHiddenRegionPart parts}, which are either {@link IWhitespace white
 * space} or {@link IComment comments}. A HiddenRegion can be empty.
 * </p>
 * 
 * The purpose of this class is:
 * <ul>
 * <li>Allow the formatter to operate on a parsed document (node model) and a serialized model.</li>
 * <li>Provide a convenient abstraction for formatting (tokens, HiddenRegions).
 * <li>Fast access to TextRegions. The node model would be too slow to traverse due to its large expression trees.</li>
 * </ul>
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * 
 * @see ISemanticRegion
 * @see IHiddenRegion
 * 
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 * @since 2.8
 */
public interface ITextRegionAccess {

	/**
	 * @return the {@link RuleCall} or the assigned {@link Action} that led to the construction of this EObject. For the
	 *         model's root element, the {@link ParserRule} is returned.
	 */
	EObject getInvokingGrammarElement(EObject obj);

	/**
	 * @return The {@link XtextResource} that backs the document this class provides access to.
	 */
	XtextResource getResource();

	/**
	 * @return true, if one or more parse error occurred when parsing the document.
	 */
	boolean hasSyntaxError();

	/**
	 * @return true, if an parse error occurred during parsing of the provided EObject or any of its children.
	 */
	boolean hasSyntaxError(EObject object);

	/**
	 * @return the semantic region representing the 'keyword' that immediately follows the EObject or null.
	 */
	ISemanticRegion immediatelyFollowingKeyword(EObject owner, String keyword);

	/**
	 * @return the semantic region representing the 'keyword' that immediately follows the 'region' or null.
	 */
	ISemanticRegion immediatelyFollowingKeyword(ISequentialRegion region, String keyword);

	/**
	 * @return the semantic region for a keyword located right before the provided EObject. May be null if there is no
	 *         preceding semantic region or the preceding semantic region does not represent a keyword.
	 */
	ISemanticRegion immediatelyPrecedingKeyword(EObject owner);

	/**
	 * @return the semantic region for a keyword located right before the provided EObject. May be null if there is no
	 *         preceding semantic region or the preceding semantic region does not represent the provided keyword.
	 */
	ISemanticRegion immediatelyPrecedingKeyword(EObject owner, String keyword);

	/**
	 * @return the semantic region for a keyword located right before the provided region. May be null if there is no
	 *         preceding semantic region or the preceding semantic region does not represent a keyword.
	 */
	ISemanticRegion immediatelyPrecedingKeyword(ISequentialRegion region);

	/**
	 * @return the semantic region for a keyword located right before the provided region. May be null if there is no
	 *         preceding semantic region or the preceding semantic region does not represent the provided keyword.
	 */
	ISemanticRegion immediatelyPrecedingKeyword(ISequentialRegion region, String keyword);

	/**
	 * @return true, if the EObject's text range contains a line-wrap ("\n"). The EObject's text range reaches from the
	 *         beginning of its first semantic region to the end of its last semantic region.
	 */
	boolean isMultiline(EObject object);

	/**
	 * @return the {@link IHiddenRegion} that precedes the EObject's first {@link ISemanticRegion}.
	 * 
	 * @see #trailingHiddenRegion(EObject)
	 */
	IHiddenRegion leadingHiddenRegion(EObject owner);

	/**
	 * @return a text region that reaches from the beginning of its first semantic region to the end of its last
	 *         semantic region.
	 */
	IEObjectRegion regionForEObject(EObject object); // TODO: should be semantic region?

	/**
	 * @return returns the first {@link ISemanticRegion} that represents the value of {@code owner.eGet(feature)}. May
	 *         be null.
	 */
	ISemanticRegion regionForFeature(EObject owner, EStructuralFeature feature);

	/**
	 * @return the first {@link ISemanticRegion} that represent 'keyword' and directly belongs to the provided
	 *         'EObject'. Keywords of child-EObjects are not considered. May be null.
	 */
	ISemanticRegion regionForKeyword(EObject owner, String keyword);

	/**
	 * @return the first {@link ISemanticRegion} that represent a RuleCall to the provided AbstractRule and directly
	 *         belongs to the provided 'EObject'. RuleCalls of child-EObjects are not considered. May be null.
	 */
	ISemanticRegion regionForRuleCallTo(EObject owner, AbstractRule rule);

	/**
	 * @return All {@link ISemanticRegion semantic regions} that represent one of the provided 'keyword's and directly
	 *         belong to the provided 'EObject'. Keywords of child-EObjects are not considered.
	 */
	List<ISemanticRegion> regionsForKeywords(EObject owner, String... string);

	/**
	 * @return All {@link ISemanticRegion semantic regions} that represent a RuleCall to one of the provided
	 *         AbstractRules and directly belong to the provided 'EObject'. RuleCalls of child-EObjects are not
	 *         considered. May be null.
	 */
	List<ISemanticRegion> regionsForRuleCallsTo(EObject owner, AbstractRule... rule);

	/**
	 * @return the {@link IHiddenRegion} that follows after the EObject's last {@link ISemanticRegion}.
	 * 
	 * @see #leadingHiddenRegion(EObject)
	 */
	IHiddenRegion trailingHiddenRegion(EObject owner); // rename to nextHiddenRegion; do same with leading()

	ITextRegionRewriter getRewriter();

	IEObjectRegion regionForRootEObject();

	ITextSegment regionForDocument();

	ITextSegment regionForOffset(int offset, int length);

	ILineRegion lineForOffset(int offset);

	String textForOffset(int offset, int length);

	List<ILineRegion> expandToLines(ITextSegment segment, int leadingLinesToAdd, int trailingLinesToAdd);

	List<IEObjectRegion> regionsForAllEObjects();
}
