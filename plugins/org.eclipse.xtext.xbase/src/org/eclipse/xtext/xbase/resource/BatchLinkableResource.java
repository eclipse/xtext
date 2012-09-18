/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.resource;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.diagnostics.ExceptionDiagnostic;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.DerivedStateAwareResource;
import org.eclipse.xtext.util.Triple;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Linking assumptions
 */
public class BatchLinkableResource extends DerivedStateAwareResource {
	
	private static final Logger log = Logger.getLogger(BatchLinkableResource.class);
	
	@Inject
	private BatchLinkingService batchLinkingService;
	
	@Override
	public synchronized EObject getEObject(String uriFragment) {
		try {
			if (getEncoder().isCrossLinkFragment(this, uriFragment)) {
				Triple<EObject, EReference, INode> triple = getEncoder().decode(this, uriFragment);
				if (batchLinkingService.isBatchLinkable(triple.getSecond())) {
					return batchLinkingService.resolveBatched(triple.getFirst(), triple.getSecond(), uriFragment);
				} else {
					return super.getEObject(uriFragment, triple);
				}
			}
		} catch (RuntimeException e) {
			getErrors().add(new ExceptionDiagnostic(e));
			log.error("resolution of uriFragment '" + uriFragment + "' failed.", e);
			// wrapped because the javaDoc of this method states that WrappedExceptions are thrown
			// logged because EcoreUtil.resolve will ignore any exceptions.
			throw new WrappedException(e);
		}
		return super.getEObject(uriFragment);
	}
	
}
