/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.linking;

import static com.google.common.collect.Iterables.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.resource.DefaultLocationInFileProvider;
import org.eclipse.xtext.util.ITextRegion;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class Xtend2LocationInFileProvider extends DefaultLocationInFileProvider {

	@Inject
	private IXtend2JvmAssociations xtend2JvmAssociations;
	
	@Override
	public ITextRegion getFullTextRegion(EObject element) {
		return super.getFullTextRegion(convertToXtendSource(element));
	}

	@Override
	public ITextRegion getFullTextRegion(EObject owner, EStructuralFeature feature, int indexInList) {
		return super.getFullTextRegion(convertToXtendSource(owner), feature, indexInList);
	}
	
	@Override
	public ITextRegion getSignificantTextRegion(EObject element) {
		return super.getSignificantTextRegion(convertToXtendSource(element));
	}

	@Override
	public ITextRegion getSignificantTextRegion(EObject owner, EStructuralFeature feature, int indexInList) {
		return super.getSignificantTextRegion(convertToXtendSource(owner), feature, indexInList);
	}
	
	protected EObject convertToXtendSource(EObject element) {
		if(element == null)
			return null;
		Iterable<EObject> xtendSources = xtend2JvmAssociations.getXtendElements(element);
		return (isEmpty(xtendSources)) ? element : xtendSources.iterator().next();
	}
}
