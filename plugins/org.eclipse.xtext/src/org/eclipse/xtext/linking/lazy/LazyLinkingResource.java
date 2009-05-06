/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.linking.lazy;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.linking.impl.XtextLinkingDiagnostic;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.Triple;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class LazyLinkingResource extends XtextResource {
	
	private static final Logger log = Logger.getLogger(LazyLinkingResource.class);

	@Inject
	private ILinkingService linkingService;
	
	@Inject
	private LazyURIEncoder encoder;

	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
		super.doLoad(inputStream, options);
		if (options != null && Boolean.TRUE.equals(options.get(OPTION_RESOLVE_ALL)))
			EcoreUtil.resolveAll(this);
	}
	
	@Override
	public EObject getEObject(String uriFragment) {
		try {
			if (getEncoder().isCrossLinkFragment(this, uriFragment)) {
				Triple<EObject, EReference, AbstractNode> triple = getEncoder().decode(this, uriFragment);
				List<EObject> linkedObjects = getLinkingService().getLinkedObjects(triple.getFirst(), triple.getSecond(),
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
				EObject result = linkedObjects.get(0);
				if (!triple.getSecond().getEReferenceType().isSuperTypeOf(result.eClass())) {
					XtextLinkingDiagnostic diag = new XtextLinkingDiagnostic(triple.getThird(), "Couldn't resolve reference to "+triple.getSecond().getEType().getName());
					if (!getErrors().contains(diag))
						getErrors().add(diag);
					return null;
				}
				// remove previously added error markers, since everything should be fine now
				XtextLinkingDiagnostic diag = new XtextLinkingDiagnostic(triple.getThird(), "Couldn't resolve reference to "+triple.getSecond().getEType().getName());
				getErrors().remove(diag);
				return result;
			}
		} catch (RuntimeException e) { // XXX: why do we catch any runtime exception?
			log.error(e.getMessage(), e);
		}
		return super.getEObject(uriFragment);
	}

	public void setLinkingService(ILinkingService linkingService) {
		this.linkingService = linkingService;
	}

	public ILinkingService getLinkingService() {
		return linkingService;
	}

	public void setEncoder(LazyURIEncoder encoder) {
		this.encoder = encoder;
	}

	public LazyURIEncoder getEncoder() {
		return encoder;
	}
}
