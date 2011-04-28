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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.ui.refactoring.IDependentElementsCalculator;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * Delivers all contained elements of an element to be renamed in order to updated references to them.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DefaultDependentElementsCalculator implements IDependentElementsCalculator {
	
	@Inject
	private IQualifiedNameProvider nameProvider;

	public List<URI> getDependentElementURIs(EObject baseElement, IProgressMonitor monitor) {
		SubMonitor progress = SubMonitor.convert(monitor, 10);
		List<URI> elementURIs = Lists.newArrayList();
		for (Iterator<EObject> i = EcoreUtil.getAllProperContents(baseElement, false); i.hasNext();) {
			if(progress.isCanceled())
				break;
			EObject childElement = i.next();
			if (nameProvider.getFullyQualifiedName(childElement)!=null) {
				URI childURI = EcoreUtil.getURI(childElement);
				if (childURI != null) {
					elementURIs.add(childURI);
				}
			}
			progress.worked(1);
			progress.setWorkRemaining(10);
		}
		return elementURIs;
	}

}
