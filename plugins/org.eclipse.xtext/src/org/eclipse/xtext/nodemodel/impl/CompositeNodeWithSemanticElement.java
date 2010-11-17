/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.impl;

import org.eclipse.emf.ecore.EObject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CompositeNodeWithSemanticElement extends CompositeNode {

	private EObject semanticElement;
	
	@Override
	public EObject getSemanticElement() {
		return semanticElement;
	}
	
	@Override
	public int getNodeType() {
		return super.getNodeType() | SEMANTIC_MODEL_REFERENCE;
	}

	public void setSemanticElement(EObject element) {
		this.semanticElement = element;
	}
	
}
