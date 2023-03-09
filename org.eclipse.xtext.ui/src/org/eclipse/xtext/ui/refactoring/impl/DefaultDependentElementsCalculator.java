/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
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

	private static final int MONITOR_CHUNK_SIZE = 1000;
	
	@Override
	public List<URI> getDependentElementURIs(EObject baseElement, IProgressMonitor monitor) {
		SubMonitor progress = SubMonitor.convert(monitor, 2);
		List<URI> elementURIs = Lists.newArrayList();
		int counter = 0;
		for (Iterator<EObject> iterator = EcoreUtil.getAllProperContents(baseElement, false); iterator.hasNext();) {
			if(progress.isCanceled()) {
				throw new OperationCanceledException();
			}
			EObject childElement = iterator.next();
			if (nameProvider.getFullyQualifiedName(childElement)!=null) {
				URI childURI = EcoreUtil.getURI(childElement);
				if (childURI != null) {
					elementURIs.add(childURI);
				}
			}
			counter++;
			if (counter % MONITOR_CHUNK_SIZE == 0) {
				progress.worked(1);
				progress.setWorkRemaining(2);
			}
		}
		return elementURIs;
	}

}
