/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.ui.refactoring.ElementRenameArguments;
import org.eclipse.xtext.ui.refactoring.IRefactoringUpdateAcceptor;

import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * A generic reference updater for EMF resources referring to Xtext elements.
 * 
 * Uses the resources default serialization mechanism to update resources. This only works if the resource does not have
 * errors. For Xtext-based languages it is far more fault tolerant to use a {@link DefaultReferenceUpdater} that only
 * serializes the sections of the document that actually represent cross-references.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 * @author Holger Schill
 */
public class EmfResourceReferenceUpdater extends AbstractReferenceUpdater {
	
	private final static Logger LOG = Logger.getLogger(EmfResourceReferenceUpdater.class);

	@Inject
	private EmfResourceChangeUtil changeUtil;

	@Override
	protected void createReferenceUpdates(ElementRenameArguments elementRenameArguments,
			Multimap<URI, IReferenceDescription> resource2references, ResourceSet resourceSet,
			IRefactoringUpdateAcceptor updateAcceptor, IProgressMonitor monitor) {
		for (URI referringResourceURI : resource2references.keySet()) {
			try {
				if (monitor.isCanceled())
					throw new OperationCanceledException();
				Resource referringResource = resourceSet.getResource(referringResourceURI, false);
				EObject refactoredElement = resourceSet.getEObject(elementRenameArguments.getNewElementURI(elementRenameArguments.getTargetElementURI()), true);
				if (referringResource != refactoredElement.eResource()) {
					if (refactoredElement instanceof EClassifier) { 
						for (IReferenceDescription reference : resource2references.get(referringResourceURI)) {
							EObject source = referringResource.getEObject(reference.getSourceEObjectUri().fragment());
							if (source == null) {
								LOG.error("Couldn't find source element "+ reference.getSourceEObjectUri() + " in " + referringResource.getURI());
							} else {
								EObject referringEReference = source.eContainer();
								if (referringEReference != null && referringEReference instanceof EReference)
									((EReference) referringEReference).setEType((EClassifier) refactoredElement);
							}
						}
					}
					changeUtil.addSaveAsUpdate(referringResource, updateAcceptor);
				}
			} catch (OperationCanceledException e) {
				throw e;
			} catch (Exception exc) {
				throw new WrappedException(exc);
			}
		}
	}

}
