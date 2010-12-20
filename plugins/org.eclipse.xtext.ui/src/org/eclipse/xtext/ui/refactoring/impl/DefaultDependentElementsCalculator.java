/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.ui.refactoring.ElementRenameInfo;
import org.eclipse.xtext.ui.refactoring.IDependentElementsCalculator;
import org.eclipse.xtext.util.ITextRegion;

import com.google.inject.Inject;
import com.google.inject.internal.Lists;

/**
 * Delivers all contained elements of an element to be renamed in order to updated references to them.
 * 
 * @author koehnlein - Initial contribution and API
 */
public class DefaultDependentElementsCalculator implements IDependentElementsCalculator {

	@Inject
	private ILocationInFileProvider locationInFileProvider;

	public Iterable<ElementRenameInfo> getDependentElementRenameInfos(EObject baseElement,
			ElementRenameInfo baseRenameInfo) {
		List<ElementRenameInfo> elementRenameInfos = Lists.newArrayList();
		for (Iterator<EObject> i = EcoreUtil.getAllProperContents(baseElement, false); i.hasNext();) {
			EObject childElement = i.next();
			URI childURI = EcoreUtil.getURI(childElement);
			ITextRegion childTextRegion = locationInFileProvider.getSignificantTextRegion(childElement);
			if (childURI != null && childTextRegion != null) {
				elementRenameInfos.add(new ElementRenameInfo(baseRenameInfo.getDocument(), childURI, childTextRegion
						.getOffset()));
			}
		}
		return elementRenameInfos;
	}

}
