/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.util.ITextRegion;

import com.google.inject.ImplementedBy;

/**
 * Delivers {@link ITextRegion}s for model elements or feature settings. The significant text is the part of the text
 * identifying the element, e.g. its name, as opposed to the full region which is the full text representing the
 * element.
 * In addition to this service, the extension interface {@link ILocationInFileProviderExtension} allows to query 
 * for the region that is spanned by an {@link EObject} including its comments.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein - Distinguish significant and full region
 */
@ImplementedBy(DefaultLocationInFileProvider.class)
public interface ILocationInFileProvider {

	/**
	 * @see org.eclipse.xtext.resource.ILocationInFileProviderExtension.RegionDescription#SIGNIFICANT
	 */
	ITextRegion getSignificantTextRegion(EObject obj);
	/**
	 * @see org.eclipse.xtext.resource.ILocationInFileProviderExtension.RegionDescription#SIGNIFICANT
	 */
	ITextRegion getSignificantTextRegion(EObject owner, EStructuralFeature feature, int indexInList);
	/**
	 * @see org.eclipse.xtext.resource.ILocationInFileProviderExtension.RegionDescription#FULL
	 */
	ITextRegion getFullTextRegion(EObject obj);
	/**
	 * @see org.eclipse.xtext.resource.ILocationInFileProviderExtension.RegionDescription#FULL
	 */
	ITextRegion getFullTextRegion(EObject owner, EStructuralFeature feature, int indexInList);
}
