/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.diagnostics;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.nodemodel.INode;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractDiagnosticProducer implements IDiagnosticProducer {

	private final IDiagnosticConsumer consumer;

	private INode node;

	protected AbstractDiagnosticProducer(IDiagnosticConsumer consumer) {
		if (consumer == null)
			throw new NullPointerException("consumer may not be null");
		this.consumer = consumer;
	}

	@Override
	public void addDiagnostic(DiagnosticMessage message) {
		consumer.consume(createDiagnostic(message), message.getSeverity());
	}
	
	protected abstract Diagnostic createDiagnostic(DiagnosticMessage message);
	
	@Override
	public void setNode(INode node) {
		this.node = node;
	}

	@Override
	public INode getNode() {
		return node;
	}

	@Override
	public void setTarget(EObject object, EStructuralFeature feature) {
		// nothing to do
	}

}