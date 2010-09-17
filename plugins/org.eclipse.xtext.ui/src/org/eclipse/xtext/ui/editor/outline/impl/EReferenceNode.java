/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;

/**
 * @author koehnlein - Initial contribution and API
 */
public class EReferenceNode extends AbstractOutlineNode {

	private URI ownerURI;

	private EReference reference;

	public EReferenceNode(EObject owner, EReference reference, IOutlineNode parent, Image image, Object text,
			boolean isLeaf) {
		super(parent, image, text, isLeaf);
		this.ownerURI = EcoreUtil.getURI(owner);
		this.reference = reference;
		setTextRegion(getLocationInFileProvider().getLocation(owner, reference, 0));
	}

	public URI getEObjectURI() {
		return ownerURI;
	}

	public EReference getEReference() {
		return reference;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj) && reference.equals(((EReferenceNode) obj).getEReference());
	}

	@Override
	public int hashCode() {
		return super.hashCode() + 37 * reference.hashCode();
	}

}
