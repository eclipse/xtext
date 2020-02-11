/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.resource.XtextResource;

/**
 * <p>
 * This class provides access to {@link ITextSegment text regions } based on the semantic model. A text region describes the offset and
 * length in characters of a semantic elements within a text document.
 * </p>
 * 
 * <p>
 * Technically, it is a lightweight facade over the node model or the serializer's output.
 * </p>
 * 
 * <p>
 * The text regions are arranged as a linked list of strictly alternating {@link ISemanticRegion semantic regions} and {@link IHiddenRegion
 * hidden region}. HiddenRegions group all hidden tokens (typically whitespace, newlines, tabs and comments) between two semantic tokens.
 * HiddenRegions are empty, but do exist, if there are no hidden tokens between two semantic elements.
 * </p>
 * 
 * <p>
 * Tokens are considered to be hidden, when they have been parsed via terminal rule referenced in "hidden(...)" in the Xtext grammar. In the
 * node model, hidden tokens are usually marked as {@link ILeafNode#isHidden() hidden == true}.
 * </p>
 * 
 * <p>
 * A semantic token can be the value of an EAttribute, a CrossReference or a keyword.
 * </p>
 * 
 * <p>
 * A {@link IHiddenRegion} contains a list of {@link IHiddenRegionPart parts}, which are either {@link IWhitespace white space} or
 * {@link IComment comments}. A HiddenRegion can be empty.
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

	ITextRegionExtensions getExtensions();

	/**
	 * @return The {@link XtextResource} that backs the document this class provides access to.
	 */
	XtextResource getResource();

	ITextRegionRewriter getRewriter();

	ILineRegion regionForLineAtOffset(int offset);

	/**
	 * Returns a the text region for a semantic element (i.e. and EObject from the AST).
	 */
	IEObjectRegion regionForEObject(EObject semanticElement);

	ITextSegment regionForDocument();

	ITextSegment regionForOffset(int offset, int length);

	IEObjectRegion regionForRootEObject();

	String textForOffset(int offset, int length);

	boolean hasSyntaxError();

}
