/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.util.ITextRegion;

/**
 * Extends the functionality of the {@link ILocationInFileProvider} to
 * allow clients to query for a region with more fine grained criteria.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.3
 */
public interface ILocationInFileProviderExtension {

	/**
	 * Describes the kind of region that is queried.
	 */
	enum RegionDescription {
		/**
		 * The significant region of an {@link EObject} is basically
		 * the part of the text that identifies the instance in a 
		 * human readable manner.
		 */
		SIGNIFICANT,
		/**
		 * The full region spans the outermost visible nodes of an instance.
		 * Comments and whitespaces are trimmed.
		 */
		FULL,
		/**
		 * Allows to obtain the range including the associated comments.
		 */
		INCLUDING_COMMENTS,
		/**
		 * Returns the complete range including leading and trailing whitespace.
		 */
		INCLUDING_WHITESPACE
	}
	
	/**
	 * Queries for parts of the text region that the given object is originates from.
	 * @param object the instance whose region should be returned.
	 * @param query the hint about the requested range.
	 * @return the text region or <code>null</code> if the object does not have an associated text region.
	 */
	/* @Nullable */
	ITextRegion getTextRegion(EObject object, RegionDescription query);
	
	/**
	 * Queries for parts of the text region that parts of the given object originate from.
	 * @param object the instance whose region should be returned.
	 * @param feature the feature that was set when the requested range was consumed by the parser.
	 * @param indexInList the index in the list of feature values. <code>-1</code> if all values should be considered.
	 * @param query the hint about the requested range.
	 * @return the text region or <code>null</code> if the object does not have an associated text region.
	 */
	/* @Nullable */
	ITextRegion getTextRegion(EObject object, EStructuralFeature feature, int indexInList, RegionDescription query);
	
}
