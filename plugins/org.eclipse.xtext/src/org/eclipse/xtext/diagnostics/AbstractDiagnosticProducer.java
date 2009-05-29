/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.diagnostics;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.parsetree.AbstractNode;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractDiagnosticProducer implements IDiagnosticProducer {

	private final IDiagnosticConsumer consumer;

	private AbstractNode node;

	protected AbstractDiagnosticProducer(IDiagnosticConsumer consumer) {
		if (consumer == null)
			throw new NullPointerException("consumer may not be null");
		this.consumer = consumer;
	}

	public void addDiagnostic(String message) {
		consumer.consume(createDiagnostic(message));
	}
	
	protected abstract Diagnostic createDiagnostic(String message);
	
	public void setNode(AbstractNode node) {
		this.node = node;
	}

	public AbstractNode getNode() {
		return node;
	}

	public void setTarget(EObject object, EStructuralFeature feature) {
		// nothing to do
	}

}