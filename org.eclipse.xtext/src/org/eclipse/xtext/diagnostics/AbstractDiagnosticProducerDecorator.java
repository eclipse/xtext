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
public class AbstractDiagnosticProducerDecorator implements IDiagnosticProducer {

	private final IDiagnosticProducer producer;
	
	public AbstractDiagnosticProducerDecorator(IDiagnosticProducer producer) {
		super();
		this.producer = producer;
	}

	@Override
	public void addDiagnostic(DiagnosticMessage message) {
		producer.addDiagnostic(message);
	}

	@Override
	public INode getNode() {
		return producer.getNode();
	}

	@Override
	public void setNode(INode node) {
		producer.setNode(node);
	}

	@Override
	public void setTarget(EObject object, EStructuralFeature feature) {
		producer.setTarget(object, feature);
	}
	
}
