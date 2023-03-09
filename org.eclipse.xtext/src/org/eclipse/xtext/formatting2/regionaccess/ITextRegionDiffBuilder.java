/*******************************************************************************
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.ISequenceAcceptor;
import org.eclipse.xtext.util.ITextRegion;

/**
 * Create instances of {@link ITextRegionAccessDiff}.
 * 
 * The purpose of this service is to create a modified copy of a {@link ITextRegionAccess}.
 * 
 * This service guarantees that
 * <ol>
 * <li>the result has a valid strictly alternating sequence of {@link IHiddenRegion}s and {@link ISemanticRegion}s.</li>
 * <li>{@link IComment}s are appropriately handled according to how associated {@link ISemanticRegion} are modified. See
 * {@link IHiddenRegionPartAssociator} to customize this behavior.</li>
 * <li>The order in which methods of this service are called does not impact the result, except for insertions.</li>
 * </ol>
 * 
 * This service does NOT guarantee consistency to the grammar. This is the callers responsibility.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * 
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 * @since 2.13
 */
public interface ITextRegionDiffBuilder {

	ITextRegionAccessDiff create();

	ITextRegionAccess getOriginalTextRegionAccess();

	/**
	 * @return true IFF there is a modification between {@link ITextRegion#getOffset()} and
	 *         offset+{@link ITextRegion#getLength()}.
	 */
	boolean isModified(ITextRegion region);

	void move(IHiddenRegion insertAt, IHiddenRegion substituteFirst, IHiddenRegion substituteLast);

	void remove(IHiddenRegion first, IHiddenRegion last);

	void remove(ISemanticRegion region);

	void replace(IHiddenRegion first, IHiddenRegion last, IHiddenRegion substituteFirst, IHiddenRegion substituteLast);

	void replace(IHiddenRegion first, IHiddenRegion last, ITextRegionAccess substitute);

	void replace(ISemanticRegion region, String newText);

	ISequenceAcceptor replaceSequence(IHiddenRegion first, IHiddenRegion last, ISerializationContext ctx, EObject root);
}