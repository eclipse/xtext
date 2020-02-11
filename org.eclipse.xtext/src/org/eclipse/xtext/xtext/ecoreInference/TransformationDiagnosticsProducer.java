/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.ecoreInference;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.diagnostics.AbstractDiagnosticProducer;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TransformationDiagnosticsProducer extends AbstractDiagnosticProducer implements ErrorAcceptor {

	private TransformationErrorCode lastError;
	
	public TransformationDiagnosticsProducer(IDiagnosticConsumer consumer) {
		super(consumer);
	}

	@Override
	protected Diagnostic createDiagnostic(DiagnosticMessage message) {
		return new TransformationDiagnostic(getNode(), message.getMessage(), lastError);
	}

	@Override
	public void acceptError(TransformationErrorCode errorCode, String message, EObject element) {
		setTarget(element, null);
		lastError = errorCode;
		addDiagnostic(new DiagnosticMessage(message, Severity.ERROR, null));	
		lastError = null;
	}
	
	@Override
	public void setTarget(EObject object, EStructuralFeature feature) {
		EObject myObject = object;
		INode result = NodeModelUtils.getNode(myObject);
		while(result == null && myObject.eContainer() != null) {
			myObject = myObject.eContainer();
			result = NodeModelUtils.getNode(myObject);
		}
		if (result == null)
			throw new IllegalStateException("Cannot find NodeAdapter for object: " + object);
		else {
			if (feature == null) {
				feature = myObject.eClass().getEStructuralFeature("name");
			}
			if (feature != null) {
				List<INode> nodes = NodeModelUtils.findNodesForFeature(myObject, feature);
				if (nodes.size() == 1) {
					result = nodes.get(0);
				}
			}
		}
		setNode(result);
	}

}
