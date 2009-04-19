/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.crossref.lazy;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.crossref.ILinkingService;
import org.eclipse.xtext.crossref.impl.XtextLinkingDiagnostic;
import org.eclipse.xtext.resource.XtextResource;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class LazyLinkingResource extends XtextResource {
	
	private static final Logger log = Logger.getLogger(LazyLinkingResource.class);

	private final ILinkingService linkingService;
	private final URIFragmentEncoder encoder;

	@Inject
	public LazyLinkingResource(ILinkingService crossLinkResolver, URIFragmentEncoder encoder) {
		this.linkingService = crossLinkResolver;
		this.encoder = encoder;
	}
	
	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
		super.doLoad(inputStream, options);
		if (options != null && Boolean.TRUE.equals(options.get(OPTION_RESOLVE_ALL)))
			EcoreUtil.resolveAll(this);
	}
	
	@Override
	public EObject getEObject(String uriFragment) {
		try {
			if (encoder.isCrossLinkFragment(this, uriFragment)) {
				URIFragmentEncoder.Data data = encoder.decode(this, uriFragment);
				List<EObject> linkedObjects = linkingService.getLinkedObjects(data.getRootModel(), data.getContext(), data.getReference(), data.getNode());
				if (linkedObjects.isEmpty()) {
					XtextLinkingDiagnostic diag = new XtextLinkingDiagnostic(data.getNode(), "Couldn't resolve reference to "+data.getReference().getEType().getName());
					if (!getErrors().contains(diag))
						getErrors().add(diag);
					return null;
				}
				if (linkedObjects.size() > 1)
					throw new IllegalStateException("linkingService returned more than one object for fragment "
							+ uriFragment);
				EObject result = linkedObjects.get(0);
				if (!data.getReference().getEReferenceType().isSuperTypeOf(result.eClass())) {
					XtextLinkingDiagnostic diag = new XtextLinkingDiagnostic(data.getNode(), "Couldn't resolve reference to "+data.getReference().getEType().getName());
					if (!getErrors().contains(diag))
						getErrors().add(diag);
					return null;
				}
				// remove previously added error markers, since everything should be fine now
				XtextLinkingDiagnostic diag = new XtextLinkingDiagnostic(data.getNode(), "Couldn't resolve reference to "+data.getReference().getEType().getName());
				getErrors().remove(diag);
				return result;
			}
		} catch (RuntimeException e) { // XXX: why do we catch any runtime exception?
			log.error(e.getMessage(), e);
		}
		return super.getEObject(uriFragment);
	}
}
