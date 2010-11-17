package org.eclipse.xtext.nodemodel.impl;

import org.eclipse.emf.ecore.EObject;

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
