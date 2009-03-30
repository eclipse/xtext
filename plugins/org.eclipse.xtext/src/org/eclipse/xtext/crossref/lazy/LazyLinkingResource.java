/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.crossref.lazy;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.crossref.ILinkingService;
import org.eclipse.xtext.crossref.impl.XtextLinkingDiagnostic;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.Triple;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class LazyLinkingResource extends XtextResource {
	private Logger log = Logger.getLogger(LazyLinkingResource.class);

	public ILinkingService linkingService;
	private URIFragmentEncoder encoder;

	@Inject
	public LazyLinkingResource(ILinkingService crossLinkResolver, URIFragmentEncoder encoder) {
		this.linkingService = crossLinkResolver;
		this.encoder = encoder;
	}
	
	@Override
	public EObject getEObject(String uriFragment) {
		try {
			if (encoder.isCrossLinkFragment(this, uriFragment)) {
				Triple<EObject, EReference, AbstractNode> triple = encoder.decode(this, uriFragment);
				List<EObject> linkedObjects = linkingService.getLinkedObjects(triple.getFirst(), triple.getSecond(),
						triple.getThird());
				if (linkedObjects.isEmpty()) {
					XtextLinkingDiagnostic diag = new XtextLinkingDiagnostic(triple.getThird(), "Couldn't resolve reference to "+triple.getSecond().getEType().getName());
					if (!getErrors().contains(diag))
						getErrors().add(diag);
					return null;
				}
				if (linkedObjects.size() > 1)
					throw new IllegalStateException("linkingService returned more than one object for fragment "
							+ uriFragment);
				return linkedObjects.get(0);
			}
		} catch (RuntimeException e) {
			log.error(e.getMessage(),e);
		}
		return super.getEObject(uriFragment);
	}
}
