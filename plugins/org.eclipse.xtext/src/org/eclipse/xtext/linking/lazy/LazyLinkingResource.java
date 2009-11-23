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
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.linking.impl.XtextLinkingDiagnostic;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.Triple;

import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class LazyLinkingResource extends XtextResource {

	private final Logger log = Logger.getLogger(getClass());

	@Inject
	private ILinkingService linkingService;

	@Inject
	private LazyURIEncoder encoder;

	private boolean eagerLinking = false;

	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
		super.doLoad(inputStream, options);
		if (options != null && Boolean.TRUE.equals(options.get(OPTION_RESOLVE_ALL)))
			EcoreUtil.resolveAll(this);
	}

	@Override
	protected void doLinking() {
		super.doLinking();
		if (isEagerLinking())
			EcoreUtil.resolveAll(this);
	}

	private LinkedHashSet<Triple<EObject, EReference, AbstractNode>> resolving = Sets.newLinkedHashSet();

	@Override
	public EObject getEObject(String uriFragment) {
		try {
			if (getEncoder().isCrossLinkFragment(this, uriFragment)) {
				Triple<EObject, EReference, AbstractNode> triple = getEncoder().decode(this, uriFragment);
				try {
					if (!resolving.add(triple))
						throw new AssertionError("Cyclic resolution of lazy links : "+getReferences(triple,resolving));
					EReference reference = triple.getSecond();
					List<EObject> linkedObjects = getLinkingService().getLinkedObjects(triple.getFirst(), reference,
							triple.getThird());
					if (linkedObjects.isEmpty()) {
						XtextLinkingDiagnostic diag = createDiagnostic(triple);
						if (!getErrors().contains(diag))
							getErrors().add(diag);
						return null;
					}
					if (linkedObjects.size() > 1)
						throw new IllegalStateException("linkingService returned more than one object for fragment "
								+ uriFragment);
					EObject result = linkedObjects.get(0);
					if (!reference.getEReferenceType().isSuperTypeOf(result.eClass())
							&& EcorePackage.Literals.EOBJECT != reference.getEReferenceType()) {
						XtextLinkingDiagnostic diag = createDiagnostic(triple);
						if (!getErrors().contains(diag))
							getErrors().add(diag);
						return null;
					}
					// remove previously added error markers, since everything should be fine now
					XtextLinkingDiagnostic diag = createDiagnostic(triple);
					getErrors().remove(diag);
					return result;
				} finally {
					resolving.remove(triple);
				}
			}
		} catch (RuntimeException e) {
			// wrapped because the javaDoc of this method states that WrappedExceptions are thrown
			// logged because EcoreUtil.resolve will ignore any exceptions.
			log.warn("resolution of uriFragment '" + uriFragment + "' failed.", e);
			throw new WrappedException(e);
		}
		return super.getEObject(uriFragment);
	}

	private String getReferences(Triple<EObject, EReference, AbstractNode> triple,
			LinkedHashSet<Triple<EObject, EReference, AbstractNode>> resolving2) {
		StringBuffer buffer = new StringBuffer();
		boolean found = false;
		for (Triple<EObject, EReference, AbstractNode> triple2 : resolving2) {
			found = found || triple2.equals(triple);
			if (found)
				buffer.append(getQualifiedName(triple2.getSecond())).append("->");
		}
		buffer.append(getQualifiedName(triple.getSecond()));
		return buffer.toString();
	}

	private String getQualifiedName(EReference eReference) {
		return eReference.getEContainingClass().getName()+"."+eReference.getName();
	}

	protected XtextLinkingDiagnostic createDiagnostic(Triple<EObject, EReference, AbstractNode> triple) {
		String serializedNode = triple.getThird().serialize();
		if (serializedNode != null)
			serializedNode = serializedNode.trim();
		String msg = "Couldn't resolve reference to " + triple.getSecond().getEType().getName() + " " + serializedNode;
		return new XtextLinkingDiagnostic(triple.getThird(), msg);
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

	public void setEagerLinking(boolean eagerLinking) {
		this.eagerLinking = eagerLinking;
	}

	public boolean isEagerLinking() {
		return eagerLinking;
	}
}
